
-- category --

insert into category(id, name, sort_order) values(0, 'CPU', 0);
insert into category(id, name, sort_order) values(1, 'RAM', 1);
insert into category(id, name, sort_order) values(2, 'VGA', 2);
insert into category(id, name, sort_order) values(3, 'POWER', 3);


-- banner --

insert into banner(id, name) values(0, '특가 이벤트');
insert into banner(id, name) values(1, '할인 이벤트');
insert into banner(id, name) values(2, '웰컴 이벤트');

-- product --

insert into product(id, name, price, created_datetime, category_id) values (0, 'CPU 1', 13000, '2024-03-08 00:00:00', 0);
insert into product(id, name, price, created_datetime, category_id) values (1, 'CPU 2', 11000, '2024-03-08 00:00:10', 0);
insert into product(id, name, price, created_datetime, category_id) values (2, 'CPU 3', 15000, '2024-03-08 00:00:20', 0);

insert into product(id, name, price, created_datetime, category_id) values (3, 'RAM 1', 16000, '2024-03-08 00:00:00', 1);
insert into product(id, name, price, created_datetime, category_id) values (4, 'RAM 2', 17000, '2024-03-08 00:00:10', 1);
insert into product(id, name, price, created_datetime, category_id) values (5, 'RAM 3', 18000, '2024-03-08 00:00:20', 1);

insert into product(id, name, price, created_datetime, category_id) values (6, 'VGA 1', 16000, '2024-03-08 00:00:00', 2);
insert into product(id, name, price, created_datetime, category_id) values (7, 'VGA 2', 33000, '2024-03-08 00:00:10', 2);
insert into product(id, name, price, created_datetime, category_id) values (8, 'VGA 3', 32000, '2024-03-08 00:00:20', 2);

insert into product(id, name, price, created_datetime, category_id) values (9, 'POWER 1', 22000, '2024-03-08 00:00:00', 3);
insert into product(id, name, price, created_datetime, category_id) values (10, 'POWER 2', 42000, '2024-03-08 00:00:10', 3);
insert into product(id, name, price, created_datetime, category_id) values (11, 'POWER 3', 33000, '2024-03-08 00:00:20', 3);

-- recommend --

insert into recommend(id, product_id) values(0, 0);
insert into recommend(id, product_id) values(1, 1);
insert into recommend(id, product_id) values(2, 3);
insert into recommend(id, product_id) values(3, 4);
insert into recommend(id, product_id) values(4, 6);
insert into recommend(id, product_id) values(5, 8);
insert into recommend(id, product_id) values(6, 10);

-- raffle --

insert into raffle(id, product_id) values(0, 11);
