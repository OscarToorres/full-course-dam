USE concesionario;

ALTER TABLE TRABAJADOR
	ADD COLUMN apellido1 VARCHAR(20) NOT NULL COMMENT 'Se almacenara el primer apellido de los trabajadores',
   	ADD COLUMN apellido2 VARCHAR(20) NOT NULL COMMENT 'Se almacenara el primer apellido de los trabajadores'
;
ALTER TABLE DESGUACE 
	ADD COLUMN fecha_desguace DATE NOT NULL COMMENT 'Se almacenara la fecha en la que el vehiculo se ha desguazado'
;
ALTER TABLE COCHE
	ADD COLUMN numero_dueños INTEGER NOT NULL COMMENT 'Se pone en dato numerico la cantidad de dueños qu se conoce que ha 
													   tenido eel vehiculo',
	MODIFY COLUMN fecha_desguace DATE DEFAULT '0001-01-01'
;
ALTER TABLE CLIENTE
	ADD COLUMN apellido1 VARCHAR(20) NOT NULL COMMENT 'Se almacenara el primer apellido de los clientes',
   	ADD COLUMN apellido2 VARCHAR(20) NOT NULL COMMENT 'Se almacenara el primer apellido de los clientes',
	RENAME COLUMN nombre_clt TO nombre_cliente,
	ADD COLUMN fecha_nacimiento DATE NOT NULL COMMENT 'Fecha de nacimineto de cada liente'
;
ALTER TABLE CLIENTE
	DROP COLUMN fecha_nacimiento
;
ALTER TABLE REVISION
	ADD COLUMN fecha_revision DATE NOT NULL COMMENT 'Fecha en la que se ha realzado la revision',
    MODIFY COLUMN parte_revision VARCHAR (200)
;
ALTER TABLE REPARACION
	ADD COLUMN fecha_reparacion DATE NOT NULL COMMENT 'Fecha en la que se realiza la reparacion'
;
