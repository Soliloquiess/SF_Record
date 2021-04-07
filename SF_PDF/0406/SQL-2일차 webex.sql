use testdb;

## 함수

-- 1. 집계함수: count(), sum (), avg(), min(),  max()

select count(*), avg(salary), max(salary)
from emp;

-- 2. 숫자 관련함수

select ceil (8.9) ;#올림
select greates(100,34,888) max, least(100,34,999) min;

-- 3. 문자열 관련함수

select empid, concat(fname, ' ' ,lname) name
from emp;

select fname , replace(fname, 'a','x') name
from emp;

select fname , substring(fname, 1,2) name
from emp;

-- 4. 날짜/시간 관련함수

select now() , sysdate(), curdate(), curtime();
select now(), date_add(now(), interval 1 second);
select year(now()), month(now()), monthname(now()),dayofweek(now());

-- json 
select json_object('empid', empid, 'fname', fname) obj
from emp;

# group by (~별)
-- 부서별 , 업무별

select deptid 부서번호, round(avg(salary), 2) 평균연봉
from emp
where deptid >=40
group by deptid
order by deptid;








######################


#join 
##inder조인은 심플하니까 outer join을 많이 면접이나 이런데서 물어 볼 것.

create table tmp
as 
select empid, fname, dept name
from emp e, dept d;

