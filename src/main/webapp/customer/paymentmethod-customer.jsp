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

<body>
      <!--Navbar-->
  <nav class="navbar fixed-top navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="login.html">
        <img src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
        LOGO
      </a>
      <h3 class="h3 text-center">
          Ticket Booking
      </h3>
      <!--User account-->
      <div class="btn-container-user">
        <div class="dropdown">
          <button class="btn dropdown-toggle nav-box" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Farid</button>
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
          <a class="nav-link active" aria-current="page" href="dashboard-staff.jsp" style="margin-top: 70px">
            <span class="fas fa-home" style="margin-right: 20px"></span>
            Dashboard
          </a>
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
          <a class="nav-link" href="booking.html">
            <i class="fas fa-bus" style="margin-right: 20px"></i>
            <span>Booking</span>
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
          <h2 class="mt-5">Bus Ticket Payment</h2>
          <form action="/process-payment" method="POST">
            <div class="form-group">
              <label for="cardholder">Cardholder Name</label>
              <input type="text" class="form-control" id="cardholder" name="cardholder" required>
            </div>
            <div class="form-group">
              <label for="cardnumber">Card Number</label>
              <input type="text" class="form-control" id="cardnumber" name="cardnumber" required>
            </div>
            <div class="form-row">
              <div class="col-md-6">
                <label for="expiry">Expiration Date</label>
                <input type="text" class="form-control" id="expiry" name="expiry" placeholder="MM/YY" required>
              </div>
              <div class="col-md-6">
                <label for="cvv">CVV</label>
                <input type="text" class="form-control" id="cvv" name="cvv" required>
              </div>
            </div>
            <div class="form-group mt-4">
              <label for="amount">Total Amount</label>
              <input type="text" class="form-control" id="amount" name="amount" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Pay Now</button>
          </form>
        </div>
      </div>
      </div>
      </section>
      
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>