package com.Exception;

public class ExceptionTest2 {
	
	public ExceptionTest2(int num) throws Exception {
		first(num);
	}
	private void first(int num) throws Exception {
		second(num);
	}
	private void second(int num) throws Exception {
		third(num);
	}
	private void third(int num) throws Exception {
		if(num>0)
		{
			System.out.println("result:" + ++num);
		}
		else
		{
			//throw: 예외 발생 시킴
			throw new Exception();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExceptionTest2 ex =new ExceptionTest2(100);
	}

}
