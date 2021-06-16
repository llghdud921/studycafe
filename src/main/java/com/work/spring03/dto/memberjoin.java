package com.work.spring03.dto;

import java.io.Serializable;

public class memberjoin implements Serializable {

	private String Name;
	private String Day;
	private String Gender;
	
	
	
	public memberjoin() {
		// TODO Auto-generated constructor stub
	}
	
	public memberjoin( String day, String gender) {
		Day = day;
		Gender = gender;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDay() {
		return Day;
	}
	public void setDay(String day) {
		Day = day;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	
	
	
}
