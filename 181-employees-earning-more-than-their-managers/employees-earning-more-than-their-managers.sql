# Write your MySQL query statement below
select name As Employee from Employee e1 where salary>(select salary from Employee e2 where e2.id=e1.managerId);