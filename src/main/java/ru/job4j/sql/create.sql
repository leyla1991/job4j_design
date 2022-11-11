create table roles(
	id serial primary key,
	name varchar(255)
);

create table category(
	id serial primary key,
	number int,
	name varchar(255)
);

create table stateItem(
	id serial primary key,
	name varchar(255)
);

create table users(
	id serial primary key,
	name varchar(255),
	roles_id int references roles(id)
);

create table item(
	id serial primary key,
	number int,
	name varchar(255),
	category_id int references category(id),
	stateItem_id int references stateItem(id),
	users_id int references users(id)
);




create table rules(
	id serial primary key,
	name text
);

create table commentsItem(
	id serial primary key,
	name text,
	item_id int references item(id)
);



create table attachs(
	id serial primary key,
	name varchar(255),
	item_id int references item(id)
);

create table roles_rules(
	id serial primary key,
	roles_id int references roles(id),
	rules_id int references rules(id)
);
