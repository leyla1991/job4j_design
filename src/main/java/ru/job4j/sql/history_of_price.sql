create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

CREATE OR REPLACE FUNCTION history_insert()
	RETURNS trigger AS
$$
BEGIN
	INSERT INTO history_of_price(name, price, date) VALUES(NEW.name, NEW.price, current_date);
	return NEW;
END
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER hop_insert
	AFTER INSERT
	ON products
	FOR EACH ROW
	EXECUTE PROCEDURE history_insert();

insert INTO products(name, producer, count, price)
VALUES
('comics', 'producer_2', 6, 100),
('drink', 'producr_1', 4, 50),
('salt', 'producr_1', 5, 20);


SELECT*FROM history_of_price;