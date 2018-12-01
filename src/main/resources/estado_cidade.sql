CREATE VIEW estado_cidade AS (
	SELECT e.nome as nomeEstado, e.sigla, c.nome as nomeCidade, c.codigo_ibge 
	FROM estados e, city c
	WHERE c.estado_id = e.id
)