CREATE TABLE IF NOT EXISTS mt_storage
(
    `tag`      VARCHAR(16) NOT NULL, -- NBT tag of the item
    `size`     INT         NOT NULL, -- Size of the inventory (9 for purses, 18 for suitcases, 27 for backpacks)
    `contents` TEXT        NOT NULL, -- JSON version of the contents of the inventory

    PRIMARY KEY (`tag`)
)