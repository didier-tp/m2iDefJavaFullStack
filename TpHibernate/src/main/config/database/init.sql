create database if not exists produit;
use produit;

drop table if exists produit;

create table produit(
	numero integer primary key auto_increment,
	label VARCHAR(64),
	prix double
);

insert into produit(numero,label,prix) 
      values (1,'p1',53.6),
             (2,'p2',33.7);

select * from produit;