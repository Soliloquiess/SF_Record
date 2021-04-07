-- 데이터베이스 언어(DML(select, insert, update, delete), 
-- DDL(create table, drop table, alter table...), 
-- DCL(grant, revoke),
-- TCL(transaction)

select * from emp;-- 사원정보
select * from dept; -- 부서정보
select * from job; -- 업무정보
select * from loc; -- 위치정보

-- DDL(Data Definition Lang)

-- create table 
create table test(id int primary key,
name varchar(10) not null);

-- primary key 삭제하기
-- alter table 테이블명 drop primary key;

-- primary key 추가하기
-- alter table 테이블명 add primary key(컬럼명, 컬럼명);

insert into test values(1, 'tommy');
select * from test;

update test
set id = '22'
where id='1';

-- alter table
-- add column
alter table test add(tel varchar(11));
desc test;

-- delete tel
alter table test drop tel;

-- tel modify
alter table test modify tel varchar(13);

drop table test;

-- 1) pk 지정하기
-- alter table table_name
-- add constraint pk_name(제약조건이름) primary key (column_name);

-- emp 테이블에 pk지정하기
alter table emp
add constraint pk_emp primary key (empid);

-- dept(deptid)
alter table dept
add constraint pk_dept primary key (deptid);

-- job(jobid)
alter table job
add constraint pk_job primary key (jobid);
-- loc(locid)
alter table loc
add constraint pk_loc primary key (locid);

-- 2) fk(다른 테이블의 컬럼을 참조하는 키)
-- emp 테이블 -> jobid
alter table emp
add constraint emp_fk1 foreign key(jobid)
references job(jobid);

-- emp 테이블 -> deptid
alter table emp
add constraint emp_fk2 foreign key(deptid)
references dept(deptid);

-- emp -> mgrid
alter table emp
add constraint emp_fk3 foreign key(mgrid)
references emp(empid);

-- dept -> locid
alter table dept
add constraint fk_locid foreign key(locid)
references loc(locid);

-- dept -> mgrid
alter table dept
add constraint fk_dept foreign key(mgrid)
references emp(empid);

-- TABLE CREATION
-- 1.members(mid:pk, name, tel, addr)
-- 2.orders(oid:pk, mid(fk), odate (timestamp), payment)
-- 3.fk 지정: orders(mid)
-- 부모 테이블
create table members(mid varchar(10) primary key, 
name varchar(10) not null,
tel varchar(13) not null,
addr varchar(20) not null);

-- 자식 테이블
create table orders(oid int primary key,
mid varchar(10),
odate timestamp default current_timestamp,
payment varchar(13) default 'money wire' not null,
constraint pcheck check(payment in ('credit card','money wire','point')));

-- insert(부모 먼저, 자식 나중)
-- delete(자식 먼저, 부모 나중)
insert into members values('tom','tom kim', '010-1234','seoul');
insert into orders(oid, mid, payment) values(2, 'tom', 'point');

select * from members;
select * from orders;

-- fk
-- fk를 지정할 때 "on delete cascade"를 지정하면 부모 테이블의 데이터 삭제시
-- 자식테이블 데이터까지 삭제됨
alter table orders
add constraint orders_fk foreign key(mid)
references members(mid) on delete cascade; 
