<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EMS - Home</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styleHome.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/redirect.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <jsp:include page="homeHeader.jsp" />

    <!-- Hero Section with Background Image -->
    <section class="hero-section">
        <div class="hero-content fade-in">
            <h2>Efficient Employee Management at Your Fingertips</h2>
            <p>Our system is designed to make managing employees, payroll, and departments easy and efficient.</p>
            <a href="#" class="cta-button">Learn More</a>
        </div>
    </section>

    <!-- Features Section with Icons and Pictures -->
    <section class="features-section">
        <h3>Explore Our Core Features</h3>
        <div class="feature-box">
            <i class="fa fa-black-tie fa-2x" aria-hidden="true"></i>
            <h4>Employee Management</h4>
            <p>Seamlessly manage employee information, track records, and coordinate across departments with ease.</p>
        </div>
        <div class="feature-box">
            <i class="fa fa-money fa-2x" aria-hidden="true"></i>
            <h4>Payroll Management</h4>
            <p>Streamline payroll processing with automated calculations and comprehensive financial reports.</p>
        </div>
        <div class="feature-box">
            <i class="fa fa-bar-chart fa-2x" aria-hidden="true"></i>
            <h4>Reporting & Analytics</h4>
            <p>Access real-time insights and reports to help you make data-driven decisions for your workforce.</p>
        </div>
    </section>

    <!-- Testimonials Section -->
    <section class="testimonials-section">
        <h3>What Our Clients Say</h3>
        <div class="testimonial">
            <img src="${pageContext.request.contextPath}/image/Client1.png" alt="Client 1">
            <p>"The EMS has transformed how we manage our employee data. It's intuitive and user-friendly!"</p>
            <h5>— Sundar Pichchai, CEO - Google</h5>
        </div>
        <div class="testimonial">
            <img src="${pageContext.request.contextPath}/image/Client2.png" alt="Client 2">
            <p>"Handling payroll has never been easier! The automated features save us so much time."</p>
            <h5>— Tim Cooke, CEO - Apple inc.</h5>
        </div>
    </section>

    <!-- Call to Action -->
    <section class="call-to-action fade-in">
        <h3>Get Started Today</h3>
        <p>Sign up now and start streamlining your employee management processes.</p>
        <a href="employeeLogin.jsp" class="cta-button">Sign In</a>
    </section>

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
