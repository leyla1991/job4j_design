SELECT c.id, c.name AS car_name, cb.name AS body_name, ce.name AS engine_name, ct.name AS transmission_name
FROM
	cars c
	LEFT OUTER JOIN car_bodies cb ON cb.id = c.body_id
	LEFT OUTER JOIN car_engines ce ON ce.id = c.engine_id
	LEFT OUTER JOIN car_transmissions ct ON ct.id = c.transmission_id;

SELECT cb.name
FROM car_bodies cb LEFT JOIN cars c
	ON cb.id = c.body_id
WHERE c.body_id IS null;

SELECT ct.name
FROM car_transmissions ct LEFT JOIN cars c
	ON ct.id = c.transmission_id
WHERE transmission_id IS null;

SELECT ce.name
FROM car_engines ce LEFT JOIN cars c
	ON ce.id = c.engine_id
WHERE engine_id IS null;