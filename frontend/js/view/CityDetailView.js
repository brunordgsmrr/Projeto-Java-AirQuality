import MeasurementChart from "../charts/chart.js";

export default class CityDetailView {
  constructor() {
    this.main = document.getElementById('main-content');
  }

  render(data) {
    const { cidade, measurement } = data;

    let parameters = [...new Set(measurement.map((m) => { return m.parameterName }))]

    let chart = new MeasurementChart([], this.main)

    chart.create()




    //const o3Data = measurement.filter(m => m.parameterName === "o3");
    //const pm10Data = measurement.filter(m => m.parameterName === "pm10");

    //this.main.innerHTML = `
    //  <h2>${city.name}</h2>
    //  <div id="chart-container">
    //    <!-- gráfico aqui futuramente -->
    //    <p>Total de medições: ${measurements.length}</p>
    //  </div>
    //`;
  }
}

