USE traballadores;

-- Ejercicio 6
SELECT empExtension, count(*)
FROM empregado
GROUP BY empExtension;

-- Ejercicio 1.7

SELECT empFillos, count(*)
FROM empregado
GROUP BY empFillos;

-- Ejercicio 1.8
SELECT empDepartamento, empFillos, count(*)
FROM empregado
GROUP BY empFillos, empDepartamento;

-- Ejercicio 1.9
SELECT depCentro, count(depNumero) 
FROM departamento
GROUP BY depCentro;

-- Ejerccio 1.10 pendiente
SELECT depNumero, MAX(empSalario), MIN(empSalario), MAX(empSalario) - MIN(empSalario) AS Diferencia
FROM departamento
INNER JOIN empregado ON empDepartamento = depNumero
GROUP BY depNumero;

-- Ejercicio 1.11
SELECT depNumero, depPresuposto, depPresuposto - (12 * (SUM(empSalario) + SUM(ifnull(empComision, 0)))) AS Resto
FROM departamento
INNER JOIN empregado ON empDepartamento = depNumero
GROUP BY depNumero;

-- Ejercicio 2.5
SELECT depNumero, depNome, depEmpregados
FROM departamento
WHERE depEmpregados = 5;

-- Ejercicio 2.6
SELECT COUNT(empNumero) AS numeroEmpregados, empExtension AS extensoinTelefonica
FROM empregado
GROUP BY empExtension
HAVING COUNT(empNumero) > 1;


