-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `happyhouse` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
USE `happyhouse` ;

-- -----------------------------------------------------
-- Table `happyhouse`.`baseaddress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`baseaddress` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(30) NOT NULL,
  `code` VARCHAR(30) NULL DEFAULT NULL,
  `dongcode` VARCHAR(30) NULL DEFAULT NULL,
  `gugun` VARCHAR(30) NULL DEFAULT NULL,
  `dong` VARCHAR(30) NOT NULL,
  `lat` VARCHAR(20) NULL DEFAULT NULL,
  `lng` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 3626
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `happyhouse`.`houseinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`houseinfo` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `dong` VARCHAR(30) NOT NULL,
  `AptName` VARCHAR(50) NOT NULL,
  `code` VARCHAR(30) NOT NULL,
  `buildYear` VARCHAR(30) NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(30) NULL DEFAULT NULL,
  `lng` VARCHAR(30) NULL DEFAULT NULL,
  `img` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 5990
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `happyhouse`.`housedeal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`housedeal` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `dong` VARCHAR(30) NOT NULL,
  `AptName` VARCHAR(50) NOT NULL,
  `code` VARCHAR(30) NOT NULL,
  `dealAmount` VARCHAR(50) NOT NULL,
  `buildYear` VARCHAR(30) NULL DEFAULT NULL,
  `dealYear` VARCHAR(30) NULL DEFAULT NULL,
  `dealMonth` VARCHAR(30) NULL DEFAULT NULL,
  `dealDay` VARCHAR(30) NULL DEFAULT NULL,
  `area` VARCHAR(30) NULL DEFAULT NULL,
  `floor` VARCHAR(30) NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `type` VARCHAR(30) NULL DEFAULT NULL,
  `rentMoney` VARCHAR(30) NULL DEFAULT NULL,
  `houseinfo_no` INT NOT NULL,
  PRIMARY KEY (`no`),
  INDEX `fk_housedeal_houseinfo1_idx` (`houseinfo_no` ASC) VISIBLE,
  CONSTRAINT `fk_housedeal_houseinfo1`
    FOREIGN KEY (`houseinfo_no`)
    REFERENCES `happyhouse`.`houseinfo` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 68865
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `happyhouse`.`sidocode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`sidocode` (
  `sido_code` VARCHAR(10) NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`guguncode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`guguncode` (
  `gugun_code` VARCHAR(10) NOT NULL,
  `gugun_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`gugun_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`dongcode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`dongcode` (
  `dongcode` INT NOT NULL,
  `city` TEXT NULL DEFAULT NULL,
  `gugun` TEXT NULL DEFAULT NULL,
  `dong` TEXT NULL DEFAULT NULL,
  `housedeal_no` INT NOT NULL,
  `sidocode_sido_code` VARCHAR(10) NOT NULL,
  `guguncode_gugun_code` VARCHAR(10) NOT NULL,
  `houseinfo_no` INT NOT NULL,
  INDEX `fk_dongcode_housedeal1_idx` (`housedeal_no` ASC) VISIBLE,
  INDEX `fk_dongcode_sidocode1_idx` (`sidocode_sido_code` ASC) VISIBLE,
  INDEX `fk_dongcode_guguncode1_idx` (`guguncode_gugun_code` ASC) VISIBLE,
  INDEX `fk_dongcode_houseinfo1_idx` (`houseinfo_no` ASC) VISIBLE,
  PRIMARY KEY (`dongcode`),
  CONSTRAINT `fk_dongcode_housedeal1`
    FOREIGN KEY (`housedeal_no`)
    REFERENCES `happyhouse`.`housedeal` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dongcode_sidocode1`
    FOREIGN KEY (`sidocode_sido_code`)
    REFERENCES `happyhouse`.`sidocode` (`sido_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dongcode_guguncode1`
    FOREIGN KEY (`guguncode_gugun_code`)
    REFERENCES `happyhouse`.`guguncode` (`gugun_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dongcode_houseinfo1`
    FOREIGN KEY (`houseinfo_no`)
    REFERENCES `happyhouse`.`houseinfo` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`user` (
  `userid` VARCHAR(16) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `userpwd` VARCHAR(16) NOT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `address` VARCHAR(100) NULL DEFAULT NULL,
  `joindate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `happyhouse`.`interest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`interest` (
  `` INT NOT NULL,
  `user_userid` VARCHAR(16) NOT NULL,
  `houseinfo_no` INT NOT NULL,
  PRIMARY KEY (``),
  INDEX `fk_interest_user_idx` (`user_userid` ASC) VISIBLE,
  INDEX `fk_interest_houseinfo1_idx` (`houseinfo_no` ASC) VISIBLE,
  CONSTRAINT `fk_interest_user`
    FOREIGN KEY (`user_userid`)
    REFERENCES `happyhouse`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_interest_houseinfo1`
    FOREIGN KEY (`houseinfo_no`)
    REFERENCES `happyhouse`.`houseinfo` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`hospital` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sido` TEXT NULL,
  `sigun` TEXT NULL,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `dongcode_dongcode` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hospital_dongcode1_idx` (`dongcode_dongcode` ASC) VISIBLE,
  CONSTRAINT `fk_hospital_dongcode1`
    FOREIGN KEY (`dongcode_dongcode`)
    REFERENCES `happyhouse`.`dongcode` (`dongcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`popularState`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`popularState` (
  `dongcode_dongcode` INT NOT NULL,
  `dong` VARCHAR(45) NULL,
  `count` INT NULL,
  `popularStatecol` VARCHAR(45) NULL,
  INDEX `fk_hospital_dongcode2_idx` (`dongcode_dongcode` ASC) VISIBLE,
  CONSTRAINT `fk_hospital_dongcode2`
    FOREIGN KEY (`dongcode_dongcode`)
    REFERENCES `happyhouse`.`dongcode` (`dongcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
