select name, datetime
from animal_ins
where animal_id not in (SELECT ins.animal_id
                            from animal_ins as ins, animal_outs outs
                            where ins.animal_id = outs.animal_id)
order by datetime asc
limit 3;