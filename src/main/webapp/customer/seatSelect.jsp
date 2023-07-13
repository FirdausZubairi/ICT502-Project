<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Booking</title>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="seatSelect.CSS">
  
  <link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined&display=swap" rel="stylesheet">
</head>
<body style="display: flex; flex-direction: column; min-height: 100vh;">
   <!--Navbar-->
 <!--Navbar-->
<nav class="navbar fixed-top navbar-light bg-light">
    <div class="container-fluid d-flex justify-content-between">
            <a class="navbar-brand" href="login.html">
                <img src="/ICT502-Project/image/bus-stop.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
                BTS
            </a>
        <span class="navbar-text">
            Seats
        </span>
        <div class="btn-container-user">
           <div class="btn-container-user">
				<a class="dropdown-item" href="/ICT502-Project/login.jsp">Staff Login</a>
			</div>
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
        <a class="nav-link" href="booking-customer.jsp">
          <i class="fa fa-bus" style="margin-right: 20px"></i>
          <span>Booking</span>
        </a>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center mt-3 mb-3 border-bottom" style="padding: 0 40px"></div>
        <a class="nav-link mb-2" href="viewticket.jsp">
          <i class="fa-sharp fa-solid fa-ticket" style="margin-right: 20px"></i>
          <span>View Ticket</span>
        </a>
      </div>
    </div>
  </div>
</div>
<!-- End sidebar -->
  
  <section class="col-9 offset-3 main-section" style="padding-top: 70px">
    <div class="container" >
      <div class="row">
        <div class="col-md-4" >
          <div class="card" style="width: 18rem;" >
            <div class="card-body" >
             <div class="container-fluid bus" style="height: 500px;">
                <div class="select" style="height: 150px;" >
                  <h2>Please select a seat</h2>
                </div>
                <div class="steering">
                  <img src="image/STEERING.png">
                </div>
                <div class="exit"></div>
                <ol>
                  <li>
                    <ol class="seats" name="seat">
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 1A" id="1A" data-price="100" />
                        <label for="1A">1A</label>
                      </li>
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 1B" id="1B" data-price="100" />
                        <label for="1B">1B</label>
                      </li>
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 1C" id="1C" data-price="100" />
                        <label for="1C">1C</label>
                      </li>
                    </ol>
                  </li>
                  <li>
                    <ol class="seats">
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 2A" id="2A" data-price="100" />
                        <label for="2A">2A</label>
                      </li>
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 2B" id="2B" data-price="100" />
                        <label for="2B">2B</label>
                      </li>
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 2C" id="2C" data-price="100" />
                        <label for="2C">2C</label>
                      </li>
                    </ol>
                  </li>
                  <li>
                    <ol class="seats">
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 3A" id="3A" data-price="100" />
                        <label for="3A">3A</label>
                      </li>
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 3B" id="3B" data-price="100" />
                        <label for="3B">3B</label>
                      </li>
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 3C" id="3C" data-price="100" />
                        <label for="3C">3C</label>
                      </li>
                    </ol>
                  </li>
                  <li>
                    <ol class="seats">
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 4A" id="4A" data-price="100" />
                        <label for="4A">4A</label>
                      </li>
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 4B" id="4B" data-price="100" />
                        <label for="4B">4B</label>
                      </li>
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 4C" id="4C" data-price="100" />
                        <label for="4C">4C</label>
                      </li>
                    </ol>
                  </li>
                  <li>
                    <ol class="seats">
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 5A" id="5A" data-price="100" />
                        <label for="5A">5A</label>
                      </li>
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 5B" id="5B" data-price="100" />
                        <label for="5B">5B</label>
                      </li>
                      <li class="seat">
                        <input type="checkbox" name="refNo" value="Seat 5C" id="5C" data-price="100" />
                        <label for="5C">5C</label>
                      </li>
                    </ol>
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-5">   
          <form action="bookingControl" method="post">
            <h3 class="card-title">Booking Details</h3>
            <h6>Selected Seats :</h6>
            <ul id="selectedSeats"></ul>
             <h6>payment method:</h6>
           <select class="form-select container mt-3" id="sel1" name="paymentMethod">
			  <option>Debit card</option>
			  <option>Cash</option>
			</select>
 			<div name = "totalPrice">
            <h6>Total price: <span id="totalPrice" >0</span></h6>
            </div>
            <div class="mt-3">
              <a href="booking.html"  class="btn btn-outline-success" role="button" aria-pressed="true">Back</a>
              <a href="paymentmethod-customer.jsp" type="submit" class="btn btn-success" role="button" aria-pressed="true">Continue</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
  <script type="text/javascript">

  window.onload = function() {
    let seats = document.querySelectorAll('input[type="checkbox"]');
    let display = document.getElementById('selectedSeats');
    let totalPrice = 0;
    let totalDisplay = document.getElementById('totalPrice');

    for (let i = 0; i < seats.length; i++) {
      seats[i].addEventListener('change', function() {
        let seatPrice = parseInt(this.dataset.price);
        if (this.checked) {
          let li = document.createElement('li');
          li.textContent = this.value + ' RM ' + seatPrice;
          li.id = 'li' + this.id;

          let cancelBtn = document.createElement('button');
          cancelBtn.innerHTML = '<i class="fas fa-trash"></i> Cancel';
          cancelBtn.className = 'btn-cancel';
          cancelBtn.addEventListener('click', function() {
            document.getElementById(seats[i].id).checked = false;
            document.getElementById('li' + seats[i].id).remove();
            totalPrice -= seatPrice;
            totalDisplay.textContent = 'RM ' + totalPrice;
          });

          li.appendChild(cancelBtn);
          display.appendChild(li);
          totalPrice += seatPrice;
        } else {
          document.getElementById('li' + this.id).remove();
          totalPrice -= seatPrice;
        }
        totalDisplay.textContent = 'RM ' + totalPrice;
      });
    }
  };

 

  </script>
  
<footer class="fixed-bottom">
  <div class="col-10 offset-2 text-center text-white py-2 px-4 px-xl-5 bg-primary" style="width: 100%;">
    &copy; 2023. All rights reserved.
  </div>
</footer>

  
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
