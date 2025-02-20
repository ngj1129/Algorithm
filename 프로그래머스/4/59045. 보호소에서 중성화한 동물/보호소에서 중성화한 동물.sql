select ins.animal_id, ins.animal_type, ins.name
from animal_ins as ins, animal_outs as outs
where ins.sex_upon_intake like 'intact%' and ins.animal_id = outs.animal_id and
        (outs.sex_upon_outcome like 'spayed%' or outs.sex_upon_outcome like 'neutered%')
order by ins.animal_id asc;