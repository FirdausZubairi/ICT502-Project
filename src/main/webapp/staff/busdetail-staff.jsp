<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bus Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="dashboard-staff.css">
</head>
<body style="display: flex; flex-direction: column; min-height: 100vh;">
    <!-- Navbar -->
    <nav class="navbar fixed-top navbar-light bg-light">
        <div class="container-fluid d-flex justify-content-between">
            <a class="navbar-brand" href="login.html">
                <img src="/ICT502-Project/image/bus-stop.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
                BTS
            </a>
            <span class="navbar-text">
                Staff
            </span>
            <!-- User account -->
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

    <!-- Side bar menu -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-2 position-fixed" id="sticky-sidebar" style="border-right: #888; box-shadow: 2px 0px 5px rgba(0,0,0,0.1);">
                <div class="nav flex-column flex-nowrap vh-100 overflow-auto text-white" style="padding: 15px 0">
                    <a class="nav-link active" aria-current="page" href="dashboard-staff.jsp" style="margin-top: 70px">
                        <span class="fas fa-home" style="margin-right: 20px"></span>
                        Dashboard
                    </a>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
                    <a class="nav-link" href="tripschedule-staff.jsp">
                        <i class="fas fa-bus" style="margin-right: 20px"></i>
                        <span>Create Bus Trip</span>
                    </a>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
                    <a class="nav-link" href="register-staff.jsp">
                        <i class="fas fa-user-plus" style="margin-right: 20px"></i>
                        <span>Create Staff</span>
                    </a>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
                    <a class="nav-link" href="update-staff.jsp">
                        <i class="fas fa-user-edit" style="margin-right: 20px"></i>
                        <span>Update Staff</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- End side bar -->

   <section class="col-10 offset-2 main-section" style="padding-top: 70px">
        <div class="container">
            <!-- Bus Details -->
            <div class="row justify-content-center mt-5">
                <div class="col-lg-8">
                    <div class="card">
                        <div class="card-header">
                            <div class="d-flex justify-content-between align-items-center">
                                <h5 class="mb-0">Bus Details</h5>

                            </div>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label>Bus Name:</label>
                                <p id="busName"></p>
                            </div>
                            <div class="form-group">
                                <label>Plate Number:</label>
                                <p id="noPlate"></p>
                            </div>
                            <div class="form-group">
                                <label>Destination Name:</label>
                                <p id="DestinationName"></p>
                            </div>
                            <div class="form-group">
                                <label>State:</label>
                                <p id="State"></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


<footer class="mt-auto">
    <div class="text-center text-white py-2 px-4 px-xl-5 bg-primary">
        &copy; 2023. All rights reserved.
    </div>
</footer>


    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
