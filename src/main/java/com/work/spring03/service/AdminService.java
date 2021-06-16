package com.work.spring03.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.spring03.controller.MemberController;
import com.work.spring03.dao.AdminDAO;
import com.work.spring03.dao.MainDAO;
import com.work.spring03.dao.MemberDAO;
import com.work.spring03.dao.SeatDAO;
import com.work.spring03.dao.TimeDAO;
import com.work.spring03.dto.Amember;
import com.work.spring03.dto.Member;
import com.work.spring03.dto.Seat;
import com.work.spring03.dto.Time;
import com.work.spring03.dto.memberjoin;
import com.work.spring03.exception.AuthenticationException;

@Service
public class AdminService {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	/* spring di : setter injection */
	private AdminDAO Adao;
	private TimeDAO Tdao;
	private SeatDAO Sdao;
	private Member dto;
	private Seat sdto;
	private memberjoin jdto;

	@Autowired
	public void setAdao(AdminDAO Adao) {
		this.Adao = Adao;
	}
	
	@Autowired
	public void setTdao(TimeDAO Tdao) {
		this.Tdao = Tdao;
	}
	
	@Autowired
	public void setSdao(SeatDAO Sdao) {
		this.Sdao = Sdao;
	}
	
	public void setdto(Member dto) {
		this.dto = dto;
	}
	
	public void setjdto(memberjoin jdto) {
		this.jdto = jdto;
	}
	
	/* spring di : setter injection */
	private MemberDAO dao;

	@Autowired
	public void setdao(MemberDAO dao) {
		this.dao = dao;
	}

	public AdminService() {
	}

	//관리자 로그인
	public String login(String email, String password) throws AuthenticationException {
		String name = Adao.loginCheck(email, password);
		if (name == null) {
			throw new AuthenticationException("관리자 로그인 정보가 올바르지 않습니다.");
		}
		return name;
	}
	
	//관리자 회원가입
	   public int admin_join(Amember dto) {
	      return Adao.admin_insert(dto);
	   }


	public ArrayList<Member> getMemberList(int i) {
		// TODO Auto-generated method stub
		return dao.selectMemberList(i);
	}

	public ArrayList<Member> getMemberWholeList() {
		// TODO Auto-generated method stub
		 return dao.selectMemberwholeList();
	}

	public Member getMemberdetail(String name) {
		
		return dao.selectMemberdetail(name);
	}

	public ArrayList<Time> getMemberdetailList(String name) {
		// TODO Auto-generated method stub
		return Tdao.selectMemberdetailList(name);
	}

	public ArrayList<Seat> getSeatList() {
		// TODO Auto-generated method stub
		return Sdao.selectSeatList();
	}

	public String seatCheck(int snum) {
		String seatTF = Sdao.seat_Check(snum);
		return seatTF;
	}

	public String snum_check(int snum) {
		// TODO Auto-generated method stub
		return Sdao.nameselect(snum);
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
		// TODO Auto-generated method stub
		return Sdao.seat_numselect(name);
	}

	public String gender_check(String name) {
		// TODO Auto-generated method stub
		return dao.seat_genderselect(name);
	}

	public int seatMove(int seatnum, String name, String gender) {
		// TODO Auto-generated method stub
		int num = Sdao.seat_numselect(name);
		Sdao.seat_out(num);
		dao.member_seat(name,1);
		return Sdao.seat_insert(seatnum,name,gender);
	}

	public int seatInsert(int snum, String name, String gender) {
		// TODO Auto-generated method stub
		dao.member_seat(name,1);
		return Sdao.seat_insert(snum,name,gender);
	}

	public ArrayList<memberjoin> getUserList() {
		// TODO Auto-generated method stub
		return Tdao.selectticketList();
	}
}
