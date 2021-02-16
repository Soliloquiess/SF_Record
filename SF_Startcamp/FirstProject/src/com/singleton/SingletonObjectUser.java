package com.singleton;

public class SingletonObjectUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonObject s1 = SingletonObject.getInstance();
		SingletonObject s2 = SingletonObject.getInstance();
		SingletonObject s3 = SingletonObject.getInstance();
		
		System.out.println(s1 == s2);	// ==: 주소값 비교 메모리 상에서 주소값이 같은지 비교
		System.out.println(s2 == s3);	//객체는 하나인데 가리키는 요소가 3개(주소값은 하나)
	}

}
