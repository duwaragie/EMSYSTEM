<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/att.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/createSalary.js"></script>
</head>

<body style = "margin-bottom: 20px;">

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
        
        
        	<div class="table-container">
	
			<h2> Employee List </h2>
			
			<!-- Search Bar -->
		<div class="search-container">
		    <input type="text" id="searchInput" class="search-bar" placeholder="Search by ID or Name" onkeyup="filterTable()">
		</div>
			
			<table id= "EmployeeTable">
			    <tr>
			        <th>Employee ID</th>
		            <th>Name</th>
		            <th>Email</th>
		            <th>Phone</th>
		            <th>Hire Date</th>
		            <th>Job Title</th>
			    </tr>
	
	    <!-- Use JSTL to iterate over the list of records -->
	    <c:forEach var="employee" items="${employees}">
	        <tr>
	            
	            <td>${employee.empID}</td>
            	<td>${employee.name}</td>
            	<td>${employee.email}</td>
	            <td>${employee.phone}</td>
	            <td>${employee.hireDate}</td>
	            <td>${employee.jobTitle}</td>

	        </tr>
	    </c:forEach>
		</table>

	<button id="generateBtn" onclick="window.location.href='<%= request.getContextPath() %>/GenerateEmployeeDetailsPDF'">Generate PDF</button>
</div>

</div>
<jsp:include page="footer.jsp" />

<script>
    function filterTable() {
        const input = document.getElementById('searchInput');
        const filter = input.value.toLowerCase();
        const table = document.getElementById('EmployeeTable');
        const tr = table.getElementsByTagName('tr');

        // Iterate through all rows except the header
        for (let i = 1; i < tr.length; i++) {
            const tdID = tr[i].getElementsByTagName('td')[0]; // Employee ID
            const tdName = tr[i].getElementsByTagName('td')[1]; // Name
            if (tdID || tdName) {
                const idValue = tdID.textContent || tdID.innerText;
                const nameValue = tdName.textContent || tdName.innerText;

                // Display row if it matches filter text
                if (idValue.toLowerCase().indexOf(filter) > -1 || nameValue.toLowerCase().indexOf(filter) > -1) {
                    tr[i].style.display = ""; // Show row
                } else {
                    tr[i].style.display = "none"; // Hide row
                }
            }       
        }
    }
</script>
</body>
</html>