package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/* 도서리스트를 컬렉션으로 유지하며 관리하는 클래스
 * 싱글톤 디자인패턴 적용 */
public class BookManagerImpl implements IBookManager {
	/* 관리할 도서 리스트 */
	private ArrayList<Book> books = null; 
	
	IBookManager instance;
	
	/* 기본 생성자 */
	private BookManagerImpl() { // 외부에서 객체 생성을 하지 못하도록 접근 제어자 지정
				loadData(;)
	}
	 
	/* 내부에서 생성한 객체의 참조값을 반환한다. */
	 IBookManager getInstance() {
		return instance;
	}

	@Override
	public void add(Book book) {
		books.add(book);	// 리스트 마지막에 추가
	}
	
	@Override
	public void remove(String isbn){
		final int size = books.size();	// 저장되어 있는 도서개수 확인
		int i;
		for ( i = 0; i < size; ++i) {
			// 삭제할 도서를 찾았다면 해당 도서 위치를 이용하여 리스트에서 도서 삭제
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}
		if(i == size)
			System.out.println("remove error!");
	}
	
	@Override
	public ArrayList<Book> getList() {
		return books;			// 컬렉션 내용을 배열로 복사 후 배열 리턴 
	}

	@Override
	public Book searchByIsbn(String isbn) {		
		for (Book book : books) {
			if(book.getIsbn().equals(isbn)) 
				return book;
		}
		return null;
	}
	
	@Override
	public ArrayList<Book> searchByTitle(String title) {
		// 제목을 포함하는 도서의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(book.getTitle().contains(title)) 
				temp.add(book);
		}
		return temp; 			// 컬랙션의 내용을 배열로 복사 후 리턴
	}
	
	@Override
	public ArrayList<Magazine> getMagazines() {
		// 잡지의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Magazine> temp = new ArrayList<Magazine>();
		for (Book book : books) {
			if(book  instanceof Magazine) temp.add((Magazine)book);
		}		
		return temp; 					// 컬랙션의 내용을 배열로 복사 후 리턴
	} 	
	
	/* 잡지가 아닌 도서리스트를 반환한다. */
	@Override
	public Book[] getBooks() {
		// 일반 도서의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(!(book  instanceof Magazine)) temp.add(book);
		}
		Book[] result = new Book[temp.size()];	// 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		return temp.toArray(result); 			// 컬랙션의 내용을 배열로 복사 후 리턴
	}
	/* 도서리스트의 가격의 총합을 반환한다. */
	@Override
	public int getTotalPrice() {
		int total = 0;
		for (Book book : books) {
			total += book.getPrice();
		}
		return total;
	}
	/* 도서가격의 평균을 반환한다.	 */
	@Override
	public double getPriceAvg() {
		return (double)getTotalPrice()/ books.size();
	}
	
	/*
	 * 고유번호에 해당하는 도서를 수량만큼 판매처리하여 재고를 감소시킨다.
	 * QuantityException 발생: 재고 수량 부족의 예외 상황
	 * ISBNNotFoundException 발생: 고유번호에 해당하는 도서가 존재하지 않는 예외상황 
	 */
	@Override
	public void sell(String isbn, int quantity)  {
		Book book = searchByIsbn(isbn);				// 고유번호 도서 조회
		if(book == null) 
		// 고유번호 도서 조회 실패시 ISBNNotFoundException 사용자 정의 예외 발생시킴
		
		int res = book.getQuantity() - quantity;	// 판매 후 새로운 재고 수량 계산
		if(res < 0) 
		// 재고수량 부족시 QuantityException 사용자 정의 예외 발생시킴
		
		book.setQuantity(res); 						// 판매후 남은 재고수량으로 재고수량 변경
	}
	
	/*
	 * 고유번호에 해당하는 도서를 수량만큼 구매 처리하여 재고를 증가시킨다.
	 * ISBNNotFoundException 발생: 고유번호에 해당하는 도서가 존재하지 않는 예외상황 
	 */
	@Override
	public void buy(String isbn, int quantity)  {
		Book book = searchByIsbn(isbn);	// 고유번호 도서 조회
		if(book == null) 
			throw new ISBNNotFoundException(isbn); //고유번호 도서 조회 실패시 ISBNNotFoundException 사용자 정의 예외 발생시킴
		
		book.setQuantity(book.getQuantity() + quantity);// 구매 후의 새로운 재고 수량 계산하여 재고 수량 변경 
	}

	@Override
	public ArrayList<Book> sortedByIsbn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> sortedByTitle() {
		// TODO Auto-generated method stub
		return null;
	}	
}
