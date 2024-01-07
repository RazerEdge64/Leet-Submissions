# Write your MySQL query statement below
select distinct p1.email as Email from Person p1 where email in (select email from Person p2 where p2.id != p1.id)