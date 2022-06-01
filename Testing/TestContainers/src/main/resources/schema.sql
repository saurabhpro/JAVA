DROP TABLE IF EXISTS customers;
CREATE TABLE IF NOT EXISTS customers
(
    id         int not null auto_increment primary key,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);
insert into customers (first_name, last_name)
values ('trisha', 'gee');
insert into customers (first_name, last_name)
values ('marco', 'behler');
insert into customers (first_name, last_name)
values ('saurabh', 'kumar');