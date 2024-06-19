use traballadores;

-- 1
DELETE FROM centro
WHERE cenNumero = 50;

-- 2
DELETE FROM centro
WHERE cenNome LIKE 'REPARACIONS';

-- 3 
DELETE FROM centro
WHERE cenEnderezo IS NULL;

-- 4
DELETE FROM empregado
WHERE empDepartamento = 120;

-- 5 
DELETE FROM empregado
WHERE empDepartamento = (SELECT depNumero
						 FROM departamento
                         WHERE depNome LIKE 'FINANZAS');
                         
-- 6
DELETE FROM empregado
WHERE wmpDataNacemento < date_sub(curdate(),INTERVAL 60 YEAR);

-- 7
DELETE FROM empregado E
WHERE (empSalario * 14 + empComision) > (SELECT * FROM 
										 (SELECT empSalario
										 FROM empregado
                                         INNER JOIN departamento D ON depDirector = empNumero
                                         WHERE D.depNumero = E.empDepartamento) T);
                                         
-- 8
DELETE FROM empregado
WHERE empFillos > 0 AND empDepartamento IN (SELECT depNumero
											FROM departamento 
                                            WHERE depNime LIKE 'DIRECCION COMERCIAL'
                                            OR depNome LIKE 'SECTOR INDUSTRIAL');
									
-- 9
DELETE FROM empregado 
WHERE empFillos > 0
AND empNumero NOT IN 
		(SELECT empDirector 
		 FROM empregado
         WHERE depNumero = empDepartamento)
AND empDepartamento IN 
		(SELECT depNumero
		 FROM departamento
         WHERE depNome LIKE 'SECTOR INDUSTRIAL');

-- 10
DELETE FROM departamento
WHERE depEmpregados = 0 OR depEmpregados IS NULL;

						
SELECT * FROM empregado;
SELECT * FROM departamento;