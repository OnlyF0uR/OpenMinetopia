CREATE TABLE IF NOT EXISTS mt_banks
(
    `id`           INT(11)       NOT NULL AUTO_INCREMENT,

    `display_name` VARCHAR(255)  NOT NULL,
    `interest`     DOUBLE(11, 2) NOT NULL,
    `balance`      DOUBLE(11, 2) NOT NULL,

    PRIMARY KEY (`id`)
)