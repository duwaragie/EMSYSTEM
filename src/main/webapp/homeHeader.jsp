<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/headerHome.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/redirect.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css">
</head>
<body>
 <header class="header">
        <div class="header-content">
            <!-- Logo section -->
            <div class="logo-title-container">
                <img src="${pageContext.request.contextPath}/image/whthead.png" alt="Logo" class="logo">
                <h3 class="header-title">Employee Management System</h3>
            </div>
            
            <nav class="navbar">
                <ul>
                    <li><a href="home.jsp"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                    <li><a href="employeeLogin.jsp"><i class="fa fa-users" aria-hidden="true"></i> Employees</a></li>
                    <li><a href="department.jsp"><i class="fa fa-building" aria-hidden="true"></i> Departments</a></li>
                    <li><a href="info.jsp"><i class="fa fa-info-circle" aria-hidden="true"></i>About</a></li>
                </ul>

                <div class="right-align">
				    <div class="search-bar">
				        <input type="text" placeholder="Search...">
				        <button type="submit"><i class="fa fa-search"  aria-hidden="true"></i></button>
				    </div>
				
				    <div class="dropdown-container">
				        <label for="role-select" class="role-label">Select Role</label>
				        <select id="role-select" name="role" class="dropdown" onchange="redirectToLogin()">
				            <option value="sele">-- Select Role --</option>
				            <option value="admin">Admin</option>
				            <option value="payroll">Payroll</option>
				            <option value="hr">HR</option>
				            <option value="it">IT</option>
				        </select>
				    </div>
				</div>
            </nav>
        </div>
    </header>
</body>
</html>