package com.inner;

public class Car {

	int num =1234;
	public class Engine
	{
		public void go()
		{
			System.out.println(num);
		}
	}
	
	public static void main(String[] args) {
		
		Car c = new Car();
//		System.out.println(c.num);
//		//member class: �ٱ��� ��ü�� ���� ���� �� �Ŀ� ��� �����ϴ�
		Engine e = c.new Engine();
		e.go();
		System.out.println(e.getClass().getName());
	}
}
