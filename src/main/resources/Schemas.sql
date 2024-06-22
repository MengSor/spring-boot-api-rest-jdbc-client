DROP TABLE IF EXISTS Account;
drop table if exists my_order_address_table;
drop table if exists my_order_table;

CREATE TABLE Account (
                      id varchar(255) NOT NULL,
                      name varchar(255) NOT NULL,
                      email varchar(255) NOT NULL,
                      PRIMARY KEY (id)
);

