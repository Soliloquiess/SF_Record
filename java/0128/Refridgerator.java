package com.ssafy.algo;

public class Refridgerator extends Product {

	private int size;

	public Refridgerator() {
		super();
	}

	public Refridgerator(String num, String nam, int p, int st, int sz) {
		this.numb = num;
		this.name = nam;
		this.price = p;
		this.stock = st;
		this.size = sz;
	}

	public String toString() {
		String info = "제품 번호: " + numb + "\n제품명: " + name + "\n가격 정보: " + price + "\n재고수량: " + stock + "\n용량: " + size;
		return info;
	}
	
	public void setsize(int s) {
		this.size = s;
	}
	public int getsize() {
		return size;
	}
}
