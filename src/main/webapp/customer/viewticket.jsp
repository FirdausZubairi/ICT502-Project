<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Ticket</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="booking.css">
</head>
<body style="display: flex; flex-direction: column; min-height: 100vh;">
	<!--Navbar-->
	<nav class="navbar fixed-top navbar-light bg-light">
		<div class="container-fluid d-flex justify-content-between">
			<a class="navbar-brand" href="login.html"> <img
				src="/ICT502-Project/image/bus-stop.png" alt="" width="30"
				height="24" class="d-inline-block align-text-top"> BTS
			</a> <span class="navbar-text"> Customer </span>
			<!--User account-->
			<div class="btn-container-user">
				<a class="dropdown-item" href="/ICT502-Project/login.jsp">Staff login</a>
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
        <a class="nav-link" href="bookingdetail">
          <i class="fa fa-bus" style="margin-right: 20px"></i>
          <span>Booking</span>
        </a>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
        <a class="nav-link mb-2" href="viewticket">
          <i class="fa-sharp fa-solid fa-ticket" style="margin-right: 20px"></i>
          <span>View Ticket</span>
        </a>
      </div>
    </div>
  </div>
</div>
<!-- End sidebar -->
	<section class="col-10 offset-2 main-section" style="padding-top: 20px">
		<div class="container">
			<div class="row mt-5">
				<div class="col-lg-10">
					<h2>Ticket</h2>
					<div class="table-responsive container-fluid" id="infinite-table">
						<table class="table table-hover align-middle">
							<thead class="header">
								<tr>
									<th scope="col">Ticket ID</th>
									<th scope="col">Date</th>
									<th scope="col">Destination ID</th>
									<th scope="col">Bus ID</th>
									<th scope="col">Bus Name</th>
									<th scope="col">Destination Name</th>
									
									<!-- New column for actions -->
								</tr>
							</thead>
							<tbody>
								<c:forEach var="tb" items="${listTicket}">
									<tr key="<c:out value="${tb.ticketID}" />">

										<th scope="row" style="color: #FF4E5B !important;"><c:out
												value="${tb.ticketID}" /></th>
										<td><c:out value="${tb.ticketDate}" /></td>
										<td><c:out value="${tb.destinationID}" /></td>
										<td><c:out value="${tb.busID}" /></td>
										<td><c:out value="${tb.name}" /></td>
										<td><c:out value="${tb.destinationName}" /></td>
										<td>
										 <!-- Delete Button -->
											<button type="button" class="btn btn-danger"
												onclick="myFunction(<c:out value="${tb.ticketID}"/>, 'DeleteTicket')">
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
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
