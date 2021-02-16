package com.ssafy;


public class OB extends OA {
	@Override
	void m1() { System.out.println("OB m1()");}
	//오버라이딩 어노테이션 붙여준건 상위 클래스OA에서 오버라이딩 한다고 붙여줌.
	void m1(int i) { System.out.println("OB m1()");}
	//이렇게 붙여주면 오버라이딩 하려는 m1이라는 메서드는 파라미터 없다고 알려줌
	void m2() { System.out.println("OB m2()");}
//	void m2(int i) { System.out.println("OB m1()");}
//	근데 m2가 어노테이션 바뀌면 오류는 안남.
//	오버라이딩이 꺠진거(내 자신이 새롭게 정의한 메서드가 됨으로 틀리진 않았으니까. 다만 의도치 않음)
//	그래서 어노테이션 넣어서 오류 발생을 방지.
	
	//처음엔 상속받는 거로 했는데 상위클래스 뒤바뀌니까 오버라이딩이 깨져버림. 내 자신이
}
