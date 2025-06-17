--DROP TABLE IF EXISTS tb_cidades_instrument;
--DROP TABLE IF EXISTS tb_sensor;
--DROP TABLE IF EXISTS tb_cidade;
--DROP TABLE IF EXISTS tb_instrument;
--DROP TABLE IF EXISTS tb_parameter;
--DROP TABLE IF EXISTS tb_provider;

CREATE TABLE IF NOT EXISTS tb_provider (
	id SERIAL PRIMARY KEY, 
	name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_parameter (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	units VARCHAR(50) NOT NULL,
	displayName VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_instrument (
	id SERIAL PRIMARY KEY, 
	name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_cidade (
	id SERIAL PRIMARY KEY, 
	name VARCHAR(50) NOT NULL,
	locality VARCHAR(50) NOT NULL,
	id_provider INT NOT NULL,
	FOREIGN KEY (id_provider) REFERENCES tb_provider(id)
);

CREATE TABLE IF NOT EXISTS tb_sensor (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	id_cidade INT NOT NULL,
	id_parameter INT NOT NULL,
	FOREIGN KEY (id_cidade) REFERENCES tb_cidade(id),
	FOREIGN KEY (id_parameter) REFERENCES tb_parameter(id)
);

CREATE TABLE IF NOT EXISTS tb_cidades_instrument (
	id SERIAL PRIMARY KEY,
	id_instrument INT NOT NULL,
	id_cidade INT NOT NULL,
	FOREIGN KEY (id_cidade) REFERENCES tb_cidade(id),
	FOREIGN KEY (id_instrument) REFERENCES tb_instrument(id)
);

SELECT * FROM tb_cidades_instrument;
SELECT * FROM tb_sensor;
SELECT * FROM tb_cidade;
SELECT * FROM tb_instrument;
SELECT * FROM tb_parameter;
SELECT * FROM tb_provider;

SELECT c.id as cidade_id, 
c.name as cidade_name, 
c.locality, 
p.id as id_provider, 
p.name as provider_name 
FROM tb_cidade c 
JOIN tb_provider p 
ON c.id_provider = p.id;


