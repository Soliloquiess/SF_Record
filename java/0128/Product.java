package com.ssafy.algo;

public class Product {
	public String numb;
	public String name;
	public int price;
	public int stock;

	public Product() {
		this("제품", "제품", 0, 0);
	}

	public Product(String nu, String na, int p, int st) {
		numb = nu;
		name = na;
		price = p;
		stock = st;
	}

	public String toString() {
		String info = "제품 번호: " + numb + "\n제품명: " + name + "\n가격 정보: " + price + "\n재고수량: " + stock + "\n용량: ";
		return info;
	}
}
