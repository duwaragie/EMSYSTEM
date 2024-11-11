package main.hr;

public class EmpStatus {
	
	private int employeeId;
	private String employeeName;
	private  String employeeStatus;
	
	
         public EmpStatus(int employeeId, String employeeName, String employeeStatus) {
		
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeStatus = employeeStatus;
	}

	
	public int getEmployeeId() {
		return employeeId;
	}



	public String getEmployeeName() {
		return employeeName;
	}


	public String getEmployeeStatus() {
		return employeeStatus;
	}


}
