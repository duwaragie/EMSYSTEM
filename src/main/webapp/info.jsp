<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EMS - About Us</title>
    <link rel="stylesheet" type="text/css" href="css/info.css">
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
</head>
<body>

    <!-- Header Section -->
    <jsp:include page="homeHeader.jsp"></jsp:include>
   

    <!-- About Us Section -->
    <section class="about-section">
        <h2>About Employee Management System</h2>
        <p>At the core of our Employee Management System (EMS) is a vision to simplify and automate the management of employees, payroll, and departmental operations. We focus on providing tools that empower organizations to operate efficiently while improving employee satisfaction.</p>

        <div class="about-content">
            <div class="about-card">
                <h3>Our Vision</h3>
                <p>Our vision is to be the leading employee management software provider, known for innovative solutions that are intuitive and scalable to businesses of all sizes.</p>
            </div>

            <div class="about-card">
                <h3>Our Mission</h3>
                <p>We strive to enhance productivity in organizations by providing tools that streamline time-consuming HR, payroll, and management tasks. Our mission is to empower businesses by allowing them to focus on growth and employee engagement.</p>
            </div>

            <div class="about-card">
                <h3>Our Values</h3>
                <ul>
                    <li><strong>Efficiency:</strong> We believe in creating tools that save time and minimize errors.</li>
                    <li><strong>Transparency:</strong> Our system provides clear, real-time data for better decision-making.</li>
                    <li><strong>Innovation:</strong> We are constantly improving our products to keep up with the latest trends and technologies.</li>
                    <li><strong>Customer Focus:</strong> We work closely with our clients to understand their unique challenges and deliver tailored solutions.</li>
                </ul>
            </div>

            <div class="about-card">
                <h3>Our Story</h3>
                <p>Founded in 2024, our journey began with a mission to help organizations manage their workforce more effectively. Today, we have a growing client base that trusts us to handle their most critical HR tasks. Our commitment to excellence has been recognized with industry awards, and we continue to push the boundaries of what's possible in employee management.</p>
            </div>
        </div>
    </section>

    <!-- Team Section -->
    <section class="team-section">
        <h2>Meet Our Team</h2>
        <div class="team-grid">
            <div class="team-member">
                <img src="image/admin.jpg" alt="CEO" class="team-photo">
                <h4>Zayan Mohamed</h4>
                <p>Chief Executive Officer</p>
            </div>
            <div class = "team-member">
            	<img src="image/payroll.jpg" alt="Payroll" class="team-photo">
                <h4>Duwaragie Kugaraj</h4>
                <p>Chief Payroll Officer</p>
            </div>
            <div class="team-member">
                <img src="image/it.jpg" alt="CTO" class="team-photo">
                <h4>Almeda Ranjith</h4>
                <p>Chief Technology Officer</p>
            </div>
            <div class="team-member">
                <img src="image/hr.jpg" alt="HR Manager" class="team-photo">
                <h4>Nilukshika Clair Roche</h4>
                <p>HR Manager</p>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
