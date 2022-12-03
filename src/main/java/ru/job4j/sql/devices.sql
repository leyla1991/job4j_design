create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price)
VALUES
	('Наушники', 4000),
	('Часы', 5555),
	('Телефон', 6458);

INSERT INTO people(name)
VALUES
   ('Anna'),
   ('Lev'),
   ('Kate');

INSERT INTO devices_people(device_id, people_id)
VALUES
	(1, 1),
	(1, 3),
	(2, 2),
	(2, 3),
	(3, 1),
	(3, 2),
	(3, 3);

SELECT avg(price)
FROM devices;

SELECT people.name, avg(devices.price) AS Цена
FROM
	devices_people AS dp
	JOIN people
	on dp.people_id = people.id
	JOIN devices
	on dp.device_id = devices.id
GROUP by people.name
having avg(devices.price) > 5000;