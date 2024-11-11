package com.employee;

public class Attendance {

	private int AttendanceId;
	private int EmpId;
	private String Date;
	private String Status;
	private String CheckInTime;
	private String CheckOutTime;
	
	
	public Attendance(int attendanceId, int empId, String date, String status, String checkInTime,String checkOutTime) {
		this.AttendanceId = attendanceId;
		this.EmpId = empId;
		this.Date = date;
		this.Status = status;
		this.CheckInTime = checkInTime;
		this.CheckOutTime = checkOutTime;
	}


	public int getAttendanceId() {
		return AttendanceId;
	}


	public int getEmpId() {
		return EmpId;
	}


	public String getDate() {
		return Date;
	}


	public String getStatus() {
		return Status;
	}


	public String getCheckInTime() {
		return CheckInTime;
	}


	public String getCheckOutTime() {
		return CheckOutTime;
	}


	public void setAttendanceId(int attendanceId) {
		AttendanceId = attendanceId;
	}


	public void setEmpId(int empId) {
		EmpId = empId;
	}


	public void setDate(String date) {
		Date = date;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public void setCheckInTime(String checkInTime) {
		CheckInTime = checkInTime;
	}


	public void setCheckOutTime(String checkOutTime) {
		CheckOutTime = checkOutTime;
	}
	
	
	
}
