INSERT INTO grocery_item (name, price, quantity) VALUES ('Apple', 2.5, 100);
INSERT INTO grocery_item (name, price, quantity) VALUES ('Banana', 1.2, 200);
INSERT INTO grocery_item (name, price, quantity) VALUES ('Carrot', 1.0, 150);

INSERT INTO orders (user_id, total_price) VALUES (1, 0);
INSERT INTO orders (user_id, total_price) VALUES (2, 0);

INSERT INTO order_item (order_id, grocery_item_id, quantity, price) VALUES (1, 1, 10, 25);
INSERT INTO order_item (order_id, grocery_item_id, quantity, price) VALUES (1, 2, 5, 10);
INSERT INTO order_item (order_id, grocery_item_id, quantity, price) VALUES (2, 3, 15, 30);