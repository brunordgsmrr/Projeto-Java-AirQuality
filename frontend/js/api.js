const API_BASE = 'https://api.openaq.org/v3';
const API_KEY = ''

export async function fetchCitiesFromBrazil() {
  const res = await fetch(`${API_BASE}/locations?country_id=BR`);
  const data = await res.json();
  return data.results;
}

export async function fetchCityDetails(cityId) {
  const res = await fetch(`${API_BASE}/measurements?location_id=${cityId}&limit=1000`);
  const data = await res.json();
  return data.results;
}
