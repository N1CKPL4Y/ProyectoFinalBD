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
  id int(11) AUTO_INCREMENT,
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
  id int(11) AUTO_INCREMENT,
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
  id int(11) AUTO_INCREMENT,
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


-- INSERTS

-- Tabla Tipo_cuenta
INSERT INTO tipo_cuenta VALUES(NULL, 'Debito'); --ID 1
INSERT INTO tipo_cuenta VALUES(NULL, 'Credito'); --ID 2
INSERT INTO tipo_cuenta VALUES(NULL, 'Cuenta de ahorro'); --ID 3

-- Tabla motivo
INSERT INTO motivo VALUES(NULL, 'Activar cuenta');
INSERT INTO motivo VALUES(NULL, 'Desactivar cuenta');

-- Tabla Trabajador
INSERT INTO Trabajador VALUES('15.738.857-6', 'Viviana', 'Droguett', 'Administracion', 'Servicio al cliente', 'viviana123');

-- Tabla Usuario
--                           n_cuenta           rut          nombre    apellido_p   apellido_m    clave  activo
INSERT INTO usuario VALUES( 15116506, '15.116.506-0',     'Nicolas',     'Perez',  'Droguett',  '1010',      1);
INSERT INTO usuario VALUES( 20660314, '20.660.314-3','Javier Alein','Villalobos',   'Ramirez',  '2020',      1);

--Tabla Cuenta
--                          ID    n_cuenta(fk)    t_cuenta(fk)        saldo   saldo(credito)        activo (1= si) (0=no)
-- cuentas de Nicolas Perez Droguett
INSERT INTO cuenta VALUES(  NULL,       15116506,              1,        50000,              0,                    1);
INSERT INTO cuenta VALUES(  NULL,       15116506,              2,            0,        1000000,                    1);
INSERT INTO cuenta VALUES(  NULL,       15116506,              3,        50000,              0,                    1);
-- Cuentas de Javier Alein Villalobos Ramirez
INSERT INTO cuenta VALUES(  NULL,       20660314,              1,        50000,              0,                    1);
INSERT INTO cuenta VALUES(  NULL,       20660314,              2,            0,        1000000,                    1);
INSERT INTO cuenta VALUES(  NULL,       20660314,              3,        50000,              0,                    1);



-- Procedimientos

-- Simula una transferencia bancaria entre cuentas
DELIMITER //
DROP PROCEDURE IF EXISTS transferencia_Bancaria //
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

END //
DELIMITER ;

-------------------------------------------

-- Crear un usuario y se le asginan las cuentas (debito, credito y ahorro)
DELIMITER //
DROP PROCEDURE IF EXISTS crear_Cuentas //
CREATE PROCEDURE crear_Cuentas
(IN n_Cuenta INT, IN rut varchar(13), IN nombre varchar(50), IN apellido_P varchar(50), IN apellido_M varchar(50), IN clave INT)
BEGIN 
    INSERT INTO usuario VALUES(n_Cuenta,rut,nombre,apellido_P,apellido_M,clave,1);
    INSERT INTO cuenta VALUES(NULL,n_Cuenta,1,50000,0,1),
                             (NULL,n_Cuenta,2,0,1000000,1),
                             (NULL,n_Cuenta,3,50000,0,1);
END //
DELIMITER ;