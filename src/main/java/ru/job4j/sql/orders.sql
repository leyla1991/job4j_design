CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

INSERT INTO orders(amount, customer_id) VALUES(3, 1);
INSERT INTO orders(amount, customer_id) VALUES(2, 5);
INSERT INTO orders(amount, customer_id) VALUES(3, 2);
INSERT INTO orders(amount, customer_id) VALUES(1, 3);
INSERT INTO orders(amount, customer_id) VALUES(4, 4);
INSERT INTO orders(amount, customer_id) VALUES(5, 1);

SELECT * FROM customers AS c
WHERE c.id NOT IN (SELECT customer_id FROM orders);

