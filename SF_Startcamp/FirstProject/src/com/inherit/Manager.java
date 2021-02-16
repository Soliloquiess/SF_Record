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
	//자식보다 부모가 먼저 생성되어야 하므로 부모 생성자에 맞춰서 값을 전달해야 함.
	//super(): 자식 클래스에서 부모 생성자 호출시 사용.
	{
		super(num,name,salary);	//받은 4개중에 3개는  대신해줌
		//파라미터 넣어서 보냄.
//		this.num = num;
//		this.name = name;
//		this.salary = salary;
		this.mcode= mcode;	//본인은 이거만 세팅하면 됨(부모엔 얘가 없으니까)
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
		//메서드 재정의 하면 무조건 재정의 한 거로 호출이 된다.
		//메서드 재정의 할때 규칙을 잘 알아두자.
		//코드 보여주고 다음 실행 결과가 어떻게 되는 지 물어보는 모델이 나올 수도 있다.
		
		System.out.println(tom.getBonus());
		System.out.println(bill.getBonus());
		System.out.println(tom2.getBonus());
	}	
}


//class CEO extends Employee
//{
//	
//}
