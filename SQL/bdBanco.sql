DROP DATABASE IF EXISTS banco;
CREATE DATABASE banco;
USE banco;


CREATE TABLE tipo_cuenta (
  id int(11) AUTO_INCREMENT,
  detalle varchar(30),

  PRIMARY KEY(id)
);

CREATE TABLE motivo (
  id int(11) AUTO_INCREMENT,
  detalle varchar(30),

  PRIMARY KEY(id)
);

CREATE TABLE trabajador(
  rut varchar(20),
  nombre varchar(20),
  apellido varchar(30),
  cargo varchar(20),
  seccion varchar(20),
  clave varchar(10),

  PRIMARY KEY(rut)
);

CREATE TABLE usuario(
  n_Cuenta int(11),
  rut varchar(20),
  nombre varchar(50),
  apellido_P varchar(50),
  apellido_M varchar(50),
  correo varchar(50),
  clave varchar(10),
  estado bit(1),

  PRIMARY KEY(n_Cuenta)
);

CREATE TABLE cuenta (
  id int(11),
  n_Cuenta int(11),
  tipo int(11),
  saldo int(11),
  saldo_C int(11),
  estado bit(1),
  
  PRIMARY KEY(id),
  FOREIGN KEY(n_Cuenta) REFERENCES usuario(n_Cuenta),
  FOREIGN KEY(tipo) REFERENCES tipo_cuenta(id) 
);

CREATE TABLE solicitud(
  id int(11),
  motivo int(11),
  n_Cuenta int(11),
  rut_Tra varchar(20),
  fecha date,
  estado bit(1),

  PRIMARY KEY(id),
  FOREIGN KEY(motivo) REFERENCES motivo(id),
  FOREIGN KEY(n_Cuenta) REFERENCES usuario(n_Cuenta),
  FOREIGN KEY(rut_Tra) REFERENCES trabajador(rut)
);

CREATE TABLE movimiento(
  id int(11),
  descripcion varchar(100),
  n_Cuenta_Ori int(11),
  n_Cuenta_Des int(11),
  fecha date,
  hora time,
  monto int(11),
  cuenta int(11),

  PRIMARY KEY(id),
  FOREIGN KEY(n_Cuenta_Ori) REFERENCES usuario(n_Cuenta),
  FOREIGN KEY(n_Cuenta_Des) REFERENCES usuario(n_Cuenta),
  FOREIGN KEY(cuenta) REFERENCES cuenta(id)
);



