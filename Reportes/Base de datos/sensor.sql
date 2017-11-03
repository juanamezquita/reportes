-- MySQL Script generated by MySQL Workbench
-- 10/14/17 15:18:16
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sensores
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sensores
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sensores` ;
USE `sensores` ;

-- -----------------------------------------------------
-- Table `sensores`.`nodo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sensores`.`nodo` (
  `idnodo` INT NOT NULL,
  `nodoname` VARCHAR(45) NOT NULL,
  `ubicacion` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idnodo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sensores`.`datos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sensores`.`datos` (
  `nodo_idnodo` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `hora` VARCHAR(45) NOT NULL,
  `variable` VARCHAR(45) NOT NULL,
  `valor` INT NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nodo_idnodo`, `fecha`, `hora`,`variable`),
  INDEX `fk_datos_nodo_idx` (`nodo_idnodo` ASC),
  CONSTRAINT `fk_datos_nodo`
    FOREIGN KEY (`nodo_idnodo`)
    REFERENCES `sensores`.`nodo` (`idnodo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
INSERT INTO `sensores`.`nodo` (`idnodo`, `nodoname`, `ubicacion`, `descripcion`) VALUES ('1', 'tecnoparque_bogota', 'Lab solar', 'scada lab solar');
INSERT INTO `sensores`.`datos` (`nodo_idnodo`, `fecha`, `hora`, `variable`, `valor`, `unidad`) VALUES ('1', '2017-10-15', '11:05:00', 'voltaje', '5', 'V');