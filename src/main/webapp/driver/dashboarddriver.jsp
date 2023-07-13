<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DashboardDriver</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="driver.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

</head>
<body style="display: flex; flex-direction: column; min-height: 100vh;">


	<!--Navbar-->
	<nav class="navbar fixed-top navbar-light bg-light">
		<div class="container-fluid d-flex justify-content-between">
			<a class="navbar-brand" href="login.html"> <img
				src="/ICT502-Project/image/bus-stop.png" alt="" width="30"
				height="24" class="d-inline-block align-text-top"> BTS
			</a> <span class="navbar-text"> Driver </span>
			<!--User account-->
			<div class="btn-container-user">
				<a class="dropdown-item" href="/ICT502-Project/login.jsp">Logout</a>
			</div>
		</div>
	</nav>

	<!--Sidebar menu-->
	<div class="container-fluid">
		<div class="row">
			<div class="col-2 position-fixed" id="sticky-sidebar"
				style="border-right: #888; box-shadow: 2px 0px 5px rgba(0, 0, 0, 0.1);">
				<div
					class="nav flex-column flex-nowrap vh-100 overflow-auto text-white"
					style="padding: 15px 0">
					<a class="nav-link active" aria-current="page"
						href="dashboarddriver.jsp" style="margin-top: 70px"> <span
						class="fas fa-home" style="margin-right: 20px"></span> Dashboard
					</a>
					<div
						class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom"
						style="padding: 0 40px"></div>
					<a class="nav-link" href="schedule-driver"> <i
						class="fa fa-calendar" style="margin-right: 20px"></i> <span>Schedule</span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<!-- End sidebar -->

	<section class="col-10 offset-2 main-section" style="padding-top: 70px">
		<h3>Welcome</h3>
		<hr
			style="height: 2px; border-width: 0; color: #808080; background-color: #808080">
		<div class="offset-4 justify-content-center" style="height: 400px; width: 400px;">
			<canvas id="pieChart" style=""></canvas>
		</div>
		
		<p id="bus" style="display: none;">${busCount}</p>
		<p id="dest" style="display: none;">${destCount}</p>
		
		<p style="text-align: center;">Discover a seamless way to travel
			with our advanced bus booking system. Experience convenience,
			reliability, and efficiency as you effortlessly reserve your bus
			tickets, manage your bookings, and stay updated on bus schedules.
			With our user-friendly interface and comprehensive features, embark
			on a hassle-free journey and explore the world one bus ride at a
			time.</p>
		<div class="text-center">
			<a href="booking.html" class="btn btn-primary btn-lg">View
				details</a>
		</div>
	</section>

	<footer class="fixed-bottom">
		<div
			class="col-10 offset-2 text-center text-white py-2 px-4 px-xl-5 bg-primary"
			style="width: 100%;">&copy; 2023. All rights reserved.</div>
	</footer>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script>
  // Dummy data
  	let valBus = document.getElementById("bus").innerText;
  	let valDest = document.getElementById("dest").innerText;

    var pieData = {
            labels: ['bus', 'destination'],
            datasets: [{
              data: [valBus, valDest],
              backgroundColor: ['#FF6384', '#36A2EB']
            }]
          };
	 
      var pieCtx = document.getElementById('pieChart').getContext('2d');
      var pieChart = new Chart(pieCtx, {
        type: 'pie',
        data: pieData,
        options: options
      });
      var options = {
    	        responsive: true,
    	        maintainAspectRatio: false
    	      };
</script>


</body>
</html>