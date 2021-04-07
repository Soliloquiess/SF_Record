use ssafydb;
select * from testdb.dept;
select * from testdb.emp;

select * from testdb.job;
select * from testdb.loc;


-- 1. 부서위치가 CHICAGO인 모든 사원에 대해 이름,업무,급여 출력하는 SQL을 작성하세요.
select *
from dept
where locid = (select locid from loc where locid = 1700);

-- 2. 부하직원이 없는 사원의 사원번호,이름,업무,부서번호 출력하는 SQL을 작성하세요.
select *
from emp
where mgrid not in (select distinct mgrid from emp where mgrid is not null);

-- 3. BLAKE와 같은 상사를 가진 사원의 이름,업무,상사번호 출력하는 SQL을 작성하세요.
select *
from emp
where mgrid = (select mgrid from emp where fname = 'Irene');

-- 4. 입사일이 가장 오래된 사람 5명을 검색하세요.
select *
from emp
order by hdate
limit 0, 5;

-- 5. JONES 의 부하 직원의 이름, 업무, 부서명을 검색하세요.
select *
from emp join dept
using (mgrid)
where mgrid = (select mgrid from emp where fname = 'Nancy');


select * from testdb.dept;
