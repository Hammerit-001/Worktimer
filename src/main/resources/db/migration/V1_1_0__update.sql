CREATE TABLE if not exists departments
(
    department_id SERIAL PRIMARY KEY,
    department_name VARCHAR (100)

);

ALTER TABLE workers ADD COLUMN department_id BIGINT, ADD FOREIGN KEY (department_id) REFERENCES departments(department_id) ON DELETE RESTRICT;
