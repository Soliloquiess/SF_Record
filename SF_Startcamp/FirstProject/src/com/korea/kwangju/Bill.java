package com.korea.kwangju;

import com.basic.StaticTest;
import com.korea.seoul.Tommy;	//com.korea.seoul가 패키지 이름 TOmmy가 클래스 이름.
//빌은 광주에 있고 토미는 서울에

public class Bill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tommy t = new Tommy();
		t.go();//잘 호출이 됨.
		
		System.out.println(t.age);
		System.out.println(StaticTest.scount);
		//패키지 달라서 임포트 해줘야.
		//사용할 떄 클래스 이름 하는건 똑같은데 접근 지정자가 없어서 default라
//		패키지가 달라지면 안됨.
		StaticTest.go();
	}
}
