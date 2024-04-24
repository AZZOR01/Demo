document.addEventListener('DOMContentLoaded', function () {
    fetch('/api/report/monthlyMember')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('membersTable').getElementsByTagName('tbody')[0];
            data.forEach(item => {
               let row = tableBody.insertRow();
               let idCell = row.insertCell(0);
               let monthsCell = row.insertCell(1);
               let membersCell = row.insertCell(2);

               const labels = [];
               const membersData = [];

                idCell.textContent = item.id;
                monthsCell.textContent = item.months;
                membersCell.textContent = item.members;
                
                labels.push(item.months);
                membersData.push(item.members);
            });
        })
        .catch(error => console.error('Failed to fetch data:', error));
});

document.addEventListener('DOMContentLoaded', function() {
    const tableBody = document.getElementById('membersTable').getElementsByTagName('tbody')[0];
    const data = [
        { time: '2024-01-01 10:00', members: 150 },
        { time: '2024-01-01 11:00', members: 165 },
        { time: '2024-01-01 12:00', members: 172 }
         //Add more data points as needed
    ];

    const labels = [];
    const membersData = [];

    data.forEach(item => {
        let row = tableBody.insertRow();
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);
        cell1.textContent = item.time;
         cell2.textContent = item.members;

        // Prepare chart data
        labels.push(item.time);
       membersData.push(item.members);
    });

    // Chart creation
    var ctx = document.getElementById('membersChart').getContext('2d');
    var membersChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Number of Members',
                data: membersData,
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});