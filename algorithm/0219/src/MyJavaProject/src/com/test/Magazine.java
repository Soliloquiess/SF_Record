package com.test;

/**
 * ���� ������ ��Ÿ���� Ŭ����
 * Book Ŭ������ ��� ����
 */
public class Magazine   {
	/**
	 * ����⵵
	 */
	private int year;
	/**
	 * �����
	 */
	private int month;
	
	/** �⺻ ������ */
	
	
	/** ���� ���� ��θ� �޾� �����ϴ� ������ */
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month,int quantity) {
		
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
}
