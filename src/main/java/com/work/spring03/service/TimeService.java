package com.work.spring03.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.spring03.controller.TicketController;
import com.work.spring03.dao.MemberDAO;
import com.work.spring03.dao.TicketDAO;
import com.work.spring03.dao.TimeDAO;

@Service
public class TimeService {

	
	 /* spring di : setter injection */
	   private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	   
	   private TimeDAO Tidao;
	   
	   @Autowired
	   public void setTidao(TimeDAO Tidao) {
	      this.Tidao = Tidao;
	   }
	   
	   private MemberDAO dao;
		@Autowired
		public void setDao(MemberDAO dao) {
			this.dao = dao;
		}

	public void timeInsert_in(String nowTime, String nowDate, String name) {
		
		// TODO Auto-generated method stub
		Tidao.timeinsertIn(nowDate,nowTime,name);
		
	}

	public void timeInsert_out(String nowTime, String name,String useTime) {
		// TODO Auto-generated method stub
		   int Rtime = dao.user_Rtime(name) - Integer.parseInt(useTime);
		   //초과되었을때 exception
		   dao.user_Rtime_insert(name,Rtime);
		   //누적시간 넣자!!!!!
		   
		Tidao.timeinsertout(nowTime,name,useTime);
	}

	public void Stime_insert(String name,int useTime) {
		// TODO Auto-generated method stub
		
		int stime = dao.user_STime(name) + useTime;
		dao.user_Stime_update(name,stime);
	}

	public String intime_select(String name) {
		// TODO Auto-generated method stub
		
		return Tidao.intimeSelect(name);
	}
	   
	   
}
