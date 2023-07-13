<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>bus trip</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="dashboard-staff.css">
</head>
<body style="display: flex; flex-direction: column; min-height: 100vh;">
	<!--Navbar-->
	<nav class="navbar fixed-top navbar-light bg-light">
		<div class="container-fluid d-flex justify-content-between">
			<a class="navbar-brand" href="login.html"> <img
				src="/ICT502-Project/image/bus-stop.png" alt="" width="30"
				height="24" class="d-inline-block align-text-top"> BTS
			</a> <span class="navbar-text"> Staff </span>
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
					<a class="nav-link" href="bustrip"> <i
						class="fas fa-bus" style="margin-right: 20px"></i> <span>
							Bus Trip</span>
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
						class="fas fa-user" style="margin-right: 20px"></i> <span>Account</span>
					</a>
					<div
						class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom"
						style="padding: 0 40px"></div>
					<a class="nav-link" href="busdetail-staff"> <i
						class="fa fa-table" style="margin-right: 20px"></i> <span>Bus</span>
					</a>


				</div>
			</div>
		</div>
	</div>
	<!-- End side bar -->
	<section class="col-10 offset-2 main-section " style="padding-top: 20px">
		<div class="container " style= "margin-top:10px">
			<div class="row mt-5 ">
				<div class="col-lg-10 "> 
				<div class=" d-flex justify-content-between align-items-center "> 
					<h2>Bus Trip</h2>
					<a href="create-trip"> 
					<button  type="button" class="btn btn-info"> Add Trip</button>
					</a>
					</div>
					
					<div class="table-responsive container-fluid" id="infinite-table">
						<table class="table table-hover align-middle">
							<thead class="header">
								<tr>
									<th scope="col">BusID</th>
									<th scope="col">Name</th>
									<th scope="col">NoPlate</th>
									<th scope="col">DestinationID</th>
									<th scope="col">Destination Name</th>
									<th scope="col">Time</th>
									<th scope="col">Actions</th>
									<!-- New column for actions -->
								</tr>
							</thead>
							<tbody>
								<c:forEach var="bd" items="${listBusDest}">
									<tr key="<c:out value="${bd.busID}" />">

										<th scope="row" style="color: #FF4E5B !important;"><c:out
												value="${bd.busID}" /></th>
										<td><c:out value="${bd.getName()}" /></td>
										<td><c:out value="${bd.noPlate}" /></td>
										<td><c:out value="${bd.destinationID}" /></td>
										<td><c:out value="${bd.destinationName}" /></td>
										<td><c:out value="${bd.time}" /></td>
										<td>
											<!-- Delete Button -->
											<button type="button" class="btn btn-danger"
												onclick="myFunction(<c:out value="${bd.busID}"/>, 'DeleteTrip')">
												Delete</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	<br>




	<footer class="fixed-bottom">
		<div
			class="col-10 offset-2 text-center text-white py-2 px-4 px-xl-5 bg-primary"
			style="width: 100%;">&copy; 2023. All rights reserved.</div>
	</footer>

	<!-- JavaScript to fill the fields. In real scenario, this could be a data fetch from server-side -->
	<!-- <script src="js/script.js"></script> -->
	<script>
		function myFunction(x,y) {
			console.log("Row index is: " + x); 
			window.location.href= y + "?id=" + x;
			sessionStorage.setItem("key", x);
			console.log("Session key : " + sessionStorage.getItem("key"));
		}
	</script>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
