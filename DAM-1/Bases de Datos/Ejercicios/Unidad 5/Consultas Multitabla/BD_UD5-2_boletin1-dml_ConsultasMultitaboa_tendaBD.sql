USE tendaBD;

SELECT art_color, art_codigo, art_nome, art_peso, prv_nome
FROM artigos AS A
INNER JOIN provedores AS P ON art_provedor = prv_id
WHERE art_color LIKE 'NEGRO';

SELECT clt_apelidos, clt_nome, LEFT(clt_cp,2) AS provincia
FROM empregados, clientes 
ORDER BY provincia, clt_apelidos, clt_nome; 

SELECT clt_nome, clt_apelidos, ven_data, 
DAY(ven_data) AS diaVenda, 
MONTH(ven_data) AS mesVenda, 
YEAR(ven_data) AS anoVenda
FROM clientes AS clt
INNER JOIN vendas AS vnd ON (ven_cliente = clt_id);

SELECT COUNT(distinct ven_id) AS numeroVendas, 
	   COUNT(distinct dev_artigo) AS numero_artigos,
       SUM(dev_cantidade) AS unidadesVendidas,
       AVG(dev_prezo_unitario) AS media_prezos
FROM vendas
INNER JOIN detalle_vendas ON ven_id = dev_venda;

SELECT art_codigo, art_nome, art_peso, peso_nome
FROM artigos AS ar
INNER JOIN pesos AS pe
ORDER BY art_peso DESC; 

SELECT clt_nome, clt_apelidos, ven_data, DAY( current_date()) - DAY(ven_data) AS diasTranscorridos
FROM clientes, vendas
ORDER BY diasTranscorridos DESC;

SELECT DISTINCT(LEFT(clt_cp,2)) AS provincia
FROM clientes
WHERE provincia IS NOT NULL;

SELECT ven_id, ven_data, clt_nome, clt_apelidos, emp_nome, emp_apelidos
FROM vendas, clientes, empregados
ORDER BY clt_apelidos, clt_nome;

SELECT 	CONCAT(clt_nome, clt_apelidos) AS nome_completo, art_nome, dev_cantidade, dev_prezo_unitario, dev_desconto, 
		IF(dev_desconto > 0,(dev_cantidade * dev_prezo_unitario) * (1 - (dev_desconto/100)), 
        dev_cantidade * dev_prezo_unitario ) AS importeFinal
FROM clientes, detalle_vendas, artigos
	

