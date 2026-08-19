-- # Write your MySQL query statement below
-- select contest_id,(count(r.user_id)/count(u.user_id)) as percentage
select contest_id,round((count(r.user_id)/(select count(user_id) from users))*100,2)  as percentage
from register r
group by contest_id
order by percentage desc,contest_id asc;