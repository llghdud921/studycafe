package com.work.spring03.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.work.spring03.service.TicketService;
import com.work.spring03.service.TimeService;

@Controller
public class TimeController {
	
	  
	   private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	   /** spring di : setter injection */
	   private TimeService Tiservice;
	   
	   @Autowired
	   public void setTiservice(TimeService Tiservice) {
	      this.Tiservice = Tiservice;
	   }
	   
	   
	   //시간 입력
	   @RequestMapping("time_insert_in.do")
	   public String timeIsertIn(HttpSession session) { 
		   
		   String name = (String) session.getAttribute("name");
		   long currentTime = System.currentTimeMillis();
		  
		   SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy/MM/dd");
		   
		   String nowTime = String.valueOf(currentTime);
		   String nowDate = dateFormat.format(new Date(currentTime));
		   
		   Tiservice.timeInsert_in(nowTime, nowDate,name);

	      return "redirect:seatList.do";
	   }
	   
	 //관리자 시간 입력
	   @RequestMapping("admin_time_insert_in.do")
	   public String admin_timeIsertIn(@RequestParam(value="name") String name) { 
		   
		   long currentTime = System.currentTimeMillis();
		  
		   SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy/MM/dd");
		   
		   String nowTime = String.valueOf(currentTime);
		   String nowDate = dateFormat.format(new Date(currentTime));
		   
		   Tiservice.timeInsert_in(nowTime, nowDate,name);

	      return "redirect:admin_seatView.do";
	   }


	   
	 //시간 입력
	   @RequestMapping("time_insert_out.do")
	   public String timeIsertout(HttpSession session) { 
		   
		   String name = (String) session.getAttribute("name");
		   long currentTime = System.currentTimeMillis();

		   String it = Tiservice.intime_select(name);
		  
		   long inTime = Long.parseLong(it);
		   
		   long ut= (currentTime-inTime)/60000;
		   String useTime= String.valueOf(ut);

		   
		   String nowTime = String.valueOf(currentTime);
		   
		   Tiservice.timeInsert_out(nowTime,name,useTime);
		   Tiservice.Stime_insert(name,Integer.parseInt(useTime));

	      return "redirect:seatList.do";
	   }
	   
	 //시간 입력
	   @RequestMapping("admin_time_insert_out.do")
	   public String admin_timeIsertout(@RequestParam(value="name") String name) { 
		   
		   long currentTime = System.currentTimeMillis();

		   String it = Tiservice.intime_select(name);
		  
		   long inTime = Long.parseLong(it);
		   
		   long ut= (currentTime-inTime)/60000;
		   String useTime= String.valueOf(ut);
		   
		   String nowTime = String.valueOf(currentTime);
		   
		   Tiservice.timeInsert_out(nowTime,name,useTime);
		   Tiservice.Stime_insert(name,Integer.parseInt(useTime));

	      return "redirect:admin_seatView.do";
	   }
}


