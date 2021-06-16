package com.work.spring03.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.spring03.controller.MemberController;
import com.work.spring03.controller.TicketController;
import com.work.spring03.dao.MemberDAO;
import com.work.spring03.dao.SeatDAO;
import com.work.spring03.dao.TicketDAO;
import com.work.spring03.exception.AuthenticationException;

@Service
public class TicketService {

	/* spring di : setter injection */
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

	private TicketDAO Tdao;

	@Autowired
	public void setTdao(TicketDAO Tdao) {
		this.Tdao = Tdao;
	}

	private MemberDAO dao;

	@Autowired
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	public TicketService() {
	}

	//이용권 구매요청
	public int pay(int money) throws AuthenticationException {
		int U_Money = Tdao.payCheck(money);

		if (U_Money == 0) {
			throw new AuthenticationException("구매 정보가 올바르지 않습니다.");
		}
		return U_Money;
	}

	//잔여시간 입력
	public int tUpdate(String name, int time) {
		return dao.memberTicket_update(name, time);

	}
	
	//잔여시간 확인
	public int member_rtime_check(String name) {
		return dao.user_Rtime(name);
	}

}
