package com.v.shape;

public class ShapeUtil {

	public void calcArea(Shape s) {
		s.calculateArea();
		s.printArea();
	}
	
	public void display(Drawable d) {
		System.out.println("화면을 초기화하고 도형을 나타냅니다.");
		d.drawing();
	}
}
