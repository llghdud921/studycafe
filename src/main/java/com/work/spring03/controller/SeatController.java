package com.work.spring03.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.work.spring03.dto.Seat;
import com.work.spring03.service.SeatService;

@Controller
public class SeatController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	/** spring di : setter injection */
	private SeatService Sservice;

	@Autowired
	public void setSService(SeatService Sservice) {
		this.Sservice = Sservice;
	}

	// 자리 페이지 출력
	@RequestMapping("seatView.do")
	public String seatView() {

		return "seat/seat";
	}

	// 퇴실 페이지 출력
	@RequestMapping("seatOutView.do")
	public String seatoutView() {

		return "seat/seat_out_check";
	}

	// 자리 선택
	@RequestMapping(value = "seatSelect.do", method = RequestMethod.GET)
	public ModelAndView seatSelect(@RequestParam("seat") String seat, HttpSession session) throws IOException {

		ModelAndView mv = new ModelAndView();
		String name = (String) session.getAttribute("name");

		int Snum = Integer.parseInt(seat);
		// 사용 여부 확인
		String seatTF = Sservice.seatCheck(Snum);
		if (seatTF.equals("T")) {

			int Seatnum = Sservice.user_check(name);

			if (Seatnum == Snum) {
				mv.setViewName("seat/seat_out_check");
			} else {
				mv.addObject("message", "다른 사람이 사용중입니다.");
				mv.setViewName("message");
			}

		} else if (seatTF.equals("F")) {
			int result = Sservice.use_check(name);

			if (result == 0) {
				//이용권 없을경우
				int rtime = Sservice.rtime_check(name);
				if(rtime <=0) {
					mv.setViewName("seat/seat_ticket");
				}else {
				mv.addObject("seatNum", Snum);
				session.setAttribute("use", "좌석 선택 가능 ");
				mv.setViewName("seat/seat_check");
				}
			} else if (result == 1) {
				mv.addObject("message", "사용중인 좌석이 있습니다.");
				session.setAttribute("use", "좌석 이용 중입니다. ");
				mv.setViewName("message");
			}
		}
		return mv;
	}

	// 자리 입력
	@RequestMapping("seatInsert.do")
	public String seatInsert(@RequestParam("seatNum") String seatNum, HttpSession session) {

		String name = (String) session.getAttribute("name");
		String gender = (String) session.getAttribute("gender");
		int snum = Integer.parseInt(seatNum);
		int result = Sservice.seatInsert(snum, name, gender);
		session.setAttribute("use", "사용 중");
		return "redirect:time_insert_in.do";
	}

	// 자리 현황 출력
	@RequestMapping("seatList.do")
	public String seatList(HttpServletResponse response, HttpServletRequest request) {

		ArrayList<Seat> list = Sservice.getSeatList();
		request.setAttribute("list", list);

		return "seat/seat";
	}

	// 퇴실 처리
	@RequestMapping("seatOut.do")
	public String seatOut(HttpSession session) {

		String name = (String) session.getAttribute("name");
		int result = Sservice.seatOut(name);

		if (result == 1) {
			Sservice.member_seatOut(name);
			session.setAttribute("use", "선택 가능");
			return "redirect:time_insert_out.do";
		}
		return null;
	}

	// 자리 이동 처리
	@RequestMapping("seatMove.do")
	public String seat1move(@RequestParam("seatNum") String seatNum, HttpSession session) {

		String name = (String) session.getAttribute("name");
		String gender = (String) session.getAttribute("gender");
		int snum = Integer.parseInt(seatNum);
		int result = Sservice.seatMove(snum, name, gender);

		if (result == 1)
			return "redirect:seatList.do";

		return null;
	}

	// 자리 현황 출력
	@RequestMapping("seatMoveList.do")
	public String seatMoveList(HttpServletResponse response, HttpServletRequest request) {

		ArrayList<Seat> list = Sservice.getSeatList();
		request.setAttribute("list", list);

		return "seat/seatMove";
	}

	// 자리 선택
	@RequestMapping(value = "seatMoveSelect.do", method = RequestMethod.GET)
	public ModelAndView seatMoveSelect(@RequestParam("seat") String seat, HttpSession session) {

		ModelAndView mv = new ModelAndView();
		String name = (String) session.getAttribute("name");
		
		int Seatnum = Integer.parseInt(seat);

		
		mv.addObject("seatNum", Seatnum);
		mv.setViewName("seat/seat_move_check");
		return mv;
	}

}