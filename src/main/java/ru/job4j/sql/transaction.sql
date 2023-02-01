insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 66);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 7, 50);

begin transaction;

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_1', 2, 50);

savepoint f_savepoint;

update products set count = 3 where price > 60;

savepoint second_savepoint;

delete from products where count = 3;

select * from products;

rollback to second_savepoint;

select * from products;

delete from products where price < 49;

savepoint t_savepoint;

select * from products;

rollback to f_savepoint;

select * from products;

commit transaction;
