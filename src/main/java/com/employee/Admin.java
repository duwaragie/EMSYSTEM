package com.employee;

public class Admin {
	private int AdminID;
	private String name;
	private String email;
	private int phone;
	private String uname;
	private String pword;
	
	public Admin(int adminID, String name, String email, int phone, String uname, String pword) {
		super();
		this.AdminID = adminID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.uname = uname;
		this.pword = pword;
	}

	public int getAdminID() {
		return AdminID;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getPhone() {
		return phone;
	}

	public String getUname() {
		return uname;
	}

	public String getPword() {
		return pword;
	}
}
