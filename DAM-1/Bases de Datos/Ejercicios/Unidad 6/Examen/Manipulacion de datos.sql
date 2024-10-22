USE hospital;

-- Ej 1
INSERT pacientes (id, Nombre, IdMedico, IdHabitacion, FechaIngreso)
VALUE (11, 'Ana Lopez', '5', '8', curdate()),
	  (12, 'Luis Garcia', '5', '8', curdate());
      
-- Ej 2 
INSERT medicos (Id, Nombre, Supervisor, Salario, Especialidad, FechaTitulo)
SELECT id + 100,
	   concat(Nombre, 'ALUMNO'),
       id,
       0,
	   'Cardiologia MIR',
       '2022-1-1'
FROM medicos
WHERE Especialidad LIKE 'Cardiologia' AND Supervisor IS NOT NULL;

-- Ej 3
UPDATE pacientes
SET IdMedico = 3
WHERE IdMedico = 9; 

-- Ej 4
UPDATE medicos
SET Salario = Salario * 1.1
WHERE Id IN (SELECT DISTINCT IdMedico
	        FROM pacientes) 
AND date_sub(curdate(),INTERVAL 15 YEAR)
AND Salario > 60000;

-- Ej 5
DELETE
FROM pacientes
WHERE Nombre LIKE 'Esther Godoy';

-- Ej 6
DELETE 
FROM pacientes
WHERE IdMedico = (SELECT Id
				  FROM medicos
                  WHERE Especialidad LIKE 'Dermatologia')
AND YEAR(FechaIngreso) LIKE 2021;

-- Ej 7
select * from pacientes; 
select * from medicos;
-- Con estas operaciones los que hacemos es acceder a todos los datos de la base de datos hospital de las tablas pacientes y
-- medicos. 
DELETE 
FROM medicos
WHERE Especialidad LIKE 'Geriatria';
 -- Al volver a analizar la base de datos podemos ver que los datos se han actualizado ya que tenemos el autocomit activado y 
 -- en cuanto una operacion finaliza con exito se aplican los cambios en la BD y se guardan.

-- Ej 8
SAVEPOINT sp_pac;
INSERT pacientes (id, Nombre, IdMedico, IdHabitacion, FechaIngreso)
VALUE (13, 'Ana Perez', '', '', '2022-05-22');

ROLLBACK TO sp_pac;

SELECT M.Nombre, COUNT(P.id)
FROM medicos AS M
INNER JOIN pacientes AS P ON M.id = P.idMedico
WHERE M.Especialidad LIKE 'Cardiologia';

UPDATE pacientes 
SET IdMedico = 1
WHERE Nombre LIKE 'AnaPerez';

SAVEPOINT sp_med;

SELECT *
FROM habitaciones
WHERE Id NOT IN (SELECT idHabitacion
			 FROM pacientes); 

UPDATE pacientes 
SET IdHabitacion = 1
WHERE Nombre LIKE 'AnaPerez';

-- Ej 9
-- Las propiedades ACID se cumplirian si se creara un proceso de transaccion (que suponemos que si) y al terminar
-- dicha transacion los datos indicamos si se mantienen o si no se aplican los cambios. Por otro lado no se indica ningun 
-- tipo de bloque para consultas externas, es decir que si alguien quiere saber cuantos pacientes esta atendiendo el medico 
-- con id 1 a la vez que nosotros estamos añadiendole un paciente mas, la informacion que va a salir por pantalla va a ser 
-- erronea. Para este caso se deberian de aplicar bloqueos de lectura ya que tampoco tinen otro tipos de riesgo, ya que no se
-- trata de una transaccion de un banco que es bastante mas compleja que la realizada anteriormente.

select * from habitaciones;
select * from pacientes;
select * from medicos;