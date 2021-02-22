package com.ex;

import java.io.Serializable;

/**
 * ���� ������ ��Ÿ���� Ŭ����
 */
public class Book implements Serializable, Comparable<Book> {	// ��ü ����ȭ �����ϵ���  Serializable �������̽� ����
	/** ���� ��ȣ */
	private String isbn;		
	/**	���� */
	private String title;		
	/** ���� */
	private String author;		
	/** ���ǻ� */
	private String publisher;	
	/** ���� */
	private int price;			
	/**	���� */
	private String desc;		
	/** ��� ���� */
	private int quantity;
	/** �⺻ ������ */
	public Book() {
	}
	/** ���� ������ ��� �޾� �����ϴ� ������ */
	public Book(String isbn, String title, String author, String publisher, int price, String desc,int quantity){
		// ���� ������ ��ü�� ���¸� �ʱ�ȭ�Ѵ�.
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.quantity = quantity;
	}
	/**
	 * ������ȣ�� ��ȯ�Ѵ�.
	 * @return ������ȣ
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * ������ȣ�� �����Ѵ�.
	 * @param isbn : ������ȣ
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * ������ ��ȯ�Ѵ�.
	 * @return ����
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * ������ �����Ѵ�.
	 * @param title : ����
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * ���ڸ� ��ȯ�Ѵ�.
	 * @return ����
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * ���ڸ� �����Ѵ�.
	 * @param author : ����
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * ���ǻ縦 ��ȯ�Ѵ�.
	 * @return ���ǻ�
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * ���ǻ縦 �����Ѵ�.
	 * @param publisher : ���ǻ�
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * ������ ��ȯ�Ѵ�.
	 * @return ����
	 */	
	public int getPrice() {
		return price;
	}
	/**
	 * ������ �����Ѵ�.
	 * @param price : ����
	 */	
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * ������ ��ȯ�Ѵ�.
	 * @return ����
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * ������ �����Ѵ�.
	 * @param desc : ����
	 */		
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * �������� ��ȯ�Ѵ�.
	 * @return ������
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * �������� �����Ѵ�.
	 * @param amount : ������
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * ������ ������ ���ڿ��� ��ȯ�Ѵ�
	 * @return ��������
	 */
	public String toString() {
		return isbn + '\t' + "| " + title + "  \t" + "| " + author + '\t' + "| " + publisher + '\t'
				+ "| " + price + '\t' + "| " + desc + '\t'+ "| " + quantity + '\t';
	}
	@Override
	public int compareTo(Book o) {
		return this.isbn.compareTo(o.isbn);
	}
}

