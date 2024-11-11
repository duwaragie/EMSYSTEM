<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Dashboard - EMS</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/employeeDashboard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

    <div class="dashboard-container">
        <aside class="sidebar">
            <div class="logo-container">
                <i class="fas fa-user-circle"></i>
                <h2>EMS Dashboard</h2>
            </div>
            <nav>
                <ul>
                    <li><a href="<%= request.getContextPath() %>/employeeLoginServlet"><i class="fas fa-home"></i> Home</a></li>
                    <li><a href="#"><i class="fas fa-tasks"></i> Tasks</a></li>
                    <li><a href="#"><i class="fas fa-calendar-alt"></i> Attendance</a></li>
                    <li><a href="#"><i class="fas fa-file-alt"></i> Reports</a></li>
                    <li><a href="#"><i class="fas fa-user"></i> Profile</a></li>
                    <li><a href="<%= request.getContextPath() %>/Logout"><i class="fas fa-sign-out-alt"></i> Logout</a></li>
                </ul>
            </nav>
        </aside>

        <main class="content">
            <header>
                <h2> Welcome, <%= session.getAttribute("name") != null ? session.getAttribute("name") : "User" %>! </h2>
            </header>
            <section class="dashboard-content">
                <div class="card">
                    <i class="fas fa-tasks"></i>
                    <h3>Tasks</h3>
                    <p><%= request.getAttribute("Tasks") %></p>
                </div>
                <div class="card">
                    <i class="fas fa-calendar-alt"></i>
                    <h3>Attendance</h3>
                    <p>Your Attendance rate: <%= request.getAttribute("Leave") %></p>
                </div>
                <div class="card">
                    <i class="fas fa-file-alt"></i>
                    <h3>Reports</h3>
                    <p>You have <%= request.getAttribute("Reports") %> pending</p>
                </div>
                <div class="card">
                    <i class="fas fa-user"></i>
                    <h3>Profile</h3>
                    <p><%= request.getAttribute("totalEmployees") %></p>
                </div>
            </section>
        </main>
    </div>

</body>
</html>
