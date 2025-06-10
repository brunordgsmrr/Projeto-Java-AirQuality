export default class MeasurementChart {
    constructor(measurements, container, cidade) {
        this.measurements = measurements;
        this.container = container;
        this.cidade = cidade;
        this.charts = [];
    }

    create() {
        // Limpa o container antes de adicionar novos gráficos
        this.container.innerHTML = '';

        this.container.innerHTML = `
            <h2>${this.cidade.name}</h2>
            <div id="chart-container">
                <!-- gráfico aqui futuramente -->
                <p>Total de medições: ${this.measurements.length}</p>
            </div>
        `;

        // Agrupa as medições por parâmetro
        const grouped = {};
        this.measurements.forEach(m => {
            if (!grouped[m.parameterName]) grouped[m.parameterName] = [];
            grouped[m.parameterName].push(m);
        });

        Object.keys(grouped).forEach(parameter => {
            // Cria um título para o gráfico
            const title = document.createElement('h3');
            title.textContent = `Parâmetro: ${parameter}`;
            this.container.appendChild(title);

            // Cria o canvas para o gráfico
            const canvas = document.createElement('canvas');
            canvas.id = `chart-${parameter}`;
            this.container.appendChild(canvas);

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
                        x: { display: true, title: { display: true, text: 'Data/Hora' } },
                        y: { display: true, title: { display: true, text: 'Valor' } }
                    }
                }
            });

            this.charts.push(chart);
        });
    }
}