use testdb;
use ssafydb;

#join 
-- cross join
create table tmp
as
select empid, fname, deptname 
from emp e, dept d;

-- empid, fname, deptname
select empid, fname, deptname 
from emp e, dept d
where e.deptid = d.deptid
order by empid;

-- join~on
select empid, fname, deptname 
from emp e inner join dept d
on e.deptid = d.deptid
order by empid;

-- join~using(공통컬럼명)
select empid, fname, deptname 
from emp e join dept d
using (deptid)
order by empid;

-- empid, fname, deptname, jobtitle
select empid, fname, deptname, jobtitle
from emp e, dept d, job j
where e.deptid = d.deptid
and e.jobid = j.jobid
order by empid;

--
select empid, fname, deptname, jobtitle
from emp e join dept d
on e.deptid = d.deptid
join job j
on e.jobid = j.jobid
order by empid;

-- empid, fname, deptname,salary, jobid, jobtitle
-- salary 15000~2000 사이
select empid, fname, salary, e.deptid,  e.jobid, deptname, jobtitle
from emp e, dept d, job j
where salary between 15000 and 20000
and e.deptid = d.deptid
and e.jobid = j.jobid
order by empid;

-- 부서별 관리 직원의 이름(부서id, 부서명, 부서관리직원이름)
select d.deptid, d.deptname, e.fname
from emp e, dept d
where d.mgrid = e.empid
order by 1;

#outer join
-- null 값으로 인해 조인조건에서 빠지는 레코드도 다같이 포함시켜 주는 조인
select empid, fname, deptname 
-- from emp e left join dept d
from dept d right join  emp e
on e.deptid = d.deptid
order by empid;
select count(*) from emp;


select count(*) from tmp;

drop table tmp;

-- 부서별 관리 직원의 이름(부서id, 부서명, 부서관리직원이름) --11
select d.deptid, d.deptname, e.fname
from emp e, dept d
where d.mgrid = e.empid
order by 1;

-- 2. 27건
select d.deptid, d.deptname, e.fname
from emp e right join dept d
on d.mgrid = e.empid
order by 1;

-- 3. empid, fname, dpetname, city
select e.empid, e.fname, d.deptname, city
from emp e left join dept d
on e.deptid = d.deptid
left join loc l		-- 왼쪽에 널값 존재해서 레프트 조인.
on d.locid = l.locid


order by empid;

#self join
-- 자기자신 테이블 가지고 조인
-- 자신의 매니저 정보

select e1.empid, e1.fname, e2.fname
from emp e1 join emp e2
on e1.mgrid = e2.empid;

-- 자신의 매니저 정보(매니저 연봉. 매니저 연봉이 15000 이상인)

select e1.empid, e1.fname, e2.empid, e2.fname, e2.salary 
from emp e1, emp2
where e2.salary>=15000
and e1.mgrid = e2.empid
order by 5;


# subquery
-- 1. 최소 연봉 받는 직원 정보
select min(salary)
from emp
where salary = (
select min(salary) 
from emp
);

-- 2. 전체 평균 연봉보다 많이 받는 직원 정보.

select empid , fname, salary
from emp 
where salary >(select avg(salary) from emp);

-- 3. 미국 내 부서 id, 부서명(23)

select deptid, deptname
from dept
where locid in( 
select locid from loc 
where countryid = 'US'
);


select deptid ,deptname
from dept d, loc l
where d.locid = l.locid
and l.countryid ='US';

select avg(salary)
from emp e join dept d
where d.locid in (select locid from loc where countryid='US');

-- 4. 미국에 근무하는 사원들의 평균 연봉



-- 5. 60번 부서 직원 연봉 중 아무거나 비교해서 더 많이 받는 직원 정보


-- 6. 60번 부서 직원 연봉 전부와 비교해서 더 많이 받는 직원 정보
select empid, fname, salary
from emp
where salary > all
(
select salary
from emp
where deptid = 