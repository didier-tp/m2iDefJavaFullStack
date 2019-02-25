create database if not exists mydb;
use mydb;

drop table if exists Compte;

create table Compte(
	numero integer primary key auto_increment,
	label VARCHAR(64),
	solde double
);

insert into Compte(numero,label,solde) 
      values (1,'compte 1',150.0),
             (2,'compte 2',300.0);

select * from Compte;