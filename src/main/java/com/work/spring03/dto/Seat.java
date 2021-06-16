package com.work.spring03.dto;

public class Seat {
	
	private int Tnumber;
	private String Gender;
	private String Name;
	private String seatTF;
	private int UseTime;
	
	public Seat() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Seat(int tnumber, String gender, String name, String seatTF, int useTime) {
		super();
		Tnumber = tnumber;
		Gender = gender;
		Name = name;
		this.seatTF = seatTF;
		UseTime = useTime;
	}



	public int getTnumber() {
		return Tnumber;
	}

	public void setTnumber(int tnumber) {
		Tnumber = tnumber;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSeatTF() {
		return seatTF;
	}

	public void setSeatTF(String seatTF) {
		this.seatTF = seatTF;
	}

	public int getUseTime() {
		return UseTime;
	}

	public void setUseTime(int useTime) {
		UseTime = useTime;
	}


	

}
