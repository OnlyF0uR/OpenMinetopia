CREATE TABLE IF NOT EXISTS(
    `uuid` VARCHAR(36) NOT NULL,

    `shards` DECIMAL NOT NULL,
    `level` INT NOT NULL,
    `playtime` VARCHAR(255) NOT NULL,

    `job` VARCHAR(255) NOT NULL,
    `sidejob_id` INT NOT NULL,
    `gang_id` INT NOT NULL,

    PRIMARY KEY (`uuid`)
)