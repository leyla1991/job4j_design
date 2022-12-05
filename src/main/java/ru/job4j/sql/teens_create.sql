CREATE TABLE teens(
		id SERIAL PRIMARY KEY,
		name VARCHAR(50),
		gender VARCHAR(30)
);

INSERT INTO teens(name, gender)
VALUES
('Anna','ж'),
('Антон','м'),
('Лиза','ж'),
('Саша','м'),
('Саша','ж');

SELECT m.name AS name_1, m.gender AS m, w.name AS name_2, w.gender AS w
FROM teens m CROSS JOIN teens w
WHERE m.gender != w.gender;