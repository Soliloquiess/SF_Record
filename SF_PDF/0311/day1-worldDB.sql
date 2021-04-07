-- 1. 기존 country 테이블 구조와 동일한 새이름(country2)의 테이블을 하나 만들고(CHARSET=utf8)
CREATE TABLE `country2` (
  `Code` char(3) NOT NULL DEFAULT '',
  `Name` char(52) NOT NULL DEFAULT '',
  `Continent` enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') NOT NULL DEFAULT 'Asia',
  `Region` char(26) NOT NULL DEFAULT '',
  `SurfaceArea` float(10,2) NOT NULL DEFAULT '0.00',
  `IndepYear` smallint DEFAULT NULL,
  `Population` int NOT NULL DEFAULT '0',
  `LifeExpectancy` float(3,1) DEFAULT NULL,
  `GNP` float(10,2) DEFAULT NULL,
  `GNPOld` float(10,2) DEFAULT NULL,
  `LocalName` char(45) NOT NULL DEFAULT '',
  `GovernmentForm` char(45) NOT NULL DEFAULT '',
  `HeadOfState` char(60) DEFAULT NULL,
  `Capital` int DEFAULT NULL,
  `Code2` char(2) NOT NULL DEFAULT '',
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 2. 예전 테이블에서 데이터만 가져다 새 테이블에 넣고
insert into country2 (select * from country);

-- 3. 예전 테이블은 없애고
drop table country;

-- 4. 새로 만든 테이블의 이름 바꾸고 
rename table country2 to country;

-- 5. 아까 쿼리  실행 하면 돼.  cast없이
select concat(name,'은 ', region,
	'에 속하며 인구는 ', population, ' 입니다') 정보
from country
where continent = 'asia';







