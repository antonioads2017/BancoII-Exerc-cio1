CREATE VIEW city AS (
	SELECT c.nome,c.codigo_ibge,c.estado_id,populacao_2010,densidade_demo, gentilico, geom
	FROM Cidades c, municipio m
	WHERE c.codigo_ibge = CAST(m.cd_geocmu as INTEGER)
)