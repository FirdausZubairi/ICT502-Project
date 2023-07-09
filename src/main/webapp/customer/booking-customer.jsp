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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="booking.css">
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


    <!-- SEARCH SECTION -->
    <section class="col-10 offset-2 main-section d-flex justify-content-center align-items-center" id="main" style="padding-top: 70px; background-image: url('https://img.freepik.com/premium-vector/abstract-colorful-gradient-wavy-background_263779-811.jpg'); background-size: cover; background-position: center; background-repeat: no-repeat;">
          <div class="container mt-5">
            <form action="#" method="#">
              <div class="row">
                <div class="col-md-4 mb-3">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
                    </div>
<div class="form-control-plaintext text-center" style="padding-top: 0.375rem; border: 1px solid #ced4da; border-radius: 0.25rem; background-color: #f8f9fa;">KL Sentral</div>





                  </div>
                </div>
				
                <div class="col-md-4 mb-3">
  				<div class="input-group">
    			<div class="input-group-prepend">
    			<span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
    			</div>
    			<select class="custom-select" id="toSelect">
      			<option disabled selected>Select destination</option>
      			<option value="1">Melaka Sentral</option>
      			<option value="2">Kelantan Sentral</option>
      			<option value="3">Cheras Sentral</option>
      			<option value="4">Terminal Bas Kota Bharu</option>
    			</select>
  				</div>
				</div>

<div class="col-md-4 mb-3">
  <div class="input-group">
    <div class="input-group-prepend">
      <span class="input-group-text"><i class="fas fa-calendar-alt"></i></span>
    </div>
    <input type="date" class="form-control text-center" id="date" min="">
  </div>
</div>


              </div>
<div class="col-md-12 text-center">
  <input class="btn btn-secondary btn-sm" type="reset" value="Reset">
  <a href="bookingdetail.jsp" class="btn btn-primary btn-sm active" type="submit" value="Submit" role="button" aria-pressed="true">Submit</a>
</div>

              <br><br>
            </form>
          </div>

<footer class="fixed-bottom">
  <div class="col-10 offset-2 text-center text-white py-2 px-4 px-xl-5 bg-primary" style="width: 100%;">
    &copy; 2023. All rights reserved.
  </div>
</footer>

          
    </section>
    <!-- END OF SEARCH SECTION -->

    


    <script src="booking.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</body>
</html>