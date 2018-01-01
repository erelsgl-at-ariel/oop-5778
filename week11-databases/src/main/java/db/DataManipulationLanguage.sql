INSERT INTO employees (id,name,age,address,salary)
       VALUES (1, 'Paul', 32, 'California', 20000.00);

INSERT INTO employees (id,name,age,address,salary)
       VALUES (2, 'Allen', 25, 'Texas', 15000.00 ), 
              (3, 'Teddy', 23, 'Norway', 20000.00 ); 

INSERT INTO employees (id,name,age,salary)
       VALUES (4, 'Mark', 25, 65000.00 ); 

INSERT OR IGNORE INTO employees (id,name,age,address,salary)
       VALUES (1, 'Paul', 32, 'California', 20000.00);

UPDATE employees SET salary=25000 WHERE id=1 OR id=3;
       
DELETE FROM employees WHERE id IN (1,2,3,4);


/***********************************************/ 

INSERT OR IGNORE INTO teams(manager,member)
       VALUES (1,1), (1,2), (1,3), 
              (3,3), (3,4);

