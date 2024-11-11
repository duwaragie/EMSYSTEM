package main.hr;

public class Leave {

	private int leaveId;
	private String LeaveType;
	private String StartDate;
	private String EndDate ; 
	private String LeaveStatus;
	private String Reason;
	private String DateApproved; 
	private String DateRejected;
	private int  EmployeeId ;
	private String ApprovedRejectedBy;  
	private String DateSubmitted;
	
	public Leave(int leaveId, String leaveType, String startDate, String endDate, String leaveStatus, String reason,
			String dateApproved, String dateRejected, int employeeId, String approvedRejectedBy, String dateSubmitted) {
			
		    this.leaveId = leaveId;
			this.LeaveType = leaveType;
			this.StartDate = startDate;
			this.EndDate = endDate;
			this.LeaveStatus = leaveStatus;
			this.Reason = reason;
			this.DateApproved = dateApproved;
			this.DateRejected = dateRejected;
			this.EmployeeId = employeeId;
			this.ApprovedRejectedBy = approvedRejectedBy;
			this.DateSubmitted = dateSubmitted;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveType() {
		return LeaveType;
	}

	public void setLeaveType(String leaveType) {
		LeaveType = leaveType;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getLeaveStatus() {
		return LeaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		LeaveStatus = leaveStatus;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getDateApproved() {
		return DateApproved;
	}

	public void setDateApproved(String dateApproved) {
		DateApproved = dateApproved;
	}

	public String getDateRejected() {
		return DateRejected;
	}

	public void setDateRejected(String dateRejected) {
		DateRejected = dateRejected;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public String getApprovedRejectedBy() {
		return ApprovedRejectedBy;
	}

	public void setApprovedRejectedBy(String approvedRejectedBy) {
		ApprovedRejectedBy = approvedRejectedBy;
	}

	public String getDateSubmitted() {
		return DateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		DateSubmitted = dateSubmitted;
	}
	
}
