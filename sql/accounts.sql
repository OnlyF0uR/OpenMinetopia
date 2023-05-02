CREATE TABLE IF NOT EXISTS(
    `id` INT(11) NOT NULL AUTO_INCREMENT,

    `name` VARCHAR(255) NOT NULL,
    `dname` VARCHAR(255) NOT NULL,
    `bank_id` VARCHAR(255) NOT NULL,
    `balance` DOUBLE(11,2) NOT NULL,

    `owner_uuid` VARCHAR(36),
    PRIMARY KEY (`id`)
)