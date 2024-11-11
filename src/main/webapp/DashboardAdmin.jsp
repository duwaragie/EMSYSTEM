<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EMS - Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Dashboardadmin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- For icons -->
</head>
<body>
<jsp:include page="header.jsp" />

<c:if test="${not empty message}">
    <div class="alert">${message}</div>
</c:if>

<section class="dashboard">
    <!-- Welcome Section -->
    <p>Welcome, <%= session.getAttribute("name") != null ? session.getAttribute("name") : "User" %>!</p>
    <h2>Admin Overview</h2>

    <!-- Main Statistics Section -->
    <div class="stats-container">
        <div class="stat-box">
            <i class="fas fa-users icon"></i>
            <h3>Total Employees</h3>
            <p><%= request.getAttribute("totalEmployees") %></p>
        </div>
        <div class="stat-box">
            <i class="fas fa-building icon"></i>
            <h3>Departments</h3>
            <p><%= request.getAttribute("totalDepartments") %></p>
        </div>
        <div class="stat-box">
            <i class="fas fa-envelope-open-text icon"></i>
            <h3>Pending Leave Requests</h3>
            <p><%= request.getAttribute("pendingLeaves") %></p>
        </div>
        <div class="stat-box">
            <i class="fas fa-file-invoice-dollar icon"></i>
            <h3>Payroll Processed</h3>
            <p><%= request.getAttribute("payrollProcessed") %></p>
        </div>
    </div>

    <!-- Recent Activity Section -->
    <section class="recent-activity">
        <h2>Recent Activity</h2>
        <ul>
            <li>John Doe requested leave - 2 days ago</li>
            <li>Payroll for September processed successfully</li>
            <li>New employee Jane Smith added to Marketing</li>
            <li>IT department team meeting scheduled</li>
        </ul>
    </section>

    <!-- Graphs Section (Placeholder for Data Visualization) -->
    <section class="charts">
        <div class="chart-box">
            <h4>Employee Growth</h4>
            <img src="${pageContext.request.contextPath}/image/img2.png" alt="Employee Growth Chart" />
        </div>
        <div class="chart-box">
            <h4>Department Performance</h4>
            <img src="${pageContext.request.contextPath}/image/img3.png" alt="Department Performance Chart" />
        </div>
    </section>

    <!-- Quick Actions Section -->
    <section class="quick-actions">
        <h2>Quick Actions</h2>
        <div class="actions-container">
            <a href="addemployee.jsp" class="action-btn"><i class="fas fa-user-plus"></i> Add New Employee</a>
            <a href="<%= request.getContextPath() %>/ManageLeaveServlet" class="action-btn"><i class="fas fa-calendar-check"></i> View Leave Requests</a>
            <a href="<%= request.getContextPath() %>/ManagePayrollServlet" class="action-btn"><i class="fas fa-money-check-alt"></i> Process Payroll</a>
            <a href="viewReports.jsp" class="action-btn"><i class="fas fa-chart-bar"></i> View Reports</a>
        </div>
    </section>

    <!-- Announcements Section -->
    <section class="announcements">
        <h2>Company Announcements</h2>
        <div class="announcement-box">
            <h4>Annual Performance Review</h4>
            <p>The performance review process will start from October 15. Managers are requested to complete their evaluations.</p>
        </div>
        <div class="announcement-box">
            <h4>Company Picnic</h4>
            <p>Join us for the annual company picnic on November 5. All employees and families are invited!</p>
        </div>
    </section>
</section>

<jsp:include page="footer.jsp" />
</body>
</html>
