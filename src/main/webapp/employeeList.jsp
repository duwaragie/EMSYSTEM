<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/empList.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/redirect.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
    <style>
    </style>
</head>
<body style="margin-bottom: 20px;">
<jsp:include page="header.jsp" />

<h2>Employee List</h2>

<c:if test="${not empty message}">
    <div class="alert">${message}</div>
</c:if>

<!-- Search Bar -->
<div class="search-container">
    <input type="text" id="searchInput" class="search-bar" placeholder="Search by ID or Name" onkeyup="filterTable()">
     <button id="generateBtn" onclick="window.location.href='<%= request.getContextPath() %>/GenEmpList'">Generate PDF</button>
</div>

<table id="employeeTable">
    <thead>
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Hire Date</th>
            <th>Job Title</th>
            <th>Username</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <!-- Iterate over the list of employees using JSTL -->
        <c:forEach var="employee" items="${employees}">
            <tr>
  <!-- Employee Details -->
            <td>${employee.empID}</td>
            <td>${employee.name}</td>
            <td><input type="email" name="employeeemail" form="updateForm${employee.empID}" value="${employee.email}" required></td>
            <td><input type="text" name="employeephone" form="updateForm${employee.empID}" value="${employee.phone}" required></td>
            <td><input type="date" name="employeehireDate" form="updateForm${employee.empID}" value="${employee.hireDate}" required></td>
            <td><input type="text" name="employeejobTitle" form="updateForm${employee.empID}" value="${employee.jobTitle}" required></td>
            <td>${employee.usrname}</td>
            <td>
                <input type="password" name="employeepasswd" id="passwd${employee.empID}" form="updateForm${employee.empID}" 
                       value="${employee.passwd}" required>
                <!-- Password toggle visibility -->
                <div class="checkbox-container">
                    <label>Show Password</label>
                    <input type="checkbox" id="togglePass${employee.empID}" onclick="togglePasswordVisibility('passwd${employee.empID}')">
                </div>
            </td>
                <!-- Action buttons for Update and Delete -->
                <td>
                    <!-- Update Button/Form -->
                    <form id="updateForm${employee.empID}" action="Update" method="post">
                        <input type="hidden" name="employeeid" value="${employee.empID}">
                        <input type="hidden" name="employeename" value="${employee.name}">
                        <input type="button" value="Update" onclick="confirmUpdate('updateForm${employee.empID}');">
                    </form>
                    <!-- Delete Button/Form -->
                    <form id="deleteForm${employee.empID}" action="del" method="post" style="margin-top: 10px;">
                        <input type="hidden" name="employeeid" value="${employee.empID}">
                        <input type="button" value="Delete" onclick="confirmDelete('${employee.empID}');">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp" />

<script>
    function filterTable() {
        const input = document.getElementById('searchInput');
        const filter = input.value.toLowerCase();
        const table = document.getElementById('employeeTable');
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
