DROP DATABASE IF EXISTS practicas1;
CREATE DATABASE practicas1;
USE practicas1;
CREATE TABLE fabricante (
	idFabricante CHAR(5) COMMENT "codigo que identifica a cada fabricante",  
	nome VARCHAR(80) NOT NULL,
    CONSTRAINT fabricante 
    PRIMARY KEY (idFabricante)
);
CREATE TABLE pelicula (
	codPelicula INT UNSIGNED 
		AUTO_INCREMENT,
    anoRodaxe YEAR NULL,
    titulo VARCHAR(100) NOT NULL,
    xenero VARCHAR(100) NOT NULL,
    duracion DECIMAL(4,2) NOT NULL,
    PRIMARY KEY (codPelicula),  
		CHECK (duracion > 0)
);
CREATE TABLE nacionalidad (
	codPelicula INT UNSIGNED,
    nacionalidade VARCHAR(100),
    CONSTRAINT nacionalidad 
    PRIMARY KEY (nacionalidade, codPelicula),
    FOREIGN KEY (codPelicula) 
		REFERENCES PELICULA (codPelicula) 
		ON DELETE RESTRICT
);
CREATE TABLE equipo (
	codEquipo CHAR(9) 
		COMMENT "Codigo do equipo, combinacion de letras e numeros", 
    nome VARCHAR(20) NOT NULL,
    director VARCHAR (20) NOT NULL
		COMMENT "Nome compreto do director do equipo",
    urlWeb Varchar (500),
    CONSTRAINT equipo
    PRIMARY KEY (codEquipo),
    CHECK (codEquipo REGEXP "[A-Za-z0-9]{9}")
);
CREATE TABLE ciclista (
	codEquipoContrato CHAR(9),
	fichaFederativa CHAR (10)
		COMMENT "Es un codigo que relaciona a cada ciclista, compuesto por numeros y letras",
    dataNacemento DATE NOT NULL,
    nome VARCHAR(30) NOT NULL,
    apellidos VARCHAR(60) NOT NULL,
    CONSTRAINT pk_ciclista 
		PRIMARY KEY (fichaFederativa),
	CONSTRAINT fk_ciclista_equipo
		FOREIGN KEY (codEquipoContrato) 
		REFERENCES equipo(codEquipo)
		ON DELETE RESTRICT
);
CREATE TABLE grupo(
	codGrupo CHAR(5) NOT NULL,
    nome VARCHAR(20) UNIQUE NOT NULL,
    cacheGrupo FLOAT(10) NOT NULL,
    dataFormacion DATE NOT NULL,
    CONSTRAINT pk_grupo 
		PRIMARY KEY (codGrupo)
);
CREATE TABLE concerto (
	codGrupo CHAR(5) NOT NULL,
	codConcerto CHAR(5),
    nomeConcerto VARCHAR(20) NOT NULL UNIQUE,
    dataConcerto DATE NOT NULL,
    aforo INT UNSIGNED NOT NULL,
    prezo DECIMAL(5,2) NOT NULL,
	CONSTRAINT aforoMaximo 
		CHECK (aforo <= 100000),
	CONSTRAINT prezoMaximo
		CHECK (prezo <= 200), 
    CONSTRAINT pk_concerto 
		PRIMARY KEY (codConcerto)
);
CREATE TABLE actua (
	codGrupo INTEGER,
	codConcerto INTEGER,
    PRIMARY KEY (codGrupo, codConcerto),
    FOREIGN KEY (codGrupo) 
		REFERENCES grupo (codGrupo),
	FOREIGN KEY (codConcerto) 
		REFERENCES concerto (codConcerto)
);
CREATE TABLE piso (
	codPiso VARCHAR(100) NOT NULL,
    domicilio VARCHAR(100) NOT NULL,
    localidade VARCHAR(100) NOT NULL,
    codPostal CHAR(5),
    CONSTRAINT piso
    PRIMARY KEY (codPiso)
);
CREATE TABLE contador (
	codContador CHAR(5) NOT NULL,
    modelo VARCHAR(30) NOT NULL,
    CONSTRAINT contador
    PRIMARY KEY (codContador)
);
SHOW TABLES;
SHOW DATABASES;
DESCRIBE nacionalidad;
DESCRIBE fabricante;
