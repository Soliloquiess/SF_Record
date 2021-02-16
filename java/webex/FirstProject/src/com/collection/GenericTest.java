package com.collection;

import com.abst.Circle;

//Gemneric Programming: 클래스 설계시에 데이터 타입을 정하지 않고
//런타임(실행)시에 데이터의 타입을 임의로 정하도록 유연성을 주는 방식.
public class GenericTest<X> {
	
	private int num;
//	private String name;
	private X what;
	
	
	
	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public X getWhat() {
		return what;
	}



	public void setWhat(X what) {
		this.what = what;
	}



	public static void main(String[] args) {
		
		GenericTest<String> t1= new GenericTest<>();
		GenericTest<Integer> t2= new GenericTest<>();
		GenericTest<Circle> t3= new GenericTest<>();
		
		t1.setWhat("hello");
		t2.setWhat(new Integer(123));
		t3.setWhat(new Circle(6));
		
		System.out.println(t1.getWhat());
		System.out.println(t2.getWhat());
		System.out.println(t3.getWhat().getArea()); //circle 가진 메서드도 호출이 가능하다.
	} 
}
