package com.v.shape;

public abstract class Shape {

	protected double area;
	
	public abstract void calculateArea();
	
	public void printArea() {
		System.out.println("==================================");
		System.out.printf("면적 : %.2f\n",area);
		System.out.println("==================================");
	}
}
