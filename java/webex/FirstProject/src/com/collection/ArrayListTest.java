package com.collection;

import java.util.ArrayList;

import com.abst.Rect;

//ArrayList(List����): ���� o, �ߺ� o
public class ArrayListTest {
	public static void main(String[] args) {
		
		ArrayList<Rect> shape = new ArrayList<>();
		shape.add(new Rect(4,5));
		shape.add(new Rect(2,6));
		shape.add(new Rect(7,8));

//		Rect r = shape.get(2); //index��ġ�� ������ ������
//		System.out.println(shape);
		shape.remove(1);
		shape.clear();//remove all
		
		
		System.out.println(shape.isEmpty());
		System.out.println(shape.size());
		for(Rect r:shape)
		{
			System.out.println(r.getArea());
		}
		
		

		ArrayList<String> str = new ArrayList<>();
		str.add("red");
		str.add("blue");
		str.add("yellow");
		str.add("black");
		str.add("black");
		for(String s : str)
		{
			
		}
		
	}
}
