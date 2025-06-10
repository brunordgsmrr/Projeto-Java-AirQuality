export default class CityListView {
  constructor(onAdd, onDelete, onMonitor) {
    this.sidebar = document.getElementById('sidebar');
    this.onAdd = onAdd;
    this.onDelete = onDelete;
    this.onMonitor = onMonitor;
  }

  render(cities) {
    this.sidebar.innerHTML = `
      <style>
        #sidebar ul {
          list-style: none;
          padding: 0;
          margin: 0;
        }
        #sidebar ul li {
          display: flex;
          align-items: center;
          justify-content: space-between;
          padding: 8px 12px;
          margin-bottom: 6px;
          background: #f5f5f5;
          border-radius: 4px;
          min-height: 40px;
        }
        #sidebar ul li button {
          margin-left: 8px;
        }
      </style>
      <button id="add-city-btn">Nova cidade</button>
      <ul>
        ${cities.map(city => `
          <li>
            ${city.name}
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
