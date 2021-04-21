# view : 가상의 테이블 (뷰를 만들기 위한 쿼리문장만 저장)

create  or replace view emp50
as 
select empid , fname,email, salary,deptid
from emp
where deptid = 50;


select empid, fname, salary 
from emp50
where salary >=7000;

-- empdept : empid, fname, deptid, deptname

create view empdept 
as
select  empid, fname, e.deptid, deptname
from emp e, dept d
where e.deptid = d.deptid;

select count(*)
from empdept;

desc empdept;

-- emp50:empid


# err (non updatable view) 낫널인 부분 있어서 업데이트 안됨.
insert into emp50 values(777,'bill','bill', 15000, 30);
# 에러 나는데 외 에러가 나죠?
#emp50 테이블에 집어 넣었는데 5개 컬럼만 집어넣고 emp 테이블의 나머지 컬럼(lname, 이런거엔 값을 줄 수 없는 상황)


-- check option 을 가진 뷰

create or replace view emp_2050
as
select empid, fname, lname, hdate, jobid, deptid
from emp 
where deptid in(20,50)
with check option;

select count(*) from emp_2050;
#insert는 됨. 왜냐면 여기에 인서트 하면 emp에 인서트 되서 들어감.

insert into emp_2050 values(888,'kim', 'genie', sysdate(),' IT_PRG', 20);


insert into emp_2050 values(888,'kim', 'genie', sysdate(), 20);


# index

create index deptid_idx on emp(deptid);

#function 
select fname, comm, if(comm, 1,0), 'if',
ifnull(comm,'none') 'ifnull' ,coalesce(comm, 'none') 'coalesce'
from emp;

#널이 아니면 자기값 넣고 널이면 대체값 넣음

select empid, fname salary,
case
	when salary > 15000 then 'high'
    when salary > 8000 then 'mid'
    else 'low'
    end grade
from emp;

