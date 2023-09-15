# Write your MySQL query statement below
# No.584.Find Customer Referee
# https://leetcode.com/problems/find-customer-referee/
SELECT name FROM Customer
WHERE ifnull(referee_id,0) != 2;