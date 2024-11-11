<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave</title>
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
        
    </style>
</head>
<body>
   <div class=" container">
 
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

    <!-- Main Content -->
    <div class="main-content">
        <h2>Employee Leave Table</h2>
        
   <div class="search-container">
            <input type="text" id="searchInput" placeholder="Enter Employee ID" onkeyup="Leave()">
        <table id="leaveTable">
            <thead>
                <tr>
                    
                    <th>Leave ID</th>
                    <th>Leave Type</th>
                    <th>StartDate</th>
                     <th>EndDate</th>
                     <th>LeaveStatus</th>
                    <th>Reason</th>
                     <th>DateApproved</th>
                    <th>DateRejected</th>
                    <th>Employee ID</th>
                    <th>Approved
                       RejectedBy</th>
                     <th>DateSubmitted</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lev" items="${leave}">
                    <tr>
                        <td>${lev.leaveId}</td>
                        <td>${lev.leaveType}</td>
                        <td>${lev.startDate}</td>
                        <td>${lev.endDate}</td>
                         <td>${lev.leaveStatus}</td>
                        <td>${lev.reason}</td>
                         <td>${lev. dateApproved}</td>
                        <td>${lev.dateRejected}</td>
                         <td>${lev. employeeId}</td>
                         <td>${lev. approvedRejectedBy}</td>
                        <td>${lev. dateSubmitted}</td>
                      </tr>
                </c:forEach>
            </tbody>
        </table>

    </div> 
    
    </div> 
     </div>
             <jsp:include page="NiluFooter.jsp" />
 
         <script>
        function Leave() {
            const input = document.getElementById('searchInput');
            const filter = input.value.toLowerCase();
            const table = document.getElementById('leaveTable');
            const rows = table.getElementsByTagName('tr');

            for (let i = 1; i < rows.length; i++) {
                const cells = rows[i].getElementsByTagName('td');
                let match = false;

                
                if (cells[8]) { 
                    const employeeId = cells[8].textContent || cells[8].innerText;
                    match = employeeId.toLowerCase().includes(filter);
                }

                
                rows[i].style.display = match ? '' : 'none';
            }
        }
    </script>
</body>
</html>
                     
                  
                
          
                        