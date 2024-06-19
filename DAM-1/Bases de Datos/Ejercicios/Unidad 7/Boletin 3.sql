USE tendaBD;

-- 1 A
DROP TRIGGER IF EXISTS detalle_vendasBI;
delimiter //
CREATE TRIGGER detalle_vendasBI BEFORE INSERT ON detalle_vendas
FOR EACH ROW
BEGIN
DECLARE vStockActual SMALLINT;
SET vStockActual = (SELECT art_stock FROM artigos WHERE art_codigo = NEW.dev_artigo);
IF NEW.dev_cantidade > vStockActual THEN
SIGNAL SQLSTATE '45000' SET message_text = 'Non hai stock suficiente';
END IF;
END;
//
delimiter ;

-- 1 B
DROP TRIGGER IF EXISTS detalle_vendasAI;
delimiter //
CREATE TRIGGER detalle_vendasAI AFTER INSERT ON detalle_vendas
FOR EACH ROW
BEGIN
UPDATE artigos
SET art_stock = art_stock - NEW.dev_cantidade
WHERE art_codigo = NEW.dev_artigo;
END;
//
delimiter ;

-- 1 C
-- creación da táboa de rexistro se non existe
CREATE TABLE IF NOT EXISTS rexistro_cambios_desconto (
usuario VARCHAR(80),
dataHora DATETIME DEFAULT now(),
valorVello TINYINT UNSIGNED,
valorNovo TINYINT UNSIGNED
) ENGINE MyISAM;
DROP TRIGGER IF EXISTS clientesAU;
delimiter //
-- creación do disparador
CREATE TRIGGER clientesAU AFTER UPDATE ON clientes
FOR EACH ROW
BEGIN
IF NEW.clt_desconto <> OLD.clt_desconto THEN
INSERT INTO rexistro_cambios_desconto (usuario, valorVello, valorNovo)
VALUES (user(), OLD.clt_desconto, NEW.clt_desconto);
END IF;
END;
//
delimiter ;

-- 1 D
DROP TRIGGER IF EXISTS empregadoBI;
delimiter //
CREATE TRIGGER empregadoBI BEFORE INSERT ON empregado
FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM departamento WHERE depNumero = NEW.empDepartamento) = 0 THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non existe o departamento';
END IF;
END;
//
delimiter ;

-- 1 E
SHOW CREATE TRIGGER tendabd.detalle_vendasBI;

-- 1 F
DROP TRIGGER tendabd.detalle_vendasBI;

-- 2
USE traballadores;
DROP TRIGGER IF EXISTS departamentoAI;
delimiter //
CREATE TRIGGER empregadoAI AFTER INSERT ON empregado
FOR EACH ROW
BEGIN
	UPDATE departamento
    SET depEmpregados = depEmpregados + 1
    WHERE depNumero = NEW.empDepartamento;
END;
CREATE TRIGGER empregadoAU AFTER DELETE empregado
FOR EACH ROW 
BEGIN
	UPDATE departamento
    SET depEmpregados = depEmpregados - 1
    WHERE depNumero = OLD.empDepartamento
END;
CREATE TRIGGER empregadoAU AFTER UPDATE empregado
FOR EACH ROW
BEGIN
	UPDATE departamento
    SET depEmpregados = depEmpregados + 1
    WHERE depNumero = NEW.empDepartamento;
    UPDATE departamento
    SET depEmprgados = depEmpregados - 1 
    WHERE depNumero = OLD.empDepartamento
END;
//
delimiter ;
-- Para comprobar ponemos un insert con varios datos, ejecutamos los triggers y despues los inserts. Por ultimo para
-- comprobar que esta todo bien hacemos un select de los departamentos para ver si cambian.

-- Ej 3
USE traballadores;
CREATE TABLE centro_aud (
	cenNumero 	INT COMMENT 'Número co que se identifica.',
	cenNome		CHAR(30)  		COMMENT 'Nome.',
	cenEnderezo CHAR(30) 		COMMENT 'Enderezo.',
    aud_dat 	TIMESTAMP DEFAULT(current_timestamp),
    aud_usr		VARCHAR(30),
    aud_ope 	ENUM('I','U','D') COMMENT 'I=INSERT, U=UPDATE, D=DELETE',
    PRIMARY KEY (cenNumero, aud_dat, aud_usr),
    INDEX idxCentroNome (cenNome)
);
delimiter //
CREATE TRIGGER centroBU BEFORE UPDATE ON centro
FOR EACH ROW
BEGIN
	INSERT INTO centro_aud (cenNumero, cenNome, cenEnderezo, aud_usr, aud_ope)
    VALUES (OLD.cenNumero, OLD.cenNome, OLD.cenEnderezo, current_user(), 'U');
END;
CREATE TRIGGER centroBD BEFORE DELETE ON centro
FOR EACH ROW
BEGIN
	INSERT INTO centro_aud (cenNumero, cenNome, cenEnderezo, aud_usr, aud_ope)
    VALUES (OLD.cenNumero, OLD.cenNome, OLD.cenEnderezo, current_user(), 'D');
END;
//
delimiter ;

UPDATE centro
SET cenNome = 'SEDE NO CENTRAL'
WHERE cenNumero = 10;

select * from centro_aud;
select * from centro;


-- ---------------- EVENTOS ---------------- --
USE traballadores;
USE tendaBD;
-- 1 A
SHOW VARIABLES LIKE 'event_scheduler';

-- 1 BA
DROP EVENT IF EXISTS actualizaPrezo;
CREATE EVENT actualizaPrezo
ON SCHEDULE AT '2022-07-01 00:00:00' + INTERVAL 2 MINUTE
DO
UPDATE artigos SET art_pv = art_pv * 0.9;

-- 1 BB
DROP EVENT IF EXISTS actualizaPrezo;
CREATE EVENT actualizaPrezo
ON SCHEDULE AT '2022-08-01 00:00:00' + INTERVAL 2 MINUTE
DO
UPDATE artigos SET art_pv = art_pv * 1.10;

-- 1 C
CREATE TABLE comprasPrevistas(
data TIMESTAMP DEFAULT current_timestamp,
artigo CHAR(8),
unidades_vendidas INTEGER NOT NULL,
stock INTEGER NOT NULL,
prevision_compra INTEGER NOT NULL,
PRIMARY KEY (data, artigo),
FOREIGN KEY (artigo) REFERENCES artigos(art_codigo)
);
-- Evento calcula compras semanalmente
delimiter //
CREATE EVENT calculaComprasSemanal
ON SCHEDULE EVERY 1 WEEK
STARTS '2022-05-14 21:41:00' -- Next sunday
DO BEGIN
INSERT INTO comprasPrevistas(artigo, unidades_vendidas, stock, prevision_compra)
SELECT art_codigo, SUM(dev_cantidade), art_stock,
(CASE
WHEN SUM(dev_cantidade) > art_stock THEN SUM(dev_cantidade) * 2
ELSE SUM(dev_cantidade)
END)
FROM artigos A
JOIN detalle_vendas D ON D.dev_artigo = A.art_codigo
JOIN vendas V ON V.ven_id = D.dev_venda
WHERE V.ven_data > DATE_ADD(curdate(), INTERVAL -1 WEEK)
GROUP BY art_codigo;
END;
//
delimiter ;

-- 1 D
ALTER EVENT actualizaPrezo
ON SCHEDULE EVERY 1 DAY
STARTS '2025-11-01 00:00:00'
ENDS '2026-12-31 00:00:00';

-- 1 E
ALTER EVENT tendaBD.actualizaPrezo
RENAME TO traballadores. rebaixaPrezo;

-- 1 F
ALTER EVENT traballadores. rebaixaPrezo
DISABLE
COMMENT 'Deshabilitado por Julia Mendez o 12/12/2015';

-- 1 G
SHOW EVENTS FROM practicas1;

-- 1 H
DROP EVENT IF EXISTS actualizaPrezo

-- 2
-- Evento que incremente el precio de compra de los articulos
delimiter //
CREATE EVENT IncrementaPrecioVentaMes2
ON SCHEDULE EVERY 2 MONTH
STARTS '2022-07-01 00:00:00'
-- ENABLE es valor por defecto por lo tanto no hace falta
DO BEGIN
UPDATE artigos SET art_pv = art_pv * 1.01;
END;
//
delimiter ;

-- 3
ALTER EVENT tendaBD.IncrementaPrecioVentaMes2
ON SCHEDULE EVERY 2 MONTH
			STARTS '2022-07-01 00:00:00'
            ENDS '2022-12-01 00:00:00';
            
-- 4
ALTER EVENT tendaBD.IncrementaPrecioVentaMes2
DISABLE;
 
-- 5
USE tendaBD;
delimiter //
CREATE EVENT Evento
ON SCHEDULE AT '2022-06-10 02:00:00'
DISABLE
DO BEGIN
UPDATE artigos 
SET art_baixa = curdate(),
	art_ultimaÇ_actualizacion = curdate()
WHERE art_baixa IS NULL AND 
art_codigo NOT IN (SELECT dev_artigo											
				   FROM detalle_vendas
                   INNER JOIN vendas ON ven_id = dev_venda
                   WHERE dev_artigo = art_codigo AND ven_data > ) ;
UPDATE clientes
SET clt_ultima_actualizacion = curdate(),
	clt_baixa = curdate()
WHERE clt_baixa IS NULL AND 
END;
//
delimiter ;
select * from artigos;

-- 6
ALTER EVENT actualizarTablas
ON SCHEDULE AT '2022-07-12 20:00:00'
ENABLE;
SHOW EVENTS;
SHOW CREATE EVENT incrementaPrezoVentaArtigos;
SHOW CREATE EVENT actualizaDatas;