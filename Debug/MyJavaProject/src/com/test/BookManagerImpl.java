package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/* ��������Ʈ�� �÷������� �����ϸ� �����ϴ� Ŭ����
 * �̱��� ���������� ���� */
public class BookManagerImpl implements IBookManager {
	/* ������ ���� ����Ʈ */
	private ArrayList<Book> books = null; 
	
	IBookManager instance;
	
	/* �⺻ ������ */
	private BookManagerImpl() { // �ܺο��� ��ü ������ ���� ���ϵ��� ���� ������ ����
				loadData(;)
	}
	 
	/* ���ο��� ������ ��ü�� �������� ��ȯ�Ѵ�. */
	 IBookManager getInstance() {
		return instance;
	}

	@Override
	public void add(Book book) {
		books.add(book);	// ����Ʈ �������� �߰�
	}
	
	@Override
	public void remove(String isbn){
		final int size = books.size();	// ����Ǿ� �ִ� �������� Ȯ��
		int i;
		for ( i = 0; i < size; ++i) {
			// ������ ������ ã�Ҵٸ� �ش� ���� ��ġ�� �̿��Ͽ� ����Ʈ���� ���� ����
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}
		if(i == size)
			System.out.println("remove error!");
	}
	
	@Override
	public ArrayList<Book> getList() {
		return books;			// �÷��� ������ �迭�� ���� �� �迭 ���� 
	}

	@Override
	public Book searchByIsbn(String isbn) {		
		for (Book book : books) {
			if(book.getIsbn().equals(isbn)) 
				return book;
		}
		return null;
	}
	
	@Override
	public ArrayList<Book> searchByTitle(String title) {
		// ������ �����ϴ� ������ ������ �� �� �����Ƿ� �÷����� Ȱ���Ͽ� ���� �� �������� �迭�� �ٲپ� ��ȯ�Ѵ�.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(book.getTitle().contains(title)) 
				temp.add(book);
		}
		return temp; 			// �÷����� ������ �迭�� ���� �� ����
	}
	
	@Override
	public ArrayList<Magazine> getMagazines() {
		// ������ ������ �� �� �����Ƿ� �÷����� Ȱ���Ͽ� ���� �� �������� �迭�� �ٲپ� ��ȯ�Ѵ�.
		ArrayList<Magazine> temp = new ArrayList<Magazine>();
		for (Book book : books) {
			if(book  instanceof Magazine) temp.add((Magazine)book);
		}		
		return temp; 					// �÷����� ������ �迭�� ���� �� ����
	} 	
	
	/* ������ �ƴ� ��������Ʈ�� ��ȯ�Ѵ�. */
	@Override
	public Book[] getBooks() {
		// �Ϲ� ������ ������ �� �� �����Ƿ� �÷����� Ȱ���Ͽ� ���� �� �������� �迭�� �ٲپ� ��ȯ�Ѵ�.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(!(book  instanceof Magazine)) temp.add(book);
		}
		Book[] result = new Book[temp.size()];	// ��ȸ ����� ���� �÷����� ũ�⸦ Ȱ���Ͽ� �迭 ����
		return temp.toArray(result); 			// �÷����� ������ �迭�� ���� �� ����
	}
	/* ��������Ʈ�� ������ ������ ��ȯ�Ѵ�. */
	@Override
	public int getTotalPrice() {
		int total = 0;
		for (Book book : books) {
			total += book.getPrice();
		}
		return total;
	}
	/* ���������� ����� ��ȯ�Ѵ�.	 */
	@Override
	public double getPriceAvg() {
		return (double)getTotalPrice()/ books.size();
	}
	
	/*
	 * ������ȣ�� �ش��ϴ� ������ ������ŭ �Ǹ�ó���Ͽ� ��� ���ҽ�Ų��.
	 * QuantityException �߻�: ��� ���� ������ ���� ��Ȳ
	 * ISBNNotFoundException �߻�: ������ȣ�� �ش��ϴ� ������ �������� �ʴ� ���ܻ�Ȳ 
	 */
	@Override
	public void sell(String isbn, int quantity)  {
		Book book = searchByIsbn(isbn);				// ������ȣ ���� ��ȸ
		if(book == null) 
		// ������ȣ ���� ��ȸ ���н� ISBNNotFoundException ����� ���� ���� �߻���Ŵ
		
		int res = book.getQuantity() - quantity;	// �Ǹ� �� ���ο� ��� ���� ���
		if(res < 0) 
		// ������ ������ QuantityException ����� ���� ���� �߻���Ŵ
		
		book.setQuantity(res); 						// �Ǹ��� ���� ���������� ������ ����
	}
	
	/*
	 * ������ȣ�� �ش��ϴ� ������ ������ŭ ���� ó���Ͽ� ��� ������Ų��.
	 * ISBNNotFoundException �߻�: ������ȣ�� �ش��ϴ� ������ �������� �ʴ� ���ܻ�Ȳ 
	 */
	@Override
	public void buy(String isbn, int quantity)  {
		Book book = searchByIsbn(isbn);	// ������ȣ ���� ��ȸ
		if(book == null) 
			throw new ISBNNotFoundException(isbn); //������ȣ ���� ��ȸ ���н� ISBNNotFoundException ����� ���� ���� �߻���Ŵ
		
		book.setQuantity(book.getQuantity() + quantity);// ���� ���� ���ο� ��� ���� ����Ͽ� ��� ���� ���� 
	}

	@Override
	public ArrayList<Book> sortedByIsbn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> sortedByTitle() {
		// TODO Auto-generated method stub
		return null;
	}	
}
