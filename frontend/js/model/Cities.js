export default class Cities {
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

  setCities(cities) {
    this.cities = cities;
  }

  getCityById(cityId) {
    return this.cities.find(c => c.id === cityId);
  }
}
