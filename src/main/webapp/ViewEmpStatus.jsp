<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Status</title>
    <style>
           
         body {
        font-family: Arial, sans-serif;
        margin: 0;
        display: flex;
        flex-direction: column; 
        height: 100vh;
        background-color: #f4f4f9;
    }
           
       .container{
        display:flex;
        
       
       }    
    .sidebar {
        width: 250px;
        background-color: #4B49AC;
        color: white;
        padding: 10px;
        height: 86vh; 
        border-radius:0px,6px,0px,0px;
    }

    .sidebar h2 {
        text-align: center;
        color: white;
    }

    .sidebar ul {
        list-style-type: none;
        padding: 0;
    }

    .sidebar ul li {
        padding: 20px;
        cursor: pointer;
        color: white;
        transition: background-color 0.3s;
    }

    .sidebar ul li:hover {
        background-color: #7DA0FA;
    }

    .main-content {
        flex: 1; 
        padding: 20px;
        display: flex;
        flex-direction: column; 
        justify-content: flex-start; 
    }

    h2 {
        color: #7978E9;
        text-align: center;
    }

    table {
        width: 80%;
        border-collapse: collapse;
        margin: 20px auto;
        font-size: 18px;
    }

    table, th, td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    th {
        background-color: #98BDFF;
        color: #333;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #f1f1f1;
    }
    
    
          input[type="submit"] {
        padding: 10px 30px;
        border: none;
        cursor: pointer;
    }
     input[type="submit"]:hover {
        opacity: 0.8;
    }

    .update-btn {
        background-color: #98BDFF;
        color: white;
    }

   
    .delete-btn {
        background-color: #7978E9;
        color: white;
    }
        
    </style>
</head>
<body>

    <div class = "container">
    <div class="sidebar">
        <h2>Human Resource</h2>
        <ul>
            <li onclick="location.href='Nilu.jsp'">Dashboard</li>
            <li onclick="location.href='ApproveLeave.jsp'">Register Employee Status</li>
            <li onclick="location.href='<%= request.getContextPath() %>/EmployeeViewServlet'">View Status</li>
            <li onclick="location.href='<%= request.getContextPath() %>/TicketServlet'">HR Tickets</li>
            <li onclick="location.href='<%= request.getContextPath() %>/LeaveServlet'">Leave</li>
            <li onclick="location.href='<%= request.getContextPath() %>/attendServlet'">Attendance</li>
        </ul>
    </div>


    <div class="main-content">
        <h2>Employee Details</h2>
         <div class="search-container">
            <input type="text" id="searchField" placeholder="Search by Employee ID or Employee Status" onkeyup="filterEmployees()">
        </div>

        <table id="employeeTable">
            <thead>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Employee Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="es" items="${emp}">
                    <tr>
                        <td>${es.employeeId}</td>
                        <td>${es.employeeName}</td>
                        <td>
                            <select id="employeeStatus" name="employeeStatus" form="updateForm${es.employeeId}" required>
                                <option value="" disabled ${es.employeeStatus == null ? 'selected' : ''}>Select Employee Status</option>
                                <option value="Active" ${'Active'.equals(es.employeeStatus) ? 'selected' : ''}>Active</option>
                                <option value="Inactive" ${'Inactive'.equals(es.employeeStatus) ? 'selected' : ''}>Inactive</option>
                                <option value="On Leave" ${'On Leave'.equals(es.employeeStatus) ? 'selected' : ''}>On Leave</option>
                                <option value="Resigned" ${'Resigned'.equals(es.employeeStatus) ? 'selected' : ''}>Resigned</option>
                                <option value="Retired" ${'Retired'.equals(es.employeeStatus) ? 'selected' : ''}>Retired</option>
                            </select>
                        </td>
                        <td>
                            <form id="updateForm${es.employeeId}" action="hrupdate" method="post">
                                <input type="hidden" name="employeeId" value="${es.employeeId}">
                                <input type="submit" value="Update" class="update-btn" onclick="return confirmUpdate('updateForm${es.employeeId}');">
                            </form>
                        
                        
                        <form id="deleteForm${es.employeeId}" action="hrdelete" method="post">
                                <input type="hidden" name="employeeId" value="${es.employeeId}">
                                <input type="submit" value="delete" class ="delete-btn" onclick="return confirmDelete('deleteForm${es.employeeId}');">
                            </form>
                        
                        </td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    </div>
    <jsp:include page="NiluFooter.jsp"/>
   <script src="js/view.js"></script>
    
</body>
</html>