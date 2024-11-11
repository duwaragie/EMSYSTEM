package main.hr;

public class Attendance {

	
	private int attendanceId;
	private int empId;
     private String date;
     private String status;
     private String checkInTime;
     private String checkOutTime;
     
     
	public Attendance(int attendanceId, int empId, String date, String status, String checkInTime,
			String checkOutTime) {
	
		this.attendanceId = attendanceId;
		this.empId = empId;
		this.date = date;
		this.status = status;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}


	public int getAttendanceId() {
		return attendanceId;
	}


	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCheckInTime() {
		return checkInTime;
	}


	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}


	public String getCheckOutTime() {
		return checkOutTime;
	}


	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	
	
}
