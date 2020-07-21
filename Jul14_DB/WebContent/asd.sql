-- create table 테이블명(
--		필드명 자료형 옵션,
--		...
-- );
create table jul15_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null
);
-- insert into 테이블명 values(값, 값, ...);
insert into jul15_coffee values('에스프레소', 3000);
-- select * from 테이블명;
select * from jul15_coffee;

-- 총 데이터 수
select count(*) from JUL15_COFFEE;

-- 메뉴명 기준 정렬해서 4 ~ 6번까지 조회
select rownum, rn, c_name, c_price
from (
	select rownum as rn, c_name, c_price 
	from (
		select*
		from JUL15_COFFEE 
		order by c_name;
	)
)
where rn >= 4 and rn <= 6;

--
delete from jul15_coffee where c_name = '라떼';

update jul15_coffee
set c_price = 1000
where c_name = '물';









