# Write your MySQL query statement below
# NO.175.Combine Two Tables
# https://leetcode.com/problems/combine-two-tables/
select p.firstName as firstName, p.lastName as lastName, a.city as city, a.state as state
from Person p
left join Address a
on p.personId = a.personId