CREATE TABLE Product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL
);

CREATE TABLE order_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE NOT NULL
);

CREATE TABLE order_product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT,
    product_id BIGINT,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES order_table(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(id) ON DELETE CASCADE
);
