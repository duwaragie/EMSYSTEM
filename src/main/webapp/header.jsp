<!-- header.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/headerstyle.css">
</head>
<body>
<header>
    <!-- Top section with logo and username -->
    <div class="header-top">
        <a href="<%= request.getContextPath() %>/DashboardServlet">
            <img src="<%= request.getContextPath() %>/image/whthead.png" alt="Company Logo" class="logo">
        </a>
        <div class="user-info">
             <p><%= session.getAttribute("name") != null ? session.getAttribute("name") : "Guest User" %></p>
             <a class="logout-button" href="<%= request.getContextPath() %>/LogoutServlet">Logout</a>
        </div>
    </div>

    <!-- Navigation section (this will wrap to a new line if needed) -->
    <nav class="navbar">
        <ul>
            <li><a href="addemployee.jsp">Add Employee</a></li>
            <li><a href="<%= request.getContextPath() %>/ReadEmployeeServlet">Manage Employees</a></li>
            <li><a href="<%= request.getContextPath() %>/ManagePayrollServlet">Manage Payroll</a></li>
            <li><a href="<%= request.getContextPath() %>/ManageLeaveServlet">Manage Leaves</a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Settings</a></li>
        </ul>
	</nav>
</header>
</body>
</html>

