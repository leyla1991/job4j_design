insert into roles(name) values ('Romeo');
insert into roles(name) values ('Julieta');
insert into roles(name) values ('Rozalin');

insert into category(number, name) values (1, 'first');
insert into category(number, name) values (2, 'second');
insert into category(number, name) values (3, 'third');

insert into stateItem(name) values ('close');
insert into stateItem(name) values ('open');

insert into users(name, roles_id) values ('Ivan', 1);
insert into users(name, roles_id) values ('Anna', 2);
insert into users(name, roles_id) values ('Luiza', 2);
insert into users(name, roles_id) values ('Anton', 1);
insert into users(name, roles_id) values ('Anastasia', 2);

insert into item(number, name, category_id, stateItem_id, users_id) values ((1), 'find Man', 1, 2, 1);
insert into item(number, name, category_id, stateItem_id, users_id) values ((1), 'find Women', 2, 1, 2);
insert into item(number, name, category_id, stateItem_id, users_id) values ((1), 'find Women', 3, 2, 2);

insert into rules(name) values ('лунный свет');
insert into rules(name) values ('Romeo!');
insert into rules(name) values ('Noo');

insert into commentsItem(name, item_id) values ('bravo', 1);
insert into commentsItem(name, item_id) values ('no', 2);
insert into commentsItem(name, item_id) values ('brave', 3);

insert into attachs(name, item_id) values ('rules', 1);
insert into attachs(name, item_id) values ('rules', 2);
insert into attachs(name, item_id) values ('rules', 3);

insert into roles_rules(roles_id, rules_id) values (1, 1);
insert into roles_rules(roles_id, rules_id) values (2, 2);
insert into roles_rules(roles_id, rules_id) values (3, 3);
insert into roles_rules(roles_id, rules_id) values (2, 1);
