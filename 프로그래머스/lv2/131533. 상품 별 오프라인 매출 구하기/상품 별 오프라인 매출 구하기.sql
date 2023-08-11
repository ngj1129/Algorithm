select p.product_code as product_code, sum(o.sales_amount)*p.price as sales
from product p, offline_sale o
where p.product_id = o.product_id
group by o.product_id
order by sales desc, product_code asc;