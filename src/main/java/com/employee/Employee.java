package com.employee;

public class Employee {
	private int empID;
	private String name;
	private String email;
	private long phone;
	private String hireDate;
	private String jobTitle;
	private String usrname;
	private String passwd;
	
	public Employee(int empID, String name, String email, long phone, String hireDate, String jobTitle, String usrname,
			String passwd) {
		super();
		this.empID = empID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.jobTitle = jobTitle;
		this.usrname = usrname;
		this.passwd = passwd;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
