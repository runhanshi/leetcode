# Write your MySQL query statement below
# NO.181.Employee Earning More Than Their Managers
# https://leetcode.com/problems/employees-earning-more-than-their-managers/
select a.Name  Employee
from Employee a
         join Employee b
              on a.ManagerId = b.id
where a.Salary>b.Salary