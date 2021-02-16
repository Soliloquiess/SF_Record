package com.collection;

import com.abst.Circle;

//Gemneric Programming: Ŭ���� ����ÿ� ������ Ÿ���� ������ �ʰ�
//��Ÿ��(����)�ÿ� �������� Ÿ���� ���Ƿ� ���ϵ��� �������� �ִ� ���.
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
		System.out.println(t3.getWhat().getArea()); //circle ���� �޼��嵵 ȣ���� �����ϴ�.
	} 
}
