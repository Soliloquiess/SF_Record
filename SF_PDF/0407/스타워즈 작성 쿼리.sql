drop table casting;
drop table characters;
drop table roles;
drop table starwars;



use starwars;

-- 1.starwars
create table  STARWARS(
	EPISODEID  int,
    EPISODENAME  varchar(50),
    OPENYEAR int
    );

-- 2. characters

create table characters(
	characterid int,
    charactername varchar(50),
    masterid int,
    roleid int,
    email varchar(50));

-- 3. casting 
create table casting (
	episodeid int,
    characterid int,
    realname varchar(50));


-- 4. roles

create table roles(
	roleid int,
    rolename varchar(50));
    
    
# pk, fk 지정

alter table starwars add constraint starwars_pk primary key(episodeid);
alter table characters add constraint characters_pk primary key(characterid);
alter table roles add constraint roles_pk primary key(roleid);    
alter table casting add constraint casting_pk primary key(episodeid, characterid);

alter table characters add constraint characters_fk
foreign key(roleid) references roles(roleid);

alter table casting add constraint casting_fk1
foreign key(episodeid) references starwars(episodeid);

alter table characters add constraint characters_fk
foreign key(characterid) references characters(characterid);

#data insert

insert into roles values(1001, '제다이');
insert into roles values(1002, '시스');
insert into roles values(1003, '반란군');