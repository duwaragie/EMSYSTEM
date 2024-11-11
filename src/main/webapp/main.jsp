<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>IT Support Staff Interface</title>

    <!-- Include FontAwesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <style>
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

        /* CRUD Boxes Styles */
        .crud-boxes {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        .crud-box {
            width: 250px;
            height: 150px;
            background-color: #7DA0FA;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 8px;
            text-align: center;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            transition: background-color 0.3s;
            flex-direction: column;
        }

        .crud-box:hover {
            background-color: #5D85E6;
        }

        .crud-box h3 {
            margin-bottom: 10px;
        }

        .crud-box a {
            text-decoration: none;
            color: white;
        }

        .crud-box button {
            padding: 10px 20px;
            background-color: #98BDFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .crud-box button:hover {
            background-color: #7DA0FA;
        }

        /* Ticket Boxes */
        .ticket-container {
            display: flex; /* Use flexbox for horizontal layout */
            justify-content: space-around; /* Space items evenly */
            padding: 20px; /* Add some padding around the container */
        }

        .ticket-box {
            background-color: #f8f9fa; /* Light background for each box */
            border-radius: 8px; /* Rounded corners */
            padding: 20px; /* Internal padding */
            text-align: center; /* Center the text */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Subtle shadow for depth */
            flex: 1; /* Allow boxes to grow equally */
            margin: 10px; /* Space between boxes */
        }

        .ticket-box i {
            color: #007bff; /* Icon color */
        }

        h2 {
            margin: 10px 0; /* Space above and below the heading */
        }

        small {
            color: #6c757d; /* Darker color for the smaller text */
        }
         /* Feature Boxes Styles */
    .feature-box {
      background-color: #f8f9fa;
      border-radius: 12px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
      transition: transform 0.3s ease, box-shadow 0.3s ease;
      padding: 20px;
      margin: 15px; /* Adjust margin for spacing */
    }

    .feature-box:hover {
      transform: translateY(-10px);
      box-shadow: 0 6px 16px rgba(0, 0, 0, 0.15);
    }

    .feature-box .icon i {
      color: #6c63ff;
      transition: color 0.3s ease;
    }

    .feature-box h4 {
      font-size: 1.5rem;
      color: #333;
      margin-bottom: 15px;
      font-weight: bold;
    }

    .feature-box p {
      color: #777;
      font-size: 1rem;
    }

    .feature-box:hover .icon i {
      color: #4b49ac;
    }

    @media (min-width: 768px) {
      .feature-box {
        height: 100%;
      }
    }

    @media (max-width: 767px) {
      .feature-box {
        margin-bottom: 20px;
      }
    }
    
.image-paragraph-container {
    display: flex; /* Use flexbox for horizontal alignment */
    align-items: center; /* Center items vertically */
    padding: 20px; /* Add some padding around the container */
}

.side-image {
    max-width: 300px; /* Adjust width as needed */
    height: auto; /* Maintain aspect ratio */
    margin-right: 20px; /* Space between image and paragraph */
}

.image-paragraph-container p {
    flex: 1; /* Allow the paragraph to take the remaining space */
    font-size: 16px; /* Adjust font size as needed */
    color: #333; /* Set paragraph text color */
}

        /* Footer styles */
        footer {
            background-color: #4B49AC;
            padding: 1rem;
            text-align: center;
            color: #fff;
            width: 100%;
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

    <!-- Main Content Section -->
    <div class="main-content">

        <!-- CRUD Boxes Section -->
        <div class="crud-boxes">
            <div class="crud-box">
                <h3>Create Ticket</h3>
                <a href="Insert.jsp">
                    <button><i class="fas fa-user-plus"></i> Insert</button>
                </a>
            </div>

            <div class="crud-box">
                <h3>Update Ticket</h3>
                <a href="<%= request.getContextPath() %>/ReadServlet">
                    <button><i class="fas fa-edit"></i> Update</button>
                </a>
            </div>

            <div class="crud-box">
                <h3>Delete Ticket</h3>
                <a href="<%= request.getContextPath() %>/ReadServlet">
                    <button><i class="fas fa-trash-alt"></i> Delete</button>
                </a>
            </div>

            <div class="crud-box">
                <h3>Read Ticket</h3>
                <a href="<%= request.getContextPath() %>/ReadServlet">
                    <button><i class="fas fa-eye"></i> Read</button>
                </a>
            </div>
        </div>

        <div class="ticket-container">
            <div class="ticket-box">
                <i class="fas fa-exclamation-triangle fa-4x text-secondary"></i>
                <h2 class="mb-0 fw-bold">5</h2>
                <small class="text-dark">Pending Tickets</small>
            </div>

            <div class="ticket-box">
                <i class="fas fa-clipboard-check fa-4x text-secondary"></i>
                <h2 class="mb-0 fw-bold">25</h2>
                <small class="text-dark">Resolved Tickets</small>
            </div>
            <div class="ticket-box">
                <i class="fas fa-clipboard-list fa-4x text-secondary"></i>
                <h2 class="mb-0 fw-bold">105</h2>
                <small class="text-dark">Updated Tickets</small>
            </div>
        </div>

        <!-- Feature Boxes Section -->
        <div class="dashboard">
            <div class="feature-box">
                <div class="icon"><i class="fas fa-laptop"></i></div>
                <h4>System Overview</h4>
                <p>Get an overview of the current system status and health checks.</p>
            </div>

            <div class="feature-box">
                <div class="icon"><i class="fas fa-tools"></i></div>
                <h4>Tools & Resources</h4>
                <p>Access quick links to frequently used tools and resources.</p>
            </div>

            <div class="feature-box">
                <div class="icon"><i class="fas fa-users"></i></div>
                <h4>User Management</h4>
                <p>Manage users, roles, and permissions.</p>
            </div>

            <div class="feature-box">
                <div class="icon"><i class="fas fa-comments"></i></div>
                <h4>Support Tickets</h4>
                <p>View and manage incoming support tickets.</p>
            </div>
        </div>
        
    </div>
    
<!-- Image and Paragraph Container -->
<div class="image-paragraph-container">
    <!-- Image for the left side -->
    <img src="${pageContext.request.contextPath}/image/image.jpg" alt="Pending Tickets Image" class="side-image"> <!-- Add your image path -->

    <!-- Paragraph on the right side -->
    <p>IT Support staff maintain and troubleshoot hardware, software, and 
        networks, providing technical assistance to employees. <br>
        They resolve system issues, install software, 
        and ensure smooth IT operations to minimize downtime and support business efficiency.
    </p>
</div>


    <!-- Footer Section -->
<jsp:include page="footer.jsp" />
</body>
</html>
