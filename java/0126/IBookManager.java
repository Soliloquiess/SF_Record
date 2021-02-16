package com.off.day5;

import com.off.day4.sol.Book;
import com.off.day4.sol.Magazine;

public interface  IBookManager {

	public void add(Book book);
// 데이터 저체 검색 기능
	public Book[] getList();
	public void remove(String isbn);
//  Isbn 번호로 상품을 검색
	public Book searchByIsbn(String isbn); //특정번호의 책을 검색해 리턴
	// Title 으로 상품을 검색하는 기능
	public Book[] searchByTitle(String title);
	// 잡지만 검색하는 기능
	public Magazine[] getMagazines();
	// 소설책만 검색하는 기능
	public Book[] getNovel();
	
	//  저장된 모든 도서의 금액 합계를 구하는기능
	public int getTotalPrice();

	//  저장된 모든 도서의 금액 평균을 구하는 기능
	public double getPriceAvg();
	public int getSize();
}
