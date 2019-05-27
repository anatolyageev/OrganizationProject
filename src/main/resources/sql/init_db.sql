CREATE TABLE organizations (
  id SERIAL NOT NULL CONSTRAINT organizations_key PRIMARY KEY,
  name VARCHAR(255),
  phone_number VARCHAR(255),
  adress VARCHAR(255),
  region VARCHAR(20),
  country VARCHAR(55),
  city VARCHAR(255),
  active BOOLEAN,
  specialization VARCHAR(255),
  office_number INTEGER
);


CREATE TABLE employees (
  id SERIAL NOT NULL CONSTRAINT employees_key PRIMARY KEY,
  name VARCHAR(255),
  surname VARCHAR(255),
  position VARCHAR(255),
  marital_status BOOLEAN,
  years_worked FLOAT8,
  organizations_id BIGINT NOT NULL,
  CONSTRAINT fk_organizations_employees_id FOREIGN KEY (organizations_id) REFERENCES organizations (id)
);