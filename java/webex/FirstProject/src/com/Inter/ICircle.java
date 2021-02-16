package com.Inter;


class Truck{}
interface Boat{};

//IShape 인터페이스를 구현(완성)하는 자식 클래스
//인터페이스를 implements해도 상속 관계가 성립
public class ICircle extends Truck implements IShape, Boat {
	int r;
	
	

	public ICircle(int r) {
		this.r = r;
	}

	public ICircle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCircum() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
