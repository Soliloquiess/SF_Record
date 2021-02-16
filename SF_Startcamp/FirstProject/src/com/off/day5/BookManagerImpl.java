package com.off.day5;

import java.util.ArrayList;
import java.util.Arrays;

import com.off.day6.Book;

//DAO(Data Access Object):crud: create read update delete
//Book을 관리하는 클래스: 
//Book을 저장할 수 있는 배열을 가지고 있음 Book[]
//1.배열에 Book저장, 2. 배열에서 Book 삭제, 3.배열 정보 리턴, 4.isbn기준으로 Book 검색
/* 도서리스트를 배열로 유지하며 관리하는 클래스 */

public class BookManagerImpl implements IBookManager{

	private static int MAX_SIZE = 100;//관리할 최대 도서 수
	private Book[] books = new Book[MAX_SIZE];
	
	/*	 * 현재 등록된 도서 수 */
	private int size;
		
	//생성자 
	private BookManagerImpl() {};
	
	
	public void add(Book book) {
		if(size<MAX_SIZE) books[size++] = book;
	}
	
	public void remove(String isbn) { //배열에서 특정 번호 책 삭제
		for (int i = 0; i < size; ++i) {
			// 삭제할 도서를 찾았다면 해당 도서 위치에 배열의 제일 마지막 도서를 복사
			if (books[i].getIsbn().equals(isbn)) {
				books[i] = books[size-1];
				books[size-1]=null;			// 삭제된 도서 위치 null 처리
				--size;						// 등록된 도서 수 감소
				break;
			}
		}
	}
	
	
	//데이터 전부 출력.
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);	//복사한 새로운 배열 리턴.
	}
	
	//isbn으로 특정 책 검색해서 리턴.

	public Book searchByIsbn(String isbn) { //특정번호의 책을 검색해 리턴
		for (int i = 0; i < size; ++i) {
			if (books[i].getIsbn().equals(isbn)) return books[i]; 
		}
		return null;
	}
	
	public Book search(String isbn) {
		temp;
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i).getIsbn().equals(isbn)) 
				temp.add(bm.get(i));
		}
		return temp;
	}
	
	//특정 타이틀로 책 리턴.
	public Book[] searchByTitle(String title) {
		int count = 0; 
		for (int i = 0; i < size; ++i) {	// 도서 제목을 포함하는 도서의 개수 카운트
			if (books[i].getTitle().contains(title)) 
				++count;
		}
		Book[] result = new Book[count];	// 결과 카운트만큼 배열 생성
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if (books[i].getTitle().contains(title)) { // 도서 제목을 포함하는 도서만 배열에 담기
				result[idx++] = books[i];
			}
		}
		return result; 
	}

	// Magazine만 검색하는 기능
	public Magazine[] getMagazines() {
		int count = 0;
		for (int i = 0; i < size; ++i) {	// 잡지 개수 카운트
			if (books[i] instanceof Magazine) 
				++count;
		}
		
		Magazine[] result = new Magazine[count];	// 결과 카운트만큼 배열 생성
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if (books[i] instanceof Magazine) {	// 잡지만 배열에 담기
				result[idx++] = (Magazine)books[i];
			}
		}
		return result;
	} 
	
	public Book[] getNovel() {
		int count = 0; 
		for (int i = 0; i < size; ++i) {
			if ((books[i] instanceof Novel)) 
				++count;
		}
		
		Novel[] result = new Novel[count];
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if ((books[i] instanceof Novel)) {
				result[idx++] = (Novel) books[i];
			}
		}
		return result;
	}
	// 저장된 모든 도서의 금액 합계를 구하는기능
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < size; ++i) {
			total += books[i].getPrice();
		}
		return total;
	}
//  저장된 모든 도서의 금액 평균을 구하는 기능
	public double getPriceAvg() {
		return (double)getTotalPrice()/ size;
	}
}
