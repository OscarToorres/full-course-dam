USE traballadores;

INSERT INTO centros(cenNumero,cenNome,cenEnderezo)
VALUES(40, 'FRANQUICIALUGO', 'C/ PROGRESO, 8 - LUGO');

INSERT INTO centros
SET cenNumero = 40,
	cenNome = 'FRANQUICIALUGO',
    cenEnderezo = 'C/ PROGRESO, 8 - LUGO';

INSERT INTO empregado(empNome, empNumero, empDepartamento, empExtension, 
			empDataNacemento, empDataIngreso, empSalario, empComisionempFillos)
VALUES ('BARCIA', 'ANGELES', 750, 110,25, '12/02/1990', DATE,ADD(curdate()), 825, 50, 1)

INSERT INTO empregado(empNome, empNumero, empDepartamento, empExtension, 
			empDataNacemento, empDataIngreso, empSalario, empComisionempFillos)
VALUES ('MENDEZ, RICARDO', 751,110, 25, '22/10/1985', DATE,ADD(curdate(),interval day, -15), 900, null, 0)	