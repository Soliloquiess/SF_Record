package com.singleton;

//Singleton 디자인패턴
//객체생성을 한번만 수행하고 그 이후부터는 생성된 객체를 공유해서 사용하는 방식.
//조건 :
//	1)field:private, static 수식어 붙어야 됨
//	2)생성자:private
//	3)객체를 만들어서 리턴해주는 public static 메서드가 존재해야 함.
//
//3가지 조건이 붙어야 싱글톤 조건이 잘 충족 됨.


public class SingletonObject {

	//field 
	private static SingletonObject instance;
	
	//생성자
	private SingletonObject() {}
	
//	public method : 외부에서 사용 가능한 메서드
	public static SingletonObject getInstance()
	{
		if(instance == null)
			instance = new SingletonObject();
		return instance;
	}
}
