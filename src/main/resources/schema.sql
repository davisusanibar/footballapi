CREATE TABLE `competition` (
    `id` varchar(255) NOT NULL,
    `area_name` varchar(255) DEFAULT NULL,
    `code` varchar(255) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `team` (
    `id` varchar(255) NOT NULL,
    `area_name` varchar(255) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `short_name` varchar(255) DEFAULT NULL,
    `tla` varchar(255) DEFAULT NULL,
    `competition_id` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_player` (`competition_id`),
    CONSTRAINT `fk_player` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`)
);

CREATE TABLE `player` (
    `id` varchar(255) NOT NULL,
    `country_of_birth` varchar(255) DEFAULT NULL,
    `date_of_birth` varchar(255) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `nationality` varchar(255) DEFAULT NULL,
    `position` varchar(255) DEFAULT NULL,
    `team_id` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_competition` (`team_id`),
    CONSTRAINT `fk_competition` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
);

