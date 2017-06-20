-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema TransactionDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TransactionDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TransactionDB` DEFAULT CHARACTER SET utf8 ;
USE `TransactionDB` ;

-- -----------------------------------------------------
-- Table `TransactionDB`.`Transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TransactionDB`.`Transaction` (
  `TransactionID` INT NOT NULL AUTO_INCREMENT,
  `AccountID` VARCHAR(7) NOT NULL,
  `Amount` DOUBLE NOT NULL,
  `Reason` VARCHAR(9000) NULL,
  PRIMARY KEY (`TransactionID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
