select m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') as review_date
from member_profile m, rest_review r
where m.member_id = r.member_id and
      r.member_id = (select ex.member_id
                     from (select member_id, count(member_id) as review_count
                           from rest_review
                           group by member_id) ex
                     group by ex.member_id
                     order by review_count desc
                     limit 1)
order by r.review_date asc, r.review_text asc;

/*
select m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') as review_date
from member_profile m, rest_review r
where m.member_id = r.member_id and
      r.member_id = (select ex.member_id
                     from (select member_id, count(member_id) as review_count
                           from rest_review
                           group by member_id) ex
                     group by ex.member_id
                     having ex.review_count >= max(ex.review_count))
order by r.review_date asc, r.review_text asc;
*/