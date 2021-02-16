package com.ssafy.algo;

public class ProductTest {
	public static void main(String[] args) {
		//제품 정보저장
		TV tv = new TV(1, "티비", 500000, 10,40,"led");
		Refrigerator r = new Refrigerator(2, "냉장고", 600000, 1, 100);
		
		
		
		//제품 정보출력 
		System.out.println(tv.toString());
		System.out.println(r.toString());
	}
}
