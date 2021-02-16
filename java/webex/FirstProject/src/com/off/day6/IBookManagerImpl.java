package com.off.day6;

import java.util.ArrayList;

public class IBookManagerImpl implements IBookMgr {
	private ArrayList<Book> bm = new ArrayList<>();
	
	// 1. 데이터 입력 기능
	public void add(Book p) {
		bm.add(p);		
	}
	
	// 2. 데이터 저체 검색 기능
	public ArrayList<Book> search() {
		return bm;
	}
	
	// 3. Isbn 번호로 상품을 검색
	public ArrayList<Book> search(String isbn) {
		ArrayList<Book> temp = new ArrayList<>();
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i).getIsbn().equals(isbn)) 
				temp.add(bm.get(i));
		}
		return temp;
	}
	
	// 4. Title 으로 상품을 검색하는 기능
	public ArrayList<Book> searchName(String name) {
		ArrayList<Book> temp = new ArrayList<>();
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i).getTitle().contains(name)) 
				temp.add(bm.get(i));
		}
		return temp;		
	}
	
	// 5. Book만 검색하는 기능
	public ArrayList<Book> searchBook() {
		ArrayList<Book> temp = new ArrayList<>();
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i) instanceof Magazine) continue;
			temp.add(bm.get(i));
		}
		return temp;
	}
	
	// 6. Magazine만 검색하는 기능
	public ArrayList<Book> searchMagazine() {
		ArrayList<Book> temp = new ArrayList<>();
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i) instanceof Magazine) {
				temp.add(bm.get(i));
			}
		}
		return temp;
	}
	
	// 7. Magazine중 올해 잡지만 검색하는 기능
	public ArrayList<Book> searchYear(int n) {
		ArrayList<Book> temp = new ArrayList<>();
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i) instanceof Magazine) {
				Magazine t = (Magazine)bm.get(i);
				if (t.getYear() == n)
					temp.add(t);
			}
		}
		return temp;
	}
	
	// 8. 출판사로 검색하는 기능
	public ArrayList<Book> searchPub(String pub) {
		ArrayList<Book> temp = new ArrayList<>();
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i).getPublisher().equals(pub)) {
				temp.add(bm.get(i));
			}
		}
		return temp;
	}
	
	// 9. 가격으로 검색 기능
	public ArrayList<Book> searchPrice(int price) {
		ArrayList<Book> temp = new ArrayList<>();
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i).getPrice() < price) {
				temp.add(bm.get(i));
			}
		}
		return temp;
	}
	
	// 10. 저장된 모든 도서의 금액 합계를 구하는기능
	public int totalPrice() {
		int total = 0;
		for (int i = 0; i < bm.size(); i++) {
			total += bm.get(i).getPrice();
		}
		return total;
	}
	
	// 11. 저장된 모든 도서의 금액 평균을 구하는 기능
	public double totalAverage() {
		int total = totalPrice();
		double avg = (double)total / bm.size();
		return avg;
	}
	
	public int getSize() {
		return bm.size();
	}

}
