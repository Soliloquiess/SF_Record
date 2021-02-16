package com.off.day7;



import java.util.ArrayList;

public interface IBookMgr {
		// 1. 데이터 입력 기능
		public void add(Book p);
		
		// 2. 데이터 전체 출력 기능
		public ArrayList<Book> search();
		
		// 3. 도서가 판매되어 재고 수량을 빼는 기능
		void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
		
		// 4. 도서가 구매되어 재고 수량을 더하는 기능
		void buy(String isbn, int quantity) throws ISBNNotFoundException;
		
		// 5. 재고 도서들의 수량*금액을 하여 총 재고 금액을 구하여 리턴
		int getTotalAmount();
		

}
