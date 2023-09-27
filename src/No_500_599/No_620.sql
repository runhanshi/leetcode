# Write your MySQL query statement below
# No.620.Not Boring Movies
# https://leetcode.com/problems/not-boring-movies
SELECT *
FROM Cinema AS c
WHERE c.description != "boring" AND c.id % 2 = 1
ORDER BY rating DESC