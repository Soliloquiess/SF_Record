package com.inner;

public class Outer //top -level class
{
	static int count = 99;
	
	//static inner class
	static class Inner
	{
		public void go()
		{
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) {
//		Inner i = new Inner();	//�ƿ��͸� ���� ���� ����.
		
		System.out.println(Outer.count);
		Outer.Inner i = new Outer.Inner();
		i.go();
		System.out.println(i.getClass().getName());
	}
	
}
