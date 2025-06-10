import MeasurementChart from "../charts/chart.js";

export default class CityDetailView {
  constructor() {
    this.main = document.getElementById('main-content');
  }

  render(data) {
    const { cidade, measurement } = data;

    let parameters = [...new Set(measurement.map((m) => { return m.parameterName }))]

    // Cria os gráficos para cada parâmetro
    let chart = new MeasurementChart(measurement, this.main, cidade);
    chart.create();

  }
}

