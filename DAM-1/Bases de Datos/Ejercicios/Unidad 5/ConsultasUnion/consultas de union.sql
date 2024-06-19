USE tendaBD;

-- Ejercicio 1
(SELECT art_color, art_peso
FROM artigos
WHERE art_color LIKE 'negro')
UNION
(SELECT art_color, art_peso
FROM artigos
WHERE art_peso > 5000);

-- Ejercicio 2
(SELECT clt_apelidos AS apelido, clt_nome AS nome, clt_enderezo, clt_cp, clt_poboacion, 'clientes'
FROM clientes)
UNION
(SELECT emp_apelidos AS apelido, emp_nome AS nome, emp_enderezo, emp_cp, emp_poboacion, 'empregados'
FROM empregados)
ORDER BY apelido, nome; 

-- Ejercicio 3
(SELECT prv_nome AS nome
FROM provedores
WHERE prv_nome LIKE 'A%')
UNION
(SELECT emp_nome AS nome
FROM empregados
INNER JOIN vendas ON ven_empregado = emp_id 
WHERE timestampdiff(YEAR, ven_data, curdate()) < 10)
UNION
(SELECT clt_nome AS nome
FROM clientes
WHERE clt_cp LIKE '15%');

-- Ejercicio 4
(SELECT clt_nome AS nome, clt_apelidos AS apelido
FROM clientes
JOIN paises ON pai_id = clt_pais
WHERE pai_nome NOT LIKE 'España')
UNION
(SELECT emp_nome AS nome, emp_apelidos AS apelido
FROM empregados
JOIN paises ON pai_id = emp_pais
WHERE pai_nome NOT LIKE 'España');


