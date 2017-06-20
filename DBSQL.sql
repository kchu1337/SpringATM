-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ATMDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ATMDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ATMDB` DEFAULT CHARACTER SET utf8 ;
USE `ATMDB` ;

-- -----------------------------------------------------
-- Table `ATMDB`.`Account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ATMDB`.`Account` (
  `AccountID` VARCHAR(7) NOT NULL,
  `Amount` DOUBLE NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`AccountID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ATMDB`.`Transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ATMDB`.`Transactions` (
  `TransactionID` INT NOT NULL AUTO_INCREMENT,
  `Account` VARCHAR(7) NULL,
  `TransactionType` VARCHAR(45) NULL,
  `Amount` DOUBLE NULL,
  `Reason` VARCHAR(9000) NULL,
  PRIMARY KEY (`TransactionID`),
  INDEX `fk_Transactions_Acc_idx` (`Account` ASC),
  CONSTRAINT `fk_Transactions_Acc`
    FOREIGN KEY (`Account`)
    REFERENCES `ATMDB`.`Account` (`AccountID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
