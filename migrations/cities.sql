CREATE TABLE IF NOT EXISTS mt_cities
(
    `id`           INT(11)       NOT NULL AUTO_INCREMENT,

    `display_name` VARCHAR(255)  NOT NULL,
    `theme_colour` VARCHAR(6)    NOT NULL,

    `min_temp`     DOUBLE(11, 2) NOT NULL,
    `max_temp`     DOUBLE(11, 2) NOT NULL,

    PRIMARY KEY (`id`)
)