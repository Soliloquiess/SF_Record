package com.test;

public class ConditionTest {

	public static void main(String[] args) {
		
		char x= 'a';
		switch(x)	//byte,short,int,char(long을 제외한 정수형).String
		{
			case 'a':
			case 'A':
				System.out.println("one");
				break;
			case 'b':
			case 'B':
				System.out.println("Two");
				break;
			case 'c':
			case 'C':
				System.out.println("three");
				break;
				
			default:
				break;
				
		}
		
		
		
		//ctrl+d 는 줄 삭제
		int a = 200,b = 300;
		int key = 50;
		switch(key) 
		{
			case 30:
				System.out.println("level-1");
				break;
				
			case 50:
				System.out.println("level-2");
				break;
			
			default:
				System.out.println("level-3");
				break;
		}
		
		if(a > b) 
		{
			System.out.println("class-1");
		}
		else if(a==b)
		{
			System.out.println("class-2");
		}
		else 
		{
			System.out.println("class-3");
		}
	}

}
