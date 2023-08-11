select product_code, sales
from (select p.product_code, p.product_id, sum(o.sales_amount)*p.price as sales
      from product p, offline_sale o
      where p.product_id = o.product_id
      group by p.product_id) ex
order by sales desc, product_code asc;