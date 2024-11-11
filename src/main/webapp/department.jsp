<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EMS - Departments</title>
    <link rel="stylesheet" type="text/css" href="css/department.css">
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
</head>
<body>

    <!-- Header Section -->
   <jsp:include page="homeHeader.jsp"></jsp:include>

    <!-- Department Section -->
    <section class="departments-section">
        <h2>Departments Overview</h2>
        <p>Explore the key departments that form the backbone of our organization. Each department plays a crucial role in maintaining smooth operations and driving growth.</p>

        <div class="departments-grid">
            <div class="department-card">
                <i class="fa fa-users fa-3x" aria-hidden="true"></i>
                <h3>Human Resources</h3>
                <p>Responsible for recruiting, onboarding, training, and ensuring employee satisfaction. The HR department ensures compliance with labor laws and manages employee benefits.</p>
                <a href="hr-details.html" class="cta-button">Learn More</a>
            </div>

            <div class="department-card">
                <i class="fa fa-money fa-3x" aria-hidden="true"></i>
                <h3>Payroll</h3>
                <p>The Payroll team ensures timely and accurate salary payments, manages tax deductions, and coordinates employee bonuses. They play a critical role in financial well-being.</p>
                <a href="payroll-details.html" class="cta-button">Learn More</a>
            </div>

            <div class="department-card">
                <i class="fa fa-building fa-3x" aria-hidden="true"></i>
                <h3>IT Support</h3>
                <p>Our IT team keeps all systems running smoothly, from maintaining the company's network infrastructure to providing technical support for employees across all departments.</p>
                <a href="it-details.html" class="cta-button">Learn More</a>
            </div>

            <div class="department-card">
                <i class="fa fa-bar-chart fa-3x" aria-hidden="true"></i>
                <h3>Finance</h3>
                <p>Finance manages budgeting, financial planning, and reporting. They ensure that the company remains fiscally healthy by analyzing performance and making strategic recommendations.</p>
                <a href="finance-details.html" class="cta-button">Learn More</a>
            </div>

            <div class="department-card">
                <i class="fa fa-handshake-o fa-3x" aria-hidden="true"></i>
                <h3>Sales & Marketing</h3>
                <p>The Sales & Marketing department works to promote our services, generate leads, and build relationships with clients. They are the driving force behind the company's revenue.</p>
                <a href="sales-marketing-details.html" class="cta-button">Learn More</a>
            </div>
        </div>
    </section>

    <!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
