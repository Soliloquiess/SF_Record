package com.Exception;

public class ThreadTest {
	
	public static void main(String[] args) {
		
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
			//���α׷� ���ߴ� �ڵ�
		}
		System.out.println("hello wrold");
	}

}
