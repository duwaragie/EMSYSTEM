package com.employee;

public class EmpLeave {
	
	private int leaveId;
    private String leaveType;
    private String startDate;
    private String endDate;
    private String leaveStatus;
    private String reason;
    private String dateApproved;
    private String dateRejected;
    private int employeeId;
    private int approvedRejectedBy;
    private String dateSubmitted;
    
    
	public EmpLeave(int leaveId, String leaveType, String startDate, String endDate, String leaveStatus, String reason, String dateApproved, String dateRejected, int employeeId, int approvedRejectedBy, String dateSubmitted) {
		this.leaveId = leaveId;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveStatus = leaveStatus;
		this.reason = reason;
		this.dateApproved = dateApproved;
		this.dateRejected = dateRejected;
		this.employeeId = employeeId;
		this.approvedRejectedBy = approvedRejectedBy;
		this.dateSubmitted = dateSubmitted;
	}


	public int getLeaveId() {
		return leaveId;
	}


	public String getLeaveType() {
		return leaveType;
	}


	public String getStartDate() {
		return startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public String getLeaveStatus() {
		return leaveStatus;
	}


	public String getReason() {
		return reason;
	}


	public String getDateApproved() {
		return dateApproved;
	}


	public String getDateRejected() {
		return dateRejected;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public int getApprovedRejectedBy() {
		return approvedRejectedBy;
	}


	public String getDateSubmitted() {
		return dateSubmitted;
	}


	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}


	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}


	public void setDateRejected(String dateRejected) {
		this.dateRejected = dateRejected;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public void setApprovedRejectedBy(int approvedRejectedBy) {
		this.approvedRejectedBy = approvedRejectedBy;
	}


	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	
	
    
}
