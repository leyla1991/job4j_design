CREATE TABLE car_bodies(
	id SERIAL PRIMARY KEY,
	name VARCHAR(30)
);

CREATE TABLE car_engines(
	id SERIAL PRIMARY KEY,
	name VARCHAR(30)
);

CREATE TABLE car_transmissions(
	id SERIAL PRIMARY KEY,
	name VARCHAR(30)
);

CREATE TABLE cars(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	body_id INT REFERENCES car_bodies(id),
	engine_id INT REFERENCES car_engines(id),
	transmission_id INT REFERENCES car_transmissions(id)
);

INSERT INTO car_bodies(name)
VALUES
('largus'),
('sedan'),
('hatchback'),
('station wagon');

INSERT INTO car_engines(name)
VALUES
('gaz'),
('electric');

INSERT INTO car_transmissions(name)
VALUES
('automate'),
('mechanics'),
('semi - automatic');

INSERT INTO cars(name, body_id, engine_id, transmission_id)
VALUES
('LOgan', 2, 1, 2),
('Ford', 4, 1, 3),
('Gelly', 1, 1, 1),
('BMW', 1, 2, 3),
('Tesla', 2, 2, 1);