CREATE DATABASE IF NOT EXISTS customerdb;
USE customerdb;
SELECT DATABASE();

CREATE TABLE customer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL
);

INSERT INTO customer (name) VALUES
('Alice'),
('Bob'),
('Charlie'),
('David'),
('Emma');

SELECT * FROM customer;
DESCRIBE customer;
