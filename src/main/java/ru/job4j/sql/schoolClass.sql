create table schoolClass(
	id serial primary key,
	name varchar(255)
);

create table student(
	id serial primary key,
	name varchar(255),
	schoolClass_id int references schoolClass(id)
);

insert into schoolClass(name) values ('3D');
insert into student(name, schoolClass_id) VALUES ('Liza', 1);
insert into student(name, schoolClass_id) VALUES ('Elena', 1);

select * from student;

select * from schoolClass where id in (select schoolClass_id from student);


