package com.work.spring03.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.work.spring03.exception.AuthenticationException;
import com.work.spring03.service.SeatService;
import com.work.spring03.service.TicketService;

@Controller
public class TicketController {
   
   private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

   /** spring di : setter injection */
   private TicketService Tservice;
   
   @Autowired
   public void setTservice(TicketService Tservice) {
      this.Tservice = Tservice;
   }
   
   // 이용권 구매 페이지 출력
   @RequestMapping("ticketView.do")
   public String ticketView() {   
      return "ticket/person_ticket";
   }
   
   // 결제 페이지 출력
   @RequestMapping("payView.do")
   public String payView() {   
      return "ticket/pay";
   }
   
   // 결제 금액 페이지 출력
   @RequestMapping("pay.do")
   public ModelAndView pay(@RequestParam String time) {   
      int tt = Integer.parseInt(time);
      ModelAndView mv = new ModelAndView();
      
      if(tt==1) {
         mv.addObject("time",1);
         mv.addObject("money", 2000);
      }else if(tt==2) {
         mv.addObject("time",2);
         mv.addObject("money", 3500);
      }else if(tt==3) {
         mv.addObject("time",3);
         mv.addObject("money", 4500);
      }else if(tt==4) {
         mv.addObject("time",4);
         mv.addObject("money", 5500);
      }else if(tt==5) {
         mv.addObject("time",5);
         mv.addObject("money", 6500);
      }else if(tt==6) {
         mv.addObject("time",6);
         mv.addObject("money", 7500);
      }
         
      mv.setViewName("ticket/pay");
         
      return mv;
   }
   
// 결제 페이지 출력
   @RequestMapping("payroomView.do")
   public String payroomView() {   
      return "ticket/payroom";
   }
   
   //결제시간 넣어주기
   @RequestMapping("ticket_update.do")
   public String ticket_update(@RequestParam("time") String time, HttpSession session) { 
      String name = (String) session.getAttribute("name");
      int t = Integer.parseInt(time) *60 +Tservice.member_rtime_check(name);
      int str = Tservice.tUpdate(name,t);
      session.setAttribute("time", t);
      if(str==1) {
    	  return "redirect:mainView.do";
      }
      return null;
   }
    
}