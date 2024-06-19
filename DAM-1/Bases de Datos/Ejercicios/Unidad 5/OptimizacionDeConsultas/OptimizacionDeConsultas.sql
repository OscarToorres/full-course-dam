USE tendaBD;

-- Ejercicio 1
-- EXPLAIN
SELECT *
FROM empregados
WHERE emp_id = 6;

-- EXPLAIN
SELECT *
FROM empregados
WHERE emp_dni LIKE '76960385Q';

-- Ejercicio 2
EXPLAIN
SELECT *
FROM empregados
WHERE emp_nome LIKE 'ELISA';

EXPLAIN
SELECT *
FROM empregados
WHERE emp_apelidos LIKE 'VALIENTE VALIENTE';

-- Ejercicio 3
EXPLAIN
SELECT *
FROM empregados
WHERE emp_apelidos LIKE 'A%';

EXPLAIN
SELECT *
FROM empregados
WHERE emp_apelidos LIKE '%A';

-- Ejercicio 4
SELECT emp_poboacion, COUNT(*) AS numeroEmpregados
FROM empregados
GROUP BY emp_poboacion;

SELECT pai_nome, COUNT(*) AS numeroEmpregados
FROM paises
JOIN empregados ON pai_id = emp_pais
GROUP BY pai_nome;

-- Ejercicio 5
SELECT prv_id, prv_nome, art_codigo, art_nome, art_peso, art_stock
FROM provedores
JOIN artigos ON prv_id = art_provedor
WHERE prv_nome LIKE 'MUPEGA';	

SELECT art_provedor, art_codigo, art_nome, art_peso, art_stock
FROM artigos
WHERE art_provedor in (SELECT prv_id
				FROM provedores
                WHERE prv_nome LIKE 'MUPEGA');

-- Ejercicio 6
SELECT emp_apelidos, emp_nome, emp_enderezo, emp_poboacion, P1.pai_nome	   
FROM empregados
JOIN  paises AS P1 ON emp_pais = P1.pai_id
UNION
SELECT clt_apelidos, clt_nome, clt_enderezo, clt_poboacion, P2.pai_nome
FROM clientes
JOIN paises AS P2 ON pai_id = clt_pais;

SELECT apelidos, nome, poboacion, pai_nome
FROM (SELECT clt_apelidos apelidos, clt_nome nome, clt_poboacion poboacion, clt_pais pais
	  FROM clientes
      UNION 
      SELECT emp_apelidos apelidos, emp_nome nome, emp_poboacion poboacion, emp_pais pais
      FROM empregados) AS ce
JOIN paises p ON p.pai_id = ce.pais;





