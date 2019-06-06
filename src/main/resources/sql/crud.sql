SELECT * FROM organizations;

SELECT * FROM employees;

SELECT * FROM organizations
WHERE id = 1;

SELECT * FROM employees
WHERE id = 1;

DELETE FROM organizations
WHERE id = 1;

DELETE FROM employees
WHERE id = 1;

-- доп поиск по критерию
-- Список стран организаций, в европейском регионе где врачей больше n, отсортированных в алфавитном порядке
SELECT DISTINCT t1.country
FROM organizations t1,
     ( SELECT employees.organizations_id,
              count(employees.id) AS emploee_num
       FROM employees
       GROUP BY employees.organizations_id) t2
WHERE t1.id = t2.organizations_id AND t2.emploee_num > 0 AND t1.region::text = 'EUROPE'::text
ORDER BY t1.country;