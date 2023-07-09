<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking</title>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
    <link rel="stylesheet" href="dasboard.css">
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined&display=swap" rel="stylesheet">
</head>
<body style="display: flex; flex-direction: column; min-height: 100vh;">
    <!--Navbar-->
   <!--Navbar-->
<nav class="navbar fixed-top navbar-light bg-light">
    <div class="container-fluid d-flex justify-content-between">
            <a class="navbar-brand" href="login.html">
                <img src="/ICT502-Project/image/bus-stop.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
                BTS
            </a>
        <span class="navbar-text">
            Tickets
        </span>
        <!--User account-->
        <div class="btn-container-user">
            <div class="dropdown">
                <button class="btn dropdown-toggle nav-box" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">Farid</button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <li><a class="dropdown-item" href="index.html">Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>
 <!--Sidebar menu-->
<div class="container-fluid">
  <div class="row">
    <div class="col-2 position-fixed" id="sticky-sidebar" style="border-right: #888; box-shadow: 2px 0px 5px rgba(0,0,0,0.1);">
      <div class="nav flex-column flex-nowrap vh-100 overflow-auto text-white" style="padding: 15px 0">
        <a class="nav-link active" aria-current="page" href="dashboard.jsp" style="margin-top: 70px">
          <span class="fas fa-home" style="margin-right: 20px"></span>
          Dashboard
        </a>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
        <a class="nav-link" href="booking-customer.jsp">
          <i class="fa fa-bus" style="margin-right: 20px"></i>
          <span>Booking</span>
        </a>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
        <a class="nav-link mb-2" href="viewticket.jsp">
          <i class="fa-sharp fa-solid fa-ticket" style="margin-right: 20px"></i>
          <span>View Ticket</span>
        </a>
      </div>
    </div>
  </div>
</div>
<!-- End sidebar -->

    <!-- Display section -->
    <section class="col-10 offset-2 main-section" style="padding-top: 70px">
      <div class="container" style="text-align: center;">
        <div class="container" style="border: 1px solid #ccc; padding: 10px; margin-top: 50px;">
          <h2>Search Bus Ticket Details</h2>
          <form>
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required>
            <br><br>
            <button type="submit">Search</button>
          </form>
        </div>
        <div class="container" style="border: 1px solid #ccc; padding: 20px; margin-top: 50px;">
          <h2>Bus Information</h2>
          <div>
            <p><strong>Bus Name:</strong> ABC Bus</p>
            <p><strong>Plate No:</strong> XYZ123</p>
            <p><strong>Destination:</strong> City B</p>
            <p><strong>State:</strong> State X</p>
            <p><strong>Type:</strong> Deluxe</p>
            <p><strong>Date:</strong> 2023-07-10</p>
            <p><strong>Price:</strong> $50</p>
          </div>
        </div>
      </div>
    </section>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
</body>
</html>