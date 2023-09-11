# Write your MySQL query statement below
# NO.176.Second Highest Salary
# https://leetcode.com/problems/second-highest-salary/
select ifnull(
               select DISTINCT salary from Employee
               order by salary desc
                LIMIT 1 OFFSET 1
           ), null) as SecondHighestSalary