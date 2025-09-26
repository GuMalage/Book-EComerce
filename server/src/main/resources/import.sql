-- Category
insert into tb_category (name) values ('Informática');
insert into tb_category (name) values ('UD');
insert into tb_category (name) values ('Cozinha');
insert into tb_category (name) values ('Móveis');
insert into tb_category (name) values ('Eletrônico');

-- Product
insert into tb_product (name, description, price, category_id) values ('Refrigerador 429L','Refrigerador 429L Branco, duplex....',1990.0,2);
insert into tb_product (name, description, price, category_id) values ('Notebook Arus 15.6','Notebook Arus 15.6 Core I7, 16Gb Ram...',2449.0,1);
insert into tb_product (name, description, price, category_id) values ('Monitor 27pol','Monitor Gamer 27pol 144Hz, 1ms',1129.99,1);
insert into tb_product (name, description, price, category_id) values ('Kit Teclado e Mouse','Kit com teclado ABNT e mouse com 5 botões',199.0,1);
insert into tb_product (name, description, price, category_id) values ('Smartphone XYZ','Smatphone com tela de 9pol, 12GB....',9999.0,5);
insert into tb_product (name, description, price, category_id) values ('TV LCD 75pol','TV LCD 75pol, 5 HDMI...',7555.0,5);
insert into tb_product (name, description, price, category_id) values ('Fogão 6 Bocas','Fogão 6 Bocas em aço inox, ...', 799.99,3);
insert into tb_product (name, description, price, category_id) values ('Roteador Wi-Fi 5.4GhZ','Roteador Wi-Fi 5.4GhZ, 6 antenas...',1299.0,1);
-- User - password: 123
INSERT INTO tb_user(display_name, username, password) VALUES ('Administrador', 'admin','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO tb_user(display_name, username, password) VALUES ('Teste', 'test','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');

--Address
INSERT INTO tb_address(user_id, logradouro, complement, cep) VALUES (1, 'Rua das Flores, 123', 'Apto 201', '80000-000');
INSERT INTO tb_address(user_id, logradouro, complement, cep) VALUES (1, 'Av. Central, 999', 'Bloco B', '81000-000');
INSERT INTO tb_address(user_id, logradouro, complement, cep) VALUES (2, 'Rua Teste, 45', NULL, '82000-000');

--Ordres
-- Pedido do usuário admin (id=1)
INSERT INTO tb_order (date_order, total_price, user_id) VALUES ('2025-09-26 18:45:00', 1990.00, 1); -- Refrigerador
INSERT INTO tb_order (date_order, total_price, user_id) VALUES ('2025-09-26 18:50:00', 2449.00, 1); -- Notebook
-- Pedido do usuário test (id=2)
INSERT INTO tb_order (date_order, total_price, user_id) VALUES ('2025-09-26 19:00:00', 1129.99, 2); -- Monitor
INSERT INTO tb_order (date_order, total_price, user_id) VALUES ('2025-09-26 19:05:00', 9999.00, 2); -- Smartphone

--OrderItems
-- Pedido 1: Refrigerador (admin)
INSERT INTO tb_order_item (unit_price, quantity, total_price_items, order_id, product_id) VALUES (1990.00, 1, 1990.00, 1, 1);
-- Pedido 2: Notebook (admin)
INSERT INTO tb_order_item (unit_price, quantity, total_price_items, order_id, product_id) VALUES (2449.00, 1, 2449.00, 2, 2);
-- Pedido 3: Monitor (test)
INSERT INTO tb_order_item (unit_price, quantity, total_price_items, order_id, product_id) VALUES (1129.99, 1, 1129.99, 3, 3);
-- Pedido 4: Smartphone (test)
INSERT INTO tb_order_item (unit_price, quantity, total_price_items, order_id, product_id) VALUES (9999.00, 1, 9999.00, 4, 5);




