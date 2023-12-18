drop database if exists hospitalBD;
create database hospitalBD;
use hospitalBD;
SET SQL_SAFE_UPDATES = 0;

-- Tabla Médicos 
create table medicos(
	dni varchar(20),
    nombre varchar(25),
    apellidos varchar(25),
    primary key (dni)
);

-- Tabla Pacientes
create table pacientes(
	dni varchar(20),
	nombre varchar(25),
    sexo varchar(10),
    tipoPaciente varchar(20),
    gradoEnf int,
    fechaIngreso date,
    numHabitacion int,
    dniMedico varchar(9),
    primary key (dni)
);

-- Definimos claves foráneas

ALTER TABLE pacientes
ADD CONSTRAINT pac_FK_med FOREIGN KEY(dniMedico) REFERENCES medicos(dni) 
ON DELETE RESTRICT ON UPDATE CASCADE;