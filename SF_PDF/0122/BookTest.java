package com.off.day2;

public class BookTest {

	public static void main(String[] args) {
		//Manager 생성
		//BookManager man = new BookManager();//안됨
		BookManager man = BookManager.getInstance();
		BookManager man2 = BookManager.getInstance();
		
		Book b1 = new Book("12345", "자바완전정복", "김상우", "green house", 
				25000, "자바 기초 입문서");
		
		Book b2 = new Book("45662", "누가 내 치즈를 먹었을까", "james kay", 
				"red house", 18000, "치즈 도둑이야기");
		
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
			System.out.println("찾는 책이 없습니다.");
		}
		System.out.println("------------------");
		man.remove("12345");
		list = man.getList();
		
		for(Book bb: list)
			System.out.println(bb);
		
	}

}
