USE hospital;

DROP TABLE pacientes_aud;
CREATE TABLE pacientes_aud (
	Id 	INT NOT NULL, 
    NombreVello 		CHAR(50) DEFAULT NULL,
    IdMedicoVello 		INT DEFAULT NULL,
    IdHabitacionVello 	INT DEFAULT NULL,
    FechaIngresoVello 	DATE DEFAULT NULL, 
    NombreNovo 			CHAR(50) DEFAULT NULL, 
    IdMedicoNovo		INT DEFAULT NULL,
	IdHabitacionNovo 	INT DEFAULT NULL, 
    FechaIngresoNovo 	DATE DEFAULT NULL, 
    AudData 			TIMESTAMP NOT NULL DEFAULT current_timestamp, 
    AudUsr 				VARCHAR(30) NOT NULL, 
    AudOpe 				ENUM('I', 'U', 'D') NOT NULL, 
    PRIMARY KEY (Id, AudData)
);

DROP TRIGGER pacientesAU;
DROP TRIGGER pacientesAD;
DROP TRIGGER pacientesAI;

delimiter //
CREATE TRIGGER pacientesAU AFTER UPDATE ON pacientes
FOR EACH ROW
BEGIN
	INSERT pacientes_aud (Id, NombreVello, IdMedicoVello, IdHabitacionVello, FechaIngresoVello, NombreNovo, 
						  IdMedicoNovo, IdHabitacionNovo, FechaIngresoNovo, AudData, AudUsr, AudOpe)
    VALUES (OLD.Id, OLD.Nombre, OLD.IdMedico, OLD.IdHabitacion, OLD.FechaIngreso, NEW.Nombre, NEW.IdMedico, NEW.IdHabitacion,
			NEW.FechaIngreso, current_timestamp(), current_user(), 'U');
END;

CREATE TRIGGER pacientesAD AFTER DELETE ON pacientes
FOR EACH ROW
BEGIN
		INSERT pacientes_aud (Id, NombreVello, IdMedicoVello, IdHabitacionVello, FechaIngresoVello, NombreNovo, 
						 IdMedicoNovo, IdHabitacionNovo, FechaIngresoNovo, AudData, AudUsr, AudOpe)
    VALUES (OLD.Id, OLD.Nombre, OLD.IdMedico, OLD.IdHabitacion, OLD.FechaIngreso, NULL, NULL, NULL,
			NULL, current_timestamp(), current_user(), 'D');
END;

CREATE TRIGGER pacientesAI AFTER INSERT ON pacientes
FOR EACH ROW
BEGIN
		INSERT pacientes_aud (Id, NombreVello, IdMedicoVello, IdHabitacionVello, FechaIngresoVello, NombreNovo, 
						  IdMedicoNovo, IdHabitacionNovo, FechaIngresoNovo, AudData, AudUsr, AudOpe)
    VALUES (Id, NULL, NULL, NULL, NULL, NEW.Nombre, NEW.IdMedico, NEW.IdHabitacion,
			NEW.FechaIngreso, current_timestamp(), current_user(), 'I');
END;
//
delimiter ;

select * from pacientes_aud;
select * from pacientes;

INSERT pacientes (Id, Nombre, IdMedico, IdHabitacion, FechaIngreso)
VALUES	(11, 'Manuel Paz', 1, 1, curdate());

UPDATE pacientes
SET Nombre = 'Manolo'
WHERE Id = 7;

DELETE FROM pacientes
WHERE Id = 7;

-- 3
SHOW TRIGGERS;
SHOW CREATE TRIGGER pacientesAU;
SHOW CREATE TRIGGER pacientesAD; 
SHOW CREATE TRIGGER pacientesAI; 
 
-- 5
delimiter //
CREATE EVENT evento
	ON SCHEDULE EVERY 1 YEAR 
		STARTS '2023-01-01 00:00:00'
DO BEGIN
	UPDATE medicos
    SET Salario = Salario * 1.1;
END;
//
delimiter ;

-- 6
ALTER EVENT evento
	ON SCHEDULE AT '2023-07-01 10:00:00';

-- 7
ALTER EVENT evento
DISABLE;

-- 8
SHOW EVENTS;
SHOW CREATE EVENT evento;