# Write your MySQL query statement below
# NO.180.Consecutive Numbers
# https://leetcode.com/problems/consecutive-numbers/
select distinct Num ConsecutiveNums
from (
    select Num,
           lead(Num, 1, null) over(order by id) n2,
           lead(Num, 2, null) over(order by id) n3
    from Logs
     ) t1
where Num = n2 and Num = n3
