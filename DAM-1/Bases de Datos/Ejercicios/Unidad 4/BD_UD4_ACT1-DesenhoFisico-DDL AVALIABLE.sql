DROP DATABASE IF EXISTS concesionario;
CREATE DATABASE concesionario;
USE concesionario;
CREATE TABLE TRABAJADOR (
	dni_trab CHAR(9) PRIMARY KEY COMMENT 'Representa el DNI de cada trabajador de la empresa',
	nombre_trab VARCHAR(15) NOT NULL COMMENT 'Nombre del trabajador',
	tlf_trab CHAR(9) NOT NULL COMMENT 'Se guarda el numero de teledono de cada trabajador',
	enderezo VARCHAR(50) NOT NULL COMMENT 'Se pide el lugar donde se aloja cada trabajador',
	ciudad VARCHAR(20) NOT NULL COMMENT 'Ciudad donde vive el trabjador',
	provincia VARCHAR(20) NOT NULL COMMENT 'Provincia en la que vive el trabajador'
);
CREATE TABLE DESGUACE(
	id_desguace CHAR(3) PRIMARY KEY COMMENT 'Codigo del desguace donde se mandan los vehiculos',
    enderezo VARCHAR(40) NOT NULL  COMMENT 'Lugar donde se encuentra el desguace',
	marca VARCHAR(20) NOT NULL  COMMENT 'Marca del vehiculo',
    modelo VARCHAR(20) NOT NULL COMMENT 'Modelo del vehiclo'
);
CREATE TABLE COCHE(
	matricula CHAR(7) PRIMARY KEY COMMENT 'Se guarda la matricula de cada vhiculo',
	marca VARCHAR (20) NOT NULL COMMENT 'Se guada solo la marca a la que pertenece el vehiculo',
	modelo VARCHAR(20) NOT NULL COMMENT 'Se guarda solo el modelo del vehiculo sin incluir su marca',
	categoria VARCHAR(20) NOT NULL COMMENT'Se guarda el tipo de coche que es respecto su tamaño y carroceria',
	color VARCHAR(40) NOT NULL COMMENT 'Color del vehiculo, si tiene varios, especificar',
	precio DECIMAL(7,2) NOT NULL COMMENT 'Costo del vehiculo',
    id_desguace CHAR(3), 
	fecha_desguace DATE DEFAULT '0000-01-01' COMMENT 'Fecha en la que el vehiculo fue mandado al desguace. Si no fue, se pondra por defecto la fecha 0000-01-01',
    CONSTRAINT fk_desguace
		FOREIGN KEY (id_desguace) REFERENCES DESGUACE (id_desguace)
);
CREATE TABLE CLIENTE(
	dni_clt CHAR(9) PRIMARY KEY COMMENT 'DNI de cada cliente',
	nombre_clt VARCHAR(20) NOT NULL COMMENT 'Nombre de cada cliente',
	tlf_clt CHAR(9) NOT NULL COMMENT 'Telefono de contacto de cada cliente',
	enderezo VARCHAR(50) NOT NULL COMMENT 'Se pide el lugar donde se aloja cada cliente',
	ciudad VARCHAR(20) NOT NULL COMMENT 'Ciudad donde vive el cliente',
	provincia VARCHAR(20) NOT NULL COMMENT 'Provincia en la que vive el cliente'
);
CREATE TABLE COMPRA(
	matricula CHAR(7),
	dni_trab CHAR(9),
    dni_clt CHAR(9),
    fecha_compra DATE NOT NULL COMMENT 'Fecha en la que se compra un vehiculo',
    PRIMARY KEY (matricula, dni_trab, dni_clt, fecha_compra),
    CONSTRAINT fk_compra_trabajador 
		FOREIGN KEY (dni_trab) REFERENCES TRABAJADOR (dni_trab)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_compra_cliente
		FOREIGN KEY (dni_clt) REFERENCES CLIENTE (dni_clt)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_compra_coche
		FOREIGN KEY (matricula) REFERENCES COCHE (matricula)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);
CREATE TABLE VENDE(
	matricula CHAR(7),
	dni_trab CHAR(9),
    dni_clt CHAR(9),
    fecha_venta DATE NOT NULL COMMENT 'Fecha en la que se vende un vehiculo',
    PRIMARY KEY (matricula, dni_trab, dni_clt, fecha_venta),
    CONSTRAINT fk_vende_trabajador 
		FOREIGN KEY (dni_trab) REFERENCES TRABAJADOR (dni_trab)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_vende_cliente
		FOREIGN KEY (dni_clt) REFERENCES CLIENTE (dni_clt)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_vende_coche
		FOREIGN KEY (matricula) REFERENCES COCHE (matricula)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);
CREATE TABLE REVISION(
	id_revision CHAR(10) PRIMARY KEY COMMENT 'Codigo de la revision que se realizo',
    parte_revision VARCHAR(150) NOT NULL COMMENT 'Se hace un comentario con lo que se le ha detectado al vehiculo en la revision',
    numero_revision VARCHAR(3) NOT NULL COMMENT 'Se indican la cantidad de revisiones que lleva el vehiculo'
);
CREATE TABLE REPARACION(
	id_rep CHAR(10) PRIMARY KEY COMMENT 'Codigo de la reparacion que se realizo',
    precio DECIMAL(7,2) NOT NULL COMMENT 'Costo de la reparacion que se realiza'
);
CREATE TABLE PASA_POR(
	id_revision CHAR(10),
    matricula CHAR(7),
	dni_trab CHAR(9),
    PRIMARY KEY (id_revision, matricula, dni_trab),
    CONSTRAINT fk_pasa_por_trabajador 
		FOREIGN KEY (dni_trab) REFERENCES TRABAJADOR (dni_trab)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_pasa_por_cliente
		FOREIGN KEY (matricula) REFERENCES COCHE (matricula)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_pasa_por_revision
		FOREIGN KEY (id_revision) REFERENCES REVISION (id_revision)
		ON UPDATE CASCADE
        ON DELETE RESTRICT
);
CREATE TABLE REALIZA(
	matricula CHAR(7),
	dni_trab CHAR(9),
    id_rep CHAR(10),
    fecha_compra DATE NOT NULL COMMENT 'Fecha en la que se compra un vehiculo',
    PRIMARY KEY (matricula, dni_trab, id_rep, fecha_compra),
    CONSTRAINT fk_realiza_trabajador 
		FOREIGN KEY (dni_trab) REFERENCES TRABAJADOR (dni_trab)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_realiza_cliente
		FOREIGN KEY (id_rep) REFERENCES REPARACION (id_rep)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_realiza_coche
		FOREIGN KEY (matricula) REFERENCES COCHE (matricula)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);
CREATE TABLE PROVEEDOR(
	id_prov	CHAR(6) PRIMARY KEY COMMENT 'Codigo de cada proveedor que suministra piezas',
    nombre_prov VARCHAR(15) NOT NULL COMMENT 'Nombre del proveedor', 
	tlf_prov CHAR(9) NOT NULL COMMENT 'Se guarda el numero de telefono de contacto de cada proveedor',
	enderezo VARCHAR(50) NOT NULL COMMENT 'Se pide el lugar donde se aloja cada proveedor',
	ciudad VARCHAR(20) NOT NULL COMMENT 'Ciudad donde se encuentra el proveedor',
	provincia VARCHAR(20) NOT NULL COMMENT 'Provincia en la que se encuentra el proveedor'
);
CREATE TABLE PIEZAS(
	id_pieza CHAR(15) PRIMARY KEY COMMENT 'Codigo de identificacion de cada pieza', 
    stock VARCHAR (4) NOT NULL DEFAULT '0' COMMENT 'Se indica en cantidad numerica el numero de piezas disponibles que hay. Si no hay se pondra por defecto 0',
	descripcion VARCHAR(100) NOT NULL COMMENT 'Se hace una pequeña descripcion de cada pieza indicando su uso y a que pertenece',
	id_prov CHAR(6),
    id_rep CHAR(10),
    CONSTRAINT fk_pieza_proveedor
		FOREIGN KEY (id_prov) REFERENCES PROVEEDOR (id_prov)
		ON DELETE CASCADE
        ON UPDATE RESTRICT,
	CONSTRAINT fk_pieza_reparacion
		FOREIGN KEY(id_rep) REFERENCES REPARACION (id_rep)
		ON DELETE CASCADE
        ON UPDATE RESTRICT
);
CREATE TABLE PEDIDO(
	numero_pedido CHAR(12) PRIMARY KEY COMMENT 'Codigo de cada pedido',
    cantidad INTEGER NOT NULL COMMENT 'Cantidad de piezas o productos que van dentro del pedido',
    fecha_realizado DATE NOT NULL COMMENT 'Fecha en la que se realiza el pedido',
    fecha_recivido DATE NOT NULL COMMENT 'Fecha en la que el pedido lega',
    id_prov CHAR(6),
    CONSTRAINT fk_pedido_proveedor 
		FOREIGN KEY (id_prov) REFERENCES PROVEEDOR (id_prov)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
);
CREATE TABLE LINEA_COMPRA(
	cod_compra CHAR(5) COMMENT 'Codigo de cada compra que se realiza',
    coste_total DECIMAL(7,2) NOT NULL COMMENT 'Precio total de la compra realizada',
    precio_pieza DECIMAL(7,2) NOT NULL COMMENT 'Precio individual de cada pieza',
    numero_pedido CHAR(12),
    PRIMARY KEY (cod_compra, numero_pedido),
    CONSTRAINT fk_liñacompra_pedido
		FOREIGN KEY (numero_pedido) REFERENCES PEDIDO (numero_pedido)
		ON DELETE CASCADE
        ON UPDATE RESTRICT
);