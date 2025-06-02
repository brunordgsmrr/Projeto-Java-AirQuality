import CityModel from '../model/CityModel.js';
import CityListView from '../view/CityListView.js';
import CityDetailView from '../view/CityDetailView.js';
import { fetchCitiesFromBrazil, fetchCityDetails } from '../api.js';

export default class CityController {
    constructor() {
        this.model = new CityModel();
        this.cityListView = new CityListView(
            this.handleAddCity.bind(this),
            this.handleDeleteCity.bind(this),
            this.handleMonitorCity.bind(this)
        );
        this.cityDetailView = new CityDetailView();
    }

    async init() {
        const cities = await fetchCitiesFromBrazil();
        await cities.forEach(city => this.model.addCity(city));
        this.cityListView.render(this.model.getCities());

    }

    handleAddCity() {
        alert('Função de adicionar cidade será implementada.');
    }

    handleDeleteCity(cityId) {
        this.model.removeCity(Number(cityId));
        this.cityListView.render(this.model.getCities());
    }

    async handleMonitorCity(cityId) {
        const city = this.model.getCityById(Number(cityId));
        const details = await fetchCityDetails(cityId);
        this.cityDetailView.render(city, details);
    }
}
