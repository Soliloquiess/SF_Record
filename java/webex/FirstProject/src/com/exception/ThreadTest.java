package com.exception;
//InterruptedException:Non-runtime Exception. ����ó���� ����� ��.
public class ThreadTest {
	
	public static void main(String[] args) {
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("hello world");
	}
}
