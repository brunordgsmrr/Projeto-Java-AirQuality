const API_BASE = 'http://localhost:8080/api';
const API_KEY = ''

export async function fetchCitiesFromBrazil() {
  const res = await fetch(`${API_BASE}/todasCidades`);
  const data = await res.json();
  return data;
}

export async function fetchCityDetails(cityId) {
  const res = await fetch(`${API_BASE}/measurements?location_id=${cityId}&limit=1000`);
  const data = await res.json();
  return data;
}

// Requisição das cidades monitorada
export async function fetchCidadesMonitoradas() {
  const res = await fetch(`${API_BASE}/todasCidades`);
  const data = await res.json();
  return data;
}