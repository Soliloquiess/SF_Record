package com.basic;

public class StaticTest {
	
	//static filed
	int count;
	public static int scount = 999 ;	//클래스 변수. 여러 객체에서 공유해서 사용(1개만 만들어짐)
	
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
//		개체 생성할 필요 없이 바로 사용(클래스 이름으로 바로 사용 가능.
		System.out.println(StaticTest.scount);	//scount가 같은 클래스 안에 있어ㅓ서
//		System.out.println(count);
		StaticTest.go();
	}
	
	static 
	{
		System.out.println("static block-2");
	}
	

}
