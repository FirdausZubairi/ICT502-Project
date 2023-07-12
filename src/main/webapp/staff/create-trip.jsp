<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>create trip</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="dashboard-staff.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.rtl.min.css"
	integrity="sha384-PJsj/BTMqILvmcej7ulplguok8ag4xFTPryRq8xevL7eBYSmpXKcbNVuy+P0RMgq"
	crossorigin="anonymous">
</head>
<body style="display: flex; flex-direction: column; min-height: 100vh;">
	<!--Navbar-->
	<nav class="navbar fixed-top navbar-light bg-light">
		<div class="container-fluid d-flex justify-content-between">
			<a class="navbar-brand" href="login.html"> <img
				src="/ICT502-Project/image/bus-stop.png" alt="" width="30"
				height="24" class="d-inline-block align-text-top"> BTS
			</a>
			<!--User account-->
			<div class="btn-container-user">
				<a class="dropdown-item" href="/ICT502-Project/login.jsp">Logout</a>
			</div>
		</div>
	</nav>

	<!--Side bar menu-->
	<div class="container-fluid">
		<div class="row">
			<div class="col-2 position-fixed" id="sticky-sidebar"
				style="border-right: #888; box-shadow: 2px 0px 5px rgba(0, 0, 0, 0.1);">
				<div
					class="nav flex-column flex-nowrap vh-100 overflow-auto text-white"
					style="padding: 15px 0">
					<a class="nav-link active" aria-current="page"
						href="dashboard-staff.jsp" style="margin-top: 70px"> <span
						class="fas fa-home" style="margin-right: 20px"></span> Dashboard
					</a>
					<div
						class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom"
						style="padding: 0 40px"></div>
					<a class="nav-link" href="bustrip"> <i class="fas fa-bus"
						style="margin-right: 20px"></i> <span> Bus Trip</span>
					</a>
					<div
						class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom"
						style="padding: 0 40px"></div>
					<a class="nav-link" href="register-staff.jsp"> <i
						class="fas fa-user-plus" style="margin-right: 20px"></i> <span>Create
							Staff</span>
					</a>
					<div
						class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom"
						style="padding: 0 40px"></div>
					<a class="nav-link" href="accountdetails-staff"> <i
						class="fas fa-user" style="margin-right: 20px"></i> <span>View
							Account</span>
					</a>
					<div
						class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom"
						style="padding: 0 40px"></div>
					<a class="nav-link" href="busdetail-staff"> <i
						class="fa fa-table" style="margin-right: 20px"></i> <span>View
							Bus</span>
					</a>


				</div>
			</div>
		</div>
	</div>


	<!-- End side bar -->

	<section class="col-10 offset-2 main-section" style="padding-top: 70px">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img src="/ICT502-Project/image/tourist.jpg" class="img-fluid"
						alt="Sample image">
				</div>
				<div class="col-md-8 col-lg-2 col-xl-4 offset-xl-1">
					<form action="create-trip" method="post">
						<div class="container mt-3">
							<h1>Bus Trip</h1>
							<p>Kindly fill in this form to register.</p>

							<div class="form-group">
								<label for="name"><b>Bus name</b></label> <select name="busID"
									class="form-select" aria-label="Default select example">
									<option selected hidden>Choose Bus Name</option>
									<c:forEach items="${listBus}" var="bus">
										<option value="${bus.busID }"><c:out
												value="${bus.name }" /></option>
									</c:forEach>
								</select>
							</div>

							<div class="form-group">
								<label for="name"><b>Destination name</b></label> <select
									name="destinationID" class="form-select"
									aria-label="Default select example">
									<option selected hidden>Choose destination</option>
									<c:forEach items="${listDestination}" var="des">
										<option value="${des.destinationID }"><c:out
												value="${des.destinationName }" /></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="time">Time:</label> <select class="form-control"
									id="time" name="time" required>
									
									<option >Select Time</option>
									<option >12:00 AM</option>
									<option >03:00 AM</option>
									<option >06:00 AM</option>
									<option >09:00 AM</option>
									<option >12:00 PM</option>
									<option >03:00 PM</option>
									<option >06:00 PM</option>
									<option >09:00 PM</option>
								</select>
							</div>


							<div class="text-center">
								<!-- Added text-center class here -->
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>








	<footer class="fixed-bottom">
		<div
			class="col-10 offset-2 text-center text-white py-2 px-4 px-xl-5 bg-primary"
			style="width: 100%;">&copy; 2023. All rights reserved.</div>
	</footer>

	<!-- JavaScript to fill the fields. In real scenario, this could be a data fetch from server-side -->
	<!-- <script src="js/script.js"></script> -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
