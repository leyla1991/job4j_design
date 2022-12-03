create table author(
	id serial primary key,
	name varchar(255)
);

create table book(
	id serial primary key,
	name varchar(255),
	page int,
	author_id int references author(id)
);

insert into author(name) values ('Экзепьюри');
insert into author(name) values ('Кинг');
insert into author(name) values ('Василий');
insert into author(name) values ('Порто');
insert into author(name) values ('Шекспир');
insert into author(name) values ('Шекспириус');

insert into book(name, page, author_id) values ('Маленький принц', 255, 1);
insert into book(name, page, author_id) values ('It', 405, 2);
insert into book(name, page) values ('Shorts', 55);
insert into book(name, page, author_id) values ('Gamlet', 605, 5);
insert into book(name, page) values ('Key', 900);

select a.name, b.name, b.page
from author as a join book as b on b.author_id = a.id;

select a.name as Фамилия, b.name as Название, b.page as Страницы
from author as a join book as b on b.author_id = a.id;

select a.name as "Фамилия автора", b.name  Название, b.page Страницы
from author a join book b on b.author_id = a.id;