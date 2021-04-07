#subquery
-- 1. 최소 연봉을 받는 직원 정보
select empid, fname, salary
from emp
where salary = (select min(salary)	from emp);

-- 2. 전체 평균 연봉보다 많이 받는 직원 정보(51)
select empid, fname, salary
from emp
where salary > (select avg(salary) from emp);

-- 3. 미국 내 부서id, 부서명(23)
select deptid, deptname
from dept
where locid in (select locid from loc where countryid = 'US');

select deptid, deptname
from dept d, loc l
where d.locid = l.locid
and l.countryid = 'US';
 
-- 4. 미국에 근무하는 사원들의 평균 연봉(5065)
select round(avg(salary))
from emp e join dept d
where e.deptid = d.deptid
and d.locid in (select locid from loc where countryid='US');

-- 5. 60번 부서 직원 연봉 중 아무거나 비교해서 더 많이 받는 직원 정보
select empid, fname, salary
from emp
where salary > any
	(select salary 
	from emp
	where deptid = 60 order by 1 desc) order by salary desc;

-- 6. 60번 부서 직원 연봉 전부와 비교해서 더 많이 받는 직원 정보
select empid, fname, salary
from emp
where salary > all
	(select salary 
	from emp
	where deptid = 60 order by 1 desc) order by salary desc;






