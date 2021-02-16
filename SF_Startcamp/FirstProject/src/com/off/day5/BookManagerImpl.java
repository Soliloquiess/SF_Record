package com.off.day5;

import java.util.ArrayList;
import java.util.Arrays;

import com.off.day6.Book;

//DAO(Data Access Object):crud: create read update delete
//Book�� �����ϴ� Ŭ����: 
//Book�� ������ �� �ִ� �迭�� ������ ���� Book[]
//1.�迭�� Book����, 2. �迭���� Book ����, 3.�迭 ���� ����, 4.isbn�������� Book �˻�
/* ��������Ʈ�� �迭�� �����ϸ� �����ϴ� Ŭ���� */

public class BookManagerImpl implements IBookManager{

	private static int MAX_SIZE = 100;//������ �ִ� ���� ��
	private Book[] books = new Book[MAX_SIZE];
	
	/*	 * ���� ��ϵ� ���� �� */
	private int size;
		
	//������ 
	private BookManagerImpl() {};
	
	
	public void add(Book book) {
		if(size<MAX_SIZE) books[size++] = book;
	}
	
	public void remove(String isbn) { //�迭���� Ư�� ��ȣ å ����
		for (int i = 0; i < size; ++i) {
			// ������ ������ ã�Ҵٸ� �ش� ���� ��ġ�� �迭�� ���� ������ ������ ����
			if (books[i].getIsbn().equals(isbn)) {
				books[i] = books[size-1];
				books[size-1]=null;			// ������ ���� ��ġ null ó��
				--size;						// ��ϵ� ���� �� ����
				break;
			}
		}
	}
	
	
	//������ ���� ���.
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);	//������ ���ο� �迭 ����.
	}
	
	//isbn���� Ư�� å �˻��ؼ� ����.

	public Book searchByIsbn(String isbn) { //Ư����ȣ�� å�� �˻��� ����
		for (int i = 0; i < size; ++i) {
			if (books[i].getIsbn().equals(isbn)) return books[i]; 
		}
		return null;
	}
	
	public Book search(String isbn) {
		temp;
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i).getIsbn().equals(isbn)) 
				temp.add(bm.get(i));
		}
		return temp;
	}
	
	//Ư�� Ÿ��Ʋ�� å ����.
	public Book[] searchByTitle(String title) {
		int count = 0; 
		for (int i = 0; i < size; ++i) {	// ���� ������ �����ϴ� ������ ���� ī��Ʈ
			if (books[i].getTitle().contains(title)) 
				++count;
		}
		Book[] result = new Book[count];	// ��� ī��Ʈ��ŭ �迭 ����
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if (books[i].getTitle().contains(title)) { // ���� ������ �����ϴ� ������ �迭�� ���
				result[idx++] = books[i];
			}
		}
		return result; 
	}

	// Magazine�� �˻��ϴ� ���
	public Magazine[] getMagazines() {
		int count = 0;
		for (int i = 0; i < size; ++i) {	// ���� ���� ī��Ʈ
			if (books[i] instanceof Magazine) 
				++count;
		}
		
		Magazine[] result = new Magazine[count];	// ��� ī��Ʈ��ŭ �迭 ����
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if (books[i] instanceof Magazine) {	// ������ �迭�� ���
				result[idx++] = (Magazine)books[i];
			}
		}
		return result;
	} 
	
	public Book[] getNovel() {
		int count = 0; 
		for (int i = 0; i < size; ++i) {
			if ((books[i] instanceof Novel)) 
				++count;
		}
		
		Novel[] result = new Novel[count];
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if ((books[i] instanceof Novel)) {
				result[idx++] = (Novel) books[i];
			}
		}
		return result;
	}
	// ����� ��� ������ �ݾ� �հ踦 ���ϴ±��
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < size; ++i) {
			total += books[i].getPrice();
		}
		return total;
	}
//  ����� ��� ������ �ݾ� ����� ���ϴ� ���
	public double getPriceAvg() {
		return (double)getTotalPrice()/ size;
	}
}
