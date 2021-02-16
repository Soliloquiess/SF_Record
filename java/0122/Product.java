package com.ssafy.algo;

public class Product {
	private int number; //상품번호
	private String name; //상품명
	private int price; //가격
	private int amount; //수량
	
	
	
	public Product() {
		super();
	}



	public Product(int number, String name, int price, int amount) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}



	public int getnumber() {
		return number;
	}



	public void setnumber(int number) {
		this.number = number;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
	

}
