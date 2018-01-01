CREATE TABLE employees
(id        INT PRIMARY KEY     NOT NULL,
 name      TEXT    NOT NULL,
 age       INT     NOT NULL,
 address   CHAR(50),
 salary    REAL);


DROP TABLE employees;

DROP TABLE IF EXISTS employees;

/***********************************************/ 


CREATE TABLE IF NOT EXISTS teams
(manager   INT     NOT NULL,
 member    INT     NOT NULL
 );
 
DROP INDEX IF EXISTS teams_index;

CREATE UNIQUE INDEX teams_index 
ON teams(manager,member);

