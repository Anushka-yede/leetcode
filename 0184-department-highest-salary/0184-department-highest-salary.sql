select d.name as Department, e.name as Employee, e.salary as Salary
from Employee e
Left join Department d
on e.departmentId = d.id
where e.salary = (Select max(salary) from Employee where departmentId = e.departmentId);