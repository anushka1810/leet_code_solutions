# Write your MySQL query statement below
select  activity_date as day ,count(distinct user_id) as active_users
from activity a
where DateDiff('2019-07-27', a.activity_date)<30 and DateDiff('2019-07-27', a.activity_date)>=0
group by activity_date
order by activity_date;
-- select distinct count(user_id) from activity;