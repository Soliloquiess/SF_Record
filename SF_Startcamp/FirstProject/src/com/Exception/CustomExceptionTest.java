package com.Exception;

import javax.swing.text.DefaultEditorKit.CutAction;

//사용자 정의 예외클래스
class MyException extends Exception	//반드시 상속받아준다.

{
	
	String message;
	
	public MyException(String message)
	{
		this.message= message;
	}
	
	
	@Override
	public String toString() {
		return "MyException [message=" + message + "]";
	}


}

//사용자 정의 예외: CustomException


public class CustomExceptionTest {
	
	public void check(int num) throws MyException
	{
		if(num>0)
			System.out.println("result: " + ++num);
		else 
			throw new MyException("파라미터는 양수여야 합니다.");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomExceptionTest c = new CustomExceptionTest();
		
		try {
			c.check(-100);
		}
		catch (MyException e)
		{
			System.out.println(e);
		}

	}

}
