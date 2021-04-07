package com.test;

import java.util.ArrayList;

/* BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스*/
public class BookTest {

	public static void main(String[] args) {
		
		// 도서 리스트를 유지하고 관리하는 BookManager 객체를 생성한다.
		IBookManager bookManager = new BookManagerImpl();
		
		// BookManager 객체를 이용해  도서정보를 추가한다.
		bookManager.add(new Book("21424", "Java Pro", "김하나", "green.kr", 15000, "Java 기본 문법",10));
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "blue.kr", 25000, "Java 응용",20));
		bookManager.add(new Book("35355", "분석설계", "소나무", "white.kr", 30000, "SW 모델링",30));
		bookManager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "yellow.kr", 10000, "1월 알고리즘", 2021, 1,40));
		
		//추가한 도서 정보 확인
		System.out.println("********************** 도서 전체 목록**********************");
		ArrayList<Book> books = bookManager.getList();
		
		if(books == null || books.size() == 0){		// 도서리스트가 없는 경우
			System.out.println("등록된 도서가 없습니다.");
			
		}else{										// 도서리스트가 있는 경우
			for (Book b : books) {
				System.out.println(b);
			}
		}
				
		//isbn으로 검색
		
		//제목으로 검색
		
		//잡지만 검색
		
		//전체 도서 금액 합계
		
		//전체 도서 평균 금액
		
		//isbn 35355인 도서 삭제 후 확인
		
		//isbn 21425인 도서 5권 판매
		
		//isbn 21424인 도서 15권 판매
		
		//isbn 99999인 도서 3권 판매
		
		//isbn 32567인 도서 5권 구입
		
		//잡지 아닌 책만 검색
		
		//
	}
}
