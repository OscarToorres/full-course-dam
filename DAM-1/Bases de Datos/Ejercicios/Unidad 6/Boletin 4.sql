USE traballadores;

-- 1
UPDATE empregado
SET empFillos = empFillos + 1
WHERE empNome LIKE 'DOROTEA';

-- 2
UPDATE centro
SET cenNome = 'ATENCIÓN AOS CLIENTES'
WHERE cenNumero = 20;

-- 3
UPDATE centro
SET cenEnderezo = 'RÚA NOVA, 25 RIBEIRA'
WHERE cenNome LIKE 'SEDE CENTRAL';

-- 4
UPDATE departamento
SET depPresuposto = depPresuposto * 100;

-- 5
UPDATE empregado
SET empExtension = 480
WHERE empDepartamento = 130; 

-- 6
UPDATE empregado
SET empComision = empComision + 10
WHERE empDepartamento = 111 AND empDataIngreso < '1990-01-01';

-- 7
UPDATE empregado
SET empSalario = 1050
WHERE empSalario < 1000 
AND empDepartamento = (SELECT depNumero
					   FROM departamento
                       WHERE depNome LIKE 'SECTOR INDUSTRIAL');

-- 8
UPDATE empregado
SET empSalario = empSalario + 200
WHERE empSalario < 1500 
AND empDepartamento = (SELECT depNumero
					   FROM departamento
                       WHERE depNome LIKE 'DIRECCIÓN GENERAL');
                       
-- 9
SET @media = (SELECT AVG(empSalario) FROM empregado);
SELECT @media1:= AVG(empSalario) FROM empregado;
UPDATE empregado
SET empComision = empComision * 1.1
WHERE empDepartamento = ( SELECT depNumero
						  FROM departamento
                          WHERE depNome LIKE 'SECTOR INDUSTRIAL')
AND empSalario < @media;

-- 10 
UPDATE empregado E1
SET empComision = empComision * 1.1
WHERE empDepartamento IN ( SELECT depNumero
						  FROM departamento
                          WHERE depNome LIKE 'PERSONAL'
                          OR depNome LIKE 'PROCESO DE DATOS'
                          OR depNome LIKE 'FINANZAS')
AND empSalario < (SELECT * FROM (
				  SELECT AVG(E2.empSalario)
                  FROM empregado E2
                  WHERE E2.empDepartamento = E1.empDepartamento
                  ) T);

-- 11
INSERT INTO centro (cenNumero, cenNome, cenEnderezo)
VALUES (80, 'NOVO CENTRO', 'RÚA NOVA, 25 RIBEIRA');
UPDATE departamento
SET depCentro = 80,
	depTipoDirector = 'F',
    depDirector = (SELECT empNumero FROM empregado WHERE empNome LIKE 'JULIO')
WHERE (depNome LIKE 'SECTOR SERVICIOS') OR (depNome LIKE 'SECTOR INDUSTRIAL'); 

-- 12
UPDATE empregado
SET empDepartamento = 110
WHERE empDepartamento = 130 AND TIMESTAMPDIFF(YEAR, curdate(), empDataNacemento) < 50;

-- 13
UPDATE empregado
SET empDepartamento = (SELECT depNumero FROM departamento WHERE depNome LIKE 'DIRECCION GENERAL')
WHERE empSalario > 2500;

-- 14
UPDATE departamento
SET depEmpregados = (SELECT COUNT(*)
					 FROM empregado
                     WHERE empDepartamento = depNumero);
                     
-- 15
UPDATE departamento
SET depTipoDirector = 'P',
	depDirector = (SELECT empNumero
				   FROM empregado e1
				   WHERE empdataIngreso = (SELECT MIN(empDataIngreso)
										   FROM empregado e2
										   WHERE e2.empDepartamento = e1.empDepartamento));
                                           
-- 16
UPDATE empregado E
SET empSalario = empSalario - 200,
	empComision = NULL
WHERE empSalario > (SELECT * FROM 
					(SELECT ED.empSalario
					FROM empregado ED
                    JOIN departamento D ON ED.empNumero = D.depDirector
                    WHERE D.depNumero = E.empNumero) T);




SELECT * FROM centro;
SELECT * FROM departamento;
select * from empregado; -- INNER JOIN departamento ON depNumero = empDepartamento WHERE depNome LIKE 'PERSONAL';