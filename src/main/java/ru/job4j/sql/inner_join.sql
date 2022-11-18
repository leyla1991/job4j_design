create table book(
	id serial primary key,
	name varchar(255),
	page int
);

create table author(
	id serial primary key,
	name varchar(255),
	book_id int references book(id)
);

insert into book(name, page) values ('Маленький принц', 255);
insert into book(name, page) values ('It', 405);
insert into book(name, page) values ('Shorts', 55);
insert into book(name, page) values ('Gamlet', 605);
insert into book(name, page) values ('Key', 900);

insert into author(name, book_id) values ('Экзепьюри', 1);
insert into author(name, book_id) values ('Кинг', 2);
insert into author(name) values ('Василий');
insert into author(name) values ('Порто');
insert into author(name, book_id) values ('Шекспир', 4);
insert into author(name) values ('Шекспириус');

select a.name, b.name, b.page
from author as a join book as b on a.book_id = b.id;

select a.name as Фамилия, b.name as Название, b.page as Страницы
from author as a join book as b on a.book_id = b.id;

select a.name as "Фамилия автора", b.name  Название, b.page Страницы
from author a join book b on a.book_id = b.id;