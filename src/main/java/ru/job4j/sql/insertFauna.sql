create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('leo', 25, '1750-09-01');
insert into fauna(name, avg_age, discovery_date) values ('tigr', 24, '1800-09-01');
insert into fauna(name, avg_age, discovery_date) values ('rabbit', 10, '1500-10-01');
insert into fauna(name, avg_age, discovery_date) values ('fish', 16, '1010-08-21');
insert into fauna(name, avg_age, discovery_date) values ('turtle', 100, null);
