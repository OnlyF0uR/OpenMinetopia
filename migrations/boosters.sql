CREATE TABLE IF NOT EXISTS mt_boosters
(
    `id`         INT(11)       NOT NULL AUTO_INCREMENT,

    `type`       INT           NOT NULL,
    `multiplier` DOUBLE(11, 2) NOT NULL,
    `duration`   BIGINT        NOT NULL,

    `expires`    TIMESTAMP, -- Only set when activated, (activation ts + duration)
    PRIMARY KEY (`id`)
)