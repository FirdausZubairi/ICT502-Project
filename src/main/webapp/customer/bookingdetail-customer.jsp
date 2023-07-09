<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Bus Ticketing System</title>
  <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="css/dasboard.css">

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
            Booking
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
  
<section class="col-10 offset-2 main-section" style="padding-top: 70px">
  <div class="container">
    <div class="row d-flex align-items-center justify-content-center">
      <div class="col-md-6">
        <div style="text-align: center;">
          <img alt="Dashboard Account" src="/ICT502-Project/image/BookingDetail-customer.jpg" style="width: 100%;">
        </div>
      </div>
      <div class="col-md-6">
        <h1>Passenger Details</h1>
        <form action="paymentmethod-customer.jsp">
          <div class="form-group">
            <label for="customerName">Name</label>
            <input type="text" class="form-control" id="customerName" placeholder="Enter passenger name" required>
          </div>
          <div class="form-group">
            <label for="phoneNo">Phone Number</label>
            <input type="tel" class="form-control" id="phoneNo" placeholder="Enter your phone number" required>
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </div>
</section>

   <footer class="mt-auto">
    <div class="text-center text-white py-2 px-4 px-xl-5 bg-primary">
        &copy; 2023. All rights reserved.
    </div>
</footer>

<script src="booking.js"></script>
  <!-- Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
