<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Salary Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/salary.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/createSalary.js"></script>
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
        <div class="sidebar-form">
            <nav class="sidebar">
                <ul>
	                <li><a href="<%= request.getContextPath() %>/PayrollLoginServlet">Dashboard</a></li>
	                <li><a href="<%= request.getContextPath() %>/EmployeeDetails">Employee Details</a></li>
	                <li><a href="<%= request.getContextPath() %>/ReadAttendanceServlet">Attendance</a></li>
	                <li><a href="createSalary.jsp">Salary Management</a></li>
	                <li><a href="<%= request.getContextPath() %>/ReadPayRecordServlet">Payroll Records</a></li>
	                <li><a href="#">Settings</a></li>
                </ul>
            </nav>
        </div>

        <div class="form-container">
            <h2>Employee Salary Management</h2>

            <!-- Add onsubmit to prevent form submission if validation fails -->
            <form id="salaryForm" action="ins" method="POST" onsubmit="return validateForm();">
                <div class="form-group">
                    <label for="employeeID">Employee ID</label>
                    <input type="text" id="employeeID" name="emID" required placeholder="Enter Employee ID">
                </div>
                <div class="form-group">
                    <label for="basicSalary">Basic Salary</label>
                    <input type="number" id="basicSalary" name="baSal" required placeholder="Enter Basic Salary" oninput="calculateNetSalary()">
                </div>
                <div class="form-group">
                    <label for="allowance">Allowance</label>
                    <input type="number" id="allowance" name="all" required placeholder="Enter Allowance" oninput="calculateNetSalary()">
                </div>
                <div class="form-group">
                    <label for="deductions">Deductions</label>
                    <input type="number" id="deductions" name="ded" required placeholder="Enter Deductions" oninput="calculateNetSalary()">
                </div>
                <div class="form-group">
                    <label for="netSalary">Net Salary</label>
                    <input type="number" id="netSalary" name="neSal" placeholder="Net Salary" readonly>
                </div>
                <div class="form-group">
                    <label for="paymentDate">Payment Date</label>
                    <input type="date" id="paymentDate" name="paDt" required >
                </div>
                <button type="submit">Create Payroll Record</button>
            </form>
        </div>
    </div>
    
    <jsp:include page="footer.jsp"/>
</body>

</html>
