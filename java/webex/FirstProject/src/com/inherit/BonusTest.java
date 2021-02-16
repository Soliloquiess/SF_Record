package com.inherit;

public class BonusTest {

	public void printBounus(Employee who) 
	{
		System.out.println(who.getBonus());
	}
	public static void main(String[] args) 
	{
		BonusTest bt = new BonusTest();
		Employee tom =  new Employee(123, "tom", 3000);
		bt.printBounus(tom);
		
		Manager bill = new Manager(890, "bill", 5000y, mcode);
	}
}
