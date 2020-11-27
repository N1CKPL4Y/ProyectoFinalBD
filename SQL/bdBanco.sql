DROP DATABASE IF EXISTS banco;
CREATE DATABASE banco;
USE banco;


CREATE TABLE tipo_cuenta ( -- 3 insert (debito, credito, ahorro)
  id int(11) AUTO_INCREMENT,
  detalle varchar(30),

  PRIMARY KEY(id)
);

CREATE TABLE motivo (
  id int(11) AUTO_INCREMENT,
  detalle varchar(30),

  PRIMARY KEY(id)
);

CREATE TABLE trabajador( -- 1 insert
  rut varchar(20),
  nombre varchar(20),
  apellido varchar(30),
  cargo varchar(20),
  seccion varchar(20),
  clave varchar(10),

  PRIMARY KEY(rut)
);

CREATE TABLE usuario( -- 1 insert
  n_Cuenta int(11),
  rut varchar(20),
  nombre varchar(50),
  apellido_P varchar(50),
  apellido_M varchar(50),
  clave varchar(10),
  estado bit(1),

  PRIMARY KEY(n_Cuenta)
);

CREATE TABLE cuenta ( -- 3 insert
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

-- Procedimientos
DELIMITER @@
DROP PROCEDURE transferencia_Bancaria @@
CREATE PROCEDURE transferencia_Bancaria
(IN Ori INT, IN Des INT, IN Mon INT, IN t_C_Ori INT, IN msg VARCHAR(100), IN t_C_Des INT)
BEGIN 
    INSERT INTO movimiento VALUES(null,msg,Ori,Des,CURDATE(),curTime(),Mon,t_C_Ori);

        IF t_C_Ori=2 THEN
            UPDATE cuenta SET saldo_C=saldo_C-Mon WHERE n_Cuenta=Ori and tipo=t_C_Ori;
        ELSE
            UPDATE cuenta SET saldo=saldo-Mon WHERE n_Cuenta=Ori and tipo=t_C_Ori;
            UPDATE cuenta SET saldo=saldo+Mon WHERE n_Cuenta=Des and tipo=t_C_Des;
        END IF;

END @@ 
DELIMITER ;



