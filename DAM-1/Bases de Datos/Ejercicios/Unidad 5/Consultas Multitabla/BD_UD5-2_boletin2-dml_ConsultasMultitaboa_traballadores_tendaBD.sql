USE traballadores;
USE tendaBD;

SELECT depNumero, depNome, empNome
FROM departamento
INNER JOIN empregado ON depDirector = empNumero;

SELECT cenNome, cenEnderezo, empNome
FROM centro
INNER JOIN empregado ON empDepartamento
WHERE empNome LIKE 'A%';
 
SELECT dep.depNome, emp.empNome, emp.empSalario, dep.depDirector = emp2.empNumero AS depDirector, emp2.empSalario AS salarioDirector
FROM empregado AS emp
LEFT JOIN departamento AS dep ON (emp.empNumero = dep.depDirector)
INNER JOIN empregado AS emp2 ON (emp2.empNumero = dep.depDirector)
WHERE depNome IS NOT NULL;
 
SELECT emp.empNumero, emp.empNome, emp.empSalario, emp180.empSalario AS salarioEmp180 
FROM empregado AS emp
INNER JOIN empregado AS emp180 ON emp.empSalario > emp180.empSalario
WHERE emp180.empNumero = 180;

SELECT C.clt_id, C.clt_apelidos, C.clt_nome, ifnull(V.ven_data, 'SEN COMPRAS') AS data_venda
FROM clientes AS C
INNER JOIN vendas AS V ON C.clt_id = V.ven_cliente
WHERE clt_id <= 10