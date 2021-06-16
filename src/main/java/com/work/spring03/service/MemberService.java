package com.work.spring03.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.spring03.controller.MemberController;
import com.work.spring03.dao.MemberDAO;
import com.work.spring03.dao.TimeDAO;
import com.work.spring03.dto.Member;
import com.work.spring03.dto.Time;
import com.work.spring03.exception.AuthenticationException;
import com.work.spring03.util.Utility;

@Service
public class MemberService {
	/* spring di : setter injection */

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	private MemberDAO dao;
	private TimeDAO Tdao;

	@Autowired
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	@Autowired
	public void setTdao(TimeDAO Tdao) {
		this.Tdao = Tdao;
	}

	public MemberService() {
	}

	//로그인
	public Member login(String email, String password) throws AuthenticationException {
		Member dto = dao.loginCheck(email, password);
		if (dto.getName()==null) {
			throw new AuthenticationException("로그인 정보가 올바르지 않습니다.");
		}
		return dto;
	}
	
	//회원 가입
	public int join(Member dto) {
		dto.setRTime(0);
		dto.setUse(0);
		dto.setSTime(0);
		return dao.insert(dto);
	}

	//내정보 조회
	public Member getMyinfo(String email) {
		return dao.myinfo(email);
	}

	//아이디 찾기
	public String search(String name, String phone) throws AuthenticationException,NullPointerException {
		String email = dao.searchidCheck(name, phone); // dao는 데이터 접근 객체
		if (email == null) {
			throw new AuthenticationException("로그인 정보가 올바르지 않습니다.");
		}
		return email; // 컨트롤러 갑니다
	}

	//패스워드 찾기
	public String search(String name, String email, String phone) throws AuthenticationException {
		String password = dao.searchpwCheck(name, email, phone);
		if (password == null) {
			throw new AuthenticationException("로그인 정보가 올바르지 않습니다.");
		}
		return password; // 컨트롤러 갑니다
	}

	//내정보 수정
	public int update(Member dto, String email) {
		return dao.update(dto, email);
	}

	//아이디 중복확인
    public boolean idcheck(String email) throws AuthenticationException {
       boolean idcheck = dao.idcheck(email);

       return idcheck;   //컨트롤러 갑니다
    }

    //회원 탈퇴
    public int delete(Member dto, String email) {
       return dao.delete(dto, email);
    }
    
    
    public ArrayList<Time> getdetailList(String name){
    	
    	return Tdao.selectMemberdetailList(name);
    }
}
