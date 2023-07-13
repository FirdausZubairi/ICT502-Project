 // Dummy data
const data = [
  { category: 'Driver', value: 30 },
  { category: 'Bus', value: 45 },
  { category: 'Destination', value: 25 }
];

// Get the canvas element
const canvas = document.getElementById('pieChart');

// Create the chart
const ctx = canvas.getContext('2d');
const chart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: data.map(item => item.category),
    datasets: [{
      data: data.map(item => item.value),
      backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56']
    }]
  },
  options: {
    responsive: true
  }
});
      /**
 * 
 */