import { fetchCitiesFromBrazil, adicionarCidadeMonitorada } from '../api.js';

export default class CityAddModalView {

    constructor() {
        this.modal = document.getElementById('city-add-modal');
        this.listContainer = this.modal.querySelector('.city-list');
        this.closeButton = this.modal.querySelector('.close-btn');
        this.closeButton.onclick = () => this.close();
    }

    async open(onAddCallback) {
        const cities = await fetchCitiesFromBrazil();

        this.listContainer.innerHTML = cities.map(city => `
            <li>
                ${city.name}
                <button class="add-city-btn" data-id="${city.id}">Adicionar</button>
            </li>
        `).join('');

        this.listContainer.querySelectorAll('.add-city-btn').forEach(btn =>
            btn.onclick = async () => {
                const cityId = btn.dataset.id;
                let citySelected;

                cities.forEach((city) => {
                    if (city.id == cityId) {
                        citySelected = city;
                    }
                })
                try {
                    await adicionarCidadeMonitorada(citySelected);
                    onAddCallback(); // atualiza sidebar
                    this.close();
                } catch (e) {
                    alert('Erro ao adicionar cidade');
                }
            }
        );

        this.modal.style.display = 'block';
    }

    close() {
        this.modal.style.display = 'none';
    }

}