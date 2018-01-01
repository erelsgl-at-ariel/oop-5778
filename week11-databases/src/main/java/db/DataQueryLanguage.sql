SELECT * FROM employees;

SELECT id, name, age 
FROM employees 
WHERE id=1;

SELECT name, age 
FROM employees 
WHERE salary>=20000;

SELECT MAX(age)
FROM employees 
WHERE salary>=20000;

SELECT age, COUNT(*), AVG(salary)
FROM employees 
GROUP BY age;

/***********************************************/ 

SELECT *
FROM   employees INNER JOIN teams ON(employees.id=teams.member);

SELECT employees.*, teams.manager AS manager_id
FROM   employees INNER JOIN teams ON(employees.id=teams.member);

SELECT employees1.*, employees2.name AS manager_name
FROM   employees AS employees1
INNER JOIN teams ON(employees1.id=teams.member)
INNER JOIN employees AS employees2 ON(employees2.id=teams.manager);

SELECT teams.manager AS manager_id, COUNT(*) AS num_of_workers, AVG(salary) AS avg_salary
FROM   employees INNER JOIN teams ON(employees.id=teams.member)
GROUP BY manager_id;

