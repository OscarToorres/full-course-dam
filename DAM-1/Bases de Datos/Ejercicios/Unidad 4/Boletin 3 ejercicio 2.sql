DROP DATABASE IF EXISTS Boletin3_Ejercicio2;
CREATE DATABASE Boletin3_Ejercicio2;
USE Boletin3_Ejercicio2;
CREATE TABLE CLIENTE (
	cod_cliente INTEGER AUTO_INCREMENT COMMENT "Codigo identificador de cliente",
    nombre_cliente VARCHAR(30) NOT NULL,
    CONSTRAINT pk_cliente
		PRIMARY KEY (cod_cliente)
);
CREATE TABLE EMPLEADO (
	dni_empleado CHAR(9),
    nombre_empleado VARCHAR(20) NOT NULL,
    fecha_ini_contrato DATE NOT NULL,
    fecha_fin_contrato DATE NOT NULL,
    tipo ENUM("Diseñador","Montador") NOT NULL,
    CONSTRAINT pk_empleado PRIMARY KEY (dni_empleado)
);
CREATE TABLE DISEÑADOR (
	dni_empleado CHAR(9),
    CONSTRAINT pk_diseñador
		PRIMARY KEY (dni_empleado)
);
CREATE TABLE PREFIERE (
	cod_cliente CHAR(5),
    dni_empleado CHAR(9),
    PRIMARY KEY (cod_cliente, dni_empleado),
    FOREIGN KEY (cod_cliente)
		REFERENCES CLIENTE (cod_cliente),
	FOREIGN KEY (dni_empleado)
		REFERENCES DISEÑADOR (dni_empleado)
);
CREATE TABLE COCINA (
	cod_cocina CHAR(5),
    cod_cliente CHAR(5),
    dni_empleado CHAR(9),
    estructura VARCHAR(50) NOT NULL,
    material VARCHAR(30) NOT NULL,
    colores VARCHAR(20) NOT NULL,
    pagado CHAR(3) NOT NULL,
	CONSTRAINT pk_cocina
		PRIMARY KEY (cod_cocina),
	CONSTRAINT fk_cliente
		FOREIGN KEY (cod_cliente)
			REFERENCES CLIENTE (cod_cliente),
	CONSTRAINT fk_diseñador
		FOREIGN KEY (dni_empleado)
			REFERENCES DISEÑADOR (dni_empleado)
);
CREATE TABLE MONTADOR (
	dni_empleado CHAR(9),
    cod_montador CHAR(5) UNIQUE,
    CONSTRAINT pk_montador
		PRIMARY KEY (dni_empleado)
);
