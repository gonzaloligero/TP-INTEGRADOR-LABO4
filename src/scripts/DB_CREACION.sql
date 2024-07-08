CREATE DATABASE TPIntegradorLaboratorio4;

USE TPIntegradorLaboratorio4;

CREATE TABLE USUARIOS (
    IDUsuario INT PRIMARY KEY AUTO_INCREMENT,
    Usuario VARCHAR(25) NOT NULL,
    Contraseña VARCHAR(25) NOT NULL,
    TipoUsuario INT NOT NULL,
    Estado BIT NOT NULL
);


CREATE TABLE PROVINCIAS (
    IDProvincia INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL
);


CREATE TABLE LOCALIDADES (
    IDLocalidad INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    IDProvincia INT,
    FOREIGN KEY (IDProvincia) REFERENCES PROVINCIAS(IDProvincia)
);


CREATE TABLE DIRECCIONES (
    IDDireccion INT PRIMARY KEY AUTO_INCREMENT,
    IDLocalidad INT,
    CodigoPostal VARCHAR(15) NOT NULL,
    Calle VARCHAR(30) NOT NULL,
    Numero INT NOT NULL,
    FOREIGN KEY (IDLocalidad) REFERENCES LOCALIDADES (IDLocalidad)
);


CREATE TABLE CLIENTES (
    DNI INT PRIMARY KEY,
    CUIL VARCHAR(50) NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Sexo VARCHAR(20) NOT NULL,
    Nacionalidad VARCHAR(25) NOT NULL,
    FechaNacimiento DATE NOT NULL,
    IDDireccion INT,
    Email VARCHAR(25) NOT NULL,
    IDUsuario INT,
    ESTADO BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (IDUsuario) REFERENCES USUARIOS(IDUsuario)
);





CREATE TABLE TELEFONOS (
    IDTelefono INT PRIMARY KEY AUTO_INCREMENT,
    DNICliente INT,
    NumeroTelefonico VARCHAR(15) NOT NULL,
    FOREIGN KEY (DNICliente) REFERENCES CLIENTES(DNI)
);

CREATE TABLE TIPO_PRESTAMOS (
    IDTipoPrestamo INT PRIMARY KEY AUTO_INCREMENT,
	Tipo VARCHAR(50) NOT NULL,
    TNA int not null,
	CONSTRAINT chk_Tipo CHECK (Tipo NOT REGEXP '[^a-zA-Z]')
);

CREATE TABLE PRESTAMOS (
    IDPrestamo INT PRIMARY KEY AUTO_INCREMENT,
    IDTipoPrestamo int not null,
    DNICliente INT,
    MontoPedido DECIMAL(10,2) NOT NULL,
    ImporteAPagar DECIMAL(10,2) NOT NULL,
    Cuotas INT NOT NULL,
    Fecha DATE NOT NULL,
    Estado BIT NOT NULL,
    CONSTRAINT fk_Prestamos_Clientes FOREIGN KEY (DNICliente) REFERENCES CLIENTES(DNI),
	CONSTRAINT fk_PrestamoId FOREIGN KEY (IDTipoPrestamo) REFERENCES TIPO_PRESTAMOS(IDTipoPrestamo),
    CONSTRAINT chk_Monto CHECK (MontoPedido REGEXP '^[0-9]+(\\.[0-9]{1,2})?$'),
    CONSTRAINT chk_ImporteAPagar CHECK (ImporteAPagar REGEXP '^[0-9]+(\\.[0-9]{1,2})?$')
);

CREATE TABLE PLAZOS (
    IDPlazo INT PRIMARY KEY AUTO_INCREMENT,
    IDPrestamo INT,
    MesQuePaga VARCHAR(20) NOT NULL,
    NroCuota INT NOT NULL,
    ImporteAPagarCuotas DECIMAL(10,2) NOT NULL,
    Estado BIT NOT NULL,
    CONSTRAINT fk_Plazos_Prestamos FOREIGN KEY (IDPrestamo) REFERENCES PRESTAMOS(IDPrestamo),
    CONSTRAINT chk_Mes CHECK (MesQuePaga NOT REGEXP '[^a-zA-Z]'),
    CONSTRAINT chk_NroCuota CHECK (NroCuota REGEXP '^[0-9]+$')
);


CREATE TABLE TIPO_CUENTAS (
    IDTipoCuenta INT PRIMARY KEY AUTO_INCREMENT,
    Tipo VARCHAR(50) NOT NULL
);

INSERT INTO TIPO_CUENTAS (Tipo) VALUES ('Caja de Ahorro');
INSERT INTO TIPO_CUENTAS (Tipo) VALUES ('Cuenta corriente');


CREATE TABLE CUENTAS (
    IDCuenta INT PRIMARY KEY AUTO_INCREMENT,
    DNICliente INT,
    FechaCreacion DATE NOT NULL,
    NumeroCuenta INT NOT NULL,
    CBU VARCHAR(50) NOT NULL,
    Saldo DECIMAL(18,2) NOT NULL,
    IDTipoCuenta INT NOT NULL,
    ESTADO BOOLEAN NOT NULL DEFAULT TRUE,
    
    CONSTRAINT fk_Cuentas_Tipo_Cuentas FOREIGN KEY (IDTipoCuenta) REFERENCES TIPO_CUENTAS(IDTipoCuenta),
    CONSTRAINT fk_Cuentas_Clientes FOREIGN KEY (DNICliente) REFERENCES CLIENTES(DNI),
    CONSTRAINT chk_CBU CHECK (CBU REGEXP '^[0-9.,]+$'),
    CONSTRAINT chk_Saldo CHECK (Saldo REGEXP '^[0-9]+(\\.[0-9]{1,6})?$')
);


CREATE TABLE TIPO_MOVIMIENTOS (
    IDTipoMovimiento INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL
);

INSERT INTO TIPO_MOVIMIENTOS (Nombre) VALUES ('Alta de cuenta');
INSERT INTO TIPO_MOVIMIENTOS (Nombre) VALUES ('Alta de un préstamo');
INSERT INTO TIPO_MOVIMIENTOS (Nombre) VALUES ('Pago de préstamo');
INSERT INTO TIPO_MOVIMIENTOS (Nombre) VALUES ('Transferencia');


CREATE TABLE MOVIMIENTOS (
    IDMovimiento INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATE NOT NULL,
    Detalle VARCHAR(100) NOT NULL,
    Importe DECIMAL(18,2) NOT NULL,
    IDCuentaEmisor INT,
    IDCuentaReceptor INT,
    IDTipoMovimiento INT NOT NULL,
    CONSTRAINT fk_Movimientos_Tipo_Movimientos FOREIGN KEY (IDTipoMovimiento) REFERENCES TIPO_MOVIMIENTOS(IDTipoMovimiento),
    CONSTRAINT chk_Importe CHECK (Importe REGEXP '^[0-9]+(\\.[0-9]{1,2})?$')
);




-- Inserts para la tabla PROVINCIAS
INSERT INTO PROVINCIAS (Nombre) VALUES ('Buenos Aires');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Catamarca');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Chaco');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Chubut');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Córdoba');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Corrientes');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Entre Ríos');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Formosa');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Jujuy');
INSERT INTO PROVINCIAS (Nombre) VALUES ('La Pampa');
INSERT INTO PROVINCIAS (Nombre) VALUES ('La Rioja');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Mendoza');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Misiones');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Neuquén');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Río Negro');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Salta');
INSERT INTO PROVINCIAS (Nombre) VALUES ('San Juan');
INSERT INTO PROVINCIAS (Nombre) VALUES ('San Luis');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Santa Cruz');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Santa Fe');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Santiago del Estero');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Tierra del Fuego');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Tucumán');
INSERT INTO PROVINCIAS (Nombre) VALUES ('Ciudad Autónoma de Buenos Aires');


-- Inserts para la tabla LOCALIDADES (asumiendo IDProvincia = 1 para todas las localidades de Buenos Aires)
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('La Plata', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Mar del Plata', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Bahía Blanca', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Tandil', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('San Nicolás de los Arroyos', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Junín', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Pergamino', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Chivilcoy', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Zárate', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('San Pedro', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Luján', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('San Antonio de Areco', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Necochea', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Azul', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Olavarría', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('La Matanza', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Tres de Febrero', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Morón', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('San Isidro', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Tigre', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Vicente López', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Berazategui', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Quilmes', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Avellaneda', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('San Fernando', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Escobar', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Merlo', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Moreno', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Lomas de Zamora', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Adrogué', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('San Miguel', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Ituzaingó', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Berisso', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Ensenada', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Campana', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Villa Gesell', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Pinamar', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Mar de Ajó', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Miramar', 1);
INSERT INTO LOCALIDADES (Nombre, IDProvincia) VALUES ('Cariló', 1);

-- Inserts para la tabla USUARIOS
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('admin', 'admin123', 1, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario1', 'password1', 1, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario2', 'password2', 2, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario3', 'password3', 1, 0);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario4', 'password4', 2, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario5', 'password5', 1, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario6', 'password6', 2, 0);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario7', 'password7', 1, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario8', 'password8', 2, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario9', 'password9', 1, 0);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario10', 'password10', 2, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario11', 'password11', 1, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario12', 'password12', 2, 0);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario13', 'password13', 1, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario14', 'password14', 2, 1);
INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES ('usuario15', 'password15', 1, 0);



-- Inserts para la tabla DIRECCIONES (asumiendo IDLocalidad y IDProvincia adecuados)
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '1900', 'Calle Falsa', 123);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (2, '7600', 'Avenida Principal', 456);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (3, '8000', 'Calle Central', 789);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '1000', 'Avenida Rivadavia', 123);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '2000', 'Calle San Martín', 234);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '3000', 'Avenida Belgrano', 345);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '4000', 'Calle Sarmiento', 456);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '5000', 'Avenida Libertador', 567);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '6000', 'Calle Mitre', 678);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '7000', 'Avenida Independencia', 789);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '8000', 'Calle Alvear', 890);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '9000', 'Avenida Pueyrredón', 901);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '10000', 'Calle Reconquista', 112);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '11000', 'Avenida Corrientes', 223);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '12000', 'Calle Florida', 334);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '13000', 'Avenida Santa Fe', 445);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '14000', 'Calle Lavalle', 556);
INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (1, '15000', 'Avenida de Mayo', 667);



-- Inserts para la tabla CLIENTES
INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario, ESTADO) VALUES (11111111, '20-11111111-1', 'Carlos', 'Gómez', 'Masculino', 'Argentino', '1992-03-25', 1, 'carlos.gomez@gmail.com', 2, true);
INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario, ESTADO) VALUES (22222222, '27-22222222-2', 'Laura', 'Fernández', 'Femenino', 'Argentina', '1988-07-12', 2, 'laura.fernandez@yahoo.com', 3, true);
INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario, ESTADO) VALUES (44444444, '27-44444444-2', 'Ana', 'Martínez', 'Femenino', 'Argentina', '1990-04-18', 4, 'ana.martinez@gmail.com', 5, true);
INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario, ESTADO) VALUES (77777777, '20-77777777-1', 'Pablo', 'Sánchez', 'Masculino', 'Argentino', '1989-06-20', 7, 'pablo.sanchez@gmail.com', 8, true);
INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario, ESTADO) VALUES (88888888, '27-88888888-2', 'Silvia', 'López', 'Femenino', 'Argentina', '1991-09-10', 8, 'silvia.lopez@yahoo.com', 9, true);
INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario, ESTADO) VALUES (99999999, '20-99999999-1', 'Federico', 'Díaz', 'Masculino', 'Argentino', '1994-02-28', 9, 'federico.diaz@hotmail.com', 10, true);
INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario, ESTADO) VALUES (10101010, '27-10101010-2', 'Camila', 'Rojas', 'Femenino', 'Argentina', '1986-05-08', 10, 'camila.rojas@gmail.com', 11, true);
INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario, ESTADO) VALUES (12121212, '20-12121212-1', 'Alejandro', 'Pérez', 'Masculino', 'Argentino', '1997-11-14', 11, 'alejandro.perez@yahoo.com', 12, true);
INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario, ESTADO) VALUES (14141414, '20-14141414-1', 'Lucas', 'Martín', 'Masculino', 'Argentino', '1985-12-17', 13, 'lucas.martin@gmail.com', 14, true);

-- Inserts para la tabla TELEFONOS (asumiendo DNICliente adecuado)
INSERT INTO TELEFONOS (DNICliente, NumeroTelefonico) VALUES (11111111, '1122334455');
INSERT INTO TELEFONOS (DNICliente, NumeroTelefonico) VALUES (22222222, '1122446688');

INSERT INTO TELEFONOS (DNICliente, NumeroTelefonico) VALUES (77777777, '1177991122');
INSERT INTO TELEFONOS (DNICliente, NumeroTelefonico) VALUES (88888888, '1188002233');
INSERT INTO TELEFONOS (DNICliente, NumeroTelefonico) VALUES (99999999, '1199113344');
INSERT INTO TELEFONOS (DNICliente, NumeroTelefonico) VALUES (10101010, '1100224455');
INSERT INTO TELEFONOS (DNICliente, NumeroTelefonico) VALUES (12121212, '1111335566');
INSERT INTO TELEFONOS (DNICliente, NumeroTelefonico) VALUES (14141414, '1133557788');


INSERT INTO TIPO_PRESTAMOS (Tipo, TNA) VALUES ('Personal', 25);
INSERT INTO TIPO_PRESTAMOS (Tipo, TNA) VALUES ('Hipotecario', 5);
INSERT INTO TIPO_PRESTAMOS (Tipo, TNA) VALUES ('Automotriz', 10);
INSERT INTO TIPO_PRESTAMOS (Tipo, TNA) VALUES ('Estudiantil', 15);
INSERT INTO TIPO_PRESTAMOS (Tipo, TNA) VALUES ('Comercial', 20);
INSERT INTO TIPO_PRESTAMOS (Tipo, TNA) VALUES ('Agrícola', 18);

INSERT INTO PRESTAMOS (IDPrestamo, IDTipoPrestamo, DNICliente, MontoPedido, ImporteAPagar, Cuotas, Fecha, Estado) VALUES 
(1, 1, 11111111, 10000.00, 12000.00, 12, '2023-01-01', 0),
(2, 2, 11111111, 15000.00, 18000.00, 24, '2023-02-01', 0),
(3, 1, 22222222, 20000.00, 24000.00, 18, '2023-03-01', 0),
(4, 3, 22222222, 25000.00, 30000.00, 36, '2023-04-01', 0),
(5, 1, 44444444, 30000.00, 36000.00, 12, '2023-05-01', 0),
(6, 2, 44444444, 35000.00, 42000.00, 24, '2023-06-01', 0),
(7, 3, 44444444, 40000.00, 48000.00, 18, '2023-07-01', 0),
(8, 1, 77777777, 45000.00, 54000.00, 36, '2023-08-01', 0),
(9, 2, 88888888, 50000.00, 60000.00, 12, '2023-09-01', 0),
(10, 3, 99999999, 55000.00, 66000.00, 24, '2023-10-01', 0);




INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (11111111, 1, '2024-06-28', 123456789, '1234567801234567890104', 10000.00);
INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (11111111, 2, '2024-06-28', 123456789, '1234567801234567890106', 10000.00);





INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (22222222, 1, '2024-06-28', 987654321, '9876543209876543210987', 5000.00);


INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (44444444, 2, '2024-06-28', 246810123, '2468101202468101230108', 15000.00);

INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (77777777, 1, '2024-06-28', 123456789, '1234567801234567890109', 10000.00);
INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (77777777, 2, '2024-06-28', 123456789, '1234567801234567890110', 10000.00);

INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (88888888, 1, '2024-06-28', 987654321, '9876543209876543210985', 5000.00);

INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (99999999, 1, '2024-06-28', 246810123, '2468101202468101230124', 15000.00);

INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (10101010, 1, '2024-06-28', 987654321, '9876543209876543210987', 5000.00);


INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (12121212, 1, '2024-06-28', 246810123, '2468101202468101230125', 15000.00);

INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (12121212, 2, '2024-06-28', 123456789, '1234567801234567890127', 10000.00);
INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (14141414, 2, '2024-06-28', 123456789, '1234567801234567890129', 10000.00);

INSERT INTO CUENTAS (DNICliente, IDTipoCuenta, FechaCreacion, NumeroCuenta, CBU, Saldo)
VALUES (14141414, 1, '2024-06-28', 987654321, '9876543209876543210987', 5000.00);









DELIMITER //

CREATE TRIGGER after_prestamo_update 
AFTER UPDATE ON PRESTAMOS 
FOR EACH ROW 
BEGIN
    DECLARE cuota DECIMAL(10, 2);
    DECLARE saldo_actual DECIMAL(18, 2);
    DECLARE interes_mensual DECIMAL(10, 2);
    DECLARE monto DECIMAL(10, 2);
    DECLARE i INT DEFAULT 1;

    IF OLD.Estado = 0 AND NEW.Estado = 1 THEN

        SELECT TNA / 12 INTO interes_mensual
        FROM TIPO_PRESTAMOS 
        WHERE IDTipoPrestamo = NEW.IDTipoPrestamo;

      
        SET monto = NEW.ImporteAPagar / NEW.Cuotas;

        WHILE i <= NEW.Cuotas DO
            INSERT INTO PLAZOS (IDPrestamo, MesQuePaga, NroCuota, ImporteAPagarCuotas, Estado) 
            VALUES (NEW.IDPrestamo, DATE_FORMAT(DATE_ADD(NEW.Fecha, INTERVAL i MONTH), '%Y-%m'), i, monto, 0);
            SET i = i + 1;
        END WHILE;

        SELECT Saldo INTO saldo_actual 
        FROM CUENTAS 
        WHERE DNICliente = NEW.DNICliente AND IDTipoCuenta = 1;

        UPDATE CUENTAS 
        SET Saldo = saldo_actual + NEW.MontoPedido 
        WHERE DNICliente = NEW.DNICliente AND IDTipoCuenta = 1;

      
        BEGIN
            DECLARE EXIT HANDLER FOR SQLEXCEPTION
            BEGIN
                
                SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error en el trigger: no se pudo insertar en MOVIMIENTOS';
            END;

            INSERT INTO MOVIMIENTOS (Fecha, Detalle, Importe, IDCuentaEmisor, IDTipoMovimiento) 
            VALUES (NEW.Fecha, CONCAT('Préstamo aprobado - ID: ', NEW.IDPrestamo), NEW.MontoPedido, 
                    (SELECT IDCuenta FROM CUENTAS WHERE DNICliente = NEW.DNICliente AND IDTipoCuenta = 1 LIMIT 1), 
                    2);
        END;
    END IF;
END;

//

DELIMITER ;


-- DROP TRIGGER IF EXISTS after_prestamo_update;