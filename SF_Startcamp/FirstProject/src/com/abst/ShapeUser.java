package com.abst;

public class ShapeUser {
	public static void main(String[] args) {
		Shape[] s = new Shape[3];
		//Shaep�� �߻� Ŭ������ ���� �ȵ�?
//		���� �Ǳ� �ϴµ� shape�� �ƴ϶�
//		ShapeŸ���� �� �� �ִ� �迭 3���� �����ȰŤӤ�
//		Shape�� �����Ȱ� �ƴ�.
	
//		Shape[] s = new Shape(); 
//		�̷��� �ؾ� Shape�� �����Ȱ�
//		ShapeŸ���� �ֳ�?
		s[0] = new Circle(10);
		s[1] = new Rect(3,5);
		s[2] = new Circle(15);
		
		for(Shape x:s)
		{
			System.out.println("����"+x.getArea());
			System.out.println("�ѷ�"+x.getCircum());
			System.out.println(x.getClass().getSimpleName());
			System.out.println();
		}
		
	}
}
