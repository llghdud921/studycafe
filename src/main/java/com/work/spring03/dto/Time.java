package com.work.spring03.dto;

public class Time {
	
	private String InTime;
	private String OutTime;
	private String UseTime;
	private String Name;
	private String Day;
	
	
	public Time() {
		// TODO Auto-generated constructor stub
	}


	public Time(String inTime, String outTime, String useTime, String name, String day) {
		super();
		InTime = inTime;
		OutTime = outTime;
		UseTime = useTime;
		Name = name;
		Day = day;
	}


	public String getInTime() {
		return InTime;
	}


	public void setInTime(String inTime) {
		InTime = inTime;
	}


	public String getOutTime() {
		return OutTime;
	}


	public void setOutTime(String outTime) {
		OutTime = outTime;
	}


	public String getUseTime() {
		return UseTime;
	}


	public void setUseTime(String useTime) {
		UseTime = useTime;
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
	

}
