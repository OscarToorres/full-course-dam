CREATE DATABASE tendaBD;
USE tendaBD;

-- CREACION DE TABOAS E INDICES
CREATE TABLE paises (
	pai_id 		SMALLINT UNSIGNED 	AUTO_INCREMENT
		COMMENT 'Identificador do país. Numeraranse de 1 en adiante de forma automática.',
	pai_isonum	SMALLINT 	COMMENT 'Número de país segundo a norma ISO 3166-1:2013.',
	pai_iso2	CHAR(2) 	COMMENT 'Código de país de 2 carácteres segundo a norma ISO 3166-1:2013.',
    pai_iso3	CHAR(3) 	COMMENT 'Código de país de 3 carácteres segundo a norma ISO 3166-1:2013.',
    pai_nome	VARCHAR(80)	COMMENT 'Nome do país.',
	CONSTRAINT paises_pk PRIMARY KEY (pai_id)
);
CREATE TABLE pesos (
	peso_id 	SMALLINT UNSIGNED 	AUTO_INCREMENT
		COMMENT 'Identificador do peso. Numeraranse de 1 en adiante de forma automática.',
	peso_nome	CHAR(8)		NOT NULL	COMMENT 'Nome que describe o tipo de peso.',
    peso_min	SMALLINT	NOT NULL 	COMMENT 'Peso mínimo para ese nome.',
    peso_max	SMALLINT	NOT NULL 	COMMENT 'Peso máximo para ese nome.',
	CONSTRAINT pesos_pk PRIMARY KEY (peso_id)
);
CREATE TABLE provedores (
	prv_id 		SMALLINT AUTO_INCREMENT		COMMENT 'Identificador do provedor. Numeraranse de 1 en adiante de forma automática.',
	prv_nome	VARCHAR(60)		NOT NULL	COMMENT 'Nome do provedor.',
	CONSTRAINT provedores_pk PRIMARY KEY (prv_id)
);
CREATE TABLE empregados (
	emp_id 			SMALLINT UNSIGNED AUTO_INCREMENT
		COMMENT 'Identificador do empregado. Numéranse de 1 en adiante de forma automática.',
    emp_dni 		CHAR(9) 					COMMENT 'DNI do empregado.',
    emp_apelidos 	VARCHAR(100) 	NOT NULL 	COMMENT 'Apelidos do empregado.',
	emp_nome		VARCHAR(50)					COMMENT 'Nome do empregado.',
	emp_enderezo	VARCHAR(100)				COMMENT 'Enderezo do empregado.',
	emp_cp			CHAR(5)						COMMENT 'Código postal do empregado.',
	emp_poboacion	VARCHAR(60)					COMMENT 'Poboación do empregado.',
	emp_pais		SMALLINT UNSIGNED			COMMENT 'Código do país segundo a táboa de países.',
	emp_alta		DATE						COMMENT 'Data na que se deu de alta o empregado.',
	CONSTRAINT empregados_pk 		PRIMARY KEY (emp_id),
    CONSTRAINT empregados_fk_pais 	FOREIGN KEY (emp_pais) REFERENCES paises (pai_id)
);
CREATE TABLE tendas (
	tda_id 			TINYINT UNSIGNED AUTO_INCREMENT
		COMMENT 'Identificador da tenda. Numéranse de 1 en adiante de forma automática.',
    tda_poboacion 	VARCHAR(60) 		COMMENT 'Poboación na que está situada a tenda.',
    tda_xerente 	SMALLINT UNSIGNED 	COMMENT 'Identificador do empregado que é  xerente da tenda.',
	CONSTRAINT tendas_pk 			PRIMARY KEY (tda_id),
    CONSTRAINT tendas_fk_xerente 	FOREIGN KEY (tda_xerente) REFERENCES empregados (emp_id)
);
CREATE TABLE clientes (
	clt_id 			SMALLINT UNSIGNED AUTO_INCREMENT
		COMMENT 'Identificador do cliente. Numeraranse de 1 en adiante de forma automática.',
    clt_cif 		CHAR(9) 		UNIQUE		COMMENT 'CIF do cliente.',
    clt_apelidos 	VARCHAR(100) 	NOT NULL 	COMMENT 'Apelidos do cliente.',
	clt_nome		VARCHAR(50)					COMMENT 'Nome do cliente.',
	clt_enderezo	VARCHAR(100)				COMMENT 'Enderezo do cliente.',
	clt_cp			CHAR(5)						COMMENT 'Código postal do cliente.',
	clt_poboacion	VARCHAR(60)					COMMENT 'Poboación do cliente.',
	clt_pais		SMALLINT UNSIGNED			COMMENT 'Código do país segundo a táboa de países.',
	clt_email		VARCHAR(120)				COMMENT 'Email do cliente',
	clt_desconto	TINYINT						COMMENT 'Porcentaxe de desconto aplicable ao cliente.',
	clt_vendas		SMALLINT UNSIGNED			COMMENT 'Número de vendas feitas ao cliente.',
	clt_ultima_venda 			DATE			COMMENT 'Data da última venda feita ao cliente.',
	clt_alta					DATE NOT NULL	COMMENT 'Data na que se deu de alta o cliente.',
	clt_ultima_actualizacion	DATE			COMMENT 'Data da última vez que se fixeron cambios nos datos do cliente.',
	clt_baixa					DATE			COMMENT 'Data na que se deu de baixa ao cliente.',
	CONSTRAINT clientes_pk PRIMARY KEY (clt_id),
    CONSTRAINT clientes_fk_paises FOREIGN KEY (clt_pais) REFERENCES paises (pai_id)
);
CREATE TABLE artigos (
	art_codigo 		CHAR(8)							COMMENT 'Identificador do artigo. Toma valores entre 1 e 200.000.',
	art_nome		VARCHAR(120)		NOT NULL	COMMENT 'Nome ou descrición do artigo.',
	art_peso		SMALLINT UNSIGNED				COMMENT 'Peso en gramos. Valor numérico enteiro.',
	art_color		CHAR(20)						COMMENT 'Cor do artigo',
	art_pc			DECIMAL(8,2)					COMMENT 'Prezo de compra do artigo.',
	art_pv			DECIMAL(8,2)		NOT NULL	COMMENT 'Prezo de venda do artigo.',
	art_provedor	SMALLINT						COMMENT 'Identificador do provedor.',
	art_stock		SMALLINT UNSIGNED				COMMENT 'Número de unidades do artigo dispoñibles no almacén.',
	art_alta		DATE				NOT NULL	COMMENT 'Data na que se deu de alta o artigo.',
	art_baixa 		DATE							COMMENT 'Data na que se deu de baixa o artigo.',
	art_ultima_actualizacion	DATE				COMMENT 'Data da última vez que se fixeron cambios nos datos do artigo.',
	CONSTRAINT artigos_pk 			PRIMARY KEY (art_codigo),
    CONSTRAINT artigos_fk_provedor 	FOREIGN KEY (art_provedor) REFERENCES provedores (prv_id)
);
CREATE TABLE vendas (
	ven_id 			INTEGER  UNSIGNED				COMMENT 'Identificador da venda.  Numeraranse de 1 en adiante de forma automática.',
	ven_tenda		TINYINT  UNSIGNED	NOT NULL	COMMENT 'Identificador da tenda na que se fixo a venda.',
	ven_empregado	SMALLINT UNSIGNED	NOT NULL	COMMENT 'Identificador do empregado que fixo a venda.',
	ven_cliente		SMALLINT UNSIGNED	NOT NULL	COMMENT 'Identificador do cliente ao que se fixo a venda.',
	ven_data		DATE				NOT NULL	COMMENT 'Data e hora na que se fixo a venda.',
	ven_factura		DATE							COMMENT 'Data da factura na que se inclúe esta venda.',
	CONSTRAINT vendas_pk 			PRIMARY KEY (ven_id),
    CONSTRAINT vendas_fk_tenda 		FOREIGN KEY (ven_tenda) 	REFERENCES tendas (tda_id),
    CONSTRAINT vendas_fk_empregado 	FOREIGN KEY (ven_empregado) REFERENCES empregados (emp_id),
    CONSTRAINT vendas_fk_cliente 	FOREIGN KEY (ven_cliente) 	REFERENCES clientes (clt_id)
);
CREATE TABLE detalle_vendas (
	dev_venda 			INTEGER  UNSIGNED				COMMENT 'Identificador da venda á que corresponde a liña de detalle.',
	dev_numero			TINYINT  UNSIGNED				COMMENT 'Número da liña de detalle dentro da venda.',
	dev_artigo			CHAR(8)				NOT NULL	COMMENT 'Identificador do artigo vendido.',
	dev_cantidade		SMALLINT UNSIGNED	NOT NULL	COMMENT 'Número de unidades vendidas.',
	dev_prezo_unitario	DECIMAL(8,2) 		NOT NULL	COMMENT 'Prezo por cada unidade vendida.',
	dev_desconto		TINYINT	 UNSIGNED	NOT NULL	COMMENT 'Porcentaxe de desconto aplicado.',
	CONSTRAINT detalle_vendas_pk 		PRIMARY KEY (dev_venda, dev_numero),
    CONSTRAINT detalle_vendas_fk_venda 	FOREIGN KEY (dev_venda)  REFERENCES vendas (ven_id),
    CONSTRAINT detalle_vendas_fk_artigo	FOREIGN KEY (dev_artigo) REFERENCES artigos (art_codigo)
);

CREATE INDEX idx_empregados_apelidos_nome 	ON empregados(emp_apelidos, emp_nome);
CREATE INDEX idx_clientes_apelidos_nome 	ON clientes(clt_apelidos, clt_nome);
CREATE INDEX idx_artigos_nome 				ON artigos(art_nome);

-- INSERCION DE DATOS

-- DATOS DE PAISES
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (2, 248, 'AX', 'ALA', 'Islas Gland');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (3, 8, 'AL', 'ALB', 'Albania');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (4, 276, 'DE', 'DEU', 'Alemania');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (5, 20, 'AD', 'AND', 'Andorra');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (6, 24, 'AO', 'AGO', 'Angola');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (7, 660, 'AI', 'AIA', 'Anguilla');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (8, 10, 'AQ', 'ATA', 'Antártida');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (9, 28, 'AG', 'ATG', 'Antigua y Barbuda');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (10, 530, 'AN', 'ANT', 'Antillas Holandesas');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (11, 682, 'SA', 'SAU', 'Arabia Saudí');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (12, 12, 'DZ', 'DZA', 'Argelia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (13, 32, 'AR', 'ARG', 'Argentina');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (14, 51, 'AM', 'ARM', 'Armenia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (15, 533, 'AW', 'ABW', 'Aruba');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (16, 36, 'AU', 'AUS', 'Australia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (17, 40, 'AT', 'AUT', 'Austria');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (18, 31, 'AZ', 'AZE', 'Azerbaiyán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (19, 44, 'BS', 'BHS', 'Bahamas');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (20, 48, 'BH', 'BHR', 'Bahréin');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (21, 50, 'BD', 'BGD', 'Bangladesh');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (22, 52, 'BB', 'BRB', 'Barbados');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (23, 112, 'BY', 'BLR', 'Bielorrusia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (24, 56, 'BE', 'BEL', 'Bélgica');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (25, 84, 'BZ', 'BLZ', 'Belice');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (26, 204, 'BJ', 'BEN', 'Benin');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (27, 60, 'BM', 'BMU', 'Bermudas');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (28, 64, 'BT', 'BTN', 'Bhután');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (29, 68, 'BO', 'BOL', 'Bolivia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (30, 70, 'BA', 'BIH', 'Bosnia y Herzegovina');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (31, 72, 'BW', 'BWA', 'Botsuana');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (32, 74, 'BV', 'BVT', 'Isla Bouvet');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (33, 76, 'BR', 'BRA', 'Brasil');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (34, 96, 'BN', 'BRN', 'Brunéi');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (35, 100, 'BG', 'BGR', 'Bulgaria');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (36, 854, 'BF', 'BFA', 'Burkina Faso');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (37, 108, 'BI', 'BDI', 'Burundi');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (38, 132, 'CV', 'CPV', 'Cabo Verde');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (39, 136, 'KY', 'CYM', 'Islas Caimán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (40, 116, 'KH', 'KHM', 'Camboya');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (41, 120, 'CM', 'CMR', 'Camerún');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (42, 124, 'CA', 'CAN', 'Canadá');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (43, 140, 'CF', 'CAF', 'República Centroafricana');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (44, 148, 'TD', 'TCD', 'Chad');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (45, 203, 'CZ', 'CZE', 'República Checa');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (46, 152, 'CL', 'CHL', 'Chile');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (47, 156, 'CN', 'CHN', 'China');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (48, 196, 'CY', 'CYP', 'Chipre');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (49, 162, 'CX', 'CXR', 'Isla de Navidad');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (50, 336, 'VA', 'VAT', 'Ciudad del Vaticano');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (51, 166, 'CC', 'CCK', 'Islas Cocos');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (52, 170, 'CO', 'COL', 'Colombia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (53, 174, 'KM', 'COM', 'Comoras');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (54, 180, 'CD', 'COD', 'República Democrática del Congo');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (55, 178, 'CG', 'COG', 'Congo');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (56, 184, 'CK', 'COK', 'Islas Cook');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (57, 408, 'KP', 'PRK', 'Corea del Norte');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (58, 410, 'KR', 'KOR', 'Corea del Sur');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (59, 384, 'CI', 'CIV', 'Costa de Marfil');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (60, 188, 'CR', 'CRI', 'Costa Rica');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (61, 191, 'HR', 'HRV', 'Croacia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (62, 192, 'CU', 'CUB', 'Cuba');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (63, 208, 'DK', 'DNK', 'Dinamarca');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (64, 212, 'DM', 'DMA', 'Dominica');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (65, 214, 'DO', 'DOM', 'República Dominicana');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (66, 218, 'EC', 'ECU', 'Ecuador');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (67, 818, 'EG', 'EGY', 'Egipto');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (68, 222, 'SV', 'SLV', 'El Salvador');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (69, 784, 'AE', 'ARE', 'Emiratos Árabes Unidos');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (70, 232, 'ER', 'ERI', 'Eritrea');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (71, 703, 'SK', 'SVK', 'Eslovaquia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (72, 705, 'SI', 'SVN', 'Eslovenia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (73, 724, 'ES', 'ESP', 'España');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (74, 581, 'UM', 'UMI', 'Islas ultramarinas de Estados Unidos');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (75, 840, 'US', 'USA', 'Estados Unidos');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (76, 233, 'EE', 'EST', 'Estonia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (77, 231, 'ET', 'ETH', 'Etiopía');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (78, 234, 'FO', 'FRO', 'Islas Feroe');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (79, 608, 'PH', 'PHL', 'Filipinas');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (80, 246, 'FI', 'FIN', 'Finlandia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (81, 242, 'FJ', 'FJI', 'Fiyi');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (82, 250, 'FR', 'FRA', 'Francia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (83, 266, 'GA', 'GAB', 'Gabón');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (84, 270, 'GM', 'GMB', 'Gambia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (85, 268, 'GE', 'GEO', 'Georgia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (86, 239, 'GS', 'SGS', 'Islas Georgias del Sur y Sandwich del Sur');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (87, 288, 'GH', 'GHA', 'Ghana');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (88, 292, 'GI', 'GIB', 'Gibraltar');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (89, 308, 'GD', 'GRD', 'Granada');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (90, 300, 'GR', 'GRC', 'Grecia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (91, 304, 'GL', 'GRL', 'Groenlandia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (92, 312, 'GP', 'GLP', 'Guadalupe');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (93, 316, 'GU', 'GUM', 'Guam');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (94, 320, 'GT', 'GTM', 'Guatemala');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (95, 254, 'GF', 'GUF', 'Guayana Francesa');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (96, 324, 'GN', 'GIN', 'Guinea');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (97, 226, 'GQ', 'GNQ', 'Guinea Ecuatorial');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (98, 624, 'GW', 'GNB', 'Guinea-Bissau');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (99, 328, 'GY', 'GUY', 'Guyana');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (100, 332, 'HT', 'HTI', 'Haití');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (101, 334, 'HM', 'HMD', 'Islas Heard y McDonald');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (102, 340, 'HN', 'HND', 'Honduras');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (103, 344, 'HK', 'HKG', 'Hong Kong');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (104, 348, 'HU', 'HUN', 'Hungría');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (105, 356, 'IN', 'IND', 'India');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (106, 360, 'ID', 'IDN', 'Indonesia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (107, 364, 'IR', 'IRN', 'Irán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (108, 368, 'IQ', 'IRQ', 'Iraq');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (109, 372, 'IE', 'IRL', 'Irlanda');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (110, 352, 'IS', 'ISL', 'Islandia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (111, 376, 'IL', 'ISR', 'Israel');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (112, 380, 'IT', 'ITA', 'Italia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (113, 388, 'JM', 'JAM', 'Jamaica');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (114, 392, 'JP', 'JPN', 'Japón');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (115, 400, 'JO', 'JOR', 'Jordania');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (116, 398, 'KZ', 'KAZ', 'Kazajstán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (117, 404, 'KE', 'KEN', 'Kenia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (118, 417, 'KG', 'KGZ', 'Kirguistán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (119, 296, 'KI', 'KIR', 'Kiribati');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (120, 414, 'KW', 'KWT', 'Kuwait');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (121, 418, 'LA', 'LAO', 'Laos');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (122, 426, 'LS', 'LSO', 'Lesotho');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (123, 428, 'LV', 'LVA', 'Letonia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (124, 422, 'LB', 'LBN', 'Líbano');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (125, 430, 'LR', 'LBR', 'Liberia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (126, 434, 'LY', 'LBY', 'Libia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (127, 438, 'LI', 'LIE', 'Liechtenstein');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (128, 440, 'LT', 'LTU', 'Lituania');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (129, 442, 'LU', 'LUX', 'Luxemburgo');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (130, 446, 'MO', 'MAC', 'Macao');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (131, 807, 'MK', 'MKD', 'ARY Macedonia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (132, 450, 'MG', 'MDG', 'Madagascar');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (133, 458, 'MY', 'MYS', 'Malasia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (134, 454, 'MW', 'MWI', 'Malawi');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (135, 462, 'MV', 'MDV', 'Maldivas');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (136, 466, 'ML', 'MLI', 'Malí');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (137, 470, 'MT', 'MLT', 'Malta');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (138, 238, 'FK', 'FLK', 'Islas Malvinas');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (139, 580, 'MP', 'MNP', 'Islas Marianas del Norte');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (140, 504, 'MA', 'MAR', 'Marruecos');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (141, 584, 'MH', 'MHL', 'Islas Marshall');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (142, 474, 'MQ', 'MTQ', 'Martinica');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (143, 480, 'MU', 'MUS', 'Mauricio');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (144, 478, 'MR', 'MRT', 'Mauritania');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (145, 175, 'YT', 'MYT', 'Mayotte');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (146, 484, 'MX', 'MEX', 'México');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (147, 583, 'FM', 'FSM', 'Micronesia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (148, 498, 'MD', 'MDA', 'Moldavia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (149, 492, 'MC', 'MCO', 'Mónaco');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (150, 496, 'MN', 'MNG', 'Mongolia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (151, 500, 'MS', 'MSR', 'Montserrat');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (152, 508, 'MZ', 'MOZ', 'Mozambique');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (153, 104, 'MM', 'MMR', 'Myanmar');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (154, 516, 'NA', 'NAM', 'Namibia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (155, 520, 'NR', 'NRU', 'Nauru');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (156, 524, 'NP', 'NPL', 'Nepal');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (157, 558, 'NI', 'NIC', 'Nicaragua');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (158, 562, 'NE', 'NER', 'Níger');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (159, 566, 'NG', 'NGA', 'Nigeria');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (160, 570, 'NU', 'NIU', 'Niue');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (161, 574, 'NF', 'NFK', 'Isla Norfolk');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (162, 578, 'NO', 'NOR', 'Noruega');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (163, 540, 'NC', 'NCL', 'Nueva Caledonia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (164, 554, 'NZ', 'NZL', 'Nueva Zelanda');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (165, 512, 'OM', 'OMN', 'Omán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (166, 528, 'NL', 'NLD', 'Países Bajos');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (167, 586, 'PK', 'PAK', 'Pakistán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (168, 585, 'PW', 'PLW', 'Palau');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (169, 275, 'PS', 'PSE', 'Palestina');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (170, 591, 'PA', 'PAN', 'Panamá');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (171, 598, 'PG', 'PNG', 'Papúa Nueva Guinea');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (172, 600, 'PY', 'PRY', 'Paraguay');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (173, 604, 'PE', 'PER', 'Perú');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (174, 612, 'PN', 'PCN', 'Islas Pitcairn');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (175, 258, 'PF', 'PYF', 'Polinesia Francesa');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (176, 616, 'PL', 'POL', 'Polonia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (177, 620, 'PT', 'PRT', 'Portugal');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (178, 630, 'PR', 'PRI', 'Puerto Rico');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (179, 634, 'QA', 'QAT', 'Qatar');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (180, 826, 'GB', 'GBR', 'Reino Unido');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (181, 638, 'RE', 'REU', 'Reunión');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (182, 646, 'RW', 'RWA', 'Ruanda');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (183, 642, 'RO', 'ROU', 'Rumania');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (184, 643, 'RU', 'RUS', 'Rusia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (185, 732, 'EH', 'ESH', 'Sahara Occidental');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (186, 90, 'SB', 'SLB', 'Islas Salomón');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (187, 882, 'WS', 'WSM', 'Samoa');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (188, 16, 'AS', 'ASM', 'Samoa Americana');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (189, 659, 'KN', 'KNA', 'San Cristóbal y Nevis');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (190, 674, 'SM', 'SMR', 'San Marino');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (191, 666, 'PM', 'SPM', 'San Pedro y Miquelón');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (192, 670, 'VC', 'VCT', 'San Vicente y las Granadinas');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (193, 654, 'SH', 'SHN', 'Santa Helena');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (194, 662, 'LC', 'LCA', 'Santa Lucía');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (195, 678, 'ST', 'STP', 'Santo Tomé y Príncipe');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (196, 686, 'SN', 'SEN', 'Senegal');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (197, 891, 'CS', 'SCG', 'Serbia y Montenegro');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (198, 690, 'SC', 'SYC', 'Seychelles');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (199, 694, 'SL', 'SLE', 'Sierra Leona');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (200, 702, 'SG', 'SGP', 'Singapur');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (201, 760, 'SY', 'SYR', 'Siria');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (202, 706, 'SO', 'SOM', 'Somalia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (203, 144, 'LK', 'LKA', 'Sri Lanka');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (204, 748, 'SZ', 'SWZ', 'Suazilandia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (205, 710, 'ZA', 'ZAF', 'Sudáfrica');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (206, 736, 'SD', 'SDN', 'Sudán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (207, 752, 'SE', 'SWE', 'Suecia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (208, 756, 'CH', 'CHE', 'Suiza');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (209, 740, 'SR', 'SUR', 'Surinam');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (210, 744, 'SJ', 'SJM', 'Svalbard y Jan Mayen');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (211, 764, 'TH', 'THA', 'Tailandia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (212, 158, 'TW', 'TWN', 'Taiwán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (213, 834, 'TZ', 'TZA', 'Tanzania');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (214, 762, 'TJ', 'TJK', 'Tayikistán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (215, 86, 'IO', 'IOT', 'Territorio Británico del Océano Índico');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (216, 260, 'TF', 'ATF', 'Territorios Australes Franceses');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (217, 626, 'TL', 'TLS', 'Timor Oriental');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (218, 768, 'TG', 'TGO', 'Togo');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (219, 772, 'TK', 'TKL', 'Tokelau');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (220, 776, 'TO', 'TON', 'Tonga');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (221, 780, 'TT', 'TTO', 'Trinidad y Tobago');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (222, 788, 'TN', 'TUN', 'Túnez');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (223, 796, 'TC', 'TCA', 'Islas Turcas y Caicos');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (224, 795, 'TM', 'TKM', 'Turkmenistán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (225, 792, 'TR', 'TUR', 'Turquía');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (226, 798, 'TV', 'TUV', 'Tuvalu');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (227, 804, 'UA', 'UKR', 'Ucrania');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (228, 800, 'UG', 'UGA', 'Uganda');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (229, 858, 'UY', 'URY', 'Uruguay');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (230, 860, 'UZ', 'UZB', 'Uzbekistán');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (231, 548, 'VU', 'VUT', 'Vanuatu');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (232, 862, 'VE', 'VEN', 'Venezuela');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (233, 704, 'VN', 'VNM', 'Vietnam');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (234, 92, 'VG', 'VGB', 'Islas Vírgenes Británicas');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (235, 850, 'VI', 'VIR', 'Islas Vírgenes de los Estados Unidos');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (236, 876, 'WF', 'WLF', 'Wallis y Futuna');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (237, 887, 'YE', 'YEM', 'Yemen');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (238, 262, 'DJ', 'DJI', 'Yibuti');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (239, 894, 'ZM', 'ZMB', 'Zambia');
INSERT INTO paises (pai_id, pai_isonum, pai_iso2, pai_iso3, pai_nome) VALUES (240, 716, 'ZW', 'ZWE', 'Zimbabue');

-- DATOS DE PESOS
INSERT INTO pesos(peso_nome, peso_min, peso_max) VALUES ('minimo',0,199);
INSERT INTO pesos(peso_nome, peso_min, peso_max) VALUES ('baixo',200,1999);
INSERT INTO pesos(peso_nome, peso_min, peso_max) VALUES ('medio',2000,4999);
INSERT INTO pesos(peso_nome, peso_min, peso_max) VALUES ('alto',5000,9999);
INSERT INTO pesos(peso_nome, peso_min, peso_max) VALUES ('maximo',10000,19999);

-- DATOS DE PROVEDORES
INSERT INTO provedores(prv_nome) VALUES ('Plasticos Lopez');
INSERT INTO provedores(prv_nome) VALUES ('MUPEGA');
INSERT INTO provedores(prv_nome) VALUES ('UDF');
INSERT INTO provedores(prv_nome) VALUES ('Fundacion Terra');
INSERT INTO provedores(prv_nome) VALUES ('Gasnam');
INSERT INTO provedores(prv_nome) VALUES ('Telepizza');
INSERT INTO provedores(prv_nome) VALUES ('Caamaño Sistemas Metálicos');
INSERT INTO provedores(prv_nome) VALUES ('Placas Norte');
INSERT INTO provedores(prv_nome) VALUES ('Metales y Muebles Especiales');
INSERT INTO provedores(prv_nome) VALUES ('Metalvedro');
INSERT INTO provedores(prv_nome) VALUES ('Tabigal');
INSERT INTO provedores(prv_nome) VALUES ('Decorga Pintura');
INSERT INTO provedores(prv_nome) VALUES ('Malasa');
INSERT INTO provedores(prv_nome) VALUES ('Neograf Alvedro');
INSERT INTO provedores(prv_nome) VALUES ('Carpintería Ramón García');
INSERT INTO provedores(prv_nome) VALUES ('Hydracorte');
INSERT INTO provedores(prv_nome) VALUES ('Liñagar');
INSERT INTO provedores(prv_nome) VALUES ('Arce Clima Sistemas y Aplicaciones');
INSERT INTO provedores(prv_nome) VALUES ('Nordes Ancin');
INSERT INTO provedores(prv_nome) VALUES ('Martínez Otero Contract');
INSERT INTO provedores(prv_nome) VALUES ('Incoga Norte');
INSERT INTO provedores(prv_nome) VALUES ('Grupo Cándido Hermida');

-- DATOS DE EMPREGADOS
INSERT INTO empregados (emp_dni, emp_apelidos, emp_nome, emp_enderezo, emp_cp, emp_poboacion, emp_pais, emp_alta)
VALUES ('73324262D', 'GONZALEZ CAMPO', 'PLATON', 'Rúa Rosalía, 21 2ºA', '15220', 'RIBEIRA', 73, '1980-04-10');
INSERT INTO empregados (emp_dni, emp_apelidos, emp_nome, emp_enderezo, emp_cp, emp_poboacion, emp_pais, emp_alta)
VALUES ('14690202X', 'PEREZ GARCIA', 'JUAN', 'Pz. da Herba, 2', '15220', 'RIBEIRA', 73, '1998-06-16');
INSERT INTO empregados (emp_dni, emp_apelidos, emp_nome, emp_enderezo, emp_cp, emp_poboacion, emp_pais, emp_alta)
VALUES ('99397745W', 'PEREZ GARCIA', 'ALBA', 'Rúa Nova, 8 1ºB', '15220', 'RIBEIRA', 73, '2018-04-10');
INSERT INTO empregados (emp_dni, emp_apelidos, emp_nome, emp_enderezo, emp_cp, emp_poboacion, emp_pais, emp_alta)
VALUES ('00988812L', 'PEREZ GARCIA', 'HUGO', 'Lugar do Peso, 3', '15222', 'A POBRA', 73, '2021-10-08');
INSERT INTO empregados (emp_dni, emp_apelidos, emp_nome, emp_enderezo, emp_cp, emp_poboacion, emp_pais, emp_alta)
VALUES ('87009119G', 'VAZQUEZ CAMPO', 'ANTONIO', 'Fonte Nova, 27 2º', '15896', 'MUROS', 73, '2021-05-17');
INSERT INTO empregados (emp_dni, emp_apelidos, emp_nome, emp_enderezo, emp_cp, emp_poboacion, emp_pais, emp_alta)
VALUES ('76960385Q', 'VALIENTE VALIENTE', 'ELISA', 'Casas do monte, 2', '15896', 'MUROS', 73, '2004-09-01');
INSERT INTO empregados (emp_dni, emp_apelidos, emp_nome, emp_enderezo, emp_cp, emp_poboacion, emp_pais, emp_alta)
VALUES ('X2577955T', 'PATIÑO CASTIÑEIRA', 'VALDEMAR', 'Rúa Rosalía, 4 1º', '15220', 'RIBEIRA', 73, '2004-09-03');
INSERT INTO empregados (emp_dni, emp_apelidos, emp_nome, emp_enderezo, emp_cp, emp_poboacion, emp_pais, emp_alta)
VALUES ('X6698322D', 'AVATAR AYUSO', 'MARTIN', 'Rúa Valle-Inclán, 16 4º Esq', '15870', 'LALÍN', 73, '2006-04-18');

-- DATOS DE TENDAS
INSERT INTO tendas(tda_poboacion, tda_xerente) VALUES ('RIBEIRA', 2);
INSERT INTO tendas(tda_poboacion, tda_xerente) VALUES ('LALIN', 3);
INSERT INTO tendas(tda_poboacion, tda_xerente) VALUES ('BERTAMIRÁNS', 4);
INSERT INTO tendas(tda_poboacion, tda_xerente) VALUES ('PADRÓN', 6);

-- DATOS DE CLIENTES
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('S0794867B', 'Lopez Marcos', 'Marcos', 'San Martin 222', '15220', 'RIBEIRA', 73, 'marcoslopez23@gmail.com',
        12, 1, '2018-12-26', '2018-11-02', '2021-12-26', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('G19819226', 'Rodríguez  García ', 'ARA', 'Colon 111', '15222', 'ARZÚA', 73, NULL,
        0, 2, '2016-04-16', '2003-03-06', '2021-02-12', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('S0795867B', 'Ramos González', 'LISA', 'Rúa Leonardo da Vinci, 7', '15345', 'PADRÓN', 73, 'lisa.ramos@gmail.com',
        8, 10, '2012-05-26', '2009-01-21', '2018-07-12', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('N4957698F', 'Iglesias  Garrido', 'PEDRO', 'Rúa Velázquez, 80, 3ºE', NULL, 'VIANA DO CASTELO', 177, 'pedrogarrido@gmail.com',
        2, 3, '2013-05-12', '2000-02-22', '2013-07-14', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('B86910650', 'Lopez Ramos', 'HELENA', 'AV. 5 DE MAYO NO. 1108', NULL, 'O PORTO', 177, 'drLopez@educosa.pt',
        NULL, 21, '1990-06-26', '1990-03-23', '2003-08-16', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('N1350140H', 'González Rodríguez', 'XULIA', 'RÚA ALDAMA NO 156', '15220', 'RIBEIRA', 73, 'xGonzalez@afactoria.gal',
        NULL, 41, '1990-08-07', '1981-04-24', '2021-09-18', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('B07633001', 'Iglesias Castro', 'XOEL', 'AV. INDEPENDENCIA NO 145, 4ºb', '15222', 'BERTAMIRÁNS', 73, NULL,
        NULL, 12, '1997-08-08', '1981-05-25', '2017-10-20', '2017-12-26');
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('S5222498G', 'Lopez Castro', 'JOSÉ MANUEL', 'RÚA AGUSTIN LARA NO. 69-B', '15370', 'PADRÓN', 73, 'pachuli23@erapera.com',
        2, 6, '1993-09-26', '1991-06-26', '2012-11-22', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('D48465058', 'Delgado Marcos', 'ANTONIO', 'RÚA MORELOS NO. 72-B', NULL, 'PARÍS', 82, 'delgadomarcos@hotmail.com',
        10, 234, '1984-10-16', '1980-07-27', '1999-12-24', '1999-12-26');
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('B13829940', 'Blanco Blanco', 'Anxo', 'Praza da Ponte, 11', '15220', 'RIBEIRA', 73, 'anxobb@gmail.com',
        5, 41, '1983-11-11', '1976-08-28', '1990-02-04', '1990-12-26');
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('B67657189', 'Delgado Marcos', 'María Carmen', 'Avenida dos Xurelos Verdes, 11', '36220', 'PONTEVEDRA', 73, 'mc_compras@ediplas.com',
        0, 1, '2021-12-12', '2020-09-29', '2021-03-06', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('B67656189', 'Lopez Silva', 'Xabier', 'Matacans, 11', '11234', 'MADRID', 73, 'mc_compras@ediplas.com',
        5, 7, '2021-12-12', '2020-09-29', '2021-03-06', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('H22222222', 'Perez Perol', 'Olegario', 'Gran Vía, 8, 12ªB', '11235', 'MADRID', 73, 'olegarioperezp@gmail.com',
        10, 11, '2021-12-12', '2020-09-29', '2021-03-06', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('66666666Q', 'Atapuerca Sideral', 'Pilar', 'Gran Vía, 8, 12ªB', '11235', 'ASTURIAS', 73, 'pilichuli@gmail.com',
        10, 11, '2021-07-22', '2020-09-29', '2021-07-22', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('12365384H', 'Torres Do Campo', 'Antón Xosé', 'Gran Vía, 18, 2ªB', '58235', 'VALENCIA', 73, 'axtorres@gmail.com',
        NULL, 2, '2018-06-06', '2018-06-06', '2018-06-06', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('25673891V', 'Muñiz Veiga', 'Ana', 'Ronda de los faros, 23', '11236', 'VALENCIA', 73, 'ana.muniz@gmail.com',
        0, 32, '2012-05-03', '2008-09-29', '2021-03-06', NULL);
INSERT INTO clientes (clt_cif, clt_apelidos, clt_nome, clt_enderezo, clt_cp, clt_poboacion, clt_pais, clt_email, 
						clt_desconto, clt_vendas, clt_ultima_venda, clt_alta, clt_ultima_actualizacion, clt_baixa)
VALUES ('25673981V', 'Souto Castiñeiras', 'Miguel', 'Concordia, 25, 3ºB', '11235', 'VALENCIA', 73, 'compras@ceramicasantos.es',
        3, 101, '2016-09-12', '1998-03-25', '2016-09-12', NULL);

-- DATOS DE ARTIGOS
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0000','Chapa metal', 120, 'branco', 0.2, 0.5, 1, 100, '1990-09-01', '2010-09-01', '2010-09-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0001','Chapa metal verde', 120, 'verde', 0.2, 0.5, 1, 210, '1990-09-01', '2010-09-01', '2010-09-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0002','Chapa metal cyan', 120, 'cyan', 0.2, 0.5, 1, 213, '1990-09-01', '2010-09-01', '2010-09-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0003','Chapa metal negra', 120, 'negro', 0.2, 0.5, 1, 68, '1990-09-01', '2010-09-01', '2010-09-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0010','Taladro', 2500, NULL, 150.0, 200.0, 2, 8, '2020-10-01', NULL, '2022-09-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0011','Carter', 8200, NULL, 250.0, 350.0, 2, 3, '2020-10-01', NULL, '2022-09-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0012','Pulidora', 1200, NULL, 14.5, 16.5, 2, 6, '2020-10-01', NULL, '2021-06-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0013','Pulidora plus', 1250, NULL, 17.2, 20.4, 2, 13, '2021-06-01', NULL, '2021-06-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0020','Minitractor Arter', 5230, 'branco', 3500, 3700, 3, 2, '2008-09-01', '2010-09-01', '2010-09-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0021','Minitractor Lomax', 5020, 'cyan', 3600, 3850, 3, 0, '2010-09-01', NULL, '2018-09-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0022','Minitractor Silver', 5120, 'negro', 3650, 4600, 3, 12, '2010-09-01', NULL, '2020-06-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0125','Pa', 600, 'negro', 6, 8, 4, 12, '2012-11-23', NULL, '2020-06-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0126','Sacho', 600, 'negro', 6.5, 9, 4, 10, '2012-11-23', NULL, '2020-06-01');
INSERT INTO artigos(art_codigo, art_nome, art_peso, art_color, art_pc, art_pv, art_provedor, art_stock, art_alta, art_baixa, art_ultima_actualizacion)
VALUES ('aaaa0127','Rastrelo', 650, 'negro', 13, 15, 4, 8, '2012-11-23', NULL, '2020-06-01');

-- DATOS DE VENDAS E DETALLE VENDAS
INSERT INTO vendas (ven_id, ven_tenda, ven_empregado, ven_cliente, ven_data, ven_factura) VALUES (1,1,1,1,'2000-01-01','2000-01-01');
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(1, 1, 'aaaa0000', 10, 0.4, 0);
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(1, 2, 'aaaa0003', 3, 0.4, 0);
INSERT INTO vendas (ven_id, ven_tenda, ven_empregado, ven_cliente, ven_data, ven_factura) VALUES (2,1,1,2,'2008-12-12','2008-12-12');
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(2, 1, 'aaaa0010', 1, 200, 0);
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(2, 2, 'aaaa0011', 2, 340, 2);
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(2, 3, 'aaaa0125', 1, 8, 0);
INSERT INTO vendas (ven_id, ven_tenda, ven_empregado, ven_cliente, ven_data, ven_factura) VALUES (3,1,1,8,'2010-07-14','2010-07-16');
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(3, 1, 'aaaa0021', 1, 4600, 2);
INSERT INTO vendas (ven_id, ven_tenda, ven_empregado, ven_cliente, ven_data, ven_factura) VALUES (4,2,2,4,'2012-03-09','2012-03-12');
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(4, 1, 'aaaa0012', 30, 16.5, 4);
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(4, 2, 'aaaa0020', 2, 3700, 0);
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(4, 3, 'aaaa0125', 50, 8, 0);
INSERT INTO vendas (ven_id, ven_tenda, ven_empregado, ven_cliente, ven_data, ven_factura) VALUES (5,3,4,4,'2012-03-09','2012-03-10');
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(5, 1, 'aaaa0012', 18, 16.2, 0);
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(5, 2, 'aaaa0020', 1, 3700, 0);
INSERT INTO vendas (ven_id, ven_tenda, ven_empregado, ven_cliente, ven_data, ven_factura) VALUES (6,3,4,5,'2012-06-06','2012-06-06');
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(6, 1, 'aaaa0125', 2, 7.8, 0);
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(6, 2, 'aaaa0126', 2, 8.8, 0);
INSERT INTO detalle_vendas (dev_venda, dev_numero, dev_artigo, dev_cantidade, dev_prezo_unitario, dev_desconto) VALUES(6, 3, 'aaaa0127', 1, 14.8, 0);

SELECT tda_id, tda_poboacion, tda_xerente
FROM tendas;

SELECT prv_id, prv_nome
FROM provedores;

SELECT DISTINCT clt_poboacion
FROM clientes;

SELECT art_pv, art_pv * 10 / 100 + art_pv as precio_incrementado
FROM artigos;

SELECT cl_ip, clt_apelidos, clt_nome
FROM clientes
WHERE clt_poboacion LIKE 'MADRID';

SELECT art_codigo, art_nome, art_peso
FROM artigos
WHERE art_peso > 500;

SELECT art_codigo, art_nome, art_pv, art_pc
FROM artigos
WHERE art_pv >= art_pc * 2;

SELECT clt_nome, clt_apelidos, clt_poboacion, clt_desconto
FROM clientes
WHERE clt_desconto >= 2 OR clt_desconto = 0 OR clt_Desconto IS NULL
AND (clt_poboacion LIKE 'ASTURIAS' OR clt_poboacion LIKE 'VALENCIA');

SELECT *
FROM artigos
WHERE art_color LIKE 'negro' AND art_peso > 5000;

SELECT *
FROM artigos
WHERE art_color NOT LIKE 'negro' AND art_peso <= 5000; 

SELECT *
FROM artigos
WHERE art_color LIKE 'negro' AND art_peso > 100 OR art_color LIKE 'cyan';

SELECT *
FROM artigos
WHERE art_pc >= 12 AND art_pc <= 18;
 
SELECT *
FROM artigos 
WHERE art_color LIKE 'negro' OR art_color LIKE 'cyan'; 

SELECT *
FROM clientes
WHERE clt_apelidos LIKE 'RO%';

SELECT *
FROM clientes
WHERE clt_nome LIKE 'B___A';

SELECT *
FROM artigos
WHERE art_color IS NULL;

SELECT *
FROM artigos
ORDER BY art_peso DESC;

SELECT art_codigo, art_nome, art_pc, art_pv, art_pv - art_pc AS marxe_beneficio
FROM artigos
WHERE art_pc > 3000
ORDER BY marxe_beneficio DESC;

SELECT art_nome, art_provedor, art_stock, art_peso
FROM artigos
WHERE art_peso <= 1000
ORDER BY art_provedor ASC, art_stock DESC;

SELECT clt_nome, clt_apelidos
FROM clientes
WHERE clt_apelidos LIKE 'F%Z';

SELECT *
FROM artigos
WHERE art_nome LIKE BINARY '%LED%';

SELECT *
FROM artigos
WHERE art_nome LIKE 'CABI%';

SELECT 23 REGEXP '^[+-]?[0-9]+';

SELECT clt_nome, clt_apelidos
FROM clientes
WHERE clt_apelidos LIKE 'a%' OR 'f%';

SELECT *
FROM clientes
WHERE clt_apelidos NOT LIKE 'a%' 
AND clt_apelidos NOT LIKE 'B%' 
AND clt_apelidos NOT LIKE 'C%' 
AND clt_apelidos NOT LIKE 'D%';

SELECT *
FROM atigos
WHERE atr_pv LIKE '%.00';

SELECT *
FROM clientes
WHERE clt_nome LIKE '_____';