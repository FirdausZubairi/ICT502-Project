<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Staff</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="reg.css">
</head>

<body style="height: 100%;">
    <!-- LOGO -->
    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="login.html">
                <img src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24"
                    class="d-inline-block align-text-top">
                LOGO
            </a>
        </div>
    </nav>
    <!-- LOGO -->

    <section class="vh-100">
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-5">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                        class="img-fluid" alt="Sample image">
                </div>
                <div class="col-md-8 col-lg-2 col-xl-4 offset-xl-1">
                    <form>
                        <div class="container mt-3">
                            <h1>Register Staff</h1>
                            <p>Kindly fill in this form to register.</p>
                            <label for="username"><b>User name</b></label>
                            <input type="text" placeholder="Enter Username" name="username" id="username" required />
                            
                            <label for="name"><b>Name</b></label>
                            <input type="text" placeholder="Enter Full Name" name="name" id="name" required />
                            
                            <label for="password"><b>Password</b></label>
                            <input type="password" placeholder="Enter Password" name="password" id="password" required />

                            <label for="role"><b>Role</b></label>
                            <select name="role" id="role" required>
                            <option value="">Select Role</option>
                            <option value="clerk">Clerk</option>
                            <option value="driver">Driver</option>
                            </select><br>

                            <button type="submit">Register</button>
                        </div>

                      
                    </form>
                </div>
            </div>
        </div>
    </section>

    <div class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
        <div class="text-white mb-3 mb-md-0">
            Copyright © 2020. All rights reserved.
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>

</html>
