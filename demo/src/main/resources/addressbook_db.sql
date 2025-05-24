CREATE TABLE address_book_model (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(100),
    phoneNumber VARCHAR(15)
);
SHOW TABLES;
DESCRIBE address_book_model;
INSERT INTO address_book_model(id,name,city,phoneNumber)
VALUES
(1,'Abhinav Karpur','Pune','9876543210'),
(2,'Jacob Richardson','Chennai','4567832411');
SELECT * FROM address_book_model;
