USE traballadores;

 -- 1
INSERT INTO centro(cenNumero, cenNome, cenEnderezo)
VALUE (50, 'REPOSTOS', 'R/ MUROS 25, RIBEIRA');

-- 2
INSERT INTO centro(cenNumero, cenNome, cenEnderezo)
VALUE(60, 'RECURSOS HUMANS', 'R/ PRIMAVERA 10, RIBEIRA'),
	 (70, 'SISTEMAS', null),
     (80, 'DESENVOLVEMENTO', 'R/ INVERNO 30, RIBEIRA');

-- 3
INSERT INTO centro(cenNumero, cenNome)
VALUE (100, 'COMPRAS'), (110, 'SISTEMAS');

-- 4
 INSERT INTO centro
 SET cenNumero = 120,
	 cenNome = 'REPARACIÓNS',
     cenEnderezo = 'PRAZA DA CONCORDIA 5, RIBEIRA';

-- 5
INSERT INTO centro (cenNumero, cenNome, cenEnderezo)
SELECT cenNumero + 50, cenNome, cenEnderezo FROM centro WHERE cenNumero > 100;

-- 6
INSERT INTO centro (cenNumero, cenNome, cenEnderezo)
SELECT DISTINCT cenNumero + 1, concat(cenNome, '-2'), 'R/ ROSALÍA,25,RIBEIRA' 
FROM centro 
INNER JOIN departamento ON cenNumero = depCentro
WHERE cenNumero;
