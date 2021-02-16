package com.object;
/*
 * field: radius(int) 반지름
 * method: getArea() 원 면적 계산해서 리턴
 * get Circum():
 * 		getArea() 원 면적 리턴
 * 		getCircum() 원 둘레 리턴
 */
public class Circle {
	
	//field 
	int radius;
	int r;
	int num; //클래스변수 필드라고 부름. 이건 클래스꺼라 클래스 내부에 다 씀.
	
	//전역변수
	
	//생성자(default, r)
	public Circle()
	{
		this(0);
	}
	
	public Circle(int r)
	{
		this.r = r;
	}
	
	
	
	double getArea()
	{
		return 3.14 *radius*radius;
	}
	
//	static void double getCircum() radius가 스태틱 변수가 아니라 앞에 스태틱 넣으면 안됨.
 	double getCircum()
	{
		
		return 2*3.14 *radius;
	}
	public static void main(String[] args) {
		int num =99;	//이러면 이 num은 누구꺼?메인꺼
		
		//메인에 선언된 로컬변수(지역변수)
		//1.Circle 객체 생성하기
		//2.메소드 2개 호출해보기
		Circle c= new Circle();
		c.radius = 12;
		
		System.out.println("원 면적"+c.getArea());
		System.out.println("원 둘레"+c.getCircum());
	}

}
