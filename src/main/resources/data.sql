DROP TABLE IF EXISTS Hobby;
DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
                            id INT AUTO_INCREMENT  PRIMARY KEY,
                            first_name VARCHAR(250) NOT NULL,
                            last_name VARCHAR(250) NOT NULL,
                            age VARCHAR(250) NOT NULL,
                            favourite_colour VARCHAR(250) NOT NULL

);

/*INSERT INTO Person (first_name, last_name, age, favourite_colour) VALUES
('John', 'Wick', '29','red'),
('Sarah', 'Raven', '54','blue'),
('Isa', 'Lema', '25','red'),
('Manu', 'Bouzas', '30','yellow');*/

CREATE TABLE Hobby (
    id_hobby INT AUTO_INCREMENT PRIMARY KEY ,
    person_id INT,
    hobbies VARCHAR(250),
    foreign key (person_id) references Person(id) ON DELETE CASCADE
    );

--INSERT INTO Hobby (person_id, hobbies) VALUES
--(1, 'shopping'),
--(1, 'football'),
--(2, 'chess'),
--(3, 'tv shows');


