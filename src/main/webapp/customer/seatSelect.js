
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

/*
window.onload = function() {
  let seats = document.querySelectorAll('input[type="checkbox"]');
  let display = document.getElementById('selectedSeats');
  let totalPrice = 0;
  let totalDisplay = document.getElementById('totalPrice');

  for (let i = 0; i < seats.length; i++) {
    seats[i].addEventListener('change', function() {
      let seatPrice = parseInt(this.dataset.price);
      if (this.checked) {
        let seatId = this.id;
        let apiUrl = 'YOUR_API_ENDPOINT_URL'; // Replace with your actual API endpoint URL

        // Make the AJAX request
        fetch(apiUrl, {
          method: 'POST',
          body: JSON.stringify({ seatId: seatId }),
          headers: {
            'Content-Type': 'application/json'
          }
        })
          .then(response => response.json())
          .then(data => {
            if (data.booked) {
              alert('This seat is already booked. Please select another seat.');
              this.checked = false;
            } else {
              // Seat is available, add it to the selected seats list
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
              totalDisplay.textContent = 'RM ' + totalPrice;
            }
          })
          .catch(error => {
            console.error('Error:', error);
          });
      } else {
        document.getElementById('li' + this.id).remove();
        totalPrice -= seatPrice;
        totalDisplay.textContent = 'RM ' + totalPrice;
      }
    });
  }
};
*/
