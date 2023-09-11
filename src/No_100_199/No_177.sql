# Write your MySQL query statement below
# NO.177.Nth Highest Salary
# https://leetcode.com/problems/nth-highest-salary/
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        SELECT IFNULL(
                       (select salary
                        from(
                                select salary,
                                       rank() over(order by salary desc) rk
                                from Employee
                                group by salary
                            )t1
                        where rk=N),NULL) SecondHighestSalary
    );
END