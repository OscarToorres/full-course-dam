USE tendaBD;
SET AUTOCOMMIT=0;
SET AUTOCOMMIT=1;

INSERT clientes (clt_cif, clt_apelidos,clt_nome, clt_enderezo,
clt_cp,clt_poboacion,clt_pais,clt_email,clt_desconto,clt_vendas,
clt_ultima_venda,clt_alta,clt_ultima_actualizacion,clt_baixa)
VALUE ('10277865Q','Bautista Palacios','Benito','Rúa da Ponte Vella, 38',
 09002, 'BURGOS', 73, 'bbpalacios@gmail.com', 0, 0, NULL, curdate(),
 curdate(),NULL);
 
INSERT clientes (clt_cif, clt_apelidos,clt_nome, clt_enderezo,
clt_cp,clt_poboacion,clt_pais,clt_email,clt_desconto,clt_vendas,
clt_ultima_venda,clt_alta,clt_ultima_actualizacion,clt_baixa)
VALUE ('42975099J','Ayuso', 'Eliseo', 'Praza da Concordia, 12', 36201, 
'PONTEVEDRA', 73, 'eliseoAyuso@gmail.com', 0, 0, NULL, curdate(),
curdate(), NULL);

INSERT clientes (clt_cif, clt_apelidos,clt_nome, clt_enderezo,
clt_cp,clt_poboacion,clt_pais,clt_email,clt_desconto,clt_vendas,
clt_ultima_venda,clt_alta,clt_ultima_actualizacion,clt_baixa)
VALUE();

-- TRANSACCIONES
-- 1
START TRANSACTION; 
	INSERT vendas (ven_id, ven_tenda, ven_empregado, ven_cliente, ven_data, ven_factura)
    VALUE (10, 4, 6, 12, curdate(), curdate());
    INSERT detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto)
    VALUE (10, 1, 'aaaa0002', 1, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0002'), 0),
		  (10, 2, 'aaaa0012', 3, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0012'), 0),
          (10, 3, 'aaaa0022', 1, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0022'), 0);
    SELECT dev_artigo, dev_cantidade
    FROM detalle_vendas
    INNER JOIN vendas ON dev_venda = ven_id
    WHERE ven_cliente = 12;
COMMIT;

SELECT dev_artigo, dev_cantidade, clt_id
FROM detalle_vendas
INNER JOIN vendas ON dev_venda = ven_id
INNER JOIN clientes ON ven_cliente = clt_id
WHERE ven_cliente = 12;

 INSERT detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto)
    VALUE (10, 4, 'aaaa0003', 2, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0003'), 0),
		  (10, 5, 'aaaa0013', 1, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0013'), 0);


delete from detalle_vendas where dev_venda = 10;
delete from vendas where ven_id = 10;

SAVEPOINT bacup;
	INSERT vendas (ven_id, ven_tenda, ven_empregado, ven_cliente, ven_data, ven_factura)
	VALUE (11, 3, 5, 12, curdate(), curdate());
	INSERT detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto)
	VALUE (11, 1, aaaa0002, 2, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0002'), 0),
		  (11, 2, aaaa0012, 1, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0012'), 0),
          (11, 3, aaaa0022, 2, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0022'), 0);

	SELECT dev_artigo, dev_cantidade
    FROM detalle_vendas
    JOIN vendas ON dev_venda = ven_id
    JOIN clientes ON ven_cliente = clt_id
    WHERE clt_id = 12;
ROLLBACK;


START TRANSACTION;
	INSERT INTO empregado
    VALUES
    UPDATE tenda
    SET xerente = (SELECT MAX(numEmpregado))
    

START TRANSACTION;
	INSERT INTO venda (ven_id, ven_tenda, ven_empregado, ven_cliente, ven_data, ven_factura)
    VALUES ();
    INSERT INTO detalle_vendas ()
	VALUES ((SELECT MAX(numVenda) FROM vendas), 1, 'aaaa0001', 2, 
		   (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0001' )),
		   ((SELECT MAX(numVenda) FROM vendas), 2, 'aaaa0003', 25, 
           (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0003' ));
	UPDATE artigo
    SET stock = stock - 2
    WHERE art_codigo LIKE 'aaaa0001';
    UPDATE artigo
    SET stock = stock - 25
    WHERE art_codigo LIKE 'aaaa0003';
ROLLBACK;

START TRANSACTION;
	INSERT vendas (ven_id, ven_tenda, ven_empregado, ven_cliente, ven_data, ven_factura)
	VALUES (7, 3, 5, 12, curdate(), curdate());
	INSERT detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto)
	VALUES (7, 1, 'aaaa0013', 4, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0013'), 0),
		   (7, 2, 'aaaa0010', 6, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0010'), 0),
		   (7, 3, 'aaaa0020', 2, (SELECT art_pv FROM artigos WHERE art_codigo LIKE 'aaaa0020'), 0);
	UPDATE artigos 
    SET art_stock = art_stock - 4
    WHERE art_codigo LIKE 'aaaa0013';
	UPDATE artigos 
    SET art_stock = art_stock - 6
    WHERE art_codigo LIKE 'aaaa0010';
	UPDATE artigos 
    SET art_stock = art_stock - 2
    WHERE art_codigo LIKE 'aaaa0020';
ROLLBACK;

START TRANSACTION;
	



select * from artigos;
select * from vendas;
select * from clientes;
select * from detalle_vendas;




DROP DATABASE IF EXISTS test;
CREATE DATABASE test CHARACTER SET utf8mb4;
USE test;

CREATE TABLE producto (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  precio DOUBLE
);

INSERT INTO producto (id, nombre) VALUES (1, 'Primero');
INSERT INTO producto (id, nombre) VALUES (2, 'Segundo');
INSERT INTO producto (id, nombre) VALUES (3, 'Tercero');

-- 1. Comprobamos las filas que existen en la tabla
SELECT *
FROM producto;

-- 2. Ejecutamos una transacción que incluye un SAVEPOINT
START TRANSACTION;
INSERT INTO producto (id, nombre) VALUES (4, 'Cuarto');
SAVEPOINT sp1;
INSERT INTO producto (id, nombre) VALUES (5, 'Cinco');
INSERT INTO producto (id, nombre) VALUES (6, 'Seis');
ROLLBACK TO sp1;

-- 3. ¿Qué devolverá esta consulta?
SELECT * 
FROM producto;




    