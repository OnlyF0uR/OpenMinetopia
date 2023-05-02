CREATE TABLE IF NOT EXISTS mt_accounts
(
    `id` INT
(
    11
) NOT NULL AUTO_INCREMENT,

    `name` VARCHAR
(
    255
) NOT NULL,
    `display_name` VARCHAR
(
    255
) NOT NULL,
    `bank_id` VARCHAR
(
    255
) NOT NULL,
    `balance` DOUBLE
(
    11,
    2
) NOT NULL,

    `owner_uuids` VARCHAR
(
    255
), -- Comma separated list of UUIDs
    PRIMARY KEY
(
    `id`
)
    )