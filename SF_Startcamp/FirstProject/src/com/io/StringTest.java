package com.io;


public class StringTest {

	public static void main(String[] args) {
		String s = "mylimeorange";
		String t = new String("mylimeorange");
		String x = "mylimeorange";
		
		if(s==t)
			System.out.println("s == t");
		
		if(s.equals(t))
			System.out.println("s.equals(t)");
		
		if(s==x)
			System.out.println("s == x");		
	
		System.out.println(s);

		String b = s.concat("hello");
		System.out.println(b);
		
		s = s + "gogogo";
		System.out.println(s);
		
		StringBuilder sb = new StringBuilder("mylimeorange");
		sb.append("hello");
		sb.insert(2, 'q');
		System.out.println(sb);
		
//		Car c= new Car();
//		클래스안에 tostring메서드가 있으면 자동으로 호출 혹시라도 메서드 안에 tostring 있으면
//		그게 실행
//		switch break 빼면계속 돈다!
//		지역변수 멤버변수
	}

}
