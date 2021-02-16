package com.abst;

public abstract class Shape {
	//추상메서드
	public abstract double getArea(); //도형의 크기를 구하는 메서드
	public abstract double getCircum();	//도형의 둘레를 구하는 메서드
	
		
	//구현 메서드
	public void go()
	{
		System.out.println("hello...");
	}
}
