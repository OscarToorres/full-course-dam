USE hospital;

-- Ejercicio 1
SELECT * 
FROM medicos
WHERE Especialidad = 'Cardiologia' AND Salario >= 30000 AND Salario <= 60000;

-- Ejercicio 2
SELECT Nombre, Salario, Especialidad
FROM medicos
WHERE Salario > 40000
ORDER BY Especialidad DESC, FechaTitulo DESC;

-- Ejercicio 3 
SELECT ME.Nombre, ME.Especialidad
FROM medicos AS M
INNER JOIN medicos AS ME ON ME.Supervisor = M.Id;

-- Ejercicio 4 pendiente
SELECT Salario, Nombre 
FROM medicos
WHERE Nombre
ORDER BY Salario DESC;

-- Ejercicio 5 pendiente
SELECT curdate() - FechaTitulo AS TiempoEnEmpresa 
FROM medicos;

-- Ejercicio 6
SELECT P.Nombre, P.idHabitacion, H.Tipo, date_format(P.FechaIngreso, '%d%m%Y') AS FechaIngreso
FROM pacientes AS P
INNER JOIN habitaciones AS H ON P.idHabitacion = H.Id
ORDER BY FechaIngreso DESC;

-- Ejercicio 7
SELECT P.Nombre AS NombrePaciente, M.Nombre AS NombreMedico, M.Salario AS SalarioMedico, M.Especialidad
FROM pacientes AS P
INNER JOIN medicos AS M ON M.Id = P.IdMedico
WHERE Especialidad = 'Cardiologia';

-- Ejercicio 8 pendiente
SELECT P.Nombre, PA.Nombre
FROM pacientes AS P
INNER JOIN pacientes AS PA ON P.IdHabitacion = PA.IdHabitacion
WHERE PA.Nombre = 'Esther Godoy';

-- Ejercicio 9
SELECT H.Id
FROM habitaciones AS H
LEFT JOIN pacientes AS P ON H.id = P.IdHabitacion; 

-- Ejercicio 10
SELECT M.Nombre AS NombreSupervisor, M.Especialidad AS EspecialidadSupervisor, ME.Nombre, ME.Especialidad
FROM medicos AS M
INNER JOIN medicos AS ME ON ME.Supervisor = M.Id;





