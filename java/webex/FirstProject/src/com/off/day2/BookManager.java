package com.off.day2;

import java.util.Arrays;
//DAO(Data Access Object):crud: create read update delete
//Book�� �����ϴ� Ŭ����: 
//Book�� ������ �� �ִ� �迭�� ������ ���� Book[]
//1.�迭�� Book����, 2. �迭���� Book ����, 3.�迭 ���� ����, 4.isbn�������� Book �˻�

public class BookManager {
	
	final int MAX = 100; //�迭�� ������ �� �ִ� �ִ� å�� �� ��
	Book[] booklist;//Book�� ������ �迭
	int count;//�迭�� ����� å�� ��
	
	//Singleton pattern ����
	//1.�ڱ� �ڽ� Ÿ���� ���� ����:private static
	private static BookManager manager;
	
	//2.private  ������(�ܺο��� ���� ���ϰ� ����)
	private BookManager() {
		booklist = new Book[MAX];		
	}
	
	//3.�ܺο��� ���� ������ public static �޼ҵ�
	public static BookManager getInstance() {
		if(manager == null)
			manager = new BookManager();
		return manager;
	}
	
	public void add(Book b) {//�迭�� å �߰�
		if(count < MAX)
			booklist[count++] = b;
	}
	
	public void remove(String isbn) {//�迭���� Ư�� ��ȣ å ����
		for (int i = 0; i < count; i++) {
			Book one = booklist[i];
			if(one.getIsbn().equals(isbn)) {//������ å�� ã��
				booklist[i] = booklist[count - 1];//��������ġ�� å�� i��ġ�� �ű�
				booklist[count - 1] = null;
				--count;//å �Ǽ��� ����
				break;
			}
		}
	}
	
	public Book[] getList() {//�迭�� ����
		return Arrays.copyOfRange(booklist, 0, count);//���� ���� ������ �迭�� ����
		//return booklist;
	}
	
	public Book searchByIsbn(String isbn) {//Ư����ȣ�� å�� �˻��� ����
		for (int i = 0; i < count; i++) {
			if(booklist[i].getIsbn().equals(isbn))
				return booklist[i];
		}
		return null;
	}
	
	public void update(String isbn, int price) {
		
	}

}
