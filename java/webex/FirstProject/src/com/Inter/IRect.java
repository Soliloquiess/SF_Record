package com.Inter;


public class IRect implements IShape {
	int width, hegiht;

	public IRect(int width, int hegiht) {
		this.width = width;
		this.hegiht = hegiht;
	}

	public IRect() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * hegiht;
	}

	@Override
	public double getCircum() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
