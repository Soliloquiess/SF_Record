package com.test;

public class LoopTest {

	public static void main(String[] args) {

		String msg = "hello";
		//for (초기값:조건식:증감식){}
		for(int i = 0; i<5 ;i++) 
		{
//			System.out.println(i+"."+msg);
//			printf("출력할 값의 형식", 출력할 값)
			
			System.out.printf("%d.%s\n",i,msg); //printf(format)
//			이 문장의 경우  숫자+문자열 형식으로 출력
		}
		
		//while
		int num = 0; //초기값
		
		while(num < 5)
		{
			System.out.println("gogogo");//반복내용
			num++;//증감식
		}
		//do~while
		int code = 100;	//초기값
		do{
			//반복내용.
			System.out.println("welcome");
			code++;
		}while(code < 5);
		
	}
}
