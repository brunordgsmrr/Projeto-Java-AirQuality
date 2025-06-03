export default class MeasurementChart {

    constructor(data, element) {
        this.data = data
        this.element = element
    }

    create() {
        let canvas = document.createElement('canvas');
        this.element.appendChild(canvas);

        const dataChart = {
            labels: ['a', 'b', 'c', 'd'],
            datasets: [{
                label: 'a',
                data: [1, 2, 3, 4],
                borderColor: 'rgba(75, 192, 192, 1)',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                tension: 0.3
            }]
        }

        const config = {
            type: 'bar',
            data: {
                labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
                datasets: [{
                    label: '# of Votes',
                    data: [12, 19, 3, 5, 2, 3],
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
        }

        new Chart(canvas, config)


    }

}