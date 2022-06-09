DROP TABLE IF EXISTS tbl_regions;

CREATE TABLE tbl_regions (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);


DROP TABLE IF EXISTS tbl_customers;

CREATE TABLE tbl_customers (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  number_id VARCHAR(8) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(30) UNIQUE,
  photo_url VARCHAR(50),
  state VARCHAR(50),
  region_id BIGINT
);