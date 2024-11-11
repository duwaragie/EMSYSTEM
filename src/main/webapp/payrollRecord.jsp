<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payroll Record List</title>
	 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/record.css"> 
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
		
		<h2> Payroll Record List </h2>
		
		<!-- Search Bar -->
		<div class="search-container">
		    <input type="text" id="searchInput" class="search-bar" placeholder="Search by ID" onkeyup="filterTable()">
		    
		</div>
			<table id = "payrollTable">
			    <tr>
			        <th>Payroll ID</th>
			        <th>Employee ID</th>
			        <th>Basic Salary</th>
			        <th>Allowances</th>
			        <th>Deductions</th>
			        <th>Net Salary</th>
			        <th>Status</th>
			        <th>Payment Date</th>
			        <th>Action</th>
			    </tr>
	    <!-- Use JSTL to iterate over the list of records -->
	    <c:forEach var="payRec" items="${rec}">
	        <tr>
	            <!-- Form fields for each employee inside the <td> elements -->
	            <td>${payRec.payrollID}</td>
	            <td>${payRec.empId}</td>
	            <td><input type="number" name="basicsalary" form="updateForm${payRec.payrollID}" value="${payRec.basicSalary}" required></td>
	            <td><input type="number" name="allowance" form="updateForm${payRec.payrollID}" value="${payRec.allowances}" required></td>
	            <td><input type="number" name="deduction" form="updateForm${payRec.payrollID}" value="${payRec.deductions}" required></td>
	            <%-- <td><input type="number" name="netsalary" form="updateForm${payRec.payrollID}" value="${payRec.netSalary}"></td> --%>
	            <td>${payRec.netSalary}</td>
	            <td><input type="text" name="status" form="updateForm${payRec.payrollID}" value="${payRec.status}"></td>
	            <td><input type="date" name="paydate" form="updateForm${payRec.payrollID}" value="${payRec.paymentDate}" required></td>
	    
	            <td>
	            	<div class="button-container">
	            	<!-- Update Button -->
					<form id="updateForm${payRec.payrollID}" action="Upd" method="post">
					    <input type="hidden" name="payrollid" value="${payRec.payrollID}">
					    <input type="button" value="Update" onclick="confirmUpdate('updateForm${payRec.payrollID}');">
					</form>
					
					<!-- Delete Button -->
	                <form id="deleteForm${payRec.payrollID}" action="Delete" method="post" >
	                    <input type="hidden" name="payrollid" value="${payRec.payrollID}">
	                    <input type="button" value="Delete" onclick="confirmDelete('${payRec.payrollID}');">
	                </form>
					</div>
	            </td>
	        </tr>
	    </c:forEach>
		</table>
		
		<button id="generateBtn" onclick="window.location.href='<%= request.getContextPath() %>/GeneratePayRecordPDF'">Generate PDF</button>
		<div class="alert-container" >
		<c:if test="${not empty message}">
		<div class="alert">${message}</div>
		</c:if>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />
<script>
    function filterTable() {
        const input = document.getElementById('searchInput');
        const filter = input.value.toLowerCase();
        const table = document.getElementById('payrollTable');
        const tr = table.getElementsByTagName('tr');

        // Iterate through all rows except the header
        for (let i = 1; i < tr.length; i++) {
            const tdID = tr[i].getElementsByTagName('td')[1]; // Employee ID
            if (tdID) {
                const idValue = tdID.textContent || tdID.innerText;

                // Display row if it matches filter text
                if (idValue.toLowerCase().indexOf(filter) > -1) {
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
