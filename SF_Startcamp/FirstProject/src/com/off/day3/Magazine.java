package com.off.day3;
//VO
public class Magazine extends Book {
	private int year;
	private int month;
	
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
	public Magazine(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}
	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc) {
		super(isbn, title, author, publisher, price, desc);
		// TODO Auto-generated constructor stub
	}
	
	public Magazine() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + "]";
	}
	
	

}
