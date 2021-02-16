package com.singleton;

//Singleton ����������
//��ü������ �ѹ��� �����ϰ� �� ���ĺ��ʹ� ������ ��ü�� �����ؼ� ����ϴ� ���.
//���� :
//	1)field:private, static ���ľ� �پ�� ��
//	2)������:private
//	3)��ü�� ���� �������ִ� public static �޼��尡 �����ؾ� ��.
//
//3���� ������ �پ�� �̱��� ������ �� ���� ��.


public class SingletonObject {

	//field 
	private static SingletonObject instance;
	
	//������
	private SingletonObject() {}
	
//	public method : �ܺο��� ��� ������ �޼���
	public static SingletonObject getInstance()
	{
		if(instance == null)
			instance = new SingletonObject();
		return instance;
	}
}
