create table buses(
	id serial primary key,
	name int
);

create table passenger(
	id serial primary key,
	name varchar(255)
);

create table busStop(
	id serial primary key,
	passenger_id int references passenger(id),
	buses_id int references buses(id)
);

insert into buses(name) values (1);
insert into buses(name) values (3);
insert into buses(name) values (5);

insert into passenger(name) values ('Ivan');
insert into passenger(name) values ('Liza');
insert into passenger(name) values ('Anna');

insert into busStop(passenger_id, buses_id) values (1, 2);
insert into busStop(passenger_id, buses_id) values (1, 1);
insert into busStop(passenger_id, buses_id) values (2, 3);
insert into busStop(passenger_id, buses_id) values (2, 2);
insert into busStop(passenger_id, buses_id) values(3, 1);
insert into busStop(passenger_id, buses_id) values (3, 2);

select * from busStop;