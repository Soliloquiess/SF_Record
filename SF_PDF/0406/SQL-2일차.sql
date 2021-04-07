use ssafydb;



select count(*)
from departments;

-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름

select employee_id, first_name, salary, department_id
from employees
where employee_id =100
order by salary;

select * 
from employees, departments;

-- error
select  employee_id, first_name, salary, department_name
from employees, departments
where employees.department_id = departments.department_id
and empolyees.employee_id =100;

-- solved
select  employee_id, first_name, salary, department_name
from employees, departments
where employees.department_id = departments.department_id
and employee_id =100;


-- inner join()

select  e.employee_id, e.first_name, e.salary, d.department_name
from employees e , departments d
where e.department_id = d.department_id
and e.employee_id =100;

-- inner join(alias)

select  e.employee_id, e.first_name, e.salary, d.department_name
from employees e inner join departments d
where e.department_id = d.department_id
and e.employee_id =100;

-- natural join
select e.employee_id , e.first_name, e.salary, e.department_id, d.department_name
from employees e natural join departments d
where e.employee_id =100;


-- 부서번호가 10인 부서의 번호 ,부서이름, 도시

select d.department_id, d.department_name, l.city
from departments d natural join locations l
where d.department_id =10;

-- 회사에 근무하는 모든 사원의 사번 이름 부서이름

select count(employee_id)
from employees;


select e.employee_id, e.first_name, d.department_name
from employees e left outer join departments d
using (department_id);

select e.employee_id, e.first_name, ifnull(d.department_name, '대기발령중')
from employees e left outer join departments d
on e.department_id = d.department_id;

select e.employee_id, e.first_name,d.department_name ,e.first_name
from employees e join departments d
on e.department_id = d.department_id;



-- 시애틀에 근무하는 사원의 정보
-- 사번 이름 급여 직급이름 부서이름

 select e.employee_id, e.first_name, e.salary, j.job_title, d.department_name
 from employees e join jobs j
 on e.job_id = j.job_id
 join departments d
 on e.department_id = d.department_id
 join locations l
 on d.location_id = l.location_id
 where lcase(city) = lcase('seattle')
 order by salary desc;
 
 
 select *
 from employees
 where department_id is null;

-- 부서가 없는(부서번호가 널인) 사원 검색


select employee_id, first_name, department_id
from employees
where department_id is null;

select e.employee_id, e.first_name, d.department_id
from employees e left outer join departments d
using (department_id);


-- Right outer join

-- 회사에 존재하는 모든 부서의 부서이름과 부서에서 근무하는 사원의 사번, 이름

select count(department_id)
from departments;

-- 사원이 근무하는 부서수
select  count(distinct department_id)
from employees;

-- 사원이 없는 부서의 정보는 출력이 안됨
select d.department_name, e.employee_id, e.first_name
from employees e join departments d
using (department_id);

-- 회사에 존재하는 모든 부서의 부서이름과 부서에서 근무하는 사원의 사번, 이름
select d.department_name, e.employee_id, e.first_name
from employees e right outer join departments d
using (department_id);

-- self join
-- 같은 테이블끼리 조인
-- 모든 사원의 사번, 이름, 매니저사번, 매니저이름

select e.first_name, e.employee_id,  m.employee_id, m.first_name -- e.employee_id,  m.employee_id 이 2개가 같은지 보면 된다.
from employees e inner join employees m
on e.manager_id = m.employee_id;

-- none-equi join 
-- table의 pk,fk가 아닌 일반 컬럼을 조인조건으로 지정
-- 모든사원의 사번,이름,급여,급여등급

select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salgrades s
where e.salary>= s.losal
and e.salary <= s.hisal;


select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salgrades s
where e.salary between s.losal and s.hisal;



-- 사번이 101번인 사원의 근무이력
-- 사번, 이름, 부서이름, 직급이름, 시작일, 종료일
-- 날짜 : 00.00.00

select e.employee_id, e.first_name, h.start_date, h.end_date 
		j.job_title, date_format(h.start_date,'%y.%m%d'),date_format(h.end_date, '%y.%m.%d')
from employees e join job_history h
on e.employee_id = h.employee_id
join departments d
on h.department_id = d.department_id
join jobs j
on h.job_id =j.job_id
where e.employee_id =101;

-- select e.employee_id, e.first_name, h.start_date 
-- from employees e join job_history h
-- on e.employee_id = h.employee_id
-- where e.employee_id =101

-- from employees e join departments d
-- on e.department_id = d.department_id;


select *
from job_history;



