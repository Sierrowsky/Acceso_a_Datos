drop database if exists LibrosAutoresHibernate;
create database if not exists LibrosAutoresHibernate;

use LibrosAutoresHibernate;

CREATE TABLE `LIBROS` (
  `IdLibro` int NOT NULL auto_increment,
  `Titulo` varchar(100) NOT NULL,
  `Precio` varchar(100) NOT NULL,
  PRIMARY KEY (`IdLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `Autores` (
  `DniAutor` int NOT NULL ,
  `Nombre` varchar(100) NOT NULL,
  `Nacionalidad` varchar(100) NOT NULL,
  PRIMARY KEY (`DniAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `Libros_Autores` (
  `IdLibro` int NOT NULL,
  `DniAutor` int NOT NULL,
  PRIMARY KEY(`IdLibro`,`DniAutor`),
  FOREIGN KEY (IdLibro) REFERENCES LIBROS (IdLibro) ON DELETE cascade ON UPDATE cascade,
  FOREIGN KEY (DniAutor) REFERENCES Autores (DniAutor) ON DELETE cascade ON UPDATE cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `Telefonos` (
  `Dni` int NOT NULL,
  `NumeroTf` int NOT NULL,
  PRIMARY KEY(`Dni`,`NumeroTf`),
  FOREIGN KEY (Dni) REFERENCES Autores (DniAutor) ON DELETE cascade ON UPDATE cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

