<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
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
      <!--User account-->
      <div class="dropdown">
        <button class="btn dropdown-toggle nav-box" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Farid</button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
          <li><a class="dropdown-item" href="index.html">Logout</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <!--Side bar menu-->
  <div class="container-fluid">
    <div class="row">
      <nav class="col-md-2 d-none d-md-block bg-light sidebar">
        <div class="sidebar-sticky">
          <ul class="nav flex-column">
            <li class="nav-item">
              <a class="nav-link" href="dashboard.html">
                <span class="fas fa-home"></span>
                Dashboard
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="booking.html">
                <i class="fa-sharp fa-solid fa-ticket"></i>
                Booking
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/view">
                <img src="/img-icon/box-open.png"/>
                Ticket
              </a>
            </li>
          </ul>
        </div>
      </nav>
      </div>
      </div>

   <section class="col-10 offset-2 main-section" style="padding-top: 20px">
    <div class="container">
        <!-- Customer's Details -->
        <div class="row mt-5">
            <div class="col-lg-12">
                <h2>Customer's Details</h2>
                <div class="card">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Name:</label>
                            <p id="customerName"></p>
                        </div>
                        <div class="form-group">
                            <label>User Name:</label>
                            <p id="customerUsername"></p>
                        </div>
                        <div class="form-group">
                            <label>Phone Number:</label>
                            <p id="customerPhone"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Staff's Details -->
        <div class="row mt-5">
            <div class="col-lg-12">
                <h2>Staff's Details</h2>
                <div class="card">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Name:</label>
                            <p id="staffName"></p>
                        </div>
                            <div class="form-group">
                            <label>User Name:</label>
                            <p id="staffUsername"></p>
                        </div>
                        <div class="form-group">
                            <label>Phone Number:</label>
                            <p id="staffPhone"></p>
                        </div>
                        <div class="form-group">
                            <label>Role:</label>
                            <p id="staffRole"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </section>

    <!-- JavaScript to fill the fields. In real scenario, this could be a data fetch from server-side -->
    <script>
        document.getElementById("customerName").innerText = "John Doe";
        document.getElementById("customerUsername").innerText = "john.doe";
        document.getElementById("customerPhone").innerText = "0123456789";

        document.getElementById("staffName").innerText = "Jane Smith";
        document.getElementById("staffUsername").innerText = "jane.smith@company.com";
        document.getElementById("staffPhone").innerText = "0123456789";
        document.getElementById("staffRole").innerText = "Driver";
        
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
</body>
</html>
