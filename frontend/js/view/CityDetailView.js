export default class CityDetailView {
  constructor() {
    this.main = document.getElementById('main-content');
  }

  render(city, measurements) {
    this.main.innerHTML = `
      <h2>${city.name}</h2>
      <div id="chart-container">
        <!-- gráfico aqui futuramente -->
        <p>Total de medições: ${measurements.length}</p>
      </div>
    `;
  }
}
