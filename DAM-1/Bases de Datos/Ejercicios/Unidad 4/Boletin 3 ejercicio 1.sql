DROP DATABASE IF EXISTS Boletin3_Ejercicio1;
CREATE DATABASE Boletin3_Ejercicio1;
USE Boletin3_Ejercicio1;
CREATE TABLE ACTIVIDAD (
	cod_actividad INTEGER AUTO_INCREMENT COMMENT "Codigo identificador de actividad",
	nombre_actividad VARCHAR(20) NOT NULL,
	temporada INT NOT NULL COMMENT "Numero de temporada secuencial",
	descripcion VARCHAR(100) NOT NULL,
	CONSTRAINT actividad_pk PRIMARY KEY (cod_actividad)
 ); 
 -- Tabla que almacena las salas para las actividaddes deportivas
CREATE TABLE SALA (
	cod_sala INTEGER AUTO_INCREMENT COMMENT "Codigo identificador de sala",
	nombre_sala VARCHAR(20) NOT NULL,
	tamanho_sala DECIMAL(5,2) NOT NULL COMMENT "Tamaño de la sala en metros cuadrados con 2 decimales de precision",
	CONSTRAINT sala_pk PRIMARY KEY (cod_sala)
 );
CREATE TABLE MONITOR (
	dni_monitor CHAR(9),
    nombre_monitor VARCHAR(30) NOT NULL,
    tel_contacto CHAR(9) NOT NULL COMMENT "Telefono sin prefijo",
    especialidad VARCHAR(50) NOT NULL,
	CONSTRAINT monitor_pk PRIMARY KEY (dni_monitor)
 );
 CREATE TABLE CONDUCE (
	cod_sala INTEGER,
    cod_actividad INTEGER,
    dni_monitor CHAR(9),
    fecha_ddmmaa DATE NOT NULL,
    fecha_hora_inicio TIME NOT NULL,
    fecha_hora_fin TIME NOT NULL,
	CONSTRAINT conduce_pk PRIMARY KEY (cod_sala, cod_actividad, dni_monitor, fecha_ddmmaa, fecha_hora_inicio, fecha_hora_fin),
	CONSTRAINT conduce_fk_sala FOREIGN KEY (cod_sala)
		REFERENCES SALA (cod_sala)
        ON DELETE RESTRICT,
	CONSTRAINT conduce_fk_actividad FOREIGN KEY (cod_actividad)
		REFERENCES ACTIVIDAD (cod_actividad)
		ON DELETE RESTRICT,
	CONSTRAINT conduce_fk_monitor FOREIGN KEY (dni_monitor)
		REFERENCES MONITOR (dni_monitor)
        ON DELETE RESTRICT
 );
 