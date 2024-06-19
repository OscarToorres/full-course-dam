USE concesionario;
INSERT TRABAJADOR (trb_dni, trb_nombre, trb_tlf, trb_enderezo, trb_ciudad, trb_provincia)
VALUE ('78896518X', 'Manuel', '653201955', 'Calle Vieja', 'A Coruña', 'A Coruña'),
	  ('78165165P', 'Juan', '698744215', 'Taragoña', 'Santiago', 'A Coruña'),
	  ('79156541J', 'Paula', '655214785', 'Boiro', 'Santiago', 'A Coruña' ),
      ('78965421D', 'Manuel', '687454125', 'Puebla', 'Santiago', 'A Coruña'),
      ('78968821D', 'Lara', '654210789', 'Noia', 'Santiago', 'A Coruña'),
      ('78805412D', 'Toño', '665874120', 'Rianxo', 'Santiago', 'A Coruña'),
	  ('78888423P', 'Iago', '666555444', 'Avenida de Alcala', 'A Coruña', 'A Coruña');

INSERT DESGUACE (desg_enderezo)
VALUE ('Poligono industrial Santiago'),
	  ('Poligono industrial A Coruña'),
      ('Poligono industrial Boiro'),
      ('Poligono industrial Ribeira'),
      ('Poligono industrial Rianxo'),
      ('Poligono industrial Noia');

INSERT COCHE (cc_matricula, cc_marca, cc_modelo, cc_categoria, cc_color, cc_precio, desg_id, fecha_desg)
VALUE ('7854ASD', 'BMW', 'M4','Nuevo', 'Azul cian', '50000 ', DEFAULT, DEFAULT),
	  ('9874DGF', 'BMW', 'M4 S', 'Nuevo', 'Negro', '60000', DEFAULT, DEFAULT),
	  ('1325ESF', 'RENOL', 'CLIO', '2º mano', 'Negro', '10000 ', '002', '2018-06-09'),
	  ('4587OFN', 'MECEDES', 'AMG A51', 'Nuevo', 'Gris', '56000', DEFAULT, DEFAULT),
	  ('7462DFJ', 'AUDI', 'A5', '2º mano', 'Blanco', '50000', DEFAULT, DEFAULT ),
	  ('5432AFE', 'INFINITY', 'Q40', '2º mano', 'Negro', '59000', DEFAULT, DEFAULT),
   	  ('1222DFG', 'AUDI', 'A5', '2º mano', 'Blanco', '50000', DEFAULT, DEFAULT ),
	  ('7433DFH', 'AUDI', 'A5', '2º mano', 'Negro', '50000', DEFAULT, DEFAULT ),
	  ('7422DIJ', 'AUDI', 'A5', '2º mano', 'Azul Cian', '50000', DEFAULT, DEFAULT );
      
INSERT CLIENTE (clt_dni, clt_nombre, clt_tlf, clt_enderezo, clt_ciudad, clt_provincia)
VALUE ('75421568Q', 'Maria', '652214873', 'Abuin', 'Santiago', 'A Coruña'),
      ('77895411W', 'Perez', '655588874', 'Carballo', 'Santiago', 'A Coruña'),
      ('78221422A', 'Max', '665595852', 'Leiro', 'Santiago', 'A Coruña'),
      ('72236548W', 'Jose', '652014100', 'Taragoña', 'Santiago', 'A Coruña'),
      ('75448885E', 'Adrian', '663200014', 'Asados', 'Santiago', 'A Coruña'),
      ('79886663D', 'Mireia', '658745444', 'Rianxo', 'Santiago', 'A Coruña');
      
INSERT COMPRA (cmp_matricula, trb_dni, clt_dni, fecha_compra)
VALUE ('7854ASD', '78896518X', '75421568Q', '2019-05-02'),
	  ('9874DGF', '78165165P', '77895411W', '2019-05-03'),
	  ('1325ESF', '78165165P', '78221422A', '2019-07-09'),
	  ('4587OFN', '78165165P', '72236548W', '2019-09-22'),
	  ('7462DFJ', '78805412D', '75448885E', '2020-01-21'),
	  ('5432AFE', '78965421D', '79886663D', '2020-03-01');
      
INSERT VENDE (cc_matricula, trb_dni, clt_dni, fecha_venta)
VALUE ('7854ASD', '78896518X', '75421568Q', '2017-06-20'),
	  ('9874DGF', '78165165P', '77895411W', '2019-09-09'),	
	  ('1325ESF', '78165165P', '78221422A', '2020-09-22'),
      ('4587OFN', '78165165P', '72236548W', '2020-10-23'),
      ('7462DFJ', '78805412D', '75448885E', '2020-10-25'),
      ('5432AFE', '78965421D', '79886663D', '2020-11-06');
            
INSERT REVISION (rev_id, rev_parte, rev_numero)
VALUE (DEFAULT, 'Cambio de aceite y ruedas', '1'),
	  (DEFAULT, 'Cambio de aceite y ruedas', '1'),
      (DEFAULT, 'Cambio de aceite , ruedas y alineamiento de direccion', '1'),
      (DEFAULT, 'Cambio de aceite ', '1'),
      (DEFAULT, 'Cambio de aceite, correa de distribucion', '2'),
      (DEFAULT, 'Ningún cambio, todo en buen estado', '1');
      
INSERT REPARACION (rep_id, rep_precio)
VALUE (DEFAULT, '3000');
      
INSERT PASA_POR (pp_data, rev_id, cc_matricula, trb_dni)
VALUE ('2019-05-15', 1, '7854ASD', '78896518X'), 
	  ('2019-06-19', 2, '9874DGF', '78165165P'),
      ('2019-08-20', 3, '1325ESF', '79156541J'),
      ('2019-10-20', 4, '4587OFN', '78965421D'),
      ('2020-05-05', 5, '7462DFJ', '78805412D'),
      ('2021-09-19', 6, '5432AFE', '78965421D');
      
INSERT REALIZA (cc_matricula, trb_dni, rep_id, fecha_reparacion)
VALUE ('7854ASD', '78896518X', 1, '2017-11-08');

      
INSERT PROVEEDOR (prov_id, prov_nombre, prov_tlf, prov_enderezo, prov_ciudad, prov_provincia)
VALUE (DEFAULT, 'Piezas Ramon', '655444712', 'Boiro', 'Santiago', 'A Coruña'),
	  (DEFAULT, 'Carlos', '666322141', 'Ribeira', 'Santiago', 'A Coruña'),
      (DEFAULT, 'Ruedas Infinitas', '668541200', 'Ribeira', 'Santiago', 'A Coruña'),
      (DEFAULT, 'Manolo', '600587770', 'Noia', 'Santiago', 'A Coruña'),
      (DEFAULT, 'Manuel', '658743355', 'Porto do Son', 'Santiago', 'A Coruña'),
      (DEFAULT, 'Ariel', '698777777', 'Santiago', 'Santiago', 'A Coruña');
      
INSERT PIEZA (pz_id, pz_stock, pz_tipo, pz_descripcion, prov_id)
VALUE (DEFAULT, '1', 'Caja de cambio', 'caja de doble embrage',  1),
	  (DEFAULT, '2', 'motor', 'Motor de desguace con 95k km',  1),
      (DEFAULT, '20', 'Filtros de aceite', 'Modelo de CJF General Motors',  1),
      (DEFAULT, '20', 'Filtros de aire ', 'Modelo estandar, global',  1),
      (DEFAULT, '8', 'Frenos ', 'Brembo de doble pinza radial', 1),
      (DEFAULT, '8', 'Ruedas', 'Michelin Sport para lluvia',  1);
      
INSERT LINEA_REPARACION (lr_cod, lr_cantidad, pz_id, rep_id)
VALUE ('1', '4', '6', '1'), 
	  ('2', '4', '5', '1');
      
INSERT PEDIDO (pdd_numero, pdd_fecha_realizado, pdd_fecha_recibido, prov_id)
	VALUE (DEFAULT, '2018-12-20', '2019-01-05', '1');
                    
INSERT LINEA_PEDIDO (lp_cod, lp_precio_pieza, lp_cantidad, pz_id, pdd_numero)
VALUE ('1', '560', '1', '1', '1'),
	  ('2', '900', '2', '2', '1'),
      ('3', '10', '20', '3', '1'),
      ('4', '5', '20', '4', '1'),
      ('5', '120', '8', '5', '1'),
      ('6', '200', '8', '6', '1');
      