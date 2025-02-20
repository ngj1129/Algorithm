select ins.animal_id, ins.name
from animal_ins as ins, animal_outs as outs
where ins.animal_id = outs.animal_id and ins.datetime > outs.datetime
order by ins.datetime asc;