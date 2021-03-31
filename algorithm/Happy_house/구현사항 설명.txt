## HappyHouse - 광주 3반 고유창, 김희주

### 구현한 부분 - 기본

1.  com.ssafy.happyhouse.view.HouseInfoView
- before

```java
ActionListener buttonHandler = new ActionListener() {

@Override

public void actionPerformed(ActionEvent e) {

searchHouses();

}

};

searchBt.addActionListener( buttonHandler );
```

- After

```java
searchBt.addActionListener(e -> searchHouses());
```

2.  com.ssafy.happyhouse.model.service.HouseServiceImpl

```java
@Override

public HouseDeal search(int no) {

HouseDeal houseDeal = dao.search(no);

if(houseDeal == null) {

throw new NotFoundDataException("HouseDeal을 찾지 못하였습니다.");

}

return houseDeal;

}
```

- null 을 리턴하지 않고 예외를 던지도록 구현

3. com.ssafy.happyhouse.model.dao.HouseDaoImpl

```java
public HouseDeal search(int no) {

for (HouseDeal houseDeal : search) {

if (houseDeal.isMine(no)) {

return houseDeal;

}

}

*// 해당하는 no 가 없을 경우 null 을 리턴하세요.*

return null;

}
```

4~7. com.ssafy.happyhouse.util.APTRentSAXHandler

```java
public void startElement(String uri, String localName, String qName, Attributes att ){

if(qName.equals("item")){

*// complete code #04*

house = new HouseDeal(HouseSaxParser.no++);

house.setType(HouseDeal.APT_RENT);

houses.add(house);

}

}

*// endElement 메서드의 일부*

else if(qName.equals("보증금액")) {

*// complete code #05*

house.setBozung(temp.trim());

*// 보증금액 항목을 처리하세요.*

}

else if(qName.equals("건축년도")) {

*// complete code #06*

house.setBuildYear(Integer.parseInt(temp));

*// 건축년도 항목을 처리하세요.*

}

else if(qName.equals("일")) {

*// complete code #07;*

house.setDealDay(Integer.parseInt(temp));

*// 일 항목을 처리하세요.*

}
```

8. com.ssafy.happyhouse.util.HouseDealSAXHandler

```java
package com.ssafy.happyhouse.util;

import java.util.LinkedList;

import java.util.List;

import org.xml.sax.Attributes;

import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.happyhouse.model.dto.HouseDeal;

*/***

** AptDealHistory.xml 파일에서 아파트 거래 정보를 읽어 파싱하는 핸들러 클래스*

**/*

public class APTDealSAXHandler extends DefaultHandler {

*/***

** 아파트 거래 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만*

** 현재 버전에서는 0번부터 순차 부여한다.*

**/*

*/**아파트 거래 정보를 담는다 */*

private List<HouseDeal> houses;

*/**파상힌 아파트 거래 정보*/*

private HouseDeal house;

*/**태그 바디 정보를 임시로 저장*/*

private String temp;

public APTDealSAXHandler(){

houses = new LinkedList<HouseDeal>();

}

public void startElement(String uri, String localName, String qName, Attributes att){

if(qName.equals("item")){

house = new HouseDeal(HouseSaxParser.no++);

house.setType(HouseDeal.APT_DEAL);

houses.add(house);

}

}

public void endElement(String uri, String localName, String qName){

if(qName.equals("지역코드")) {

house.setCode(Integer.parseInt(temp));

}else if(qName.equals("아파트")) {

house.setAptName(temp.trim());

}else if(qName.equals("법정동")) {

house.setDong(temp.trim());

}else if(qName.equals("거래금액")) {

house.setDealAmount(temp);

}else if(qName.equals("건축년도")) {

house.setBuildYear(Integer.parseInt(temp));

}else if(qName.equals("년")) {

house.setDealYear(Integer.parseInt(temp));

}else if(qName.equals("월")) {

house.setDealMonth(Integer.parseInt(temp));

}else if(qName.equals("일")) {

house.setDealDay(Integer.parseInt(temp));

}else if(qName.equals("전용면적")) {

house.setArea(Double.parseDouble(temp));

}else if(qName.equals("지번")) {

house.setJibun(temp);

}else if(qName.equals("층")) {

house.setFloor(Integer.parseInt(temp));

}

}

public void characters(char[]ch, int start, int length){

temp = new String(ch, start, length);

}

public List<HouseDeal> getHouses() {

return houses;

}

public void setHouses(List<HouseDeal> houses) {

this.houses = houses;

}

}
```

### 구현한 부분 - 추가 (주변 환경 오염 정보 분석)

- 사용한 file: 서울시 종로구 환경 지도점검 내역현황.csv
- ReadCSVTest의 역할

    1. csv파일 read

    2. 읽은 데이터를 Maintenance 로 객체화하여 리스트로 저장 - 싱글톤 구현

    3. 해당 '동' 에 해당하는 환경지도점검(Maintenance) 들을 출력

- 동작과정

    1. HouseInfoView가 생성될때 getInstance 메서드로 ReadCSVTest 객체를 생성 -> 이 때 csv 파일 읽음

    2. HouseInfoView에서 searchHouses를 실행하여 showHouses를 호출하면 ReadCSVTest의 search 메서드로 해당 동에 있는 환경 지도점검 조회 및 콘솔 출력