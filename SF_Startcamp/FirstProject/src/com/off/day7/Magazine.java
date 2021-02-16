package com.off.day7;


public class Magazine extends Book 
{
	private int month;	

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public Magazine() {
		// TODO Auto-generated constructor stub
	}

	public Magazine(String isbn, String title, int price, int quantity, int month) {
		super(isbn, title, price, quantity);
		this.month = month;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Megazine [isbn=" + super.getIsbn() + ", title=" + super.getTitle() + ", price=" + super.getPrice() + ", quantity=" + super.getQuantity() + ", month=" + this.month + "]";
	}
	
	
}