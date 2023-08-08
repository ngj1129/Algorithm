select i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, ex.score
from rest_info i, (select rest_id, round(avg(review_score), 2) as score
                   from rest_review
                   group by rest_id) ex
where i.address like '서울%' and i.rest_id = ex.rest_id
order by ex.score desc, i.favorites desc;   
      