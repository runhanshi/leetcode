# Write your MySQL query statement below
# No.577.Employee Bonus
# https://leetcode.com/problems/employee-bonus
SELECT name, bonus
FROM Employee AS e
         LEFT JOIN Bonus AS b
                   ON e.empId = b.empId
WHERE ifnull(b.bonus, 0) < 1000