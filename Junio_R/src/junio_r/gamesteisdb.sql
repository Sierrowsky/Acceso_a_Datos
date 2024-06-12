Create database if not exists GamesTeis;
use GamesTeis;
CREATE TABLE IF NOT EXISTS cliente (
	id_cliente	INTEGER AUTO_INCREMENT,
	nombre	TEXT NOT NULL,
	apellido	INTEGER,
	direccion	TEXT,
	fecha_nacimiento	TEXT,
	telefono	INTEGER,
	email	TEXT,
	categoria	TEXT,
	fecha_baja	TEXT,
	PRIMARY KEY(id_cliente )
);
CREATE TABLE IF NOT EXISTS producto (
	id_producto	INTEGER AUTO_INCREMENT,
	nombre	TEXT NOT NULL,
	precio	TEXT NOT NULL,
	stock	INTEGER NOT NULL,
	PRIMARY KEY(id_producto)
);
CREATE TABLE IF NOT EXISTS facturas (
	idFactura	INTEGER NOT NULL AUTO_INCREMENT,
	idCliente	INTEGER NOT NULL,
	fecha	TEXT NOT NULL,
	FOREIGN KEY(idCliente) REFERENCES cliente(id_cliente),
	PRIMARY KEY(idFactura)
);
CREATE TABLE IF NOT EXISTS venta (
	idVenta	INTEGER AUTO_INCREMENT,
	idFactura	INTEGER NOT NULL,
	idProducto	INTEGER NOT NULL,
	cantidad	INTEGER NOT NULL,
	precio	TEXT NOT NULL,
	FOREIGN KEY(idProducto) REFERENCES producto(id_producto),
	FOREIGN KEY(idFactura) REFERENCES facturas(idFactura),
	PRIMARY KEY(idVenta)
);
CREATE TABLE IF NOT EXISTS empleado (
	id_empleado	INTEGER AUTO_INCREMENT,
	nombre	TEXT,
	departamento	TEXT,
	telefono	INTEGER,
	turno	TEXT,
	fecha_baja	TEXT,
	PRIMARY KEY(id_empleado)
);
