<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Dashboard</title>
 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" /> 
    <link rel="stylesheet" href="dashboard-staff.css">

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
					<a class="nav-link" href="tripschedule-staff.jsp"> <i
						class="fas fa-bus" style="margin-right: 20px"></i> <span>Create
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
						class="fas fa-user" style="margin-right: 20px"></i> <span>View
							Account</span>
					</a>
					<div
						class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom"
						style="padding: 0 40px"></div>
					<a class="nav-link" href="busdetail-staff.jsp"> <i
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
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-5">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                        class="img-fluid" alt="Sample image">
                </div>
                <div class="col-md-8 col-lg-2 col-xl-4 offset-xl-1">
                    <form action="CreateStaff" method="post">   
                        <div class="container mt-3">
                            <h1>Register</h1>
                            <p>Kindly fill in this form to register.</p>
                            <div class="form-group"><label for="username"><b>Username</b></label>
              				<input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
            				</div>
                            
                            <div class="form-group"><label for="name"><b>Name</b></label>
              				<input type="text" class="form-control" id="name" name="name" placeholder="Enter Name" required>
            				</div>
            				
                            <div class="form-group"><label for="password"><b>Password</b></label>
              				<input type="text" class="form-control" id="password" name="password" placeholder="Enter Password" required>
            				</div>
            				
            				<label for="role"><b>Role</b></label>
            				<br>
<select name="role" id="role" class="form-control" required>
    <option disabled selected>Select Role</option>
    <option value="clerk">Clerk</option>
    <option value="driver">Driver</option>
</select><br><br>

            <div class="text-center"> <!-- Added text-center class here -->
              <button type="submit" class="btn btn-primary">Register</button>
            </div>
          </div>
                    </form>
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
