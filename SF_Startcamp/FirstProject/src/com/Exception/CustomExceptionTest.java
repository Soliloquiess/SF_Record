package com.Exception;

import javax.swing.text.DefaultEditorKit.CutAction;

//����� ���� ����Ŭ����
class MyException extends Exception	//�ݵ�� ��ӹ޾��ش�.

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

//����� ���� ����: CustomException


public class CustomExceptionTest {
	
	public void check(int num) throws MyException
	{
		if(num>0)
			System.out.println("result: " + ++num);
		else 
			throw new MyException("�Ķ���ʹ� ������� �մϴ�.");
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
