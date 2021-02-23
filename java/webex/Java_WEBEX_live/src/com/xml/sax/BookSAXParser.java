package com.xml.sax;

import org.xml.sax.helpers.DefaultHandler;

//sax 방식으로 파싱작업 해주는 클래스.
//DefaultHander

public class BookSAXParser extends DefaultHandler{
	
	boolean flag= false;
	//<title>hello</title>
	//시작 엘리멘트를 만난 경우 호출됨  타이틀 앞의 태그 만난 경우
	
	
	//큐네임에 태그의 이르미 들어옴.//<title>
	if(qName.equals("title")) {
		//시작이 타이틀인 경우에만 출력.
		System.out.println("제목");
	}
	

	//종료 엘리먼트를 만난 경우 호출 됨.</title>
	if(qName.equals("title")) {	
		System.out.println("");
		//타이틀 태그 끝나면 false로 바꿈.
		//중간에 title만나도 중간에 꺼놨으니까 출력 안함.
	}
	
	//텍스트를 만나는 경우 호출됨 hello
	
	//텍스트 내용이 배열에 들어오고 배열의 시작, 길이가 들어오고 그걸 문자열로 바꿔서 쓴다.
	//파라미터로 들어왔던거 다 사용.
	//ch에 들어온거 문자로 만듬. start위치부터 length 개 만들고 문자열 만듬.
	
	
	시작태그 만나면 제목이라 찍고 중간에 캐릭터 만나면 문자열 바꾸고 닫는태그 만나면 줄바꿈
	이렇게 사건사건마다 처리해 주겠다
	//스트링 객체 하나하나 문자열 변환
	String title = new String(ch,start,length);
	if(title.equals("title"))
	if(flag ) //flag면 찍어주고 
	sout(title);
	
	
}
