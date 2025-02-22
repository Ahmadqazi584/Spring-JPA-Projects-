INSERT INTO Product (name, price) VALUES
('Laptop', 1000),
('Smartphone', 700),
('Tablet', 500),
('Smartwatch', 300),
('Headphones', 150),
('Gaming Console', 600),
('Monitor', 250);

INSERT INTO order_table (id, order_date) VALUES
(1000, '2024-02-01'),
(1001, '2024-02-10'),
(1002, '2024-02-15');


INSERT INTO order_product (order_id, product_id, quantity) VALUES
(1000, 1, 2),  -- Order 1000 contains 2 Laptops
(1000, 3, 1),  -- Order 1000 contains 1 Tablet
(1001, 2, 3),  -- Order 1001 contains 3 Smartphones
(1001, 5, 1),  -- Order 1001 contains 1 Headphones
(1002, 4, 2),  -- Order 1002 contains 2 Smartwatches
(1002, 6, 1),  -- Order 1002 contains 1 Gaming Console
(1002, 7, 2);  -- Order 1002 contains 2 Monitors

