create table alumno (
	dni char(9) primary key,
	nome varchar(50),
	apelidos varchar(150),
	idade int
);

insert into alumno(dni,nome,apelidos,idade)
	values ('11111111A','Pedro','Ferradas',22);
insert into alumno(dni,nome,apelidos,idade)
	values ('22222222A','Rosa','Fernandez',24);
insert into alumno(dni,nome,apelidos,idade)
	values ('33333333C','Olga','Ferradas',26);
insert into alumno(dni,nome,apelidos,idade)
	values ('55555555A','Elena','Gonzalez',20);
