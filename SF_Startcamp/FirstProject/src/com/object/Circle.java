package com.object;
/*
 * field: radius(int) ������
 * method: getArea() �� ���� ����ؼ� ����
 * get Circum():
 * 		getArea() �� ���� ����
 * 		getCircum() �� �ѷ� ����
 */
public class Circle {
	
	//field 
	int radius;
	int r;
	int num; //Ŭ�������� �ʵ��� �θ�. �̰� Ŭ�������� Ŭ���� ���ο� �� ��.
	
	//��������
	
	//������(default, r)
	public Circle()
	{
		this(0);
	}
	
	public Circle(int r)
	{
		this.r = r;
	}
	
	
	
	double getArea()
	{
		return 3.14 *radius*radius;
	}
	
//	static void double getCircum() radius�� ����ƽ ������ �ƴ϶� �տ� ����ƽ ������ �ȵ�.
 	double getCircum()
	{
		
		return 2*3.14 *radius;
	}
	public static void main(String[] args) {
		int num =99;	//�̷��� �� num�� ������?���β�
		
		//���ο� ����� ���ú���(��������)
		//1.Circle ��ü �����ϱ�
		//2.�޼ҵ� 2�� ȣ���غ���
		Circle c= new Circle();
		c.radius = 12;
		
		System.out.println("�� ����"+c.getArea());
		System.out.println("�� �ѷ�"+c.getCircum());
	}

}
