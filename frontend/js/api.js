const API_BASE = 'https://projeto-java-airquality.onrender.com/api';
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
  const res = await fetch(`${API_BASE}/cidadeMonitoradas`);
  const data = await res.json();
  return data;
}

// Requisição POST para adicionar cidade na lista de monitoradas
export async function adicionarCidadeMonitorada(city) {
  console.log(city)
  const options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(city),
  }
  const res = await fetch(`${API_BASE}/adicionarCidadeMonitorada`, options);

  if (!res.ok) {
    throw new Error('Erro ao adicionar cidade');
  }
}

// Requisição DELETE para EXCLUIR cidade na lista de monitoradas
export async function removerCidadeMonitorada(cityId) {
  const options = {
    method: "DELETE",
  }
  const res = await fetch(`${API_BASE}/removerCidadeMonitorada/${cityId}`, options);

  if (!res.ok) {
    throw new Error('Erro ao remover cidade');
  }
}

// Requisição dos dados de medição da cidade
export async function consultarDadosMedicao(cityId) {
  const res = await fetch(`${API_BASE}/dadosMedicao/${cityId}`);
  const data = await res.json();

  if (!res.ok) {
    throw new Error('Erro ao consultar dados');
  }

  console.log(data)
  return data;
}

// Requisição dos dados de medição da cidade
export async function consultarParametros() {
  const res = await fetch(`${API_BASE}/parameters`);
  const data = await res.json();

  if (!res.ok) {
    throw new Error('Erro ao consultar dados');
  }
  return data;
}
