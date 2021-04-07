use starwars;

-- 1. 전 스타워즈 시리즈의 상영년도, 에피소드이름, 배역, 출연배우 이름

select s.openyear, s.episodename, c.charactername, a.realname
from starwars s, characters c, casting a
where s.episodeid = a.episodeid 
and c.characterid = a.characterid;
  
-- 2. 에피소드 4에 출연한 배우는 모두 몇 명인지 구하는 쿼리

select count(*)
from casting 
where episodeid = 4;

-- 3. 각 배우 별 출연횟수를 조회하는 쿼리

 select realname, count(realname)
 from casting
 group by realname
 order by 1 desc;
 
-- 4. 에피소드별 이름과 출연자 수

select s.episodename, count(realname) as '출연자 수'
from starwars s join casting ca
on s.episodeid = ca.episodeid
group by episodename
order by 2 desc;


-- 5. 출연자수가 10명 이상인 에피소드의 이름과 출연자수

select starwars.episodename, count(*)
from starwars join  casting 
on starwars.episodeid=casting.episodeid;


-- 6.제국의 역습에 등장하는 배우 이름

select episodename, realname
from casting join starwars
on casting.episodeid = starwars.episodeid
where starwars.episodename like '제국의 역습%';


-- 7. '아미달라 여왕'이 등장했던 에피소드 id, 에피소드 이름과 상영연도

select ca.episodeid , s.episodename, s.openyear
from characters c join casting ca
on c.characterid = ca.characterid
join starwars s
on ca.episodeid = s.episodedid
where c.charactername = '아미달라 여왕';


    
-- 8. 해리슨 포드가 등장했던 에피소드의 id와 에피소드 이름

select s.episodeid, s.episodename
from starwars s join casting ca
on s.episodeid = ca.episodeid
where ca.realname = '해리슨 포드';

select episodeid, episodename
from starwars
where episodeid in ( select episodeid
					from casting
                    where realname = '해리슨 포드');


-- 9. 각 에피소드의 id와 출연한 인원 수

select episodeid, count(*)
from casting 
group by episodeid
order by 2 desc;

-- 10. 각 에피소드각에 출연한 인원 수 중 가장 많은 인원수

-- max(count(*)): err

select count(c.CHARACTERID)
from starwars s join casting c
on s.EPISODEID = c.episodeid
group by c.episodeid
order by count(c.characterid) desc
limit 1;


-- 11. 가장 많은 인원이 출연한 에피소드의 id와 인원 수

select episodeid, count(*) as "인원수"
from casting
group by episodeid
having count(*) =(select max(tmp.cnt)
					from (select count(*) cnt
						from casting 
                        group by episodeid) tmp)
                        
order by episodeid desc;
-- 12. 가장 많은 인원이 출연한 에피소드 id, 그 에피소드에 출연한 배우명

select episodeid '에피소드', rename '출연배우'
from casting 
where episodeid in (
	select s.episodeid
	from starwars s
	join casting c on s.episodeid = c.episodeid
	group by c.episodeid
	having count(*) =(
	select count(*)
	from casting
	group by episodeid
	order by count (*) desc limit 1)
    
    );


-- 13. 출연했던 횟수가 가장 많은 배우 TOP 5의 이름과 횟수를 조회


-- 14. 출연했던 횟수가 가장 많은 배우 TOP 6-10의 이름과 횟수를 조회

 

-- 15. 캐릭터에 role값을 부여하여 update(롤의 이름을 활용한다.)
-- 1,4,13 제다이
-- 2,9 반란군
-- 5,12,18 시스



-- 16. 캐릭터와 마스터 연결하여  update
-- 아나킨 스카이워커 13 		오비완 케노비 4
-- 루크 스카이워커 1		오비완 케노비 4
-- 마스터 윈두 	20		요다 11
-- 듀크백작 	21			요다	11
-- 다스 베이더		5		다스 시디어스 12
-- 다스 몰		18		다스 시디어스 12
-- 오비완 캐노비 4			콰이곤 진 14
-- 콰이콘 진		14		듀크백작 21



-- 17. 마스터 역할의 배역이름

                            
                            
-- 18. 오비완 케노비의 제자는



-- 19. 오비완 케노비의 제자는 몇명 

                    
-- 20. 모든 배역과 해당 배역의 마스터 역할배역의 이름을 함께 조회(단, 마스터가 없는 배역도 포함)





  










   