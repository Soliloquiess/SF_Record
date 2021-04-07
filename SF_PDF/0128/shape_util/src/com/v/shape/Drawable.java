package com.v.shape;

public interface Drawable {

	int MAX_SIZE = 10;
//	public static final int MAX_SIZE = 10;
	
	void drawing();
	
	//public abstract void drawing();
	
	//JAVA 8
	default public void test() {
		System.out.println("test...");
	}
}
