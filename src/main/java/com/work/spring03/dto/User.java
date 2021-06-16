package com.work.spring03.dto;

/**
 * 로그인 페이지에 대한 도메인클래스
 */
public class User {
	private String userid;
	private String userpw;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	
	public User(){}
	
	public User(String userid, String userpw) {
		this.userid = userid;
		this.userpw = userpw;
	}
}



