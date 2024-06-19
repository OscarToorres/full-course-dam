USE tendaBD;

-- Ejercicio 1
SELECT A.art_codigo, A.art_peso
FROM artigos AS  A 
WHERE A.art_peso < (SELECT A1.art_peso
	 	FROM artigos AS A1
        WHERE A1.art_codigo LIKE 'aaaa0011'); 

-- Ejercicio 2
SELECT A.art_codigo, A.art_peso, A.art_color, A.art_nome
FROM artigos AS A 
WHERE A.art_color LIKE (SELECT A1.art_color
					 FROM artigos AS A1
                     WHERE art_codigo LIKE 'aaaa0003' )
AND art_peso >= ( SELECT AVG(art_peso)
				  FROM artigos);

-- Ejercicio 3
SELECT T.tda_id, E.emp_nome
FROM tendas AS T
INNER JOIN vendas AS V ON V.ven_tenda = T.tda_id
INNER JOIN detalle_vendas AS D ON D.dev_venda = V.ven_id
INNER JOIN empregados AS E ON emp_id = T.tda_xerente
WHERE D.dev_artigo = 'aaaa0003'; 

-- Ejercicio 3 CON SUBCONSULTA
SELECT T.tda_id, E.emp_nome
FROM tendas AS T
INNER JOIN empregados AS E ON emp_id = T.tda_xerente
WHERE tda_id = ( SELECT ven_tenda
				 FROM vendas V
				 INNER JOIN detalle_vendas AS D ON D.dev_venda = V.ven_id
				 WHERE D.dev_artigo = 'aaaa0003');

-- Ejercicio 4
SELECT *
FROM artigos
WHERE art_pv > ANY (SELECT MIN(A1.art_pv)
					FROM artigos AS A1
                    WHERE art_color LIKE 'negro');
                    
-- Ejercicio 5
SELECT art_codigo, art_nome, art_provedor
FROM artigos
INNER JOIN provedores ON prv_id = art_provedor
WHERE prv_nome LIKE (SELECT prv_nome
						 FROM provedores
                         WHERE prv_nome LIKE 'Telepizza');
                         
-- Ejercicio 6
SELECT art_codigo, art_nome, art_pv, prv_nome
FROM artigos
INNER JOIN provedores ON art_provedor = prv_id
WHERE art_pv LIKE (SELECT MAX(art_pv)
				   FROM artigos);
                   
-- Ejercicio 7
SELECT art_pv, art_nome
FROM artigos
WHERE art_pv BETWEEN (SELECT art_pv
					  FROM artigos
                      WHERE art_codigo LIKE 'aaaa0003')
AND (SELECT AVG(art_pv)
	 FROM artigos)
ORDER BY art_nome;
     
-- Ejercicio 8
SELECT prv_nome
FROM provedores 
WHERE prv_id IN (SELECT art_provedor
				   FROM artigos
                   WHERE art_color LIKE 'negro');

-- Ejercicio 9
SELECT CONCAT(clt_id,', ', clt_apelidos,', ', clt_nome) AS infoCliente
FROM clientes
WHERE clt_vendas = 1
ORDER BY clt_id;

-- Ejercicio 10
SELECT clt_id, clt_nome
FROM clientes
WHERE clt_ultima_venda > (SELECT clt_ultima_venda
						  FROM clientes
                          WHERE clt_id = 6);

-- Ejercicio 11
SELECT CONCAT(emp_nome,', ', emp_apelidos) AS Nome
FROM empregados
INNER JOIN tendas ON emp_id = tda_xerente
WHERE tda_id IN (SELECT ven_tenda
				 FROM vendas);
				
			
-- Ejercicio 12
SELECT SUM(dev_prezo_unitario * dev_cantidade) AS importeTotal
FROM detalle_vendas
INNER JOIN vendas ON ven_id = dev_venda
INNER JOIN clientes ON ven_cliente = clt_id
WHERE clt_nome LIKE (SELECT clt_nome
					 FROM clientes
                     WHERE clt_nome LIKE 'Jose Manuel')
AND clt_apelidos LIKE (SELECT clt_apelidos
					   FROM clientes
					   WHERE clt_apelidos LIKE 'Lopez Castro');
                                             
-- Ejercicio 13
SELECT DISTINCT emp_id, emp_apelidos, emp_nome
FROM empregados 
LEFT JOIN vendas ON ven_empregado=emp_id
WHERE ven_empregado IS NULL;

-- Ejercicio 13 con subconsulta
SELECT DISTINCT emp_id, emp_apelidos, emp_nome
FROM empregados 
WHERE NOT EXISTS ( SELECT ven_id
				   FROM vendas
                   WHERE ven_empregado = emp_id);

-- Ejercicio 14
SELECT *
FROM artigos AS A1
WHERE EXISTS (SELECT A2.art_pv
			  FROM artigos AS A2
			  WHERE art_color LIKE 'negro' AND A1.art_pv > A2.art_pv);

-- Ejercicio 15 sin join
SELECT art_nome
FROM artigos
WHERE art_color LIKE 'negro' 
AND art_codigo IN (SELECT dev_artigo
				   FROM detalle_vendas
				   WHERE dev_cantidade >= 5);
                      
-- Ejercicio 15 con join
SELECT art_nome
FROM artigos
INNER JOIN detalle_vendas ON art_codigo = dev_artigo
WHERE art_color LIKE 'negro' AND dev_cantidade >= 5;


-- Ejercicio 16
SELECT clt_nome, clt_apelidos
FROM clientes
WHERE clt_id NOT IN (SELECT ven_cliente
				     FROM vendas);
                    
                    
select * from clientes;
select * from detalle_vendas;
                    
					





