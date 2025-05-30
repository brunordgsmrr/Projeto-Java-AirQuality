export default class CityModel {
  constructor() {
    this.cities = [];
  }

  addCity(city) {
    this.cities.push(city);
  }

  removeCity(cityId) {
    this.cities = this.cities.filter(c => c.id !== cityId);
  }

  getCities() {
    return this.cities;
  }

  getCityById(cityId) {
    return this.cities.find(c => c.id === cityId);
  }
}
