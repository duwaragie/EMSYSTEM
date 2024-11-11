<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payroll Officer Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/payrollUI.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
     <header>
    	<div class="logo">
        <a href="<%= request.getContextPath() %>/PayrollLoginServlet">
            <img src="<%= request.getContextPath() %>/image/blkheadnew.png" alt="Company Logo" >
        </a>
    	</div>
        <h1><a href="<%= request.getContextPath() %>/PayrollLoginServlet">Employee Management System</a></h1>
        <div class="profile">
            <p><%= session.getAttribute("name") != null ? session.getAttribute("name") : "User" %></p>
            <div class="dropdown-content">
                <a href="<%= request.getContextPath() %>/Logout">Logout</a>
            </div>
        </div>
    </header>

    <div class="container">
        <nav class="sidebar">

            <ul>
                <li><a href="<%= request.getContextPath() %>/PayrollLoginServlet">Dashboard</a></li>
                <li><a href="<%= request.getContextPath() %>/EmployeeDetails">Employee Details</a></li>
                <li><a href="<%= request.getContextPath() %>/ReadAttendanceServlet">Attendance</a></li>
                <li><a href="createSalary.jsp">Salary Management</a></li>
                <li><a href="<%= request.getContextPath() %>/ReadPayRecordServlet">Payroll Records</a></li>
                <li><a href="<#">Settings</a></li>
                
                
            </ul>
        </nav>

        <main class="content">
        	<h2>Welcome Payroll Officer, <%= session.getAttribute("name") != null ? session.getAttribute("name") : "User" %> !</h2>
                <p>Manage payroll tasks, employee information, and generate payroll reports.</p>
                         
                
           
            
            <!-- Payroll Summary Section -->
            <section class="payroll-summary">
            <h3>Payroll Summary</h3>
            	<div class="summary-cards">
            		<div class="card">
                        <i class="fas fa-users"></i>
                        <div>
                    		<h4>Total Employees</h4>
                    		<p><%= request.getAttribute("totalEmployees") %></p>
                   		</div>
                    </div>
                	<div class="card">
                        <i class="fas fa-money-bill-wave"></i>
                        <div>
                    		<h4>Pending Salaries</h4>
                    		<p><%= request.getAttribute("pendingSalaries") %></p>
               			 </div>
            		</div>
                 	<div class="card">
                        <i class="fas fa-file-alt"></i>
                        <div>
                    		<h4>Generated Reports</h4>
                    		<p><%= request.getAttribute("generatedReports") %></p>
                		</div>
               		</div>
               	</div>
            </section>
            
            
           <!-- Recent Activity Section -->
            <section class="recent-activity">
                <h3>Recent Activity</h3>
                <ul>
                    <li><i class="fas fa-check"></i> Payslip generated for John Doe (Oct 2024)</li>
                    <li><i class="fas fa-check"></i> Salary adjusted for Jane Smith</li>
                    <li><i class="fas fa-times"></i> Error: Missing tax documents for Mark Johnson</li>
                    <li><i class="fas fa-check"></i> Payslip generated for Alex White (Oct 2024)</li>
                </ul>
            </section>   
            
			<!-- Employee Status Section -->
            <section class="employee-status">
                <h3>Employee Status</h3>
                <div class="status-cards">
                    <div class="card">
                        <i class="fas fa-suitcase-rolling"></i>
                        <div>
                            <h3>Employees on Leave</h3>
                            <p>8</p>
                        </div>
                    </div>
                    <div class="card">
                        <i class="fas fa-minus-circle"></i>
                        <div>
                            <h3>Late Submissions</h3>
                            <p>3</p>
                        </div>
                    </div>
                    <div class="card">
                        <i class="fas fa-exclamation-triangle"></i>
                        <div>
                            <h3>Missing Documentation</h3>
                            <p>5</p>
                        </div>
                    </div>
                </div>
            </section>

            <!-- Alerts Section -->
            <section class="alerts">
                <h3>Alerts</h3>
                <div class="alert-cards">
                    <div class="alert alert-warning">
                        <i class="fas fa-exclamation-circle"></i>
                        <p>Pending approval for payroll adjustments.</p>
                    </div>
                    <div class="alert alert-error">
                        <i class="fas fa-times-circle"></i>
                        <p>Error in tax calculation for 2 employees.</p>
                    </div>
                </div>
            </section>
            
            <!-- Quick Actions Section -->
            <section class="quick-actions">
                <h3>Quick Access</h3>
                <div class="action-buttons">
                	<a href="<%= request.getContextPath() %>/EmployeeDetails" class="button"><i class="fas fa-users"></i> View Employees</a>
                    <a href="createSalary.jsp" class="button"><i class="fas fa-plus"></i> Salary Management</a>
                    <a href="<%= request.getContextPath() %>/ReadPayRecordServlet" class="button"><i class="fas fa-chart-bar"></i>Payroll Records</a>
                    <a href="#" class="button"><i class="fas fa-cog"></i> Settings</a>
					<a href="<%= request.getContextPath() %>/Logout" class="button"><i class="fas fa-sign-out-alt"></i> Logout</a>
                </div>
            </section>  
			
        </main>
    </div>

<jsp:include page="footer.jsp" />
</body>
</html>
