// Get the current date
var today = new Date().toISOString().split('T')[0];

// Set the minimum value for the date input field
document.getElementById('date').setAttribute('min', today);

// Dummy data for the table
const dummyData = [
  {
    bus: 'Bus A',
    departure: '09:00 AM',
    arrival: '12:00 PM',
    fare: 'RM 20',
    seatsAvailable: 5
  },
  {
    bus: 'Bus B',
    departure: '11:30 AM',
    arrival: '02:30 PM',
    fare: 'RM 15',
    seatsAvailable: 8
  },
  {
    bus: 'Bus C',
    departure: '02:00 PM',
    arrival: '05:00 PM',
    fare: 'RM 18',
    seatsAvailable: 3
  }
];

// Function to populate the table with dummy data
function populateTable() {
  const tableBody = document.getElementById('AvailableBusTable');
  
  dummyData.forEach((data, index) => {
    // Create a new table row
    const row = document.createElement('tr');
  
    // Populate the row with data
    row.innerHTML = `
      <td>${index + 1}</td>
      <td>${data.bus}</td>
      <td>${data.departure}</td>
      <td>${data.arrival}</td>
      <td>${data.fare}</td>
      <td>${data.seatsAvailable} Seats Availability</td>
      <td><a href="seatSelect.html" class="select-button btn btn-success" role="button" aria-pressed="true">Book</a></td>
    `;
  
    // Append the row to the table body
    tableBody.appendChild(row);
  });
}

// Call the function to populate the table
populateTable();

// Add event listeners to select buttons
const selectButtons = document.getElementsByClassName('select-button');
Array.from(selectButtons).forEach((button) => {
  button.addEventListener('click', () => {
    // Perform the desired action when the button is clicked
    // For example, redirect to another page
    window.location.href = 'login.html'; // Replace 'login.html' with the actual page URL
  });
});

// Function to swap values between two select elements
function swapData() {
  var fromSelect = document.getElementById('fromSelect');
  var toSelect = document.getElementById('toSelect');
  
  var fromValue = fromSelect.value;
  var toValue = toSelect.value;
  
  fromSelect.value = toValue;
  toSelect.value = fromValue;
}
