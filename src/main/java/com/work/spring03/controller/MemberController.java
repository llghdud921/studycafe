package com.work.spring03.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.work.spring03.dto.Member;
import com.work.spring03.dto.Time;
import com.work.spring03.exception.AuthenticationException;
import com.work.spring03.service.MemberService;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	/** spring di : setter injection */
	private MemberService service;

	@Autowired
	public void setService(MemberService service) {
		this.service = service;
	}

	/** 로그인 페이지 요청 */
	@RequestMapping("loginView.do")
	public String loginView() {
		return "login";
	}

	/** 회원가입 페이지 요청 */
	@RequestMapping("joinView.do")
	public String joinView() {
		return "member/join";
	}

	/** 아이디 비밀번호 검색 */
	@RequestMapping("searchView.do")
	public String searchView() {
		return "search";
	}

	/** 로그인 요청 */
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView login(String email, String password, HttpSession session) throws AuthenticationException,NullPointerException {
		
		// model 요청의뢰
		ModelAndView mv = new ModelAndView();
		if(email.trim().length()!=0 && password.trim().length()!=0)
		{
			Member dto = service.login(email, password);

			// 응답설정 및 응답뷰를 설정위한 객체 생성
			if (dto.getName() != null) {
				// 응답위한 결과 설정
				mv.addObject("email", dto.getEmail());
				mv.addObject("name", dto.getName());
				session.setAttribute("email", email);
				session.setAttribute("name", dto.getName());
				session.setAttribute("gender", dto.getGender());
				session.setAttribute("time", dto.getRTime());

				if (dto.getUse() == 1) {
					session.setAttribute("use", "사용 중");
				} else {
					session.setAttribute("use", "선택 가능");
				}
				// 응답페이지 이동
				mv.setViewName("redirect:mainView.do");
			} else {
				mv.addObject("message", "로그인 정보를 다시 확인하시기 바랍니다.");
				mv.setViewName("login");
			}
		}else {
			mv.addObject("message", "로그인 정보를 다시 확인하시기 바랍니다.");
			mv.setViewName("login");
		}
		
		return mv;
	}

	/** 로그아웃 요청 */
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {

		// 로그아웃 세션처리
		if (session != null) {
			if (session.getAttribute("email") != null) {
				session.removeAttribute("email");
			}
			if (session.getAttribute("name") != null) {
				session.removeAttribute("name");
			}
			if (session.getAttribute("gender") != null) {
				session.removeAttribute("gender");
			}
			if (session.getAttribute("time") != null) {
				session.removeAttribute("time");
			}
			if (session.getAttribute("use") != null) {
				session.removeAttribute("use");
			}

			session.invalidate();
		}
		return "login";
	}

	/** 회원가입 요청 */
	@RequestMapping(value = "join.do", method = RequestMethod.POST)
	public String join(String email, String password, String name, String phone, String gender, Model model) {
		Member dto = new Member(email, password, name, phone, gender);
		int result = service.join(dto);
		if (result == 1) {
			model.addAttribute("message", "회원가입이 완료되었습니다. 로그인 후 회원전용 서비스를 이용하시기 바랍니다.");
			return "login";
		} else {
			// 회원가입 오류 처리 추가 구현
			model.addAttribute("message", "회원가입중 오류가 발생하였습니다. 정보를 다시 확인하시기 바랍니다.");
			return "login";
		}
	}

	// ** 아이디 중복확인 요청 *//*
	@RequestMapping("idcheckView.do")
	public ModelAndView idcheckView(@RequestParam("email") String email, HttpSession session)
			throws AuthenticationException {
		// model 요청의뢰
		boolean idcheck = service.idcheck(email);

		// 응답설정 및 응답뷰를 설정위한 객체 생성
		ModelAndView mv = new ModelAndView();

		if (idcheck) {
//             // 응답위한 결과 설정
			mv.addObject("message", "사용가능한 이메일(아이디)입니다");
		} else {
			mv.addObject("message", "이미 존재하는 이메일(아이디)입니다");
		}
		mv.setViewName("idcheck");
		return mv;
	}

	/**
	 * 내정보 조회 요청
	 * 
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(HttpSession session, HttpServletRequest request) {

		String email = (String) session.getAttribute("email");
		Member dto = service.getMyinfo(email);
		session.setAttribute("email", dto.getEmail());
		session.setAttribute("name", dto.getName());
		session.setAttribute("gender", dto.getGender());
		request.setAttribute("dto", dto);

		return "member/update";
	}

	/** 아이디/비번찾기 페이지 세션 닫기 */
	@RequestMapping("loginSessionView.do")
	public String loginSessionView(HttpSession session) {
		session.invalidate();
		return "login";
	}

	/** 휴대폰 아이디(이메일) 찾기 요청 */
	@RequestMapping(value = "searchid.do", method = RequestMethod.POST)
	public ModelAndView searchphone(String name, String phone, HttpSession session) throws AuthenticationException {

		// model 요청의뢰
		String email = service.search(name, phone); // 받고 싶은 내용을 적는다
		// 응답설정 및 응답뷰를 설정위한 객체 생성
		ModelAndView mv = new ModelAndView();
		if (email != null) {
			// 응답위한 결과 설정
			mv.addObject("notice", email);
			session.setAttribute("email", email);
			// 응답페이지 이동
			mv.setViewName("search");// 안써도 jsp로 간다 //############
		} else {
			mv.addObject("message", "로그인 정보를 다시 확인하시기 바랍니다.");
			mv.setViewName("error/errorLogin");
		}
		return mv;
	}

	/** 이메일로 비번 찾기 요청 */
	@RequestMapping(value = "searchpw.do", method = RequestMethod.POST)
	public ModelAndView searchpw(String name, String email, String phone, HttpSession session)
			throws AuthenticationException {
		// model 요청의뢰
		String password = service.search(name, email, phone); // 받고 싶은 내용을 적는다

		// 응답설정 및 응답뷰를 설정위한 객체 생성
		ModelAndView mv = new ModelAndView();
		if (password != null) {
			// 응답위한 결과 설정
			mv.addObject("notice", password);
			session.setAttribute("password", password);
			// 응답페이지 이동
			mv.setViewName("search");// 안써도 jsp로 간다
		} else {
			mv.addObject("message", "로그인 정보를 다시 확인하시기 바랍니다.");
			mv.setViewName("error/errorLogin");
		}
		return mv;
	}

	/**
	 * 내정보 수정 요청
	 * 
	 * @return
	 */
	@RequestMapping("updateView.do")
	public String updateView(@ModelAttribute("joinInfo") Member dto, Model model, HttpSession session) {

		String email = (String) session.getAttribute("email");
		int result = service.update(dto, email);
		if (result == 1) {
			return "main";
		}
		return null;

	}

	/** 회원 탈퇴 요청 */
	@RequestMapping(value = "delete.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String delete(String email, Member dto, Model model, HttpSession session, HttpServletRequest request) {

		String id = (String) session.getAttribute("email"); // 세션에서 이메일 가져옴
		int result = service.delete(dto, id);
		if (result == 1) {
			session.invalidate();
			model.addAttribute("message", "탈퇴되었습니다.");
			return "login";
		} else {
			model.addAttribute("message", "탈퇴 중 오류가 발생하였습니다. 정보를 다시 확인하시기 바랍니다.");
			return "member/update";
		}
	}
	
	/** 회원 방문내역 조회 페이지 */
	@RequestMapping("visitmember.do")
	public String visitmember(HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		String name = (String) session.getAttribute("name");
		ArrayList<Time> list = service.getdetailList(name);
		for (int i = 0; i < list.size(); i++) {
			Time t = list.get(i);
		}
		request.setAttribute("memberdetaillist", list);

		return "member/visit";
	}

}
