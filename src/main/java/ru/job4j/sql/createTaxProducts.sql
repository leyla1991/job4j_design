create or replace function tax()
	returns trigger as
$$
	BEGIN
		update products
		set price = price + price * 0.2
		where id = (select id from inserted);
		return new;
	END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
	after insert on products
	referencing new table as inserted
	for each statement
	execute procedure tax();

insert INTO products(name, producer, count, price)
VALUES
('egg', 'producer_1', 4, 30),
('milk', 'producer_1', 5, 60),
('book', 'producer_2', 2, 120);

SELECT*FROM products;

create or replace function tax_before()
	returns trigger as
$$
	BEGIN
		NEW.price = NEW.price + NEW.price * 0.2;
		return NEW;
	END;
$$
LANGUAGE 'plpgsql';

create trigger tax_row_trigger
	before insert
	on products
	for each row
	execute procedure tax();

insert INTO products(name, producer, count, price)
VALUES
('comics', 'producer_2', 6, 100),
('drink', 'producer_1', 4, 50),
('salt', 'producer_1', 5, 20);

SELECT*FROM products;