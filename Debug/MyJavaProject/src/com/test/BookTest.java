package com.test;

import java.util.ArrayList;

/* BookManager Ŭ������ �̿��Ͽ� ���� ��ü �߰�,����,��ȸ�ϴ� Ŭ����*/
public class BookTest {

	public static void main(String[] args) {
		
		// ���� ����Ʈ�� �����ϰ� �����ϴ� BookManager ��ü�� �����Ѵ�.
		IBookManager bookManager = new BookManagerImpl();
		
		// BookManager ��ü�� �̿���  ���������� �߰��Ѵ�.
		bookManager.add(new Book("21424", "Java Pro", "���ϳ�", "green.kr", 15000, "Java �⺻ ����",10));
		bookManager.add(new Book("21425", "Java Pro2", "���ϳ�", "blue.kr", 25000, "Java ����",20));
		bookManager.add(new Book("35355", "�м�����", "�ҳ���", "white.kr", 30000, "SW �𵨸�",30));
		bookManager.add(new Magazine("45678", "���� �˰���", "ȫ�浿", "yellow.kr", 10000, "1�� �˰���", 2021, 1,40));
		
		//�߰��� ���� ���� Ȯ��
		System.out.println("********************** ���� ��ü ���**********************");
		ArrayList<Book> books = bookManager.getList();
		
		if(books == null || books.size() == 0){		// ��������Ʈ�� ���� ���
			System.out.println("��ϵ� ������ �����ϴ�.");
			
		}else{										// ��������Ʈ�� �ִ� ���
			for (Book b : books) {
				System.out.println(b);
			}
		}
				
		//isbn���� �˻�
		
		//�������� �˻�
		
		//������ �˻�
		
		//��ü ���� �ݾ� �հ�
		
		//��ü ���� ��� �ݾ�
		
		//isbn 35355�� ���� ���� �� Ȯ��
		
		//isbn 21425�� ���� 5�� �Ǹ�
		
		//isbn 21424�� ���� 15�� �Ǹ�
		
		//isbn 99999�� ���� 3�� �Ǹ�
		
		//isbn 32567�� ���� 5�� ����
		
		//���� �ƴ� å�� �˻�
		
		//
	}
}
