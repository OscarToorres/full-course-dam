DROP DATABASE IF EXISTS concesionario;
CREATE DATABASE concesionario;
USE concesionario;
CREATE TABLE TRABAJADOR (
	trb_dni CHAR(9) PRIMARY KEY COMMENT 'Representa el DNI de cada trabajador de la empresa',
	trb_nombre VARCHAR(15) NOT NULL COMMENT 'Nombre del trabajador',
	trb_tlf CHAR(9) NOT NULL COMMENT 'Se guarda el numero de teledono de cada trabajador',
	trb_enderezo VARCHAR(50) NOT NULL COMMENT 'Se pide el lugar donde se aloja cada trabajador',
	trb_ciudad VARCHAR(20) NOT NULL COMMENT 'Ciudad donde vive el trabjador',
	trb_provincia VARCHAR(20) NOT NULL COMMENT 'Provincia en la que vive el trabajador'
);

CREATE TABLE DESGUACE(
	desg_id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Codigo del desguace donde se mandan los vehiculos',
    desg_enderezo VARCHAR(40) NOT NULL  COMMENT 'Lugar donde se encuentra el desguace'
);

CREATE TABLE COCHE(
	cc_matricula CHAR(7) PRIMARY KEY COMMENT 'Se guarda la matricula de cada vhiculo',
	cc_marca VARCHAR (20) NOT NULL COMMENT 'Se guada solo la marca a la que pertenece el vehiculo',
	cc_modelo VARCHAR(20) NOT NULL COMMENT 'Se guarda solo el modelo del vehiculo sin incluir su marca',
	cc_categoria VARCHAR(20) NOT NULL COMMENT'Se guarda el tipo de coche que es respecto su tamaño y carroceria',
	cc_color VARCHAR(40) NOT NULL COMMENT 'Color del vehiculo, si tiene varios, especificar',
	cc_precio DECIMAL(7,2) NOT NULL COMMENT 'Costo del vehiculo',
	fecha_desg DATE DEFAULT NULL COMMENT 'Fecha en la que el vehiculo fue mandado al desguace.',
	desg_id INT, 
    CONSTRAINT fk_desguace
		FOREIGN KEY (desg_id) REFERENCES DESGUACE (desg_id)
			ON UPDATE CASCADE
			ON DELETE RESTRICT
);

CREATE TABLE CLIENTE(
	clt_dni CHAR(9) PRIMARY KEY COMMENT 'DNI de cada cliente',
	clt_nombre VARCHAR(20) NOT NULL COMMENT 'Nombre de cada cliente',
	clt_tlf CHAR(9) NOT NULL COMMENT 'Telefono de contacto de cada cliente',
	clt_enderezo VARCHAR(50) NOT NULL COMMENT 'Se pide el lugar donde se aloja cada cliente',
	clt_ciudad VARCHAR(20) NOT NULL COMMENT 'Ciudad donde vive el cliente',
	clt_provincia VARCHAR(20) NOT NULL COMMENT 'Provincia en la que vive el cliente'
);

CREATE TABLE COMPRA(
	cmp_matricula CHAR(7) COMMENT 'Matricula del coche que se compra',
	trb_dni CHAR(9) COMMENT 'DNI del trabajador que le atendio',
    clt_dni CHAR(9) COMMENT 'DNI del cliente que ha sido atendido',
    fecha_compra DATE NOT NULL COMMENT 'Fecha en la que se compra un vehiculo',
    PRIMARY KEY (cmp_matricula, trb_dni, clt_dni, fecha_compra),
    CONSTRAINT fk_compra_trabajador 
		FOREIGN KEY (trb_dni) REFERENCES TRABAJADOR (trb_dni)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_compra_cliente
		FOREIGN KEY (clt_dni) REFERENCES CLIENTE (clt_dni)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_compra_coche
		FOREIGN KEY (cmp_matricula) REFERENCES COCHE (cc_matricula)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE VENDE(
	cc_matricula CHAR(7) COMMENT 'Matricula del coche que se vendio',
	trb_dni CHAR(9) COMMENT 'DNI del trabajador que se hizo cargo de la venta del vehiculo' ,
    clt_dni CHAR(9) COMMENT 'DNI del cliente al que se le vende el vehiculo' ,
    fecha_venta DATE NOT NULL COMMENT 'Fecha en la que se vende un vehiculo',
    PRIMARY KEY (cc_matricula, trb_dni, clt_dni, fecha_venta),
    CONSTRAINT fk_vende_trabajador 
		FOREIGN KEY (trb_dni) REFERENCES TRABAJADOR (trb_dni)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_vende_cliente
		FOREIGN KEY (clt_dni) REFERENCES CLIENTE (clt_dni)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_vende_coche
		FOREIGN KEY (cc_matricula) REFERENCES COCHE (cc_matricula)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE REVISION(
	rev_id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Codigo de la revision que se realizo',
    rev_parte VARCHAR(150) NOT NULL COMMENT 'Se hace un comentario con lo que se le ha detectado al vehiculo en la revision',
    rev_numero VARCHAR(3) NOT NULL COMMENT 'Se indican la cantidad de revisiones que lleva el vehiculo'
);

CREATE TABLE REPARACION(
	rep_id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Codigo de la reparacion que se realizo',
    rep_precio DECIMAL(7,2) DEFAULT '0' COMMENT 'Costo de la reparacion que se realiza, por defecto estara en 0'
);

CREATE TABLE PASA_POR(
	pp_data DATE COMMENT 'Fecha en la que fue a revision', 
	rev_id INT COMMENT 'Codigo de revision',
    cc_matricula CHAR(7) COMMENT 'Matricula del coche que pasa revision',
	trb_dni CHAR(9) COMMENT 'DNI del trabajador que hizo la revision',
    PRIMARY KEY (rev_id, cc_matricula, trb_dni, pp_data),
    CONSTRAINT fk_pasa_por_trabajador 
		FOREIGN KEY (trb_dni) REFERENCES TRABAJADOR (trb_dni)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_pasa_por_cliente
		FOREIGN KEY (cc_matricula) REFERENCES COCHE (cc_matricula)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_pasa_por_revision
		FOREIGN KEY (rev_id) REFERENCES REVISION (rev_id)
		ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE REALIZA (
	cc_matricula CHAR(7),
	trb_dni CHAR(9),
    rep_id INT,
    fecha_reparacion DATE NOT NULL COMMENT 'Fecha en la que se realiza una reparacion',
    PRIMARY KEY (cc_matricula, trb_dni, rep_id, fecha_reparacion),
    CONSTRAINT fk_realiza_trabajador 
		FOREIGN KEY (trb_dni) REFERENCES TRABAJADOR (trb_dni)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_realiza_reparacion
		FOREIGN KEY (rep_id) REFERENCES REPARACION (rep_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	CONSTRAINT fk_realiza_coche
		FOREIGN KEY (cc_matricula) REFERENCES COCHE (cc_matricula)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE PROVEEDOR (
	prov_id	INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Codigo de cada proveedor que suministra piezas',
    prov_nombre VARCHAR(30) NOT NULL COMMENT 'Nombre del proveedor', 
	prov_tlf CHAR(9) NOT NULL COMMENT 'Se guarda el numero de telefono de contacto de cada proveedor',
	prov_enderezo VARCHAR(50) NOT NULL COMMENT 'Se pide el lugar donde se aloja cada proveedor',
	prov_ciudad VARCHAR(20) NOT NULL COMMENT 'Ciudad donde se encuentra el proveedor',
	prov_provincia VARCHAR(20) NOT NULL COMMENT 'Provincia en la que se encuentra el proveedor'
);

CREATE TABLE PIEZA (
	pz_id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Codigo de identificacion de cada pieza', 
    pz_stock INT NOT NULL DEFAULT '0' COMMENT 'Se indica en cantidad numerica el numero de piezas disponibles que hay. Si no hay se pondra por defecto 0',
	pz_tipo VARCHAR(30) NOT NULL COMMENT 'Se especifica el tipo de pieza que es',
	pz_descripcion VARCHAR(100) NOT NULL COMMENT 'Se hace una pequeña descripcion de cada pieza indicando su uso y a que pertenece',
    prov_id INT NOT NULL COMMENT 'id del proveedor que realiza la entrega',
    CONSTRAINT fk_pieza_proveedor
		FOREIGN KEY (prov_id) REFERENCES PROVEEDOR (prov_id)
		ON DELETE CASCADE
        ON UPDATE RESTRICT
);

CREATE TABLE LINEA_REPARACION(
	lr_cod INT COMMENT 'Codigo de cada linea de reparacion que se realiza',
    lr_cantidad INTEGER NOT NULL COMMENT 'Cantidad de piezas o productos que van dentro del pedido',
	pz_id INT,
    rep_id INT,
    PRIMARY KEY (lr_cod, rep_id),
    CONSTRAINT fk_lineaReparacion_pieza
		FOREIGN KEY (pz_id) REFERENCES PIEZA (pz_id)
		ON DELETE CASCADE
        ON UPDATE RESTRICT,
    CONSTRAINT fk_lineaReparacion_reaparacion
		FOREIGN KEY (rep_id) REFERENCES REPARACION (rep_id)
		ON DELETE CASCADE
        ON UPDATE RESTRICT
);

CREATE TABLE PEDIDO(
	pdd_numero INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Codigo de cada pedido',
    pdd_fecha_realizado DATE NOT NULL COMMENT 'Fecha en la que se realiza el pedido',
    pdd_fecha_recibido DATE DEFAULT NULL COMMENT 'Fecha en la que el pedido lega',
    prov_id INT NOT NULL COMMENT 'Id del proveedor al que se le pide la pieza',
    CONSTRAINT fk_pedido_proveedor 
		FOREIGN KEY (prov_id) REFERENCES PROVEEDOR (prov_id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
);

CREATE TABLE LINEA_PEDIDO(
	lp_cod INT COMMENT 'Codigo de cada linea de compra que se realiza',
    lp_precio_pieza DECIMAL(7,2) NOT NULL COMMENT 'Precio individual de cada pieza',
    lp_cantidad INTEGER NOT NULL COMMENT 'Cantidad de piezas o productos que van dentro del pedido',
    pdd_numero INT,
    pz_id INT,
    PRIMARY KEY (lp_cod, pdd_numero),
    CONSTRAINT fk_liñacompra_pedido
		FOREIGN KEY (pdd_numero) REFERENCES PEDIDO (pdd_numero)
		ON DELETE CASCADE
        ON UPDATE RESTRICT,
    CONSTRAINT fk_liñacompra_pieza
		FOREIGN KEY (pz_id) REFERENCES PIEZA (pz_id)
		ON DELETE CASCADE
        ON UPDATE RESTRICT
);