package com.employee;

public class Payroll {

	private int OfficerID;
	private String Name;
	private int Phone;
	private String Email;
	private String username;
	private String password;
	
	
	public Payroll(int officerID, String name, int phone, String email, String username, String password) {
		this.OfficerID = officerID;
		this.Name = name;
		this.Phone = phone;
		this.Email = email;
		this.username = username;
		this.password = password;
	}


	public int getOfficerID() {
		return OfficerID;
	}

	public String getName() {
		return Name;
	}

	public int getPhone() {
		return Phone;
	}


	public String getEmail() {
		return Email;
	}

	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	
}
