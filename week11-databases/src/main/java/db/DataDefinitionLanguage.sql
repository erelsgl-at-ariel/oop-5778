CREATE TABLE employees
(id        INT PRIMARY KEY     NOT NULL,
 name      TEXT    NOT NULL,
 age       INT     NOT NULL,
 address   CHAR(50),
 salary    REAL);
 
CREATE TABLE IF NOT EXISTS employees
(id        INT PRIMARY KEY     NOT NULL,
 name      TEXT    NOT NULL,
 age       INT     NOT NULL,
 address   CHAR(50),
 salary    REAL);
 

DROP TABLE employees;

DROP TABLE IF EXISTS employees;
