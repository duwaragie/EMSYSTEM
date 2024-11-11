<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Status Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/EmployeeStatus.css">
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column; 
            height: 100vh; 
            background-color: #f4f4f9;
        }

        .containe {
            display: flex;
            flex: 1; 
        }

        .sidebar {
            width: 250px;
            background-color: #4B49AC;
            color: white;
            padding: 20px;
            height: 100%; 
            flex-shrink: 0; 
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
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .container {
            width: 600px;
            background-color: #fff;
            padding: 40px; 
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
        }

        h1 {
            color: #4B49AC;
            margin-bottom: 20px;
        }

        label {
            font-size: 16px;
            color: #333;
            margin-top: 10px;
            display: block;
            text-align: left;
        }

        input[type="text"], select {
            width: 100%;
            padding: 12px;
            margin-top: 8px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #4B49AC;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #7DA0FA;
        }
    </style>
</head>
<body>
    <div class="containe">
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
            <div class="container">
                <h1>Employee Status Form</h1>
                <form action="hrinsert" method="POST" onsubmit="return validateForm()">
                    <label for="employeeId">Employee ID</label>
                    <input type="text" id="employeeId" name="employeeId" required>

                    <label for="employeeName">Employee Name</label>
                    <input type="text" id="employeeName" name="employeeName" required>

                    <label for="employeeStatus">Employee Status</label>
                    <select id="employeeStatus" name="employeeStatus" required>
                        <option value="">Select Employee Status</option>
                        <option value="Active">Active</option>
                        <option value="Inactive">Inactive</option>
                        <option value="On Leave">On Leave</option>
                        <option value="Resigned">Resigned</option>
                        <option value="Retired">Retired</option>
                    </select>

                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>        
    </div>
    
    <jsp:include page="NiluFooter.jsp"/> 

    <script src="js/status.js"></script>
</body>
</html>
