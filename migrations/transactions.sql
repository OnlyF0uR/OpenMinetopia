CREATE TABLE IF NOT EXISTS mt_transactions
(
    `id`              INT(11)      NOT NULL AUTO_INCREMENT,

    `from_account_id` INT(11)      NOT NULL,
    `to_account_id`   INT(11)      NOT NULL,
    `amount`          VARCHAR(255) NOT NULL,

    `completed_at`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)