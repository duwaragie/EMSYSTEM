<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Ticket Form</title>
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
      font-family: Arial, sans-serif;
    }

    /* Main content should expand to fill available space */
    .main-content {
      flex: 1;
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 20px;
      background-color: #f4f4f4;
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
    /* Form Styles */
    .crud-form {
      width: 100%;
      max-width: 400px;
      padding: 30px;
      background-color: #7DA0FA;
      color: white;
      border-radius: 8px;
      box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
      display: flex;
      flex-direction: column;
      gap: 20px;
    }

    .crud-form h3 {
      text-align: center;
      margin-bottom: 10px;
    }

    .crud-form label {
      margin-bottom: 5px;
      font-weight: bold;
    }

    .crud-form input, .crud-form textarea, .crud-form select {
      width: 100%;
      padding: 10px;
      border-radius: 4px;
      border: none;
      font-size: 14px;
    }

    .crud-form textarea {
      resize: vertical;
      height: 100px;
    }

    .crud-form select {
      background-color: #555;
      color: white;
    }

    .crud-form button {
      padding: 12px;
      background-color: #7978E9;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
      transition: background-color 0.3s;
    }

    .crud-form button:hover {
      background-color: #575757;
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
      flex-wrap: wrap;
    }

    footer ul li {
      margin: 5px 10px;
    }

    footer ul li a {
      color: #fff;
      text-decoration: none;
      padding: 8px 12px;
      display: block;
    }

    footer ul li a:hover {
      background-color: #575757;
      border-radius: 4px;
    }

    footer p {
      margin-top: 10px;
      font-size: 14px;
    }

    /* Responsive Design */
    @media (max-width: 600px) {
      .crud-form {
        padding: 20px;
      }

      nav ul {
        flex-direction: column;
      }

      nav ul li {
        margin-right: 0;
        margin-bottom: 10px;
      }

      footer ul {
        flex-direction: column;
      }

      footer ul li {
        margin: 5px 0;
      }
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
    <!-- Insert Ticket Form -->
    <form class="crud-form" action="ITinsert" method="post">
      <h3>Insert New Ticket</h3>
      
      <!-- Ticket ID Field -->
      <div>
        <label for="ticket-id">Ticket ID</label>
        <input type="text" id="ticket-id" name="ticketid" placeholder="Enter the Ticket ID" required>
      </div>
      
      <!-- IT Support ID Field -->
      <div>
        <label for="it-support-id">IT Support ID</label>
        <input type="text" id="it-support-id" name="itsupportid" placeholder="Enter IT Support ID" required>
      </div>

      <!-- Action Taken Field -->
      <div>
        <label for="action-taken">Action Taken</label>
        <textarea id="action-taken" name="actiontaken" placeholder="Describe the action taken" required></textarea>
      </div>
      

      <!-- Submit Button -->
      <button type="submit">Create Ticket</button>
    </form>
  </div>

  <!-- Sticky Footer -->
<jsp:include page="footer.jsp" />

</body>
</html>
