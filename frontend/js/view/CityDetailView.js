export default class CityDetailView {
  constructor() {
    this.main = document.getElementById('main-content');
  }

  render(data) {
    const { cidade, measurement } = data;

    const o3Data = measurement.filter(m => m.parameterName === "o3");
    const pm10Data = measurement.filter(m => m.parameterName === "pm10");


    //this.main.innerHTML = `
    //  <h2>${city.name}</h2>
    //  <div id="chart-container">
    //    <!-- gráfico aqui futuramente -->
    //    <p>Total de medições: ${measurements.length}</p>
    //  </div>
    //`;
  }
}
