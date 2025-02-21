select count(*) as fish_count, name.fish_name
from fish_info as info, fish_name_info as name
where info.fish_type = name.fish_type
group by name.fish_name
order by fish_count desc;