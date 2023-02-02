CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

INSERT INTO customers(first_name, last_name, age, country) VALUES('Anna','Andreeva', 15, 'Vladimir');
INSERT INTO customers(first_name, last_name, age, country) VALUES('Nikolya','Andreev', 23, 'Vladimir');
INSERT INTO customers(first_name, last_name, age, country) VALUES('Sveta','Petrov', 12, 'Moscow');
INSERT INTO customers(first_name, last_name, age, country) VALUES('Michail','Andreeva', 15, 'Saratov');
INSERT INTO customers(first_name, last_name, age, country) VALUES('Anna','Ivanova', 22, 'Sankt-Peterburg');
INSERT INTO customers(first_name, last_name, age, country) VALUES('Ostap','Bender', 38, 'Odessa');
INSERT INTO customers(first_name, last_name, age, country) VALUES('Olga','Kolceva', 17, 'Vladimir');


SELECT * FROM customers
WHERE age = (SELECT MIN(age) FROM customers);