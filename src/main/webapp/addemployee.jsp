<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
    <link rel="stylesheet" type = "text/css" href="${pageContext.request.contextPath}/css/addemployeeForm.css"> 
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/redirect.js"></script>
</head>
<body style = "margin-bottom: 20px;">
<jsp:include page="header.jsp" />
    
    <form action="insert" method="post" class ="add-employee-container" onsubmit = "return validateForm()">
        <label for="empName">Employee Name:</label><br>
        <input type="text" id="empName" name="empName" onkeyup="autofillUsername()" required><br><br>

        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <label for="phone">Phone Number:</label><br>
        <input type="text" id="phone" name="phone" required><br><br>

        <label for="hireDate">Hire Date:</label><br>
        <input type="date" id="hireDate" name="hireDate" required><br><br>

        <label for="jobTitle">Job Title:</label><br>
        <input type="text" id="jobTitle" name="jobTitle" required><br><br>

        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" readonly ><br><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Add Employee">
    </form>
    
<jsp:include page="footer.jsp" />

</body>
</html>
