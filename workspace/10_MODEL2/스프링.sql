select * from board;

--1차 작업 정렬
select idx, author, content, hit, ip, filename, state, postdate, lastmodified
from board
order by postdate desc;

--2차 작업 행 번호 붙이기
select rownum as rn, a.idx a.author, a.content, a.hit, a.ip, a.filename, a.state, a.postdate, a.lastmodified
from (select idx, author, content, hit, ip, filename, state, postdate, lastmodified
        from board
        order by postdate desc)a;
        
--3차 작업 번호 사이만 추출하기
select b.idx b.author, b.content, b.hit, b.ip, b.filename, b.state, b.postdate, b.lastmodified
from (select idx, author, content, hit, ip, filename, state, postdate, lastmodified
        from board
        order by postdate desc)a)b
where b.rn between ? and ?;