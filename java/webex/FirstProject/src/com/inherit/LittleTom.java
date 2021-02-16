package com.inherit;

class Tom{
	int age = 50;
}

// 인터페이스에 선언된 변수들은 static, final임
interface Hillary {
	int age = 46; // static, final
//	static final int age = 46;
}

public class LittleTom extends Tom implements Hillary {
	int age = 23;
	
	private void test() {
		System.out.println(age); // 23
		System.out.println(this.age); // 23
		System.out.println(super.age); // 50
		System.out.println(Hillary.age); // 46
		//Hillary.age = 48;
	}
	
	public static void main(String[] args) {
		LittleTom little = new LittleTom();
		little.test();
		
		if(little instanceof Tom)
		{
			System.out.println("instanceof Tom");
		}
		if(little instanceof Hillary)
		{
			System.out.println("instanceof Hillary");
		}
		if(little instanceof LittleTom)
		{
			System.out.println("instanceof LittleTom");
		}
		if(little instanceof Object)
		{
			System.out.println("instanceof Object");
		}
		
	}

}
