CREATE TABLE IF NOT EXISTS mt_players
(
    `uuid`               VARCHAR(36)  NOT NULL,

    `shards`             DECIMAL      NOT NULL,
    `level`              INT          NOT NULL,
    `reputation`         INT          NOT NULL,
    `playtime`           VARCHAR(255) NOT NULL,
    `job`                VARCHAR(255) NOT NULL,

    `sidejob_id`         INT,
    `gang_id`            INT,
    `gang_rank`          INT,

    `primary_account_id` INT          NOT NULL,
    `current_chatcolour` VARCHAR(6)   NOT NULL,
    `current_namecolour` VARCHAR(6)   NOT NULL,

    `chat_colours`       TEXT         NOT NULL, -- Comma separated list of allowed chat colours
    `name_colours`       TEXT         NOT NULL, -- Comma separated list of allowed name colours

    PRIMARY KEY (`uuid`)
)