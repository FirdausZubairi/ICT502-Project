Here's the fixed code for the page:

```html
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />    
<link rel="stylesheet" href="driver.css">
</head>
<body style="display: flex; flex-direction: column; min-height: 100vh;">

  <!--Navbar-->
<nav class="navbar fixed-top navbar-light bg-light">
    <div class="container-fluid d-flex justify-content-between">
            <a class="navbar-brand" href="login.html">
                <img src="/ICT502-Project/image/bus-stop.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
                BTS
            </a>
        <span class="navbar-text">
            Staff
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
                <a class="nav-link active" aria-current="page" href="dashboard.html" style="margin-top: 70px">
                    <span class="fas fa-home" style="margin-right: 20px"></span>
                    Dashboard
                </a>
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
                <a class="nav-link" href="booking.html">
                    <i class="fa fa-calendar" style="margin-right: 20px"></i>
                    <span>Schedule</span>
                </a>
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
                <a class="nav-link mb-2" href="/view">
                    <i class="fa fa-history" style="margin-right: 20px"></i>
                    <span>Trip History</span>
                </a>
            </div>
        </div>
    </div>
</div>
    <!-- End sidebar -->
    
  <section class="col-10 offset-2 main-section" style="padding-top: 70px">
    <div class="container">
      <div class="row justify-content-center mt-5">
        <div class="col-lg-8">
          <div class="card">
            <div class="card-header">
              <div class="d-flex justify-content-between align-items-center">
                <h5 class="mb-0">Bus Details</h5>
              </div>
            </div>
            <div class="card-body">
              <table id="scheduleTable" class="table">
                <thead>
                  <tr>
                    <th>Staff ID</th>
                    <th>Schedule</th>
                    <th>Trip History</th>
                  </tr>
                </thead>
                <tbody>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  
    <footer class="fixed-bottom">
  <div class="col-10 offset-2 text-center text-white py-2 px-4 px-xl-5 bg-primary" style="width: 100%;">
    &copy; 2023. All rights reserved.
  </div>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>