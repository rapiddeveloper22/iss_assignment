CREATE TABLE `employee` (
	`id` INT(3) NOT NULL,
    `first_name` VARCHAR(20) DEFAULT NULL,
    `last_name` VARCHAR(20) DEFAULT NULL,
    `username` VARCHAR(20) DEFAULT NULL,
    `password` VARCHAR(20) DEFAULT NULL,
    `city` VARCHAR(20) DEFAULT NULL,
    `state` VARCHAR(20) DEFAULT NULL,
    `contact` VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;