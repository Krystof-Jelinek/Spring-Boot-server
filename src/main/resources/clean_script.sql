DELETE FROM order_not_keyword_employees;
DELETE FROM order_not_keyword;
DELETE FROM vehicle;
DELETE FROM employee;

ALTER SEQUENCE employee_sequence RESTART WITH 1;
ALTER SEQUENCE order_sequence RESTART WITH 1;
ALTER SEQUENCE vehicle_sequence RESTART WITH 1;