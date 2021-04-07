package com.ssafy.shape;

import com.v.shape.Drawable;
import com.v.shape.Shape;

public class Circle extends Shape implements Drawable
{

	private double radius;
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	//@Override
	public void drawing() {
		System.out.println("2D로 원을 그립니다.");
	}

	@Override
	public void calculateArea() {
		super.area = Math.PI * radius * radius;
	}

}
