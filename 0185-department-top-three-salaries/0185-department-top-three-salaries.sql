select d.name as Department, e.name as Employee, e.salary as salary
FROM (
    SELECT e.*,
        DENSE_RANK() OVER (
            PARTITION BY departmentId
            ORDER BY salary DESC
        ) AS rnk
    FROM Employee e
) e
JOIN Department d
ON e.departmentId = d.id
WHERE e.rnk <= 3;
