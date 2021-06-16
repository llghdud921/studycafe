package com.work.spring03.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.spring03.controller.MemberController;
import com.work.spring03.dao.MemberDAO;
import com.work.spring03.dao.SeatDAO;
import com.work.spring03.dto.Seat;

@Service
public class SeatService {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/* spring di : setter injection */
	private SeatDAO Sdao;
	private Seat sdto;
	private MemberDAO dao;
	
	@Autowired
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	public void setSdto(Seat sdto) {
		this.sdto = sdto;
	}
	
	@Autowired
	public void setSdao(SeatDAO Sdao) {
		this.Sdao = Sdao;
	}
	
	public String seatCheck(int snum) {
		// TODO Auto-generated method stub
		
		return Sdao.seat_Check(snum);
	}
	
	public int use_check(String name) {
		// TODO Auto-generated method stub
		return dao.user_seat(name);
	}
	

	public int seatInsert(int seatNum,String name,String gender) {
		// TODO Auto-generated method stub
		dao.member_seat(name,1);
		return Sdao.seat_insert(seatNum,name,gender);
	}

	public ArrayList<Seat> getSeatList() {
		// TODO Auto-generated method stub
		return Sdao.selectSeatList();
	}

	public int seatOut(String name) {
		// TODO Auto-generated method stub
		
		int num = Sdao.seat_numselect(name);
		return Sdao.seat_out(num);
	}
	
	public void member_seatOut(String name) {
		// TODO Auto-generated method stub
		dao.member_seat(name,0);
	}

	public int user_check(String name) {
		
		int num = Sdao.seat_numselect(name);
		
		return num;
	}


	public int seatMove(int seatNum,String name, String gender) {
		// TODO Auto-generated method stub
		int num = Sdao.seat_numselect(name);
		Sdao.seat_out(num);
		dao.member_seat(name,1);
		return Sdao.seat_insert(seatNum,name,gender);
	}

	public int rtime_check(String name) {
		// TODO Auto-generated method stub
		return dao.user_Rtime(name);
	}

	

	
	
	
	
	
	//
}
