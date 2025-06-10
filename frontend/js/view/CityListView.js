export default class CityListView {
  constructor(onAdd, onDelete, onMonitor) {
    this.sidebar = document.getElementById('sidebar');
    this.onAdd = onAdd;
    this.onDelete = onDelete;
    this.onMonitor = onMonitor;
  }

  render(cities) {
    this.sidebar.innerHTML = `
      <button id="add-city-btn">Nova cidade</button>
      <ul>
        ${cities.map(city => `
          <li>
            <span class="item-name">
              ${city.name}
            </span>
            <span>
              <button data-id="${city.id}" class="monitor-btn">Monitorar</button>
              <button data-id="${city.id}" class="delete-btn">X</button>
            </span>
          </li>`).join('')}
      </ul>
    `;

    document.getElementById('add-city-btn').onclick = this.onAdd;
    this.sidebar.querySelectorAll('.delete-btn').forEach(btn =>
      btn.onclick = () => this.onDelete(btn.dataset.id));
    this.sidebar.querySelectorAll('.monitor-btn').forEach(btn =>
      btn.onclick = () => this.onMonitor(btn.dataset.id));
  }
}
