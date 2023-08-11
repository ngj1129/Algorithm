select p.product_id, p.product_name, sum(o.amount)*p.price as total_sales
from food_product p, food_order o
where p.product_id = o.product_id and
      o.produce_date like '2022-05-%'
group by p.product_id
order by total_sales desc, p.product_id asc;