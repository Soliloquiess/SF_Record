package com.ex;

import java.util.ArrayList;

/**
 * BookManager Ŭ������ �̿��Ͽ� ���� ��ü �߰�,����,��ȸ�ϴ� Ŭ����
 */
public class BookTest {

	public static void main(String[] args) {
		
		// ���� ����Ʈ�� �����ϰ� �����ϴ� BookManager ��ü�� �����Ѵ�.
		IBookManager man = BookManagerImpl.getInstance();
		
		System.out.println("**********************�ҷ��� ���� ��ü ���**********************");
		ArrayList<Book> books = man.getList();
		
		if(books == null || books.size() == 0){		// ��������Ʈ�� ���� ���
			System.out.println("��ϵ� ������ �����ϴ�.");
			
		}else{										// ��������Ʈ�� �մ� ���
			printList(books);
		}
		
		// BookManager ��ü�� �̿���  ���������� �߰��Ѵ�.
		man.add(new Book("21424", "Java Pro", "���ϳ�", "jaen.kr", 15000, "Java �⺻ ����",10));
		man.add(new Book("21425", "Java Pro2", "���ϳ�", "jaen.kr", 25000, "Java ����",20));
		man.add(new Book("35355", "�м�����", "�ҳ���", "jaen.kr", 30000, "SW �𵨸�",30));
		man.add(new Magazine("45678", "���� �˰���", "ȫ�浿", "jaen.kr", 10000, "1�� �˰���", 2021, 1,40));
		
		
		printList(books);
	
		System.out.println(man.searchByIsbn("21424"));
		System.out.println("------------------------------------------------------------------------------------");
		
		printList(man.searchByTitle("�м�����"));
		printList2(man.getMagazines());
		System.out.println(man.getTotalPrice());
		System.out.println("------------------------------------------------------------------------------------");
		
		System.out.println(man.getPriceAvg());
		System.out.println("------------------------------------------------------------------------------------");
		
		man.remove("35355");
		try {
			man.sell("21425", 5);
			man.sell("21424", 15);
		} catch (QuantityException | ISBNNotFoundException e) {
			System.out.println(e);			
		} 
		
		try {
			man.sell("99999", 3);			
		} catch (QuantityException | ISBNNotFoundException e) {
			System.out.println(e);			
		} 
		
		try {
			man.buy("32567", 5);
		} catch (ISBNNotFoundException e) {
			System.out.println(e);	
		}
		
		printList(man.sortedByIsbn());
		printList(man.sortedByTitle());
		
		//man.saveData(); // ��������Ʈ�� ���Ͽ� �����Ѵ�.
	}
	
	
	static void printList(ArrayList<Book> arrayList) {
		for (Book b : arrayList) {
			System.out.println(b);
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	static void printList2(ArrayList<Magazine> arrayList) {
		for (Magazine b : arrayList) {
			System.out.println(b);
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
	
}
