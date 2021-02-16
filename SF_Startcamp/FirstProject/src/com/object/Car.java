package com.object;

import java.awt.Button;

import javax.swing.JFrame;

public class Car {

//	1.data: member,field, property;
//	클래스 안의 모든 메서드 안에서 사용 가능함
//	디폴트 값이 존재
//	객체 생성하게 되면 디폴트 값이 존재
	 String model;	//null
	 String owner;	//null
	 int num;		//0
//	 boolean flag; //false;
//	 double d; //0.0
	 
//	 생성자: 객체를 생성할 때 자동으로 호출되는 메서드.
//	 클래스 이름과 동일한 메서드 이름을 가져야 하고, 리턴 타입은 적지 않는다.

//	 Car c = new Car();
	 
//	 Car(){}	//생성자
//	 Car1(){}	//생성자 아님(클래스 이름과 다름)
//	 public Car() {}	//생성자 맞음. public은 수식어일 뿐
//	 void Car() {}	//생성자 아님(void형 리턴타입이 있어서)
//	 //생성자는 아니지만 일반 메서드는 맞다.
//	 
//	 car(){}	//생성자 아님(클래스 이름과 안 맞음)
	 
//	 this는 뉴 해서 힙에 생성된 객체 가리키는 애
//	this(): 생성자 안에서 다른 생성자 호출. 다른 메서드에선 사용 x
	 
//	 this: new 키워드로 heap에 생성된 객체
//	 this():생성자 안에서 다른 생성자 호출
	 
	 
	 Car()	//얘도 메서드 디폴트 생성자.(파라미터가 없는 생성자)
	 {
//		 System.out.println("Car 생성자");
//		 this(0);
//		 this.num = 0;	//자기가  0으로 세팅
		 this(0);//0이 대신에 num으로 전달.(두번째 생성자한테 시킨거냐) 바로 밑 생성자 Car(int num)
		 //0 줄게 대신 세팅해줄래라고 물어봄.
	 }
	 
	 Car(int num)
	 {
//		 this(num,"xyz");
//		 this.num = num;
		 this(num,"xyz"); //값이 없을떄 사용한 애를 적어두자(모델명 있어야 보냄)
		 //얘도 아래 생성자로 넘겨보자
		 
	 }//생성자 맞음/ 파라미터가 있는 생성자.
	 
	 Car(int num,String model)
	 {
//		 this(num,model,"kim");
//		 this.num = num;
//		 this.model = model;
//		 얘도 마지막 생성자한테 넘겨보자.
		 this(num,model, "anonymous");
	 }//
	 
	 public Car(int num,String model, String owner)
	 {
		 this.num = num;
		 this.model = model;
		 this.owner = owner;
	 }//
//	 생성자도 메서드 시그니쳐가 같으면 안됨. 에러남.
	
//	 생성자가 여러개 = 개체를 만들 수 있는 방법이 여러개.
	 
	 
	 
//	생성만 하면 값이 들어가는 거 = 배열
//	 기본형은 생성한다 표현 X
//	 생성하는건 new 써야하는거고
//	 new 써서 바로 값 들어가는 건 배열
//	 기본적으로 다 디폴트 값이 들어간다.(0)으로 쫙 들어가고
//	 불리언형은 false로 쫙 들어간다.
	 
	 
	//2. method: 어떤 일을 하는 작업 단위
	void go() 
	{
		System.out.println("go");
	}
	
	void run()
	{
		int count = 99;
		System.out.println("run run");
	}
	void stop()
	{
		System.out.println("stop");
	}
	
	void info()
	{
		System.out.println("num:"+num);

		System.out.println("model:"+model);

		System.out.println("owner:"+owner);
		System.out.println("-------------");
	}
	
	//main 메서드
	public static void main(String[] args) {
		
		//static method 안에서는 this,super 사용 불가.
		
//		System.out.println(this.num);
		Button b = new Button("ok");
		JFrame f = new JFrame("test"); //창
		f.setSize(300,300); //창 크기
		f.add(b);//창에 버튼 붙이기.
		f.setVisible(true); //실행 헀을 때 화면에 보이게
		
		//1. data:member, field, property
		Car c1 = new Car();//디폴트 생성자
		Car c2 = new Car(12421);//파라미터 있는 생성자.
		Car c3 = new Car(4567,"avante");
		Car c4 = new Car(5421,"k5", "tommy");
		
		c1.info();
		c2.info();
		c3.info();
		c4.info();
	}

}
