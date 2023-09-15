# Write your MySQL query statement below
# No.602.Friend Requests II: Who has the Most Friends
# https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/
WITH T AS(
    SELECT requester_id, accepter_id FROM RequestAccepted
    UNION
    SELECT accepter_id, requester_id FROM RequestAccepted
)
SELECT requester_id AS id, count(accepter_id) AS num
FROM T
GROUP BY 1
ORDER BY 2 DESC
LIMIT 1;