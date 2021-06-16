package com.work.spring03.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.spring03.service.MainService;
import com.work.spring03.service.SeatService;

@Controller
public class MainController {

private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	
	/** spring di : setter injection */
	private MainService Mservice;
	
	@Autowired
	public void setMService(MainService Mservice) {
		this.Mservice = Mservice;
	}
	
	//메인 페이지 출력
	@RequestMapping("mainView.do")
	public String mainView() {
		return "main";
	}
	
	//가이드 페이지 출력
	 @RequestMapping("guideView.do")
	 public String guideView() {
	      return "guide";
	  }

}
