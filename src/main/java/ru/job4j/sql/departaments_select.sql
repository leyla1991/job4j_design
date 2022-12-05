SELECT * FROM departament d LEFT JOIN employees e ON d.id = e.departament_id;

SELECT * FROM departament d RIGHT JOIN employees e ON d.id = e.departament_id;

SELECT * FROM departament d FULL JOIN employees e ON d.id = e.departament_id;

SELECT * FROM departament CROSS JOIN employees;

SELECT * FROM departament d LEFT JOIN employees e ON d.id = e.departament_id
WHERE e IS NULL;

SELECT * FROM departament d LEFT JOIN employees e ON d.id = e.departament_id;

SELECT d.id, d.name, e.id, e.name, departament_id
FROM departament d RIGHT JOIN employees e ON d.id = e.departament_id;