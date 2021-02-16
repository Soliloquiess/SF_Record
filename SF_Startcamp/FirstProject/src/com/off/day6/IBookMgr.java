package com.off.day6;

import java.util.ArrayList;

public interface IBookMgr {
	// 1. 데이터 입력 기능
		public void add(Book p);
		
		// 2. 데이터 저체 검색 기능
		public ArrayList<Book> search();
		
		// 3. Isbn 번호로 상품을 검색
		public ArrayList<Book> search(String isbn);
		
		// 4. Title 으로 상품을 검색하는 기능
		public ArrayList<Book> searchName(String name);
		// 5. Book만 검색하는 기능
		public ArrayList<Book> searchBook(); 
		
		// 6. Magazine만 검색하는 기능
		public ArrayList<Book> searchMagazine(); 
		
		// 7. Magazine중 올해 잡지만 검색하는 기능
		public ArrayList<Book> searchYear(int n); 
		
		// 8. 출판사로 검색하는 기능
		public ArrayList<Book> searchPub(String pub); 
		
		// 9. 가격으로 검색 기능
		public ArrayList<Book> searchPrice(int price);
		
		// 10. 저장된 모든 도서의 금액 합계를 구하는기능
		public int totalPrice();
		
		// 11. 저장된 모든 도서의 금액 평균을 구하는 기능
		public double totalAverage(); 
		
		public int getSize();

}
