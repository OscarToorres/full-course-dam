DROP DATABASE IF EXISTS practicas1;
CREATE DATABASE practicas1 CHARACTER SET latin1;
USE practicas1;
CREATE TABLE grupo (
    idGrupo       INT     UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    dataFormacion DATE    NOT NULL,
    nomeGrupo     VARCHAR(100) NOT NULL
);
CREATE TABLE fabricante (
    idFabricante    CHAR(5)      PRIMARY KEY,
    nome            VARCHAR(80),
    grupo           INT UNSIGNED,
    FOREIGN KEY (grupo) REFERENCES  grupo(idGrupo)
);

ALTER TABLE fabricante
	ADD COLUMN email VARCHAR(34) NULL DEFAULT NULL,
    ADD COLUMN cif VARCHAR(20) NOT NULL AFTER idFabricante
; 
ALTER TABLE fabricante
	DROP PRIMARY KEY,
	ADD PRIMARY KEY (cif),
	DROP COLUMN idFabricante,
	RENAME COLUMN nome TO nmb
;
ALTER TABLE grupo
	MODIFY COLUMN dataFormacion DATE DEFAULT '0000-01-01'
;
CREATE TABLE DEPARTAMENTO (
	codDepartamento CHAR(15) PRIMARY KEY COMMENT 'Clave de la tabla de departamento',
    nome VARCHAR(30) NOT NULL COMMENT 'Nombre de cada departamento',
    localizacion VARCHAR(100) COMMENT 'Se recoge la direccion de cada departamento'
);
CREATE TABLE EMPREGADO(
	dni CHAR(9) PRIMARY KEY COMMENT 'Clave de la tabla de empregado',
    nss VARCHAR(20) NOT NULL COMMENT 'Clave candidata de la tabla de empregado',
    nome VARCHAR(30) NOT NULL COMMENT 'Nombre de cada empleado',
    dataNacemento DATE NOT NULL,
    sexo ENUM('H','M') NOT NULL COMMENT 'H = Hombre, M = Mujer',
    salario DECIMAL(7,2) NOT NULL COMMENT 'Se recoge la cantidad a cobrar del empleado, con 4 reales y 2 decimales',
    codDepartamentoTraballa CHAR(15),
    codDepartamentoDirixe CHAR(15),
    CONSTRAINT codDepartamentoTraballa_fk 
		FOREIGN KEY (codDepartamentoTraballa) REFERENCES DEPARTAMENTO (codDepartamento)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
	CONSTRAINT codDepartamentoDirixe_fk 
 		FOREIGN KEY (codDepartamentoDirixe) REFERENCES DEPARTAMENTO (codDepartamento)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);



DROP TABLE EMPREGADO;
DROP TABLE DEPARTAMENTO;
CREATE TABLE EMPREGADO(
	dni CHAR(9) PRIMARY KEY COMMENT 'Clave de la tabla de empregado',
    nss VARCHAR(20) NOT NULL COMMENT 'Clave candidata de la tabla de empregado',
    nome VARCHAR(30) NOT NULL COMMENT 'Nombre de cada empleado',
    dataNacemento DATE NOT NULL,
    sexo VARCHAR(20),
    salario DECIMAL(6,2) NOT NULL COMMENT 'Se recoge la cantidad a cobrar del empleado, con dos decimales y 4 reales'
);
CREATE TABLE DEPARTAMENTO (
	codDepartamento CHAR(15) PRIMARY KEY COMMENT 'Clave de la tabla de departamento',
    nome VARCHAR(30) NOT NULL COMMENT 'Nombre de cada departamento',
    localizacion VARCHAR(100) COMMENT 'Se recoge la direccion de cada departamento'
);
ALTER TABLE EMPREGADO
	ADD COLUMN codDepTraballa CHAR(15) NOT NULL,
    ADD COLUMN codDepDirixe CHAR(15) UNIQUE,
    ADD CONSTRAINT codDepTraballa_fk FOREIGN KEY (codDepTraballa) 
		REFERENCES DEPARTAMENTO (codDepartamento)
		ON DELETE RESTRICT
        ON UPDATE CASCADE,
    ADD CONSTRAINT codDepDirixe_fk FOREIGN KEY (codDepDirixe) 
		REFERENCES DEPARTAMENTO (codDepartamento)
		ON DELETE SET NULL
        ON UPDATE CASCADE
;
ALTER TABLE DEPARTAMENTO
	ADD COLUMN dnhiDirector CHAR (9) NOT NULL,
	ADD CONSTRAINT dnhiDirector_fk FOREIGN KEY (dnhiDirector) 
		REFERENCES EMPREGADO (dni)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
;

CREATE DATABASE eleccionModulos;
USE eleccionModulos;
CREATE TABLE PROFESOR(
	idProfesor CHAR(5) PRIMARY KEY COMMENT 'Nome curto do profesor',
    corpo ENUM('S','T') NOT NULL COMMENT 'Corpo ao que pertence. Valores permitidos:
										S = Profesorado Secundaria    T = Profesorado Técnico',
	nrp CHAR(20) NOT NULL UNIQUE COMMENT 'Numero de registro personal',
    nome VARCHAR(30) NOT NULL,
    apelidos VARCHAR(60) NOT NULL,
    horasLectivas SMALLINT(2) COMMENT 'Nª de horas de clase que imparte el profesor. Por defecto 18'
);
ALTER TABLE PROFESOR 
	MODIFY COLUMN horasLectivas DEFAULT '18'
;
SHOW TABLES;