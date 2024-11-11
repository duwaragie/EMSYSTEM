<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Status</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0; /* Removed margin to ensure the footer aligns properly */
        }
        h2 {
            color: #4B49AC;
            text-align: center; /* Center the header */
            margin-top: 100px; /* Add space above the header to separate it from the navbar */
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto; /* Center the table */
            font-size: 18px;
        }
        table, th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 12px; /* Increased padding for better spacing */
        }
        th {
            background-color: #4B49AC; /* Set background color for the header */
            color: white; /* Set text color for header */
        }
        tr:nth-child(even) {
            background-color: white; /* Change even rows to white */
        }
        tr:hover {
            background-color: #7DA0FA;
        }
        /* Basic Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Ensure html and body take full height */
        html, body {
            height: 100%;
        }

        /* Flexbox to make the body take up full height and make content fill the space */
        body {
            display: flex;
            flex-direction: column;
        }

        /* Main content should expand to fill available space */
        .main-content {
            flex: 1;
            margin-top: 70px; /* Ensure this matches the height of the navbar */
        }

        /* Navigation bar styles */
        nav {
        background-color: #4B49AC;
        padding: 1rem;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    nav ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
        display: flex;
    }

    nav ul li {
        margin-right: 15px;
    }

    nav ul li a {
        color: #fff;
        text-decoration: none;
        padding: 10px 15px;
        display: block;
    }

    nav ul li a:hover {
        background-color: #575757;
        border-radius: 4px;
    }

    /* Right-side container for nametag and logout */
    .right-side {
        display: flex;
        align-items: center;
    }

    .nametag {
        color: #fff;
        font-size: 18px;
        margin-right: 20px; /* Space between name tag and logout button */
        text-align: right;
    }

    /* Logout button styles */
    .logout-nav {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }

    .logout-button {
        background-color: #f3797e;
        color: #fff;
        padding: 10px 15px;
        border-radius: 4px;
        text-decoration: none;
        font-weight: bold;
    }

    .logout-button:hover {
        background-color: #d66468;
    }

        /* Footer styles */
        footer {
            background-color: #4B49AC;
            padding: 1rem;
            text-align: center;
            color: #fff;
            width: 100%;
            position: relative; /* Make sure footer is relative to the body */
            margin-top: auto; /* Push footer to the bottom */
        }

        footer ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
        }

        footer ul li {
            margin-right: 15px;
        }

        footer ul li a {
            color: #fff;
            text-decoration: none;
            padding: 10px;
            display: block;
        }

        footer ul li a:hover {
            background-color: #4B49AC;
            border-radius: 4px;
        }

        footer p {
            margin-top: 10px;
            font-size: 14px;
        }

        /* Button Styles */
        .button-container {
            display: flex; /* Use flexbox for button alignment */
            gap: 10px; /* Space between buttons */
        }

        input[type="button"] {
            padding: 8px 12px; /* Add padding for buttons */
            background-color: #4B49AC;
            color: white; /* Button text color */
            border: none; /* Remove default border */
            border-radius: 4px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            transition: background-color 0.3s; /* Transition effect */
        }

        input[type="button"]:hover {
            background-color: #3b3e8c; /* Darker shade on hover */
        }
    </style>
</head>
<body>

    <!-- Navigation Bar -->
<nav>
    <!-- Dashboard and Ticket links -->
    <ul>
        <li><a href="<%= request.getContextPath() %>/main.jsp">Dashboard</a></li>
        <li><a href="<%= request.getContextPath() %>/Insert.jsp">Insert Tickets</a></li>
        <li><a href="<%= request.getContextPath() %>/ReadServlet">Read Tickets</a></li>
        <li><a href="<%= request.getContextPath() %>/ReadServlet">Update & Delete</a></li>
    </ul>

    <!-- Right-side container for name tag and logout button -->
    <div class="right-side">
        <span class="nametag">Hello IT Staff!</span>
        <ul class="logout-nav">
            <li><a class="logout-button" href="<%= request.getContextPath() %>/IILogoutServlet">Logout</a></li>
        </ul>
    </div>
</nav>

    <h2>IT Support Ticket</h2>

    <table>
        <thead>
            <tr>
                <th>History ID</th>
                <th>Ticket ID</th>
                <th>IT Support ID</th>
                <th>Action Taken</th>
                <th>Actions</th> <!-- New header for actions -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tr" items="${itsup}">
                <tr>
                    <td>${tr.historyId}</td>
                    <td>${tr.ticketId}</td>
                    <td><input type="number" name="SupID" form="updateForm${tr.historyId}" value="${tr.iTSupportId}" required></td>
                    <td><input type="text" name="ActTTaken" form="updateForm${tr.historyId}" value="${tr.actionTaken}" required></td>

                    <td>
                        <div class="button-container"> <!-- Container for buttons -->
                            <!-- Update Button -->
                            <form id="updateForm${tr.historyId}" action="ITUpdate" method="post">
                                <input type="hidden" name="HisID" value="${tr.historyId}">
                                <input type="button" value="Update" onclick="confirmUpdate('updateForm${tr.historyId}');">
                            </form>

                            <!-- Delete Button -->
                            <form id="deleteForm${tr.historyId}" action="${pageContext.request.contextPath}/DelTicket" method="post">
                                <input type="hidden" name="HisID" value="${tr.historyId}">
                                <input type="button" value="Delete" onclick="confirmDelete('${tr.historyId}');">
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Footer Section -->
<jsp:include page="footer.jsp" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/redirect.js"></script>
</body>
</html>
