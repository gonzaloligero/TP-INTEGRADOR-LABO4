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


CREATE TABLE PRESTAMOS (
    IDPrestamo INT PRIMARY KEY AUTO_INCREMENT,
    DNICliente INT,
    MontoPedido DECIMAL(10,2) NOT NULL,
    ImporteAPagar DECIMAL(10,2) NOT NULL,
    Cuotas INT NOT NULL,
    Fecha DATE NOT NULL,
    Estado BIT NOT NULL,
    CONSTRAINT fk_Prestamos_Clientes FOREIGN KEY (DNICliente) REFERENCES CLIENTES(DNI),
    CONSTRAINT chk_Monto CHECK (MontoPedido REGEXP '^[0-9]+(\\.[0-9]{1,2})?$'),
    CONSTRAINT chk_ImporteAPagar CHECK (ImporteAPagar REGEXP '^[0-9]+(\\.[0-9]{1,2})?$')
);


CREATE TABLE CUENTAS (
    IDCuenta INT PRIMARY KEY AUTO_INCREMENT,
    DNICliente INT,
    FechaCreacion DATE NOT NULL,
    NumeroCuenta INT NOT NULL,
    CBU VARCHAR(50) NOT NULL,
    Saldo DECIMAL(10,6) NOT NULL,
    CONSTRAINT fk_Cuentas_Clientes FOREIGN KEY (DNICliente) REFERENCES CLIENTES(DNI),
    CONSTRAINT chk_CBU CHECK (CBU REGEXP '^[0-9.,]+$'),
    CONSTRAINT chk_Saldo CHECK (Saldo REGEXP '^[0-9]+(\\.[0-9]{1,6})?$')
);


CREATE TABLE TIPO_PRESTAMOS (
    IDTipoPrestamo INT PRIMARY KEY AUTO_INCREMENT,
    IDPrestamo INT,
    Tipo VARCHAR(50) NOT NULL,
    CONSTRAINT fk_TipoPrestamos_Prestamos FOREIGN KEY (IDPrestamo) REFERENCES PRESTAMOS(IDPrestamo),
    CONSTRAINT chk_Tipo CHECK (Tipo NOT REGEXP '[^a-zA-Z]')
);


CREATE TABLE PLAZOS (
    IDPlazo INT PRIMARY KEY AUTO_INCREMENT,
    IDPrestamo INT,
    MesQuePaga VARCHAR(20) NOT NULL,
    NroCuota INT NOT NULL,
    CONSTRAINT fk_Plazos_Prestamos FOREIGN KEY (IDPrestamo) REFERENCES PRESTAMOS(IDPrestamo),
    CONSTRAINT chk_Mes CHECK (MesQuePaga NOT REGEXP '[^a-zA-Z]'),
    CONSTRAINT chk_NroCuota CHECK (NroCuota REGEXP '^[0-9]+$')
);


CREATE TABLE TIPO_CUENTAS (
    IDTipoCuenta INT PRIMARY KEY AUTO_INCREMENT,
    IDCuenta INT,
    Tipo VARCHAR(50) NOT NULL,
    CONSTRAINT fk_TipoCuentas_Cuentas FOREIGN KEY (IDCuenta) REFERENCES CUENTAS(IDCuenta),
    CONSTRAINT chk_Tipo CHECK (Tipo NOT REGEXP '[^a-zA-Z]')
);


CREATE TABLE MOVIMIENTOS (
    IDMovimiento INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATE NOT NULL,
    Detalle VARCHAR(100) NOT NULL,
    Importe DECIMAL(10,2) NOT NULL,
    IDCuenta INT,
    CONSTRAINT fk_Movimientos_Cuentas FOREIGN KEY (IDCuenta) REFERENCES CUENTAS(IDCuenta),
    CONSTRAINT chk_Importe CHECK (Importe REGEXP '^[0-9]+(\\.[0-9]{1,2})?$')
);


CREATE TABLE TIPO_MOVIMIENTOS (
    IDTipoMovimiento INT PRIMARY KEY AUTO_INCREMENT,
    IDMovimiento INT,
    Tipo VARCHAR(50) NOT NULL,
    CONSTRAINT fk_TipoMovimientos_Movimientos FOREIGN KEY (IDMovimiento)
        REFERENCES MOVIMIENTOS (IDMovimiento),
    CONSTRAINT chk_Tipo CHECK (Tipo NOT REGEXP '[^a-zA-Z]')
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


