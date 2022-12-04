CREATE TABLE type(
	id INT PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE product(
	id INT PRIMARY KEY,
	name VARCHAR(50),
	type_id INT REFERENCES type(id),
	expired_date date,
	price DECIMAL(8,2)
);

INSERT INTO type(id, name)
VALUES
    (1, 'СЫР'),
	(2, 'МОЛОКО'),
	(3, 'КОЛБАСЫ');

INSERT INTO product(id, name, type_id, expired_date, price)
VALUES
	(1, 'Сыр плавленный', 1, '2022-02-23', 56.2),
	(2, 'Сыр твердый', 1, '2022-12-24', 656.4 ),
	(3, 'Мороженое 1 кг', 2, '2022-12-12', 556.01),
	(4, 'Кефир', 2, '2022-12-05', 65.99),
	(5, 'Молоко 3%', 2, '2022-12-07', 86.99),
	(6, 'Докторская', 3, '2022-12-12', 565.75),
	(7, 'Сырокопченая', 3, '2022-11-21', 656.34);
