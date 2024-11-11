<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Leaves</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/empList.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/redirect.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
    <style>
    </style>
</head>
<body style="margin-bottom: 20px;">
<jsp:include page="header.jsp" />	

<h2>Leave Records</h2>

<c:if test="${not empty message}">
    <div class="alert">${message}</div>
</c:if>

<!-- Search Bar -->
<div class="search-container">
    <input type="text" id="searchInput" class="search-bar" placeholder="Search by Status or ID" onkeyup="filterTable()">
    <button id="generateBtn" onclick="window.location.href='<%= request.getContextPath() %>/GenerateEmpLeavePDF'">Generate PDF</button>
</div>

<div class="table-container">
		
			<table id = "leaveTable">
			    <tr>
			        <th>Leave ID</th>
			        <th>Leave Type</th>
			        <th>Start Date</th>
			        <th>End Date</th>
			        <th>Leave Status</th>
			        <th>Reason</th>
			        <th>Date Approved</th>
			        <th>Date Rejected</th>
			        <th>Employee ID</th>
			        <th>Approved/ Rejected By</th>
			        <th>Date Submitted</th>
			    </tr>
			    
					    <!-- Use JSTL to iterate over the list of records -->
					     <c:forEach var="EM" items="${emp}">
					        <tr>
								<td>${EM.leaveId}</td>
					            <td>${EM.leaveType}</td>
					            <td>${EM.startDate}</td>
					            <td>${EM.endDate}</td>
					            <td>${EM.leaveStatus}</td>
					            <td>${EM.reason}</td>
					            <td>${EM.dateApproved}</td>
					            <td>${EM.dateRejected}</td>
					            <td>${EM.employeeId}</td>
					            <td>${EM.approvedRejectedBy}</td>
					            <td>${EM.dateSubmitted}</td>
							</tr>
						</c:forEach>
				</table>
</div>

<jsp:include page="footer.jsp" />
<script>
    function filterTable() {
        const input = document.getElementById('searchInput');
        const filter = input.value.toLowerCase();
        const table = document.getElementById('leaveTable');
        const tr = table.getElementsByTagName('tr');

        // Iterate through all rows except the header
        for (let i = 1; i < tr.length; i++) {
            const tdID = tr[i].getElementsByTagName('td')[4]; // Status
            const tdName = tr[i].getElementsByTagName('td')[8]; //Employee ID
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