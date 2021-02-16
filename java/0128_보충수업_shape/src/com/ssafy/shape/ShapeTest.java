package com.ssafy.shape;

import com.v.shape.Drawable;
import com.v.shape.Shape;
import com.v.shape.ShapeUtil;

public class ShapeTest {

	public static void main(String[] args) {

		ShapeUtil util = new ShapeUtil();
		
		// error
		//new Shape();
		//new Drwable();
		
		Circle c = new Circle(2);
		util.calcArea(c);
		util.display(c);
		
	}

}
