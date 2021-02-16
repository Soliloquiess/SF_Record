package com.object;

public class CarUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//필요한 객체 생성
		Car c1 = new Car();
		Car c2 = new Car();// 객체를 생성시 자동으로 호출됨.
		//생성자 사용 2번해서 2번 출력.
		
		//생성한 객체 사용
		c1.num =1234;
		c1.model = "avante";
		c1.owner = "tommy";
		
		System.out.println(c1.num+","+c1.model+","+c1.owner);
	}

}
