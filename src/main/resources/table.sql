CREATE TABLE `bdtienda`.`productos` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `producto` VARCHAR(45) NULL,
  `precio` DOUBLE NULL,
  `stock` INT NULL,
  PRIMARY KEY (`codigo`));
