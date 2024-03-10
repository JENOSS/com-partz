
-- category --

insert into category(name, sort_order) values( 'CPU', 0);
insert into category(name, sort_order) values( 'RAM', 1);
insert into category(name, sort_order) values( 'VGA', 2);
insert into category(name, sort_order) values( 'POWER', 3);


-- banner --

insert into banner( name) values( '특가 이벤트');
insert into banner( name) values( '할인 이벤트');
insert into banner( name) values( '웰컴 이벤트');

-- product --

insert into product( name, price, created_datetime, category_id) values ( 'CPU 1', 13000, '2024-03-08 00:00:00', 1);
insert into product( name, price, created_datetime, category_id) values ( 'CPU 2', 11000, '2024-03-08 00:00:10', 1);
insert into product( name, price, created_datetime, category_id) values ( 'CPU 3', 15000, '2024-03-08 00:00:20', 1);

insert into product( name, price, created_datetime, category_id) values ( 'RAM 1', 16000, '2024-03-08 00:00:00', 2);
insert into product( name, price, created_datetime, category_id) values ( 'RAM 2', 17000, '2024-03-08 00:00:10', 2);
insert into product( name, price, created_datetime, category_id) values ( 'RAM 3', 18000, '2024-03-08 00:00:20', 2);

insert into product( name, price, created_datetime, category_id) values ( 'VGA 1', 16000, '2024-03-08 00:00:00', 3);
insert into product( name, price, created_datetime, category_id) values ( 'VGA 2', 33000, '2024-03-08 00:00:10', 3);
insert into product( name, price, created_datetime, category_id) values ( 'VGA 3', 32000, '2024-03-08 00:00:20', 3);

insert into product( name, price, created_datetime, category_id) values ( 'POWER 1', 22000, '2024-03-08 00:00:00', 4);
insert into product( name, price, created_datetime, category_id) values ( 'POWER 2', 42000, '2024-03-08 00:00:10', 4);
insert into product( name, price, created_datetime, category_id) values ( 'POWER 3', 33000, '2024-03-08 00:00:20', 4);

-- recommend --

insert into recommend( product_id) values( 1);
insert into recommend( product_id) values( 2);
insert into recommend( product_id) values( 4);
insert into recommend( product_id) values( 5);
insert into recommend( product_id) values( 7);
insert into recommend( product_id) values( 8);
insert into recommend( product_id) values( 9);

-- raffle --

insert into raffle( product_id) values( 12);

-- order --

insert into orders( amount, created_datetime, user_id) values( 24000, '2024-03-08 00:00:00', 1);
insert into orders( amount, created_datetime, user_id) values( 33000, '2024-03-08 00:00:00', 1);
insert into orders( amount, created_datetime, user_id) values( 64000, '2024-03-08 00:00:00', 2);

-- order detail --

insert into order_detail( count, product_id, order_id) values( 1, 1, 1);
insert into order_detail( count, product_id, order_id) values( 1, 2, 1);
insert into order_detail( count, product_id, order_id) values( 1, 4, 2);
insert into order_detail( count, product_id, order_id) values( 1, 5, 2);
insert into order_detail( count, product_id, order_id) values( 1, 10, 3);
insert into order_detail( count, product_id, order_id) values( 1, 11, 3);

-- cart item --

insert into cart_item( count, user_id, product_id) values( 1, 1, 1);

-- user --

insert into users( mail, name, nick_name, phone, password) values( 'nari1539@naver.com', '박진우', 'zeno', '010-111-1111', '$2a$10$LDi0CugZIp1m4QVuWCuAK./rDFA3aeBCVraqvLtWOCV5Jq3mQbYxu')

-- Temp Access Token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTcxMDY3OTIzMn0.Vsm49JC2EYCyp3FjclbNBWnv6sL2vOOVk51wWCQ1ib0
-- API 호출시 헤더 => Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTcxMDY3OTIzMn0.Vsm49JC2EYCyp3FjclbNBWnv6sL2vOOVk51wWCQ1ib0
