package com.object;

import java.awt.Button;

import javax.swing.JFrame;

public class Car {

//	1.data: member,field, property;
//	Ŭ���� ���� ��� �޼��� �ȿ��� ��� ������
//	����Ʈ ���� ����
//	��ü �����ϰ� �Ǹ� ����Ʈ ���� ����
	 String model;	//null
	 String owner;	//null
	 int num;		//0
//	 boolean flag; //false;
//	 double d; //0.0
	 
//	 ������: ��ü�� ������ �� �ڵ����� ȣ��Ǵ� �޼���.
//	 Ŭ���� �̸��� ������ �޼��� �̸��� ������ �ϰ�, ���� Ÿ���� ���� �ʴ´�.

//	 Car c = new Car();
	 
//	 Car(){}	//������
//	 Car1(){}	//������ �ƴ�(Ŭ���� �̸��� �ٸ�)
//	 public Car() {}	//������ ����. public�� ���ľ��� ��
//	 void Car() {}	//������ �ƴ�(void�� ����Ÿ���� �־)
//	 //�����ڴ� �ƴ����� �Ϲ� �޼���� �´�.
//	 
//	 car(){}	//������ �ƴ�(Ŭ���� �̸��� �� ����)
	 
//	 this�� �� �ؼ� ���� ������ ��ü ����Ű�� ��
//	this(): ������ �ȿ��� �ٸ� ������ ȣ��. �ٸ� �޼��忡�� ��� x
	 
//	 this: new Ű����� heap�� ������ ��ü
//	 this():������ �ȿ��� �ٸ� ������ ȣ��
	 
	 
	 Car()	//�굵 �޼��� ����Ʈ ������.(�Ķ���Ͱ� ���� ������)
	 {
//		 System.out.println("Car ������");
//		 this(0);
//		 this.num = 0;	//�ڱⰡ  0���� ����
		 this(0);//0�� ��ſ� num���� ����.(�ι�° ���������� ��Ų�ų�) �ٷ� �� ������ Car(int num)
		 //0 �ٰ� ��� �������ٷ���� ���.
	 }
	 
	 Car(int num)
	 {
//		 this(num,"xyz");
//		 this.num = num;
		 this(num,"xyz"); //���� ������ ����� �ָ� �������(�𵨸� �־�� ����)
		 //�굵 �Ʒ� �����ڷ� �Ѱܺ���
		 
	 }//������ ����/ �Ķ���Ͱ� �ִ� ������.
	 
	 Car(int num,String model)
	 {
//		 this(num,model,"kim");
//		 this.num = num;
//		 this.model = model;
//		 �굵 ������ ���������� �Ѱܺ���.
		 this(num,model, "anonymous");
	 }//
	 
	 public Car(int num,String model, String owner)
	 {
		 this.num = num;
		 this.model = model;
		 this.owner = owner;
	 }//
//	 �����ڵ� �޼��� �ñ״��İ� ������ �ȵ�. ������.
	
//	 �����ڰ� ������ = ��ü�� ���� �� �ִ� ����� ������.
	 
	 
	 
//	������ �ϸ� ���� ���� �� = �迭
//	 �⺻���� �����Ѵ� ǥ�� X
//	 �����ϴ°� new ����ϴ°Ű�
//	 new �Ἥ �ٷ� �� ���� �� �迭
//	 �⺻������ �� ����Ʈ ���� ����.(0)���� �� ����
//	 �Ҹ������� false�� �� ����.
	 
	 
	//2. method: � ���� �ϴ� �۾� ����
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
	
	//main �޼���
	public static void main(String[] args) {
		
		//static method �ȿ����� this,super ��� �Ұ�.
		
//		System.out.println(this.num);
		Button b = new Button("ok");
		JFrame f = new JFrame("test"); //â
		f.setSize(300,300); //â ũ��
		f.add(b);//â�� ��ư ���̱�.
		f.setVisible(true); //���� ���� �� ȭ�鿡 ���̰�
		
		//1. data:member, field, property
		Car c1 = new Car();//����Ʈ ������
		Car c2 = new Car(12421);//�Ķ���� �ִ� ������.
		Car c3 = new Car(4567,"avante");
		Car c4 = new Car(5421,"k5", "tommy");
		
		c1.info();
		c2.info();
		c3.info();
		c4.info();
	}

}
