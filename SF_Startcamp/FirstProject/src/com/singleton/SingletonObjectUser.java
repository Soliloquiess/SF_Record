package com.singleton;

public class SingletonObjectUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonObject s1 = SingletonObject.getInstance();
		SingletonObject s2 = SingletonObject.getInstance();
		SingletonObject s3 = SingletonObject.getInstance();
		
		System.out.println(s1 == s2);	// ==: �ּҰ� �� �޸� �󿡼� �ּҰ��� ������ ��
		System.out.println(s2 == s3);	//��ü�� �ϳ��ε� ����Ű�� ��Ұ� 3��(�ּҰ��� �ϳ�)
	}

}