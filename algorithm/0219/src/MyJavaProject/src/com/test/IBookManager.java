package com.test;

import java.util.ArrayList;

/* ��������Ʈ�� �����ϱ� ���� Ŭ������ ���� �������� �������̽� */
public interface IBookManager {
	
	void add(Book book); //������ ��������Ʈ�� �߰��Ѵ�.	
	void remove(String isbn);	//������ȣ�� �ش� ������ ��������Ʈ���� �����Ѵ�.
	ArrayList<Book> getList();	//��ϵ� ��������Ʈ�� ��ȯ�Ѵ�.
	ArrayList<Book> sortedByIsbn();	//isbn ���� ���ĵ� ��������Ʈ�� ��ȯ�Ѵ�.(�⺻ ���ı���)
	ArrayList<Book> sortedByTitle();	//title ���� ���ĵ� ��������Ʈ�� ��ȯ�Ѵ�.
	
	Book searchByIsbn(String isbn);	//������ȣ�� �ش� ������ ��ȸ�Ѵ�.
	ArrayList<Book> searchByTitle(String title);//���� ������ �����ϰ� �ִ� ��������Ʈ�� ��ȯ�Ѵ�.	
	ArrayList<Magazine> getMagazines();	//��������Ʈ�� ��ȯ�Ѵ�.
	Book[] getBooks();//��������Ʈ�� ��ȯ�Ѵ�. 	
	int getTotalPrice();//��������Ʈ�� ������ ������ ��ȯ�Ѵ�.
	
	double getPriceAvg();//��������Ʈ�� ������ ����� ��ȯ�Ѵ�.	
	
	//������ȣ�� �ش��ϴ� ������ ������ŭ �Ǹ�ó���Ͽ� ��� ���ҽ�Ų��.
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	
	//������ȣ�� �ش��ϴ� ������ ������ŭ ���� ó���Ͽ� ��� ������Ų��.
	void buy(String isbn, int quantity) throws ISBNNotFoundException;

}