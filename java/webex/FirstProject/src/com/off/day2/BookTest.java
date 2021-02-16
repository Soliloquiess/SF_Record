package com.off.day2;

public class BookTest {

	public static void main(String[] args) {
		//Manager ����
		//BookManager man = new BookManager();//�ȵ�
		BookManager man = BookManager.getInstance();
		BookManager man2 = BookManager.getInstance();
		
		Book b1 = new Book("12345", "�ڹٿ�������", "����", "green house", 
				25000, "�ڹ� ���� �Թ���");
		
		Book b2 = new Book("45662", "���� �� ġ� �Ծ�����", "james kay", 
				"red house", 18000, "ġ�� �����̾߱�");
		
		man.add(b1);
		man.add(b2);
		Book[] list = man.getList();
		
		for(Book bb: list)
			System.out.println(bb);
		
		System.out.println("------------------");
		Book b = man.searchByIsbn("12345");
		if(b != null) {
			System.out.println(b);
			
		}else {
			System.out.println("ã�� å�� �����ϴ�.");
		}
		System.out.println("------------------");
		man.remove("12345");
		list = man.getList();
		
		for(Book bb: list)
			System.out.println(bb);
		
	}

}
