package com.ssafy.algo;

public class ProductTest {
	public static void main(String[] args) {
		//��ǰ ��������
		TV tv = new TV(1, "Ƽ��", 500000, 10,40,"led");
		Refrigerator r = new Refrigerator(2, "�����", 600000, 1, 100);
		
		
		
		//��ǰ ������� 
		System.out.println(tv.toString());
		System.out.println(r.toString());
	}
}
