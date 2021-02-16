package com.off.day6;

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


	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc) {
		super(isbn, title, author, publisher, price, desc);
		// TODO Auto-generated constructor stub
	}

	public Magazine(String isbn, String title, String author, String publisher, int price) {
		super(isbn, title, author, publisher, price);
		// TODO Auto-generated constructor stub
	}
	public Magazine() {
		// TODO Auto-generated constructor stub
	}


	public String toString() {
		String rDesc = super.getDesc();
		if(rDesc == null)
			rDesc = ""; 
		String rStr = String.format("%-10s|%s\t|%-10s|%-10s|%-10d|%-10s|%-10s",
				super.getIsbn(), super.getTitle(), super.getAuthor(), super.getPublisher(), super.getPrice(), rDesc, year+"."+month);
		return rStr;
	}

}
