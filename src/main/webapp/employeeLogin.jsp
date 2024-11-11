<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Login - EMS</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/employeeLogin.css">
    <!-- Link to Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

<c:if test="${not empty errorMessage}">
    <div class="alert">${errorMessage}</div>
</c:if>

    <div class="login-wrapper">
        <div class="login-container">
            <div class="logo-container">
                <i class="fas fa-user-circle"></i>
            </div>
            <h1>Employee Login</h1>
            <form action="val" method="POST">
                <div class="input-group">
                    <i class="fas fa-user"></i>
                    <input type="text" name="unm" placeholder="Enter Username" required>
                </div>
                <div class="input-group">
                    <i class="fas fa-lock"></i>
                    <input type="password" name="pas" placeholder="Enter Password" required>
                </div>
                <button type="submit">Login</button>
            </form>
            <a href="#" class="forgot-password">Forgot Password?</a>
            <div class="signup-link">
                Don’t have an account? <a href="employee_signup.jsp">Sign up here</a>
            </div>
        </div>
    </div>
</body>
</html>

