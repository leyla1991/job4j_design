SELECT product.name
FROM
	product INNER JOIN type
	ON product.type_id = type.id
WHERE type.name = 'СЫР';

SELECT name
FROM product
WHERE name LIKE ('%мороженое') OR name LIKE('Мороженое%');

SELECT name
FROM product
WHERE expired_date <= current_date;

SELECT name, MAX(price) AS max_price
FROM product
GROUP BY name, price
HAVING price = MAX(price);

SELECT type.name, COUNT(product.name) AS Количество
FROM
	product INNER JOIN type
	ON product.type_id = type.id
GROUP BY type.name;

SELECT product.name, type.name
FROM
	product INNER JOIN type
	ON product.type_id = type.id
GROUP BY product.name, type.name
HAVING type.name = 'СЫР' OR type.name = 'МОЛОКО';

SELECT type.name, COUNT(product.name) AS Количество
FROM
	product INNER JOIN type
	ON product.type_id = type.id
GROUP BY type.name
HAVING COUNT(product.name) < 10;

SELECT product.name, type.name
FROM
	product INNER JOIN type
	ON product.type_id = type.id;