DROP DATABASE IF EXISTS ventas;
CREATE DATABASE ventas CHARACTER SET latin1;
USE ventas;
CREATE TABLE cliente (
    id              INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nome            VARCHAR(25),
    primero_apelido VARCHAR(15) NOT NULL,
    cidade          VARCHAR(100),
    categoria       INT UNSIGNED
);
CREATE TABLE comercial (
    id       INT          UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nome     VARCHAR(100) NOT NULL,
    apelido1 VARCHAR(100) NOT NULL,
    apelido2 VARCHAR(100),
    cidade   VARCHAR(100),
    comision FLOAT
);
ALTER DATABASE ventas DEFAULT CHARACTER SET utf8mb4;

ALTER TABLE cliente 
	MODIFY COLUMN nome
		VARCHAR(100) NOT NULL,
    CHANGE COLUMN primero_apelido
		apelido1 VARCHAR(100) NOT NULL,
    DROP COLUMN categoria,
    ADD COLUMN apelido2 VARCHAR(100) NULL AFTER apelido1
;
ALTER TABLE comercial
	ALTER COLUMN comision SET DEFAULT 10
    ;
DESCRIBE cliente;
