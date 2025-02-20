# select info.item_id, info.item_name, info.rarity
# from item_info as info, item_tree as tree
# where info.item_id = tree.item_id and tree.parent_item_id 
#     in (select distinct tree.parent_item_id 
#       from item_info as info, item_tree as tree 
#       where info.rarity = 'rare' and info.item_id = tree.item_id and tree.parent_item_id is not null)
# order by info.item_id desc;

select item_id, item_name, rarity
from item_info
where item_id in (select item_id
                    from item_tree
                    where parent_item_id in (select item_id
                            from item_info
                            where rarity = 'rare'))
order by item_id desc;