package com.off.day4.sol;

import java.util.Arrays;

/* 도서리스트를 배열로 유지하며 관리하는 클래스 */
public class BookManager {
	
	private static int MAX_SIZE = 100;//관리할 최대 도서 수
	
	private Book[] books = new Book[MAX_SIZE];
	/*	 * 현재 등록된 도서 수 */
	private int size;
		
	public void add(Book book) {
		if(size<MAX_SIZE) books[size++] = book;
	}
	
	public void remove(String isbn) {
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
	
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}
	
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; ++i) {
			if (books[i].getIsbn().equals(isbn)) return books[i]; 
		}
		return null;
	}
	
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

	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < size; ++i) {
			total += books[i].getPrice();
		}
		return total;
	}
	
	public double getPriceAvg() {
		return (double)getTotalPrice()/ size;
	}
}
