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
          <a class="nav-link active" aria-current="page" href="dashboard.html" style="margin-top: 70px">
            <span class="fas fa-home" style="margin-right: 20px"></span>
            Dashboard
          </a>
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
          <a class="nav-link" href="booking.html">
            <i class="fa-sharp fa-solid fa-ticket" style="margin-right: 20px"></i>
            <span>Booking</span>
          </a>
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
          <a class="nav-link mb-2" href="/view">
            <img src="/img-icon/box-open.png" style="margin-right: 20px" />
            <span>Booking</span>
          </a>
        </div>
      </div>
    </div>
  </div>
  <!-- End sidebar -->

    <!-- SEARCH SECTION -->
    <section class="col-8 offset-3 main-section d-flex justify-content-center align-items-center" id="main" style="padding-top: 70px; background-image: url('https://img.freepik.com/premium-vector/abstract-colorful-gradient-wavy-background_263779-811.jpg'); background-size: cover;">
          <div class="container mt-5">
            <form action="#" method="#">
              <div class="row">
                <div class="col-md-4 mb-3">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
                    </div>
                    <select class="custom-select" id="fromSelect">
                      <option selected>From</option>
                      <option value="1">Location 1</option>
                      <option value="2">Location 2</option>
                      <option value="3">Location 3</option>
                    </select>
                  </div>
                </div>
                <div>
                  <button class="btn btn-primary btn-sm" onclick="swapData()"> <!-- //swap function  -->
                    <i class="fas fa-exchange-alt"></i>
                  </button>
                </div>
                <div class="col-md-4 mb-3">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
                    </div>
                    <select class="custom-select" id="toSelect">
                      <option selected>To</option>
                      <option value="1">Location 1</option>
                      <option value="2">Location 2</option>
                      <option value="3">Location 3</option>
                    </select>
                  </div>
                </div>
                <div>
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="fas fa-calendar-alt"></i></span>
                    </div>
                    <input type="date" class="form-control" id="date" min="">
                  </div>            
                </div>
              </div>
              <div class="col-md-12 text-center">
                <input class="btn btn-secondary btn-lg" type="reset" value="Reset">
                <a href="bookingdetail.jsp" class="btn btn-primary btn-lg active" type="submit" value="Submit" role="button" aria-pressed="true">Submit</a>
              </div>
              <br><br>
            </form>
          </div>
    </section>
    <!-- END OF SEARCH SECTION -->
    

<!-- DISPLAY SECTION -->
<section class="col-8 offset-3 main-section d-flex justify-content-center align-items-center">
  <div class="container-fluid mt-5">
    <table class="table table-striped mt-2">
      <thead>
        <tr>
          <th></th>
          <th>Bus</th>
          <th>Departure</th>
          <th>Arrival</th>
          <th>Fare</th>
          <th>Seats Available</th>
          <th></th>
        </tr>
      </thead>
      <tbody id="AvailableBusTable"></tbody>
    </table>
  </div>
</div>
</section>
        
        
    
    
    


    <script src="booking.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</body>
</html>