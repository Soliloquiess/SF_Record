package com.Inter;

public class IShapeUser {
	
	public static void main(String[] args) {
		Truck[] t = new Truck[3];
		
		IShape[] is = new IShape[3];
		is[0] = new ICircle(10);
		is[1] = new IRect(5, 8);
		is[2] = new ICircle(15);
		
		for (int i = 0; i < is.length; i++) {
			System.out.println(is[i].getClass().getName());
		}
		
	}

}
