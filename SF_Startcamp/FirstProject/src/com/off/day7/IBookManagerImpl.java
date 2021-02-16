package com.off.day7;




import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class IBookManagerImpl implements IBookMgr {
	private ArrayList<Book> bm = new ArrayList<>();
	
	
	
	public IBookManagerImpl() {

	}

	// 1. 데이터 입력 기능
	public void add(Book p) {
		bm.add(p);		
	}
	
	// 2. 데이터 저체 검색 기능
	public ArrayList<Book> search() {
		return bm;
	}

	// 3. 도서가 판매되어 재고 수량을 빼는 기능
	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		for (Book book : bm) {
			if(book.getIsbn().equals(isbn)) {
				int q = book.getQuantity() - quantity;
				if(q < 0)
					throw new QuantityException();
				book.setQuantity(q);
				return;
			}
		}
		// 반복문을 모두 통과했다는 것은
		// 검색한 Isbn이 존재하지 않았다는 이야기
		throw new ISBNNotFoundException();
		
	}

	// 4. 도서가 구매되어 재고 수량을 더하는 기능
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		for (Book book : bm) {
			if(book.getIsbn().equals(isbn)) {
				int q = book.getQuantity() + quantity;
				book.setQuantity(q);
				return;
			}
		}		
		// 반복문을 모두 통과했다는 것은
		// 검색한 Isbn이 존재하지 않았다는 이야기
		throw new ISBNNotFoundException();
	}
	
	// 5. 재고 도서들의 수량*금액을 하여 총 재고 금액을 구하여 리턴
	@Override
	public int getTotalAmount() {
		int sum = 0;
		for (Book book : bm) {
			sum += book.getPrice() * book.getQuantity();
		}
		return sum;
	}


	public int getSize() {
		return bm.size();
	}
}
