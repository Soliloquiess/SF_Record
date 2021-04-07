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
-- Table `mydb`.`STARWARS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`STARWARS` (
  `EPISODEID` INT NOT NULL AUTO_INCREMENT,
  `EPISODENAME` VARCHAR(50) NULL,
  `OPENYEAR` INT NULL,
  PRIMARY KEY (`EPISODEID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CHARACTERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CHARACTERS` (
  `CHARACTERID` INT NOT NULL AUTO_INCREMENT,
  `CHARACTERNAME` VARCHAR(30) NULL,
  `MASTERID` INT NULL,
  `ROLEID` INT NULL,
  `EMAIL` VARCHAR(450) NULL,
  PRIMARY KEY (`CHARACTERID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CASTING`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CASTING` (
  `EPISODEID` INT NOT NULL AUTO_INCREMENT,
  `CHARACTERID` INT NULL,
  `REALNAME` VARCHAR(40) NULL,
  `STARWARS_EPISODEID` INT NOT NULL,
  `CHARACTERS_CHARACTERID` INT NOT NULL,
  PRIMARY KEY (`EPISODEID`),
  INDEX `fk_CASTING_STARWARS_idx` (`STARWARS_EPISODEID` ASC) VISIBLE,
  INDEX `fk_CASTING_CHARACTERS1_idx` (`CHARACTERS_CHARACTERID` ASC) VISIBLE,
  CONSTRAINT `fk_CASTING_STARWARS`
    FOREIGN KEY (`STARWARS_EPISODEID`)
    REFERENCES `mydb`.`STARWARS` (`EPISODEID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CASTING_CHARACTERS1`
    FOREIGN KEY (`CHARACTERS_CHARACTERID`)
    REFERENCES `mydb`.`CHARACTERS` (`CHARACTERID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
