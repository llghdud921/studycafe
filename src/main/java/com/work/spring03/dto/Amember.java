package com.work.spring03.dto;

import java.io.Serializable;

public class Amember implements Serializable {
	   
	   /** 이메일 이메일 형식 */
	   private String Email;
	   /** 비밀번호 6자리~16자리 */ 
	   private String Password;
	   /** 이름 */
	   private String Name;

	   
	   /**
	    * 기본 생성자
	    */
	   public Amember() {
	      super();
	   }
	   
	   
	   public Amember(String email, String password, String name) {
	      super();
	      Email = email;
	      Password = password;
	      Name = name;
	   }
	   
	   public Amember(String name, String password) {
	      Name = name;
	      Password = password;
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
}