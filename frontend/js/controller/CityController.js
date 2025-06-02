import Cities from '../model/Cities.js';
import CityListView from '../view/CityListView.js';
import CityDetailView from '../view/CityDetailView.js';
import CityAddModalView from '../view/CityAddmodalView.js';
import { fetchCitiesFromBrazil, fetchCityDetails, fetchCidadesMonitoradas, removerCidadeMonitorada } from '../api.js';

export default class CityController {
    constructor() {
        this.model = new Cities();
        this.cityListView = new CityListView(
            this.handleAddCity.bind(this),
            this.handleDeleteCity.bind(this),
            this.handleMonitorCity.bind(this)
        );
        this.cityDetailView = new CityDetailView();
        this.cityAddModelView = new CityAddModalView();
    }

    async init() {
        const cities = await fetchCidadesMonitoradas();
        await cities.forEach(city => this.model.addCity(city));
        this.cityListView.render(this.model.getCities());

    }

    async handleAddCity() {
        await this.cityAddModelView.open(async () => {
            // Atualiza a lista após adição
            const cities = await fetchCidadesMonitoradas();
            this.model.setCities(cities); // certifique-se que existe setCities
            this.cityListView.render(this.model.getCities());
        });
    }

    handleDeleteCity(cityId) {
        this.model.removeCity(Number(cityId));
        removerCidadeMonitorada(Number(cityId))
        this.cityListView.render(this.model.getCities());
    }

    async handleMonitorCity(cityId) {
        const city = this.model.getCityById(Number(cityId));
        const details = await fetchCityDetails(cityId);
        const dados = await consultarDadosMedicao(cityId)
        this.cityDetailView.render(city, details, dados);
    }
}
