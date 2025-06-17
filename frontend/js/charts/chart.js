export default class MeasurementChart {
    constructor(measurements, container, cidade, parametersInfo) {
        this.measurements = measurements;
        this.container = container;
        this.cidade = cidade;
        this.parametersInfo = parametersInfo
        this.charts = [];
    }

    create() {
        // Limpa o container antes de adicionar novos gráficos
        this.container.innerHTML = '';

        this.container.innerHTML = `
            <h2>${this.cidade.name}</h2>
            <div id="chart-container">
                <p>Total de medições: ${this.measurements.length}</p>
            </div>
        `;

        // Agrupa as medições por parâmetro
        const grouped = {};
        this.measurements.forEach(m => {
            if (!grouped[m.parameterName]) grouped[m.parameterName] = [];
            grouped[m.parameterName].push(m);
        });

        const elementCharts = document.createElement('div');
        elementCharts.id = 'charts';

        Object.keys(grouped).forEach(parameter => {

            const elementChart = document.createElement('div');
            elementChart.className = 'chart';

            // Cria um título para o gráfico
            const parameterInfo = this.parametersInfo.find(info => info.name === parameter);
            const title = document.createElement('p');
            title.innerHTML = `${parameterInfo.displayName}, ${parameterInfo.units}<br>
            Descrição: ${parameterInfo.description}<br>`;
            elementChart.appendChild(title);

            // Cria o canvas para o gráfico
            const canvas = document.createElement('canvas');
            canvas.id = `chart-${parameter}`;
            elementChart.appendChild(canvas);

            // Prepara os dados para o gráfico
            const labels = grouped[parameter].map(m => m.dateTime || m.timestamp || '');
            const values = grouped[parameter].map(m => m.value);

            // Cria o gráfico usando Chart.js
            // Certifique-se de que Chart.js está incluído no seu projeto!
            // eslint-disable-next-line no-undef
            const chart = new Chart(canvas, {
                type: 'line',
                data: {
                    labels: labels,
                    datasets: [{
                        label: parameter,
                        data: values,
                        borderColor: 'rgba(75, 192, 192, 1)',
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        fill: false,
                        tension: 0.1
                    }]
                },
                options: {
                    responsive: true,
                    plugins: {
                        legend: { display: true }
                    },
                    scales: {
                        x: { display: true, title: { display: true, text: 'Data' } },
                        y: { display: true, title: { display: true, text: parameterInfo.units } }
                    }
                }
            });

            elementCharts.appendChild(elementChart);
            this.charts.push(chart);
        });

        this.container.appendChild(elementCharts);
    }
}