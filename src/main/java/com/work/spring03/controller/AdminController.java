package com.work.spring03.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.spring03.dto.Amember;
import com.work.spring03.dto.Member;
import com.work.spring03.dto.Seat;
import com.work.spring03.dto.Time;
import com.work.spring03.dto.memberjoin;
import com.work.spring03.service.AdminService;
import com.work.spring03.service.MainService;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	/** spring di : setter injection */
	private AdminService Aservice;

	@Autowired
	public void setAService(AdminService Aservice) {
		this.Aservice = Aservice;
	}

	/** 관리자 자리관리 페이지 요청 */
	@RequestMapping("admin_seatView.do")
	public String admin_seatView(HttpServletResponse response, HttpServletRequest request) {

		ArrayList<Seat> list = Aservice.getSeatList();
		request.setAttribute("list", list);

		return "admin/admin_seat";
	}

	/** 관리자 자리변경 페이지 요청 */
	@RequestMapping("admin_seatSelect.do")
	public ModelAndView admin_seatSelect(@RequestParam("seat") String seat, HttpServletResponse response,
			HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		int Snum = Integer.parseInt(seat);
		// 사용 여부 확인
		String seatTF = Aservice.seatCheck(Snum);
		if (seatTF.equals("T")) {
			String name = Aservice.snum_check(Snum);
			mv.addObject("name", name);
			mv.setViewName("admin/admin_seat_out_check");

		} else if (seatTF.equals("F")) {
			// 리스트
			ArrayList<Member> list = Aservice.getMemberList(0);
			for (int i = 0; i < list.size(); i++) {
				Member m = list.get(i);
			}
			request.setAttribute("membernonelist", list);

			mv.addObject("seatNum", Snum);
			mv.setViewName("admin/admin_seat_check");
		}
		return mv;
	}

	// 입실 처리
	@RequestMapping("admin_seatInsert.do")
	public String admin_seatInsert(@RequestParam("name") String name, @RequestParam("seat") String seatNum,
			RedirectAttributes redirectAttributes) {
		int snum = Integer.parseInt(seatNum);
		String gender = Aservice.gender_check(name);
		int result = Aservice.seatInsert(snum, name, gender);
		redirectAttributes.addAttribute("name", name);
		return "redirect:admin_time_insert_in.do";
	}

	// 관리자 퇴실 처리
	@RequestMapping("admin_seatOut.do")
	public String seatOut(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {

		int result = Aservice.seatOut(name);

		if (result == 1) {
			Aservice.member_seatOut(name);
			redirectAttributes.addAttribute("name", name);
			return "redirect:admin_time_insert_out.do?";
		}
		return null;
	}

	// 이동 자리 선택
	@RequestMapping(value = "admin_seatMoveSelect.do", method = RequestMethod.GET)
	public ModelAndView seatMoveSelect(@RequestParam("seat") String seat, @RequestParam("name") String name) {

		ModelAndView mv = new ModelAndView();

		int Snum = Integer.parseInt(seat);
		// 사용 여부 확인
		int Seatnum = Aservice.user_check(name);

		if (Seatnum == Snum) {
			mv.addObject("message", "현재 사용중인 좌석이 있습니다.");
			mv.setViewName("message");
		} else {
			mv.addObject("seatNum", Snum);
			mv.addObject("name", name);
			mv.setViewName("admin/admin_seat_move_check");
		}
		return mv;
	}

	// 관리자 자리 이동 처리
	@RequestMapping("admin_seatMove.do")
	public String admin_seat1move(@RequestParam("seatNum") String seatNum, @RequestParam("name") String name) {

		int Snum = Integer.parseInt(seatNum);
		String gender = Aservice.gender_check(name);
		int result = Aservice.seatMove(Snum, name, gender);

		if (result == 1) {
			return "redirect:admin_seatView.do";
		}

		return null;
	}

	// 자리 현황 출력
	@RequestMapping("admin_seatMoveList.do")
	public String seatMoveList(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "name") String name) {

		ArrayList<Seat> list = Aservice.getSeatList();
		System.out.println(list.size());
		request.setAttribute("list", list);
		request.setAttribute("name", name);

		return "admin/admin_seatMove";
	}



	/** 관리자 로그인 페이지 요청 */
	@RequestMapping("aloginView.do")
	public String aloginView() {
		return "admin/alogin";
	}

	/** 현재 이용 인원 관리 페이지 */
	@RequestMapping("admin_memberView.do")
	public String admin_memberView() {
		return "admin/admin_member";
	}

	/** 전체 이용 인원 관리 페이지 */
	@RequestMapping("admin_wholeView.do")
	public String admin_wholeView() {
		return "admin/admin_whole";
	}

	/** 회원 세부 조회 페이지 */
	@RequestMapping("admin_detailmember.do")
	public String admin_detailView(@RequestParam("name") String name, HttpServletResponse response,
			HttpServletRequest request) {
		Member dto = Aservice.getMemberdetail(name);
		request.setAttribute("memberdetail", dto);

		ArrayList<Time> list = Aservice.getMemberdetailList(name);
		for (int i = 0; i < list.size(); i++) {
			Time t = list.get(i);
		}
		request.setAttribute("memberdetaillist", list);

		return "admin/admin_detail";
	}

	/**
	 * 로그인 요청
	 * 
	 * @throws com.work.spring03.exception.AuthenticationException
	 */
	@RequestMapping(value = "admin_login.do", method = RequestMethod.POST)
	public ModelAndView adminlogin(String email, String password, HttpSession session)
			throws com.work.spring03.exception.AuthenticationException {
		// model 요청의뢰
		String name = Aservice.login(email, password);

		// 응답설정 및 응답뷰를 설정위한 객체 생성
		ModelAndView mv = new ModelAndView();

		session.setAttribute("email", email);
		session.setAttribute("name", name);

		// 응답페이지 이동
		mv.setViewName("redirect:admin_seatView.do");

		return mv;
	}

	/** 로그아웃 요청 */
	@RequestMapping("admin_logOut.do")
	public String logout(HttpSession session) {

		// 로그아웃 세션처리
		if (session != null) {
			if (session.getAttribute("email") != null) {
				session.removeAttribute("email");
			}
			if (session.getAttribute("name") != null) {
				session.removeAttribute("name");
			}
			session.invalidate();
		}
		return "redirect:aloginView.do";
	}

	// 사용중인 회원 출력
	@RequestMapping("admin_memberList.do")
	public String memberuserList(HttpServletResponse response, HttpServletRequest request) {

		ArrayList<Member> list = Aservice.getMemberList(1);
		for (int i = 0; i < list.size(); i++) {
			Member m = list.get(i);

		}
		request.setAttribute("memberuserlist", list);

		return "admin/admin_member";
	}

	// 전체 회원 출력
	@RequestMapping("admin_memberwholeList.do")
	public String memberList(HttpServletResponse response, HttpServletRequest request) {

		ArrayList<Member> list = Aservice.getMemberWholeList();
		for (int i = 0; i < list.size(); i++) {
			Member m = list.get(i);

		}
		request.setAttribute("memberwholelist", list);

		return "admin/admin_whole";
	}

	/** 관리자 회원가입 요청 */
	@RequestMapping(value = "admin_join.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String admin_join(String email, String password, String name, Model model) {
		Amember dto = new Amember(email, password, name);
		int result = Aservice.admin_join(dto);

		if (result == 1) {
			model.addAttribute("message", "회원가입이 완료되었습니다. 로그인 후 관리자 전용 서비스를 이용하시기 바랍니다.");
			return "admin/alogin";
		} else {
			// 회원가입 오류 처리 추가 구현
			model.addAttribute("message", "회원가입중 오류가 발생하였습니다. 정보를 다시 확인하시기 바랍니다.");
			return "admin/admin_join";
		}
	}

	// 이용권 관리
	@RequestMapping("admin_ticket.do")
	public ModelAndView admin_ticket(HttpServletResponse response, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();
		memberjoin m = new memberjoin();
		ArrayList<memberjoin> list = Aservice.getUserList();
		String result = "";
		String[] week = { "일", "월", "화", "수", "목", "금", "토" };
		int[][] d = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } };
		for (int i = 0; i < list.size(); i++) {
			m = list.get(i);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date nDate = dateFormat.parse(m.getDay());

			Calendar cal = Calendar.getInstance();
			cal.setTime(nDate);

			int dayNum = cal.get(Calendar.DAY_OF_WEEK);

			switch (dayNum) {
			case 1:
				if(m.getGender().equals("F")) {
					d[0][0]++;
				} else if(m.getGender().equals("F")) {
					d[0][1]++;
				}
				break;
			case 2:
				if (m.getGender().equals("M")) {
					d[1][0]++;
				} else if(m.getGender().equals("F")) {
					d[1][1]++;
				}
				break;
			case 3:
				if(m.getGender().equals("M")) {
					d[2][0]++;
				} else if(m.getGender().equals("F")) {
					d[2][1]++;
				}
				;
			case 4:
				if(m.getGender().equals("M")) {
					d[3][0]++;
				} else if(m.getGender().equals("F")) {
					d[3][1]++;
				}
				break;
			case 5:
				if(m.getGender().equals("M")) {
					d[4][0]++;
				} else if(m.getGender().equals("F")) {
					d[4][1]++;
				}
				break;
			case 6:
				if(m.getGender().equals("M")){
					d[5][0]++;
				} else if(m.getGender().equals("F")) {
					d[5][1]++;
				}
				break;
			case 7:
				if(m.getGender().equals("M")) {
					d[6][0]++;
				} else if(m.getGender().equals("F")) {
					d[6][1]++;
				}
				break;
			}
		}

		for (int a = 0; a < 7; a++) {
			if (result != "") {
				result += ",";
			}
			result += "['" + week[a] + "', " + d[a][0] + ", " + d[a][1] + "]";
		}
		mv.addObject("result",result);
		mv.setViewName("admin/admin_utilmanager");

		return mv;
		}
}
