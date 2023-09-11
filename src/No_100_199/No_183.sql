# Write your MySQL query statement below
# NO.182.Customers Who Never Order
# https://leetcode.com/problems/customers-who-never-order/
select Name as Customers
from Customers c
left join Orders o
on c.Id = o.CustomerId
where o.id is null