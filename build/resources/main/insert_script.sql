DELETE FROM order_not_keyword_employees;
DELETE FROM order_not_keyword;
DELETE FROM vehicle;
DELETE FROM employee;

ALTER SEQUENCE employee_sequence RESTART WITH 11;
ALTER SEQUENCE order_sequence RESTART WITH 11;
ALTER SEQUENCE vehicle_sequence RESTART WITH 11;

INSERT INTO Employee (id, first_name, last_name, birth_date) VALUES (1, 'John', 'Doe', '1990-01-15');
INSERT INTO Employee (id, first_name, last_name, birth_date) VALUES (2, 'Jane', 'Smith', '1985-07-22');
INSERT INTO Employee (id, first_name, last_name, birth_date) VALUES (3, 'Alice', 'Johnson', '1988-03-10');
INSERT INTO Employee (id, first_name, last_name, birth_date) VALUES (4, 'Bob', 'Williams', '1995-12-05');
INSERT INTO Employee (id, first_name, last_name, birth_date) VALUES (5, 'Emily', 'Davis', '1983-09-18');
INSERT INTO Employee (id, first_name, last_name, birth_date) VALUES (6, 'Michael', 'Brown', '1992-06-27');
INSERT INTO Employee (id, first_name, last_name, birth_date) VALUES (7, 'Samantha', 'Miller', '1987-11-08');
INSERT INTO Employee (id, first_name, last_name, birth_date) VALUES (8, 'Daniel', 'Moore', '1998-04-14');
INSERT INTO Employee (id, first_name, last_name, birth_date) VALUES (9, 'Olivia', 'Martin', '1984-02-23');
INSERT INTO Employee (id, first_name, last_name, birth_date) VALUES (10, 'Andrew', 'Taylor', '1991-08-31');

INSERT INTO Vehicle (id, spz, color, equipment_level) VALUES (1, 'ABC123', 'Blue', 2);
INSERT INTO Vehicle (id, spz, color, equipment_level) VALUES (2, 'XYZ789', 'Red', 3);
INSERT INTO Vehicle (id, spz, color, equipment_level) VALUES (3, 'DEF456', 'Green', 1);
INSERT INTO Vehicle (id, spz, color, equipment_level) VALUES (4, 'GHI789', 'Black', 4);
INSERT INTO Vehicle (id, spz, color, equipment_level) VALUES (5, 'JKL012', 'White', 2);
INSERT INTO Vehicle (id, spz, color, equipment_level) VALUES (6, 'MNO345', 'Silver', 3);
INSERT INTO Vehicle (id, spz, color, equipment_level) VALUES (7, 'PQR678', 'Yellow', 1);
INSERT INTO Vehicle (id, spz, color, equipment_level) VALUES (8, 'STU901', 'Purple', 4);
INSERT INTO Vehicle (id, spz, color, equipment_level) VALUES (9, 'VWX234', 'Orange', 2);
INSERT INTO Vehicle (id, spz, color, equipment_level) VALUES (10, 'YZA567', 'Brown', 3);

INSERT INTO order_not_keyword (id, cost, date_of_payment, vehicle_id) VALUES (1, 100, '2023-01-15', 1);
INSERT INTO order_not_keyword (id, cost, date_of_payment, vehicle_id) VALUES (2, 75, '2023-07-22', 2);
INSERT INTO order_not_keyword (id, cost, date_of_payment, vehicle_id) VALUES (3, 120, '2023-03-10', 3);
INSERT INTO order_not_keyword (id, cost, date_of_payment, vehicle_id) VALUES (4, 200, '2023-12-05', 5);
INSERT INTO order_not_keyword (id, cost, date_of_payment, vehicle_id) VALUES (5, 55, '2023-09-18', 8);
INSERT INTO order_not_keyword (id, cost, date_of_payment, vehicle_id) VALUES (6, 90, '2023-06-27', 6);
INSERT INTO order_not_keyword (id, cost, date_of_payment, vehicle_id) VALUES (7, 150, '2023-11-08', 8);
INSERT INTO order_not_keyword (id, cost, date_of_payment, vehicle_id) VALUES (8, 180, '2023-04-14', 9);
INSERT INTO order_not_keyword (id, cost, date_of_payment, vehicle_id) VALUES (9, 40, '2023-02-23', 1);
INSERT INTO order_not_keyword (id, cost, date_of_payment, vehicle_id) VALUES (10, 95, '2023-08-31', 1);

INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (1 , 1);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (2 , 2);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (3 , 3);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (4 , 4);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (5 , 5);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (6 , 6);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (7 , 7);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (8 , 8);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (9 , 9);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (10 , 10);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (10 , 1);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (10 , 2);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (9 , 2);
INSERT INTO order_not_keyword_employees (orders_id, employees_id) VALUES (8 , 2);