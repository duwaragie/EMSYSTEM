<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Human Resource Dashboard</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column; /* Stack children vertically */
            height: 110vh; /* Full viewport height */
            background-color: #f4f4f9;
        }

        .containe {
            display: flex;
            flex: 1; 
            overflow: auto; /* Allow scrolling */
        }

        .sidebar {
            position: fixed; /* Keeps sidebar in place */
            width: 230px;
            background-color: #4B49AC; 
            color: white;
            padding: 10px;
            height: 100%; /* Full height */
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
            margin-left: 250px; /* Space for the sidebar */
            padding: 20px;
            flex: 1; /* Allow this to grow */
            display: flex;
            flex-direction: column; /* Stack children vertically */
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
            border-bottom: 2px solid #98BDFF; 
            padding-bottom: 10px;
        }

        .welcome-message {
            font-size: 24px;
            font-weight: bold;
            color: #444;
        }

        .header-icons {
            display: flex;
            align-items: center;
        }

        .bell-icon {
            width: 30px;
            height: 30px;
            margin-right: 15px;
            cursor: pointer;
        }

        .profile-picture {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            cursor: pointer;
        }

        .logout-btn {
            background-color: #f44336;
            color: white;
            padding: 8px 16px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            margin-left: 20px;
            transition: background-color 0.3s;
        }

        .logout-btn:hover {
            background-color: #d32f2f; 
        }

        .date-picker {
            margin-top: 20px;
            display: flex;
            align-items: center;
        }

        .date-picker label {
            font-size: 18px;
            color: #444;
            margin-right: 10px;
        }

        .date-picker input {
            padding: 8px;
            border: 1px solid #7978E9; 
            border-radius: 5px;
            outline: none;
            transition: border-color 0.3s;
        }

        .date-picker input:focus {
            border-color: #98BDFF; 
        }

        .dashboard-cards {
          display: flex;
    justify-content: flex-start; /* Align cards to the start */
    margin-top: 30px;
    flex-wrap: wrap; /* Allow cards to wrap to the next line */
}

        .card {
            background-color: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    flex: 1 1 200px; /* Allow cards to grow and shrink */
    max-width: 250px; /* Set a maximum width for each card */
    margin: 10px; /* Add margin for spacing */
    transition: transform 0.3s;
        }

        .card:last-child {
            margin-right: 0;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2);
        }

        .card h3 {
            margin: 0;
            color: #555;
        }

        .card p {
            font-size: 20px;
            margin: 10px 0 0;
            color: #333;
        }


          .quote {
            margin-top: 30px;
            font-size: 18px;
            font-style: italic;
            color:  #4B49AC;
            border-left: 4px solid #4B49AC; /* Left border for emphasis */
            padding-left: 10px; /* Padding for space */
            align-self: flex-end; /* Align to the right */
            max-width: 300px; /* Limit width */
        }
        
        
        @media (max-width: 768px) {
            .sidebar {
                width: 100%;
                height: auto;
                position: relative;
            }

            .main-content {
                margin-left: 0; /* Remove margin for mobile */
                padding: 10px;
            }

            .dashboard-cards {
                flex-direction: column; /* Stack cards vertically */
            }

            .card {
                margin-right: 0;
                margin-bottom: 20px; /* Space between stacked cards */
            }
        }

        footer {
            background-color: #f4f4f9; /* Match page background */
            color: #7978E9;    
            text-align: center;
            padding: 10px 0;
            position: relative; /* Adjust positioning */
            width: 100%; /* Full width */
            bottom: 0; /* Align at the bottom */
            
        }
        
        .bottom-left {
      position: absolute;
    bottom: 60px;
    left: 300px; /* Adjust left position for better alignment */
    width: 700px; /* Set a reasonable width */
    height: auto;
    }
    </style>
</head>
<body>
    <div class="containe">
        <div class="sidebar">
            <h2>Human Resource</h2>
            <ul>
                <li onclick="location.href='#'">Dashboard</li>
                <li onclick="location.href='ApproveLeave.jsp'">Register Employee Status</li>
                <li onclick="location.href='<%= request.getContextPath() %>/EmployeeViewServlet'">View Status</li>
                <li onclick="location.href='<%= request.getContextPath() %>/TicketServlet'">HR Tickets</li>
                <li onclick="location.href='<%= request.getContextPath() %>/LeaveServlet'">Leave</li>
                <li onclick="location.href='<%= request.getContextPath() %>/attendServlet'">Attendance</li>
            </ul>
        </div>

        <div class="main-content">
            <!-- Header -->
            <div class="header">
                <!-- Welcome message -->
                <div class="welcome-message">
                    Welcome, <%= session.getAttribute("name") %>!
                </div>

                <div class="header-icons">
                    <img src="img/belly.png" alt="Notifications" class="bell-icon">
                    <img src="img/bell.png" alt="Profile" class="profile-picture">
                    <form action="HRLogoutServlet" method="POST">
                        <button class="logout-btn">Logout</button>
                    </form>
                </div>
            </div>

            <!-- Date Picker -->
            <div class="date-picker">
                <label for="date">Select Date:</label>
                <input type="date" id="date" name="date">
            </div>

            <!-- Dashboard Cards -->
            <div class="dashboard-cards">
                <div class="card">
                    <h3>Employees</h3>
                    <p>326</p>
                </div>
                <div class="card">
                    <h3>Present</h3>
                    <p>306</p>
                </div>
                <div class="card">
                    <h3>On Leave</h3>
                    <p>20</p>
                </div>
                <div class="card">
                    <h3>Pending HR Tickets</h3>
                    <p>9</p>
                </div>
            </div>
            
             <div class="quote">
                "The only way to do great work is to love what you do." – Steve Jobs
            </div>
            
            <img src="img/staff.gif" class="bottom-left">
        </div>
    </div>

    <footer>
        <jsp:include page="NiluFooter.jsp"/> 
    </footer>
</body>
</html>
