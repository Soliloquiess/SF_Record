package com.Inter;


class Truck{}
interface Boat{};

//IShape �������̽��� ����(�ϼ�)�ϴ� �ڽ� Ŭ����
//�������̽��� implements�ص� ��� ���谡 ����
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
