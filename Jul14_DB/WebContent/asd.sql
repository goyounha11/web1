-- create table ���̺��(
--		�ʵ�� �ڷ��� �ɼ�,
--		...
-- );
create table jul15_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null
);
-- insert into ���̺�� values(��, ��, ...);
insert into jul15_coffee values('����������', 3000);
-- select * from ���̺��;
select * from jul15_coffee;

-- �� ������ ��
select count(*) from JUL15_COFFEE;

-- �޴��� ���� �����ؼ� 4 ~ 6������ ��ȸ
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
delete from jul15_coffee where c_name = '��';

update jul15_coffee
set c_price = 1000
where c_name = '��';









