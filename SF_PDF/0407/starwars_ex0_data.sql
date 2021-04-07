-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema starwars
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`characters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`characters` (
  `CHARACTERID` INT NOT NULL AUTO_INCREMENT,
  `CHARACTERNAME` VARCHAR(30) NULL DEFAULT NULL,
  `MASTERID` INT NULL DEFAULT NULL,
  `ROLEID` INT NULL DEFAULT NULL,
  `EMAIL` VARCHAR(450) NULL DEFAULT NULL,
  PRIMARY KEY (`CHARACTERID`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`starwars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`starwars` (
  `EPISODEID` INT NOT NULL AUTO_INCREMENT,
  `EPISODENAME` VARCHAR(50) NULL DEFAULT NULL,
  `OPENYEAR` INT NULL DEFAULT NULL,
  PRIMARY KEY (`EPISODEID`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`casting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`casting` (
  `EPISODEID` INT NOT NULL AUTO_INCREMENT,
  `CHARACTERID` INT NULL,
  `REALNAME` VARCHAR(45) NULL,
  PRIMARY KEY (`EPISODEID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
