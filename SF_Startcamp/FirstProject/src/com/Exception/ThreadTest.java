package com.Exception;

public class ThreadTest {
	
	public static void main(String[] args) {
		
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
			//프로그램 멈추는 코드
		}
		System.out.println("hello wrold");
	}

}
