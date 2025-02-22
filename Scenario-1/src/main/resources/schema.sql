CREATE TABLE department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    location VARCHAR(255)
);


CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    salary INT,
    depart_id BIGINT,
    CONSTRAINT fk_employee_department FOREIGN KEY (depart_id) REFERENCES department (id)
);