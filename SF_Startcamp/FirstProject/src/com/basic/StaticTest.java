package com.basic;

public class StaticTest {
	
	//static filed
	int count;
	public static int scount = 999 ;	//Ŭ���� ����. ���� ��ü���� �����ؼ� ���(1���� �������)
	
	public static void go()
	{
		System.out.println("hello, static!!!");
	}
	
	//3.Static block{}
	static 
	{
		System.out.println("static block-1");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		StaticTest s1 = new StaticTest();
//		StaticTest s2 = new StaticTest();
//		StaticTest s3 = new StaticTest();
//		
//		System.out.println(++s1.count + "--" + ++s2.count + "--" + ++s3.count);
//		System.out.println(++s1.scount + "--" + ++s2.scount + "--" + ++s3.scount);
			
		System.out.println(Math.pow(2,3));
//		��ü ������ �ʿ� ���� �ٷ� ���(Ŭ���� �̸����� �ٷ� ��� ����.
		System.out.println(StaticTest.scount);	//scount�� ���� Ŭ���� �ȿ� �־�ü�
//		System.out.println(count);
		StaticTest.go();
	}
	
	static 
	{
		System.out.println("static block-2");
	}
	

}
