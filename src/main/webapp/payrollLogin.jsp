<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/addlogin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EMS - Payroll Officer Login</title>
</head>
<body>
    <!-- Header Section -->
<jsp:include page="homeHeader.jsp"></jsp:include>

    <!-- Main Content Section with GIF and Form -->
    <div class="container">
        <!-- GIF Section -->
        <div class="gif-container">
            <img src="${pageContext.request.contextPath}/image/pay.gif" alt="Animated GIF" class="login-gif" />
        </div>

        <!-- Login Form Section -->
        <div class="form-container">
            <form action="log" method="post" class="form">
                <p id="heading">Welcome, Payroll Officer</p>

                <!-- Username Input Field -->
                <div class="field">
                    <i class="fas fa-user input-icon"></i>
                    <input autocomplete="off" placeholder="Username" class="input-field" type="text" name="Rname" required>
                </div>

                <!-- Password Input Field -->
                <div class="field">
                    <i class="fas fa-lock input-icon"></i>
                    <input placeholder="Password" class="input-field" type="password" name="pass" required>
                </div>

                <!-- Submit and Other Buttons -->
                <div class="btn">
                    <input type="submit" class="button1" value="Login" />
                    <button type="button" class="button2" onclick="window.location.href='signup.jsp'">Sign Up</button>
                </div>
                <button type="button" class="button3">Forgot Password</button>
            </form>
        </div>
    </div>

    <!-- Footer Section -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
