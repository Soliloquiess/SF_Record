package com.test;

public class OperatorTest {

	public static void main(String[] args) {
		boolean a = true, b= true, c = false;
		
		//if (a ==true && b== true) //&&:and
		if(c && b) //&& :and
		{
			System.out.println("level-1");
		}
		if(a || c) //|| : or
		{
			System.out.println("level-2");
		}

		//a+b
		int x = 90, y = 91;
		int max = (x>y)? x:y;
		System.out.println(max);

	}

}
