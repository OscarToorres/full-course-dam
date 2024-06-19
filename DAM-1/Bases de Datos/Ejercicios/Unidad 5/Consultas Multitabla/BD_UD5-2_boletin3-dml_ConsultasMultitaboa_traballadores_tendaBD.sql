USE tendaBD;

SELECT prv_nome, ifnull(art_nome, 'NINGUN') 
FROM provedores
LEFT JOIN artigos ON art_provedor = prv_id;

SELECT pai_nome
FROM paises
LEFT JOIN clientes ON pai_id=clt_pais
WHERE clt_pais IS NULL;

SELECT emp_nome, ifnull(tda_poboacion, 'NON E XERENTE')
FROM empregados
LEFT JOIN tendas ON (emp_id = tda_xerente); 

SELECT art_nome, art_stock, art_pv, dev_prezo_unitario, day(ven_data) AS dia, month(ven_data) AS mes, year(ven_data) AS año
FROM artigos
LEFT JOIN detalle_vendas ON art_codigo = dev_artigo
LEFT JOIN vendas ON ven_id = dev_venda;

SELECT A.art_stock, A.art_pv AS prezo_actual,ifnull(D.dev_prezo_unitario, 0) AS prezo_cando_se_vendeu, 
		date_format(V.ven_data, '%Y%m%d') AS data_venda,ifnull(C.clt_nome, 'non hai') AS nome_cliente
FROM artigos AS A
LEFT JOIN detalle_vendas  	AS D ON D.dev_artigo = A.art_codigo
LEFT JOIN vendas 			AS V ON V.ven_id = D.dev_venda
LEFT JOIN clientes 			AS C ON C.clt_id = V.ven_cliente;








