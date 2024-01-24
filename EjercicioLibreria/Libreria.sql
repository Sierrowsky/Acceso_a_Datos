-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Libreria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Libreria
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `Libreria` DEFAULT CHARACTER SET utf8 ;
USE `Libreria` ;

-- -----------------------------------------------------
-- Table `Libreria`.`Autores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Libreria`.`Autores` (
  `DniAutor` VARCHAR(9) NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Nacionalidad` VARCHAR(45) NULL,
  PRIMARY KEY (`DniAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libreria`.`Libros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Libreria`.`Libros` (
  `idLibro` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(45) NULL,
  `Precio` FLOAT NULL,
  PRIMARY KEY (`idLibro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libreria`.`Libros_Autores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Libreria`.`Libros_Autores` (
  `DniAutor` VARCHAR(9) NOT NULL,
  `IdLibro` INT NOT NULL,
  PRIMARY KEY (`DniAutor`, `IdLibro`),
  INDEX `fk_Autores_has_Libros_Libros1_idx` (`IdLibro` ASC) VISIBLE,
  INDEX `fk_Autores_has_Libros_Autores_idx` (`DniAutor` ASC) VISIBLE,
  CONSTRAINT `fk_Autores_has_Libros_Autores`
    FOREIGN KEY (`DniAutor`)
    REFERENCES `Libreria`.`Autores` (`DniAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Autores_has_Libros_Libros1`
    FOREIGN KEY (`IdLibro`)
    REFERENCES `Libreria`.`Libros` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libreria`.`Telefonos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Libreria`.`Telefonos` (
  `Numero` INT NOT NULL,
  `DniAutor` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`DniAutor`),
  CONSTRAINT `fk_Telefonos_Autores1`
    FOREIGN KEY (`DniAutor`)
    REFERENCES `Libreria`.`Autores` (`DniAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
