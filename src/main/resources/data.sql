DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
                            id INT AUTO_INCREMENT  PRIMARY KEY,
                            first_name VARCHAR(250) NOT NULL,
                            last_name VARCHAR(250) NOT NULL,
                            age VARCHAR(250) NOT NULL,
                            favourite_colour VARCHAR(250) NOT NULL

);

INSERT INTO Person (first_name, last_name, age, favourite_colour) VALUES
('John', 'Wick', '29','red'),
('Sarah', 'Raven', '54','blue'),
('Manu', 'Bouzas', '30','yellow');