Create database if not exists GamesTeis;
use GamesTeis;

CREATE TABLE cliente (
	id_cliente	INTEGER auto_increment,
	nombre	TEXT NOT NULL,
	apellido	TEXT,
	direccion	TEXT,
	fecha_nacimiento	TEXT,
	telefono	INTEGER,
	email	TEXT,
	categoria	TEXT,
	fecha_baja	TEXT,
	PRIMARY KEY(id_cliente)
);
