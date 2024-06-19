USE hospital;

-- Ejercicio 1 faltan los nulos
SELECT m2.Nombre, m2.Especialidad, ifnull(m1.Nombre, 'Non ten supervisor') AS NombreSupervisor, m1.Especialidad AS EspecialidadSupervisor
FROM medicos as m1
JOIN medicos as m2 ON m1.id = m2.supervisor ;

-- Ejercicio 2 faltan que salgan mayusculas y ordenado
SELECT p.Nombre, m.Nombre
FROM pacientes AS p
JOIN medicos AS m ON p.idMedico = m.id
ORDER BY p.Nombre ASC, m.Nombre ASC;  

-- Ejercicio 3
SELECT p.Nombre AS NombrePaciente, m.Nombre AS NombreMedico, 'PAC' 
FROM pacientes AS p
JOIN medicos AS m ON p.idMedico = m.id
UNION
SELECT m2.Nombre, m1.Nombre AS NombreSupervisor, 'MEC'
FROM medicos as m1
JOIN medicos as m2 ON m1.id = m2.supervisor;

-- Ejercicio 4
SELECT DISTINCT Tipo, COUNT(Tipo) AS Cantidad
FROM habitaciones
GROUP BY Tipo;  

-- Ejercicio 5
SELECT Especialidad, AVG(salario) AS mediaSalarios
FROM medicos
GROUP BY Especialidad
HAVING count(Especialidad) > 2
ORDER BY AVG(salario) DESC;

-- Ejercicio 6 
SELECT MAX(m.Salario) AS SalrioMaximo, Min(m.Salario) AS SalarioMinimo
FROM medicos AS m
WHERE Especialidad LIKE 'Cardiologia' AND YEAR(FechaTitulo) = YEAR(FechaTitulo);

-- Ejercicio 7
SELECT p.Nombre
FROM pacientes AS p
WHERE idHabitacion IN (SELECT id
					   FROM habitaciones
                       WHERE Tipo LIKE 'Individual');

-- Ejercicio 8
SELECT Nombre, Especialidad, date_format(FechaTitulo, '%D%M%Y')  
FROM medicos
WHERE salario > (SELECT AVG(salario)
				 FROM medicos)
ORDER BY Especialidad, FechaTitulo;

-- Ejercicio 9 
SELECT Nombre, Especialidad, Salario
FROM medicos
WHERE salario > (SELECT AVG(salario)
				 FROM medicos);

-- Ejercicio 10
-- EXPLAIN
SELECT p.Nombre, p.FechaIngreso
FROM pacientes AS p
INNER JOIN medicos AS m ON p.IdMedico = m.id
WHERE m.Especialidad LIKE 'Cardiologia'
ORDER BY Especialidad, FechaIngreso;

-- EXPLAIN
SELECT p.Nombre, p.FechaIngreso
FROM pacientes AS p
INNER JOIN medicos AS m ON p.IdMedico = m.id
WHERE m.Especialidad LIKE 'Cardiologia'
ORDER BY FechaIngreso;


select * from medicos where especialidad like 'cardiologia';
select * from pacientes;
select * from habitaciones;

