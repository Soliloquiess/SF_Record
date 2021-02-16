package com.off.day6;

import java.util.ArrayList;

public interface IBookMgr {
	// 1. ������ �Է� ���
		public void add(Book p);
		
		// 2. ������ ��ü �˻� ���
		public ArrayList<Book> search();
		
		// 3. Isbn ��ȣ�� ��ǰ�� �˻�
		public ArrayList<Book> search(String isbn);
		
		// 4. Title ���� ��ǰ�� �˻��ϴ� ���
		public ArrayList<Book> searchName(String name);
		// 5. Book�� �˻��ϴ� ���
		public ArrayList<Book> searchBook(); 
		
		// 6. Magazine�� �˻��ϴ� ���
		public ArrayList<Book> searchMagazine(); 
		
		// 7. Magazine�� ���� ������ �˻��ϴ� ���
		public ArrayList<Book> searchYear(int n); 
		
		// 8. ���ǻ�� �˻��ϴ� ���
		public ArrayList<Book> searchPub(String pub); 
		
		// 9. �������� �˻� ���
		public ArrayList<Book> searchPrice(int price);
		
		// 10. ����� ��� ������ �ݾ� �հ踦 ���ϴ±��
		public int totalPrice();
		
		// 11. ����� ��� ������ �ݾ� ����� ���ϴ� ���
		public double totalAverage(); 
		
		public int getSize();

}
