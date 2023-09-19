# Write your MySQL query statement below
# No.610.Triangle Judgement
# https://leetcode.com/problems/triangle-judgement
SELECT *,
       if (x + y > z AND x + z > y AND y + z > x, 'Yes', 'No')AS triangle
FROM Triangle