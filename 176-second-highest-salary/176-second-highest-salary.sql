# Write your MySQL query statement below
# SELECT MAX(SALARY) AS SECONDHIGHESTSALARY FROM EMPLOYEE WHERE SALARY < 
# (SELECT MAX(SALARY) FROM EMPLOYEE)

select 

(select distinct salary
 from employee
order by salary DESC
limit 1 offset 1)

as SecondHighestSalary