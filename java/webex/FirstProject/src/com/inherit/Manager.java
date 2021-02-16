package com.inherit;


class Employee
{
	int num;
	String name;
	int salary;
	
	public Employee(int num, String name, int salary)
	
	{
		
		this.num = num;
		this.name = name;
		this.salary= salary;
	}
	
	double getBonus()
	{
		return salary * 0.3;
	}
}


public class Manager extends Employee
{
	int mcode;
	
	Manager(int num, String name, int salary,int mcode)
	//�ڽĺ��� �θ� ���� �����Ǿ�� �ϹǷ� �θ� �����ڿ� ���缭 ���� �����ؾ� ��.
	//super(): �ڽ� Ŭ�������� �θ� ������ ȣ��� ���.
	{
		super(num,name,salary);	//���� 4���߿� 3����  �������
		//�Ķ���� �־ ����.
//		this.num = num;
//		this.name = name;
//		this.salary = salary;
		this.mcode= mcode;	//������ �̰Ÿ� �����ϸ� ��(�θ� �갡 �����ϱ�)
	}
	
	//overiding 
	
	double getBonus()
	{
		return salary * 0.5;
	}

	public static void main(String[] args) {

		Manager bill = new Manager(123,"bill kim", 5000, 100);
		Employee tom = new Employee(239, "tom lee",3000);
		Employee tom2 = new Manager(123,"bill kim", 3000,100);
		//�޼��� ������ �ϸ� ������ ������ �� �ŷ� ȣ���� �ȴ�.
		//�޼��� ������ �Ҷ� ��Ģ�� �� �˾Ƶ���.
		//�ڵ� �����ְ� ���� ���� ����� ��� �Ǵ� �� ����� ���� ���� ���� �ִ�.
		
		System.out.println(tom.getBonus());
		System.out.println(bill.getBonus());
		System.out.println(tom2.getBonus());
	}	
}


//class CEO extends Employee
//{
//	
//}
