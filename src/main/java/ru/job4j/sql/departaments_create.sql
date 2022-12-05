CREATE TABLE departament(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE employees(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	departament_id INT REFERENCES departament(id)
);

INSERT INTO departament(name)
VALUES
('Гриффиндор'),
('ПУффендуй'),
('Слизерин'),
('Когтевран');

INSERT INTO employees(name, departament_id)
VALUES
('Malfoy', 3),
('Wizli', 1),
('Black', 1),
('Listrendge', 3),
('Potter', 1);