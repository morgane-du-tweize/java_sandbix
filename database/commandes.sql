CREATE DATABASE sandbox;

CREATE TABLE IF NOT EXISTS users (
    id_user SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR (80) NOT NULL,
    password VARCHAR (80) NOT NULL,
    connection_number  SMALLINT UNSIGNED NOT NULL DEFAULT 0
);
