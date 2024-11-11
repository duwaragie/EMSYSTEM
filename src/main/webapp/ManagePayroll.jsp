<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Payroll</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/empList.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/redirect.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
    <style>
    </style>
</head>
<body style="margin-bottom: 20px;">
<jsp:include page="header.jsp" />	

<h2>Payroll Records</h2>

<c:if test="${not empty message}">
    <div class="alert">${message}</div>
</c:if>

<!-- Search Bar -->
<div class="search-container">
    <input type="text" id="searchInput" class="search-bar" placeholder="Search by ID or Status" onkeyup="filterTable()">
     <button id="generateBtn" onclick="window.location.href='<%= request.getContextPath() %>/GenPayRecordPDF'">Generate PDF</button>
</div>

<div class="table-container">
		
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
			        
			    </tr>
			    
					    <!-- Use JSTL to iterate over the list of records -->
					     <c:forEach var="payRec" items="${rec}">
					        <tr>
								<td>${payRec.payrollID}</td>
					            <td>${payRec.empId}</td>
					            <td>${payRec.basicSalary}</td>
					            <td>${payRec.allowances}</td>
					            <td>${payRec.deductions}</td>
					            <td>${payRec.netSalary}</td>
					            <td>${payRec.status}</td>
					            <td>${payRec.paymentDate}</td>
							</tr>
						</c:forEach>
				</table>
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
            const tdName = tr[i].getElementsByTagName('td')[6]; // Status
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