# Write your MySQL query statement below
# NO.182 Duplicate Emails
# https://leetcode.com/problems/duplicate-emails/
select Email
from Person
group by Email
having count(*) > 1