package com.object;

import com.test.LoopTest;

public class MethodTest {

	//int형 정수 2개를 입력받아 그 합을 출력하는 sum()
	static void sum(int a, int b) {	//void 안넣어주면 안됨.
		int c = a+b;
		System.out.println(c);
	}
	static int sum2(int a, int b) {	//결과값 리턴하니까 void 대신 int로
		int c = a+b;
		return c;		//return a+b;
	}
	
//	2.reverse(): boolean형 변수 한개를 입력받아 그 반대값을 리턴
	
	static boolean reverse(boolean a) {	//void 안넣어주면 안됨.
		if(a==true)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	
//	(true)=>false, false=>true
	
//	3. result(): boolean 형 매개변수 2개를  받아 a,b모두 참인 경우에 ok를 아니면 candel 리턴
	
	static String result(boolean a, boolean b) {	//void 안넣어주면 안됨.
		if(a==true&&b==true)
		{
			return "ok";
		}
		else 
		{
			return "cancel";
		}
	}
	//4.loopString(): int형 
	static void loopString(int count, String msg) {	//void 안넣어주면 안됨.
		for(int i=0; i<count;i++) {
			System.out.println(msg);	
		}
	}
	
	static void  getArea(int r)
	{
		double area = 3.14 *r *r;
		System.out.println(area);
	}
	public static void main(String[] args) {
		
//		//메서드 사용
//		sum(7,8);
//		sum(3,7);
		
		int result = sum2(1,6);
		boolean a = true;
		boolean b = true;
		int num = 3;
		
//		System.out.println(result);
//		System.out.println(sum2(10,33));
		System.out.println(reverse(a));
		System.out.println(result(a,b));
//		System.out.println(loopString(num,"msg"));  이렇게 해서 안됐던거;
		loopString(num, "msg");
//		System.out.println(getArea(3)); 이렇게 해도 에러! 리턴 받는게 없는데 어케 출력하냐고! 
//		그냥 함수랑 매개변수만 넣어서 보내줘야
		getArea(3);
	}

}
