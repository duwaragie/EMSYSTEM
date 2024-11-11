package com.employee;

public class PayrollRecord {
	
	private int PayrollID;
	private int EmpId;
	private String BasicSalary;
	private String Allowances;
	private String Deductions;
	private String NetSalary;
	private String Status;
	private String PaymentDate;
	
	
	public PayrollRecord(int payrollID, int empId, String basicSalary, String allowances, String deductions, String netSalary, String status, String paymentDate) {
		this.PayrollID = payrollID;
		this.EmpId = empId;
		this.BasicSalary = basicSalary;
		this.Allowances = allowances;
		this.Deductions = deductions;
		this.NetSalary = netSalary;
		this.Status = status;
		this.PaymentDate = paymentDate;
	}


	public int getPayrollID() {
		return PayrollID;
	}


	public int getEmpId() {
		return EmpId;
	}


	public String getBasicSalary() {
		return BasicSalary;
	}


	public String getAllowances() {
		return Allowances;
	}


	public String getDeductions() {
		return Deductions;
	}


	public String getNetSalary() {
		return NetSalary;
	}


	public String getStatus() {
		return Status;
	}


	public String getPaymentDate() {
		return PaymentDate;
	}


	public void setPayrollID(int payrollID) {
		PayrollID = payrollID;
	}


	public void setEmpId(int empId) {
		EmpId = empId;
	}


	public void setBasicSalary(String basicSalary) {
		BasicSalary = basicSalary;
	}


	public void setAllowances(String allowances) {
		Allowances = allowances;
	}


	public void setDeductions(String deductions) {
		Deductions = deductions;
	}


	public void setNetSalary(String netSalary) {
		NetSalary = netSalary;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}
	
}
