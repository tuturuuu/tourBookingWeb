CREATE TABLE asm1.Tour (
    `id` INT(11) AUTO_INCREMENT,
    `name` VARCHAR(25) DEFAULT NULL,
    `image` LONGBLOB DEFAULT NULL, 
    `description` VARCHAR(5000) DEFAULT NULL,
    `start_date` DATE DEFAULT NULL,
    `duetime` DATE DEFAULT NULL,
    `price` FLOAT DEFAULT NULL,
    `status` boolean NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS asm1.Tour;

