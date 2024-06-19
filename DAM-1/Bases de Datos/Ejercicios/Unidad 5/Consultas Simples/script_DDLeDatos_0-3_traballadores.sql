-- A base de datos traballadores serve para levar control dos empregados, departamentos e
-- centros dunha empresa.
CREATE DATABASE traballadores;
USE traballadores;

-- Deshabilitar verificación de chaves foráneas
SET FOREIGN_KEY_CHECKS = 0;

-- CENTROS
CREATE TABLE centro (
	cenNumero 	INT PRIMARY KEY COMMENT 'Número co que se identifica.',
	cenNome		CHAR(30)  		COMMENT 'Nome.',
	cenEnderezo CHAR(30) 		COMMENT 'Enderezo.',
    INDEX idxCentroNome (cenNome)
);

-- EMPREGADOS
CREATE TABLE empregado (
	empNumero		 INT		PRIMARY KEY 	COMMENT 'Número co que se identifica.',
	empDepartamento  INT 						COMMENT 'Número do departamento no que traballa.',
	empExtension	 SMALLINT 	NOT NULL 		
		COMMENT 'Extensión telefónica para o empregado. Pode compartirse entre empregados de diferentes departamentos',
	empDataNacemento DATE						COMMENT 'Data de nacemento.',
	empDataIngreso 	 DATE						COMMENT 'Data de ingreso na empresa.',
	empSalario 		 DECIMAL(6,2)				COMMENT 'Salario mensual en euros.',
	empComision		 DECIMAL(6,2)				COMMENT 'Comisión mensual',
	empFillos		 SMALLINT					COMMENT 'Número de fillos.',
	empNome			 CHAR(20)	NOT NULL  		COMMENT 'Nome do empregado coa forma: primeiro apelido, nome.',
	FOREIGN KEY (empDepartamento) REFERENCES departamento(depNumero),
    INDEX idxEmpregadoDepartamento (empDepartamento),
    INDEX idxEmpregadoNome (empNome)
);

-- DEPARTAMENTOS
CREATE TABLE departamento (
	depNumero 		INT 		PRIMARY KEY 	COMMENT 'Número co que se identifica.',
	depNome			CHAR(20)	     			COMMENT 'Nome.',
	depDirector 	INT 	 	NOT NULL       	COMMENT 'Número do empregado director do departamento.',
	depTipoDirector CHAR(1)						COMMENT 'Tipo de directo: P (en propiedade, é dicir, titular), F (en funcións).',
	depPresuposto	DECIMAL(9,2)				COMMENT 'Cantidade en euros de presuposto anual.',
	depDepende		INT			     			COMMENT 'Número do departamento do que depende.',
	depCentro		INT			     			COMMENT 'Número do centro ao que pertence.',
	depEmpregados	SMALLINT UNSIGNED 			COMMENT 'Número de empregados que traballan no departamento.',
	FOREIGN KEY (depDirector) 	REFERENCES empregado(empNumero),
	FOREIGN KEY (depDepende)  	REFERENCES departamento(depNumero),
	FOREIGN KEY (depCentro) 	REFERENCES centro(cenNumero),
    INDEX idxDepartamentoNome (depNome),
    INDEX idxDepartamentoDepende (depDepende),
    INDEX idxDepartamentoCentro (depCentro)
);

-- INSERCION DE DATOS DE CENTROS
INSERT INTO centro(cenNumero, cenNome, cenEnderezo) VALUES (10, 'SEDE CENTRAL', 'C/ ATOCHA, 820, MADRID');
INSERT INTO centro(cenNumero, cenNome, cenEnderezo) VALUES (20, 'RELACIÓN CON CLIENTES', 'C/ ATOCHA, 405, MADRID');

-- INSERCION DE DATOS DEPARTAMENTOS 
INSERT INTO departamento (depNumero, depCentro, depDirector, depTipoDirector, depPresuposto, depDepende, depEmpregados, depNome)
VALUES(100, 10, 260, 'P', 72, NULL, 3, 'DIRECCIÓN GENERAL');
INSERT INTO departamento (depNumero, depCentro, depDirector, depTipoDirector, depPresuposto, depDepende, depEmpregados, depNome)
VALUES(110, 20, 180, 'P', 90, 100, 3, 'DIRECC.COMERCIAL');
INSERT INTO departamento (depNumero, depCentro, depDirector, depTipoDirector, depPresuposto, depDepende, depEmpregados, depNome)
VALUES(111, 20, 180, 'F', 66, 110, 8, 'SECTOR INDUSTRIAL');
INSERT INTO departamento (depNumero, depCentro, depDirector, depTipoDirector, depPresuposto, depDepende, depEmpregados, depNome)
VALUES(112, 20, 270, 'P', 54, 110, 7, 'SECTOR SERVICIOS');
INSERT INTO departamento (depNumero, depCentro, depDirector, depTipoDirector, depPresuposto, depDepende, depEmpregados, depNome)
VALUES(120, 10, 150, 'F', 18, 100, 1, 'ORGANIZACIÓN');
INSERT INTO departamento (depNumero, depCentro, depDirector, depTipoDirector, depPresuposto, depDepende, depEmpregados, depNome)
VALUES(121, 10, 150, 'P', 12, 120, 4, 'PERSONAL');
INSERT INTO departamento (depNumero, depCentro, depDirector, depTipoDirector, depPresuposto, depDepende, depEmpregados, depNome)
VALUES(122, 10, 350, 'P', 36, 120, 5, 'PROCESO DE DATOS');
INSERT INTO departamento (depNumero, depCentro, depDirector, depTipoDirector, depPresuposto, depDepende, depEmpregados, depNome)
VALUES(130, 10, 310, 'P', 12, 100, 3, 'FINANZAS');

-- INSERCION DE DATOS EMPLEADOS 
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(110, 350, '1970/11/10', '1985/02/15', 1800, NULL, 3, 'CESAR', 	121);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(120, 840, '1968/06/09', '1988/10/01', 1900, 110,  1, 'MARIO', 	112);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(130, 810, '1965/09/09', '1981/02/01', 1500, 110,  2, 'LUCIANO', 	112);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(150, 340, '1972/08/10', '1997/01/15', 2600, NULL, 0, 'JULIO', 	121);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(160, 740, '1980/07/09', '2005/11/11', 1800, 110,  2, 'AUREO', 	111);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(180, 508, '1974/10/18', '1996/03/18', 2800, 50,   2, 'MARCOS', 	110);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(190, 350, '1972/05/12', '1992/02/11', 1750, NULL, 4, 'JULIANA', 	121);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(210, 200, '1970/09/28', '1999/01/22', 1910, NULL, 2, 'PILAR', 	100);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(240, 760, '1967/02/26', '1989/02/24', 1700, 100,  3, 'LAVINIA', 	111);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(250, 250, '1976/10/27', '1997/03/01', 2700, NULL, 0, 'ADRIANA', 	100);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(260, 220, '1973/12/03', '2001/07/12',  720, NULL, 6, 'ANTONIO', 	100);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(270, 800, '1975/05/21', '2003/09/10', 1910, 80,   3, 'OCTAVIO',  112);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(280, 410, '1978/01/10', '2010/10/08', 1500, NULL, 5, 'DOROTEA',  130);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(285, 620, '1979/10/25', '2011/02/15', 1910, NULL, 0, 'OTILIA', 	122);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(290, 910, '1967/11/30', '1988/02/14', 1790, NULL, 3, 'GLORIA', 	120);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(310, 480, '1976/11/21', '2001/01/15', 1950, NULL, 0, 'AUGUSTO', 	130);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(320, 620, '1977/12/25', '2003/02/05', 2400, NULL, 2, 'CORNELIO', 122);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(330, 850, '1958/08/19', '1980/03/01', 1700, 90,   0, 'AMELIA', 	112);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(350, 610, '1979/04/13', '1999/09/10', 2700, NULL, 1, 'AURELIO', 	122);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(360, 750, '1978/10/29', '1998/10/10', 1800, 100,  2, 'DORINDA', 	111);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(370, 360, '1977/06/22', '2000/01/20', 1860, NULL, 1, 'FABIOLA', 	121);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(380, 880, '1978/03/30', '1999/01/01', 1100, NULL, 0, 'MICAELA', 	112);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(390, 500, '1976/02/19', '2010/10/08', 1290, NULL, 1, 'CARMEN', 	110);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(400, 780, '1979/08/18', '2011/11/01', 1150, NULL, 0, 'LUCRECIA', 111);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(410, 660, '1968/07/14', '1989/10/13', 1010, NULL, 0, 'AZUCENA', 	122);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(420, 450, '1966/10/22', '1988/11/19', 2400, NULL, 0, 'CLAUDIA', 	130);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(430, 650, '1967/10/26', '1988/11/19', 1260, NULL, 1, 'VALERIANA', 122);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(440, 760, '1966/09/26', '1986/02/28', 1260, 100,  0, 'LIVIA', 	111);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(450, 880, '1966/10/21', '1986/02/28', 1260, 100,  0, 'SABINA', 	112);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(480, 760, '1965/04/04', '1986/02/28', 1260, 100,  1, 'DIANA', 	111);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(490, 880, '1964/06/06', '1988/01/01', 1090, 100,  0, 'HORACIO', 	112);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(500, 750, '1965/10/08', '1987/01/01', 1200, 100,  0, 'HONORIA', 	111);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(510, 550, '1966/05/04', '1986/11/01', 1200, NULL, 1, 'ROMULO', 	110);
INSERT INTO empregado (empNumero, empExtension, empDataNacemento, empDataIngreso, empSalario, empComision, empFillos, empNome, empDepartamento)
VALUES(550, 780, '1970/01/10', '1998/01/21',  600, 120,  0, 'SANCHO', 	111);

-- Habilitar verificación de chaves foráneas
-- MOI IMPORTANTE EXECUTALO!!!
SET FOREIGN_KEY_CHECKS = 1;

DESCRIBE empregado;
SELECT DISTINCT empDepartamento
FROM empregado
WHERE empComision > empSalario * 0.1
ORDER BY empDepartamento;

SELECT empFillos, empNome, empSalario, empFillos * 30 AS salarioExtra, empSalario + empFillos * 30 AS salarioMensual
FROM empregado
WHERE empFillos > 2
ORDER BY empNome;

SELECT empNome
FROM empregado
WHERE empNome LIKE 'MORA' OR empNome LIKE 'MORA%'
ORDER BY cast(tipo as char);

SELECT empNome, empFillos + 2 AS numInvitacion, empFillos AS numRegalos
FROM empregados
WHERE empNome REGEXP '^[a-1]' AND empFillos > 0
ORDER BY empNome;

SELECT empNome, empSalario
FROM empregado
WHERE ((empFillos = 0 OR empFillos IS NULL) AND empSalario > 1200) OR (empFillos >= 1 AND EMPsALARIO < 1800);

SELECT empNome, empSalario
FROM empregado
WHERE empFillos = 0
ORDER BY empSalario DESC;

SELECT empNome, empSalario
FROM empregado
WHERE empDepartamento = 111 AND empComision > 0.15 * empSalario
ORDER BY empNome ASC;

SELECT empNome, empFillos, empComision, empComision * 0.15 AS comisionConIncremento
FROM empregado
WHERE empFillos > 2 AND empComision IS NOT NULL
ORDER BY empNome;

SELECT empNome, empDataNacemento, empSalario, (YEAR(empDataNacemento) + 60) – YEAR(empDataIngreso) AS antiguedade,
 (YEAR(empDataNacemento) + 60) – YEAR(empDataIngreso) * empSalario AS empleado
 FROM empregado
 
