select flavor
from ((select flavor, total_order from first_half)
       union all
      (select flavor, sum(total_order) as total_order from july group by flavor)) ex
group by flavor
order by sum(total_order) desc
limit 3;

