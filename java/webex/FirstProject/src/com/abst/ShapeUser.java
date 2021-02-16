package com.abst;

public class ShapeUser {
	public static void main(String[] args) {
		Shape[] s = new Shape[3];
		//Shaep가 추상 클래스라 생성 안됨?
//		생성 되긴 하는데 shape가 아니라
//		Shape타입이 들어갈 수 있는 배열 3개가 생성된거ㅣㅈ
//		Shape이 생성된게 아님.
	
//		Shape[] s = new Shape(); 
//		이렇게 해야 Shape가 생성된거
//		Shape타입이 있나?
		s[0] = new Circle(10);
		s[1] = new Rect(3,5);
		s[2] = new Circle(15);
		
		for(Shape x:s)
		{
			System.out.println("면적"+x.getArea());
			System.out.println("둘레"+x.getCircum());
			System.out.println(x.getClass().getSimpleName());
			System.out.println();
		}
		
	}
}
