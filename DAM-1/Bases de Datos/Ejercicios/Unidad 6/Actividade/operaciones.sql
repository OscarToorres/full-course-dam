USE concesionario;
-- NUEVOS INSERTS
-- Nuevos trabajadores en la empresa
INSERT TRABAJADOR (trb_dni, trb_nombre, trb_tlf, trb_enderezo, trb_ciudad, trb_provincia)
VALUES ('75111436P', 'Iago', '666555444', 'Avenida de Alcala', 'A Coruña', 'A Coruña'),
	  ('75178988D', 'Belen', '621144788', 'Calle Maria Santa', 'Santiago', 'A Coruña');

-- La empresa revibe un nuevo coche
INSERT COCHE
SET cc_matricula = '7854JGG',
	cc_marca = 'AUDI', 
    cc_modelo = 'A3',
    cc_categoria = 'Nuevo',
    cc_color = 'Azul cian' ,
    cc_precio = '50000 ',
    desg_id = DEFAULT,
    fecha_desg = DEFAULT;	

-- Se dan de alta nuevos clientes    
INSERT CLIENTE (clt_dni, clt_nombre, clt_tlf, clt_enderezo, clt_ciudad, clt_provincia)
VALUES ('75555568Q', 'Luis', '666557896', 'Leiro', 'Santiago', 'A Coruña');
INSERT CLIENTE (clt_dni, clt_nombre, clt_tlf, clt_enderezo, clt_ciudad, clt_provincia)
SELECT '77778558P', 'Jorge', '678900065', 'Oleiros', 'Santiago', 'A Coruña';

-- TRANSACCIONES
-- Hacemos un pedido de una pieza necesaria para el taller
USE concesionario;
START TRANSACTION;
INSERT PIEZA (pz_id, pz_stock, pz_tipo, pz_descripcion, prov_id)
VALUE (DEFAULT, DEFAULT, 'Parabrisas', 'Parabrisas de BMW M3',  3);
INSERT PEDIDO (pdd_numero, pdd_fecha_realizado, pdd_fecha_recibido, prov_id)
VALUE (DEFAULT, curdate(), DEFAULT, '3');
INSERT LINEA_PEDIDO (lp_cod, lp_precio_pieza, lp_cantidad, pz_id, pdd_numero)
VALUE ('1', '165', '1', '7', '2');
UPDATE PEDIDO
SET pdd_fecha_recibido = curdate()
WHERE pdd_numero = 2;
UPDATE PIEZA
SET pz_stock = pz_stock + 1
WHERE pz_id = 6;
COMMIT;

-- Hacemos una nueva reapracion y hay que hacer una actualizacion del stock de piezas y dejar listo todos
-- los datos de la reparacion
START TRANSACTION;
INSERT REPARACION (rep_id, rep_precio)
VALUE (DEFAULT, DEFAULT);
INSERT LINEA_REPARACION (lr_cod, lr_cantidad, pz_id, rep_id)
VALUE (1, 1, 1, 2), 
	  (2, 1, 2, 2),
 	  (3, 1, 3, 2),
	  (4, 4, 5, 2),
	  (5, 4, 6, 2);
UPDATE PIEZA
SET pz_stock = pz_stock - 1
WHERE pz_id = 1;
UPDATE PIEZA
SET pz_stock = pz_stock - 1
WHERE pz_id = 2;
UPDATE PIEZA
SET pz_stock = pz_stock - 1
WHERE pz_id = 3;
UPDATE PIEZA
SET pz_stock = pz_stock - 4
WHERE pz_id = 5;
UPDATE PIEZA
SET pz_stock = pz_stock - 4
WHERE pz_id = 6;
UPDATE REPARACION
SET rep_precio = 2750
WHERE rep_id = 2;
COMMIT;
  
-- DELETES
-- Borramos un proveedor que ya no existe
DELETE FROM PROVEEDOR
WHERE prov_id = 1;

-- Borramos un desguace que ya no trabaja con nosotros
DELETE FROM DESGUACE 
WHERE desg_id = 1;

--  Eliminamos a un trabajador que estaba en pruebas
DELETE FROM TRABAJADOR
WHERE trb_dni LIKE '78888423P';

-- UPDATES
-- Un coche que fue mandado al desguace
UPDATE COCHE
SET desg_id = 6, fecha_desg = '2021-04-08'
WHERE cc_matricula LIKE '9874DGF';

-- Un cliente que ha cambiado de numero de telefono
UPDATE CLIENTE
SET clt_tlf = 699999999
WHERE clt_dni LIKE '75421568Q';

-- Una revision que se le añadieron mas cambios en la descripcion
UPDATE REVISION
SET rev_parte = 'Cambio de aceite + Cambio de filtro de aire'
WHERE rev_id = 4;

-- CONSULTAS
-- Seleccionar los coches que todabia no se han vendido
SELECT C.cc_matricula, C.cc_marca
FROM COCHE AS C
WHERE C.cc_matricula NOT IN (SELECT V.cc_matricula
							 FROM VENDE AS V);

-- Seleccionar todos los proveedores que han mandado mercancia
SELECT *
FROM PROVEEDOR AS PR
INNER JOIN PIEZA AS P ON PR.prov_id = P.prov_id;

-- Seleccionar la todas las piezas y la fecha en la que se compraron correspondientes con el pedido 1
SELECT * , pdd_fecha_recibido
FROM PIEZA AS PI
INNER JOIN PEDIDO AS PE ON PI.prov_id = PE.prov_id
WHERE PE.prov_id = 1;
           
-- Seleccionar los coches que han pasado una revision y estan vendidos
SELECT C.cc_matricula, C.cc_marca, C.cc_modelo, C.cc_categoria, C.cc_color, C.cc_precio
FROM COCHE AS C
INNER JOIN VENDE AS V ON C.cc_matricula = V.cc_matricula
INNER JOIN PASA_POR AS P ON P.cc_matricula = C.cc_matricula;
                       