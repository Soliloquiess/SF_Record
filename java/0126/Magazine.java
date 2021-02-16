package com.off.day5;

public class Magazine extends Book {
	
	private int year;	
	private int month;
	
	
	public Magazine() {}	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("|");
		builder.append(year + "\t| ");
		builder.append(month);
		return builder.toString();
	}
	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc) {
		super(isbn, title, author, publisher, price, desc);
		// TODO Auto-generated constructor stub
	}
	
}
