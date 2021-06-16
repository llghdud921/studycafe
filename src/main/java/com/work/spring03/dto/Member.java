package com.work.spring03.dto;

import java.io.Serializable;

import com.work.spring03.util.Utility;

public class Member implements Serializable {
	
	/** 이메일 이메일 형식 */
	private String Email;
	/** 비밀번호 6자리~16자리 */ 
	private String Password;
	/** 이름 */
	private String Name;
	/** 휴대폰 형식 010-1234-1234 */
	private String Phone;
	/** 성별 남 또는 여 */
	private String Gender;
	/** 잔여 시간 */
	private int RTime;
	/** 사용유무 */
	private int Use;
	/** 누적시간 */
	private int STime;

	/**
	 * 기본 생성자
	 * @param j 
	 * @param i 
	 * @param string2 
	 * @param string 
	 */
	public Member(String name, String gender, int use, int rTime) {
		Name = name;
		Gender = gender;
		RTime = rTime;
		Use = use;
	}
	
	public Member(String name, String phone, int rTime) {
		Name = name;
		RTime = rTime;
		Phone = phone;
	}
	
	/**
	 * 필수데이터 초기화 생성자
	 * @param email
	 * @param password
	 * @param name
	 * @param phone
	 * @param gender
	 */

	public Member(String email, String password, String name, String phone,String gender) {

		Email = email;
		Password = password;
		Name = name;
		Phone = phone;
		Gender = gender;
	}
	
	public Member(String email, String password, String name, String phone) {

		Email = email;
		Password = password;
		Name = name;
		Phone = phone;
	}
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 모든데이터 초기화 생성자
	 * @param userid
	 * @param userpw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 * @param mileage
	 */
	
	
	public Member(String email, String password, String name, String phone, String gender, int rTime, int use) {
		super();
		Email = email;
		Password = password;
		Name = name;
		Phone = phone;
		Gender = gender;
		RTime = rTime;
		Use = use;
	}
	
	public Member(String email,String gender, String name, String phone, int rTime, int sTime) {
		Email = email;
		Name = name;
		Phone = phone;
		Gender = gender;
		RTime = rTime;
		STime = sTime;
	}
	

	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getRTime() {
		return RTime;
	}

	public void setRTime(int rTime) {
		RTime = rTime;
	}

	public int getUse() {
		return Use;
	}

	public void setUse(int use) {
		Use = use;
	}
	
	public int getSTime() {
		return RTime;
	}

	public void setSTime(int sTime) {
		STime = sTime;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
/*	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(userid);
		info.append("\t | ");
		info.append(Utility.getSecureString(userpw));
		info.append("\t | ");
		info.append(name);
		info.append("\t | ");
		info.append(mobile);
		info.append("\t | ");
		info.append(email);
		info.append("\t | ");
		info.append(entryDate);
		info.append("\t | ");
		info.append(grade);
		info.append("\t | ");
		info.append(Utility.getNumber(mileage));
	
		return info.toString();
	}*/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}*/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	/*@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Member) {
			Member dto = (Member)obj;
			if(dto.getUserid().equals(userid)) {
				return true;
			}
		}
		return false;
	}*/
	
}
