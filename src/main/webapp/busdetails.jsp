<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />    
<link rel="stylesheet" href="dasboard.css">
</head>
<body>


  <!--Navbar-->
  <nav class="navbar fixed-top navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="login.html">
        <img src="/ICT502-Project/image/bus-stop.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
        BUS TICKETING
      </a>

 <!--User account-->
      <div class="btn-container-user">
        <div class="dropdown">
          <button class="btn dropdown-toggle nav-box" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">zaid</button>
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
          <a class="nav-link" href="busdetails.html">
            <i class="fa-sharp fa-solid fa-ticket" style="margin-right: 20px"></i>
            <span>Bus Details</span>
          </a>
          
      </div>
    </div>
  </div>
  <!-- End sidebar -->
  <table id="scheduleTable" class="table col-10 offset-2 mt-5">
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

  <script>
    // Sample data for schedule, trip history, and staff ID
    var scheduleData = [
      { staffID: '1001', schedule: 'Monday - 9:00 AM', tripHistory: 'Trip 1' },
      { staffID: '1002', schedule: 'Tuesday - 2:00 PM', tripHistory: 'Trip 2' },
      { staffID: '1003', schedule: 'Wednesday - 11:30 AM', tripHistory: 'Trip 3' }
      // Add more data objects for additional schedule and trip history entries
    ];

    // Get the table body element
    var tableBody = document.querySelector('#scheduleTable tbody');

    // Populate the table with data
    scheduleData.forEach(function(data) {
      var row = document.createElement('tr');
      var staffIDCell = document.createElement('td');
      var scheduleCell = document.createElement('td');
      var tripHistoryCell = document.createElement('td');
      staffIDCell.textContent = data.staffID;
      scheduleCell.textContent = data.schedule;
      tripHistoryCell.textContent = data.tripHistory;
      row.appendChild(staffIDCell);
      row.appendChild(scheduleCell);
      row.appendChild(tripHistoryCell);
      tableBody.appendChild(row);
    });
  </script>
    









<script src="booking.jsp"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>