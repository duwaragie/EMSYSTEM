<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/addlogin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EMS - Admin Login</title>
</head>
<body>
    <jsp:include page="homeHeader.jsp" />
    <!-- Main Content Section for Login -->
    <div class="container">
        <div class="gif-container">
            <img src="${pageContext.request.contextPath}/image/itSupp.gif" alt="Admin GIF" class="login-gif" />
        </div>
        <div class="form-container">
            <form action="itsupportstafflogin" method="POST" class="form">
                <p id="heading">Welcome, IT Cheif</p>

                <!-- Username Input Field -->
                <div class="field">
                    <i class="fas fa-user input-icon"></i>
                    <input autocomplete="off" placeholder="Username" class="input-field" type="text" name="ITusername" required>
                </div>

                <!-- Password Input Field -->
                <div class="field">
                    <i class="fas fa-lock input-icon"></i>
                    <input placeholder="Password" class="input-field" type="password" name="ITPassword" required>
                </div>

                <!-- Login Button -->
                <div class="btn">
                    <input type="submit" class="button1" value="Login" />
                    <button type="button" class="button2" onclick="window.location.href='signup.jsp'">Sign Up</button>
                </div>

                <!-- Forgot Password Button -->
                <button type="button" class="button3">Forgot Password</button>
            </form>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
