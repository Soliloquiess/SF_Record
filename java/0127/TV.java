package com.ssafy.algo;

public class TV extends Product {

	// 추가 정보
	private int inch;
	private String type;

	public TV() {
		super();
	}

	public TV(String num, String nam, int p, int st, int ic, String t) {
		this.numb = num;
		this.name = nam;
		this.price = p;
		this.stock = st;
		this.inch = ic;
		this.type = t;
	}

	public String toString() {
		String info = "제품 번호: " + numb + "\n제품명: " + name + "\n가격 정보: " + price + "\n재고수량: " + stock + "\n인치: " + inch
				+ "\n타입: " + type;
		return info;
	}

}
