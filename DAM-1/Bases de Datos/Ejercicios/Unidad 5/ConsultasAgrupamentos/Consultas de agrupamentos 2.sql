USE tendaBD;

-- Ejercicio 1.1
SELECT art_color, ROUND(SUM(art_pv) / COUNT(art_pv), 2) AS prezoMedioVenda
FROM artigos
GROUP BY art_color;

-- Ejercicio 1.2
SELECT art_color, ROUND(SUM(art_pv) / COUNT(art_pv), 2) AS prezoMedioVenda
FROM artigos
WHERE art_pc > 50
GROUP BY art_color; 

-- Ejercicio 1.3
SELECT clt_poboacion, count(clt_id) AS numeroClientes
FROM clientes
GROUP BY clt_poboacion
ORDER BY numeroClientes DESC;

-- Ejercicio 1.4
SELECT 	art_codigo, art_nome, SUM(dev_prezo_unitario * dev_cantidade) AS sumaPV,
		SUM(dev_prezo_unitario * dev_cantidade) - SUM(ifnull(dev_desconto, 0)) AS sumaPVdesconto,
        SUM(ifnull(dev_desconto, 0)) AS descontoTotal
FROM artigos
INNER JOIN detalle_vendas ON dev_artigo = art_codigo
INNER JOIN vendas ON ven_id = dev_venda
WHERE ven_data BETWEEN '2010-01-01' AND '2015-05-25'  
GROUP BY art_codigo;

-- Ejercicio 1.5 FALTA EL NUMERO DE ARTICULOS
SELECT 	tda_id, 
		COUNT(dev_venda) AS numeroVendas, 
         
		SUM(dev_cantidade) AS totalUnidadesVendidas,
		SUM(dev_prezo_unitario) / COUNT(dev_artigo) AS mediaPrezosUnitarios
FROM tendas
INNER JOIN vendas ON ven_tenda = tda_id
INNER JOIN detalle_vendas ON ven_id = dev_venda
WHERE YEAR(ven_data) = '2012'
GROUP BY tda_id;

-- Ejercicio 2.1
SELECT art_color, ROUND(AVG(art_pv),2) AS prezoMedioVenda
FROM artigos
GROUP BY art_color
HAVING AVG(art_pv) >= 100;

-- Ejercicio 2.2 INCOMPLETO
SELECT ven_tenda, count(ven_tenda) AS numeroVendas, count(DISTINCT dev_artigo) AS numeroArgDif,
		SUM(dev_cantidade) AS unidadesVendidas
FROM tendas, detalle_vendas, vendas
WHERE MONTH(ven_data) = 3 AND YEAR(ven_data) = 2012
GROUP BY ven_tenda
HAVING numeroVendas > 2;

-- Ejercicio 2.3 INCOMPLETO 
SELECT clt_id, ven_data, clt_vendas, SUM(dev_prezo_unitario) AS sumaVendas, dev_desconto
FROM clientes
INNER JOIN vendas ON ven_cliente = clt_id
WHERE sumaVendas > 1200 AND ;

-- Ejercicio 2.4 INCOMPLETO
SELECT concat(clt_id, clt_nome, clt_apelidos) AS informacionCliente, ven_data
FROM clientes, vendas
WHERE clt_vendas = 1;

SELECT * from clientes


        

