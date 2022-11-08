create table driverLicense(
	id serial primary key,
	name int
);

create table driver(
	id serial primary key,
	name varchar(255),
	driverLicense_id int references driveLicense(id) unique
);
