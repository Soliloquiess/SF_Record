package com.off.day3;

import java.util.Arrays;
//DAO(Data Access Object):crud: create read update delete
//Book을 관리하는 클래스: 
//Book을 저장할 수 있는 배열을 가지고 있음 Book[]
//1.배열에 Book저장, 2. 배열에서 Book 삭제, 3.배열 정보 리턴, 4.isbn기준으로 Book 검색

public class BookManager {
	
	final int MAX = 100; //배열에 저장할 수 있는 최대 책의 권 수
	Book[] booklist;//Book을 저장할 배열
	int count;//배열에 저장된 책의 수
	
	//Singleton pattern 적용
	//1.자기 자신 타입의 변수 선언:private static
	private static BookManager manager;
	
	//2.private  생성자(외부에서 생성 못하게 막음)
	private BookManager() {
		booklist = new Book[MAX];		
	}
	
	//3.외부에서 접근 가능한 public static 메소드
	public static BookManager getInstance() {
		if(manager == null)
			manager = new BookManager();
		return manager;
	}
	
	public void add(Book b) {//배열에 책 추가
		if(count < MAX)
			booklist[count++] = b;
	}
	
	public void remove(String isbn) {//배열에서 특정 번호 책 삭제
		// 삭제할 도서를 찾았다면 해당 도서 위치에 배열의 제일 마지막 도서를 복사
		for (int i = 0; i < count; i++) {
			Book one = booklist[i];
			if(one.getIsbn().equals(isbn)) {//삭제할 책을 찾음
				booklist[i] = booklist[count - 1];//마지막위치의 책을 i위치로 옮김
				booklist[count - 1] = null;
				--count;//책 권수를 줄임
				break;
			}
		}
	}
	
	//데이터 전부 출력.
	public Book[] getList() {//배열을 리턴
		return Arrays.copyOfRange(booklist, 0, count);//원래 값을 복사한 배열을 리턴
		//return booklist;
	}
	
	//isbn으로 특정 책 검색해서 리턴.
	public Book searchByIsbn(String isbn) {//특정번호의 책을 검색해 리턴
		for (int i = 0; i < count; i++) {
			if(booklist[i].getIsbn().equals(isbn))
				return booklist[i];
		}
		return null;
	}
	
	//특정 타이틀로 책 리턴.
	public Book[] searchByTitle(String name) {
		Book[] temp = new Book[100];
		int tempCnt = 0;
		for (int i = 0; i < count; i++) {
			if(booklist[i].getTitle().contains(name)) 
				temp[tempCnt++] = booklist[i];
		}
		return temp;		
	}
	
	//특정 책 검색해서 리턴.(
//	public Book[] getBook() {
//		Book[] temp = new Book[100];
//		int tempCnt = 0;
//		for (int i = 0; i < count; i++) {
//			if(booklist[i] instanceof Book) 
////				continue;
//			temp[tempCnt++] = booklist[i];
//		}
//		return temp;
//	}
	
	//  Book만 검색하는 기능
		public Book[] getBooks() {
			Book[] temp = new Book[100];
			int tempCnt = 0;
			for (int i = 0; i < count; i++) {
				if(booklist[i] instanceof Magazine) continue;
				temp[tempCnt++] = booklist[i];
			}
			return temp;
		}
		
		// Magazine만 검색하는 기능
		public Book[] getMagazines() {
			Book[] temp = new Book[100];
			int tempCnt = 0;
			for (int i = 0; i < count; i++) {
				if(booklist[i] instanceof Magazine) {
					temp[tempCnt++] = booklist[i];
				}
			}
			return temp;
		}
		
		// 저장된 모든 도서의 금액 합계를 구하는기능
		public int getTotalPrice() {
			int total = 0;
			for (int i = 0; i < count; i++) {
				total += booklist[i].getPrice();
			}
			return total;
		}
		
		//  저장된 모든 도서의 금액 평균을 구하는 기능
		public double getTotalAverage() {
			int total = getTotalPrice();
			double avg = (double)total / count;
			return avg;
		}
		
		public int getSize() {
			return count;
		}

		
	public void update(String isbn, int price) {
		
	}

}
