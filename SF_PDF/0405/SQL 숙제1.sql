use ssafydb;

-- 0. emp테이블의 모든 레코드

select * from emp;

-- 1.직원의 id가 158인 레코드의 fname,lname,phone 검색

select fname , lname, phone
from emp
where empid = '158';


-- 2. fname이 ‘D’로 시작하는 직원의 id와 이름,부서ID 검색

select empid , fname, DEPTID
from emp
where fname like 'D%';

-- 3. 부서번호가 30인 사원들의 사번과 fname, job_id, salary,deptid 출력

select fname, jobid, salary, deptid
from emp
where deptid ='30';

-- 4. comm이 0.2이상인 사원의 사번과 fname,comm 출력

select empid, fname, comm
from emp
where comm >0.2;

-- 5. 입사일이 2004 12월31일 이후인 직원의 사원의 사번과 fname,입사일 출력(입사일로 오름차순 정렬)

select empid, fname, MGRID
from emp
where Hdate> '2004-12-31'  
order by mgrid asc;

-- 6. 부서번호가 20에서 50번 사이의 직원이름과 부서ID를 검색(부서id로 오름차순 정렬)

select Lname, deptid
from emp
where deptid between 20 and  50
order by deptid asc;


-- 7.  부서번호가 없는 직원의 id와 email, 이름 검색

select empid, email, lname
from emp
where deptid is null;
 

-- 8. jobid가 'ST_CLERK' ,'SA_MAN','SA_REP'인 직원의 id와 이름, jobid
select empid, lname, jobid 
from emp
where jobid in ('ST_CLERK', 'SA_MAN', 'SA_REP');

-- 9.  전화번호가 650으로 시작하는 직원의 id와 이름,부서ID, 전화번호 검색

select empid, lname, deptid, phone 
from emp
where phone like('650%') ;


-- 10. comm이 null이 아닌 직원 중 그 값이 0.3 이상인 레코드(comm으로 정렬)

select *
from emp
where comm is not null
and
comm >= 0.3
order by comm ;

-- 11. 아래와 같은 형식으로 출력 되도록 Query 작성
      사번             설명         
      101   Steven King IS A IT_PROG.
      
select empid as '사번' , 'Steven King IS A IT_PROG.' as '설명' 
from emp
where empid = '101';
      
-- 12. salary가 높은 상위 5명

SELECT *
FROM emp 
ORDER BY SALARY DESC
limit 5;

-- 13. 입사일 순으로 사원 정보 정렬(오래된 순)

SELECT *
FROM emp 
ORDER BY Hdate asc;

-- 14. 부서 ID가 40번이 아닌 부서에 속한 직원 들 중 SALARY가 20000 이상인 레코드

select *
from emp
where DEPTID != 40 and salary >20000;

-- 15. empid, fname, salary, 10% 증가된 salary(새연봉) :새연봉 순으로 내림차순 정렬

select empid, fname, salary *1.10
from emp
order by salary desc;

-- 16. hdate가 '2003/12/15'에서 '2004/12/31' 사이의 레코드

select Lname, deptid
from emp
where hdate between '2003-12-15' and  '2004-12-31'

