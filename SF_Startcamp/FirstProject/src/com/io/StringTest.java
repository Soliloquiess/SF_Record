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
//		Ŭ�����ȿ� tostring�޼��尡 ������ �ڵ����� ȣ�� Ȥ�ö� �޼��� �ȿ� tostring ������
//		�װ� ����
//		switch break ������ ����!
//		�������� �������
	}

}
