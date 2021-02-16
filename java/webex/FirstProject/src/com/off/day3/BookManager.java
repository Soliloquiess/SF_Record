package com.off.day3;

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
		// ������ ������ ã�Ҵٸ� �ش� ���� ��ġ�� �迭�� ���� ������ ������ ����
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
	
	//������ ���� ���.
	public Book[] getList() {//�迭�� ����
		return Arrays.copyOfRange(booklist, 0, count);//���� ���� ������ �迭�� ����
		//return booklist;
	}
	
	//isbn���� Ư�� å �˻��ؼ� ����.
	public Book searchByIsbn(String isbn) {//Ư����ȣ�� å�� �˻��� ����
		for (int i = 0; i < count; i++) {
			if(booklist[i].getIsbn().equals(isbn))
				return booklist[i];
		}
		return null;
	}
	
	//Ư�� Ÿ��Ʋ�� å ����.
	public Book[] searchByTitle(String name) {
		Book[] temp = new Book[100];
		int tempCnt = 0;
		for (int i = 0; i < count; i++) {
			if(booklist[i].getTitle().contains(name)) 
				temp[tempCnt++] = booklist[i];
		}
		return temp;		
	}
	
	//Ư�� å �˻��ؼ� ����.(
//	public Book[] getBook() {
//		Book[] temp = new Book[100];
//		int tempCnt = 0;
//		for (int i = 0; i < count; i++) {
//			if(booklist[i] instanceof Book) 
////				continue;
//			temp[tempCnt++] = booklist[i];
//		}
//		return temp;
//	}
	
	//  Book�� �˻��ϴ� ���
		public Book[] getBooks() {
			Book[] temp = new Book[100];
			int tempCnt = 0;
			for (int i = 0; i < count; i++) {
				if(booklist[i] instanceof Magazine) continue;
				temp[tempCnt++] = booklist[i];
			}
			return temp;
		}
		
		// Magazine�� �˻��ϴ� ���
		public Book[] getMagazines() {
			Book[] temp = new Book[100];
			int tempCnt = 0;
			for (int i = 0; i < count; i++) {
				if(booklist[i] instanceof Magazine) {
					temp[tempCnt++] = booklist[i];
				}
			}
			return temp;
		}
		
		// ����� ��� ������ �ݾ� �հ踦 ���ϴ±��
		public int getTotalPrice() {
			int total = 0;
			for (int i = 0; i < count; i++) {
				total += booklist[i].getPrice();
			}
			return total;
		}
		
		//  ����� ��� ������ �ݾ� ����� ���ϴ� ���
		public double getTotalAverage() {
			int total = getTotalPrice();
			double avg = (double)total / count;
			return avg;
		}
		
		public int getSize() {
			return count;
		}

		
	public void update(String isbn, int price) {
		
	}

}
