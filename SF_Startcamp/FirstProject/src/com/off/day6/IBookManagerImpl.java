package com.off.day6;

import java.util.ArrayList;

public class IBookManagerImpl implements IBookMgr {
	private ArrayList<Book> bm = new ArrayList<>();
	
	// 1. ������ �Է� ���
	public void add(Book p) {
		bm.add(p);		
	}
	
	// 2. ������ ��ü �˻� ���
	public ArrayList<Book> search() {
		return bm;
	}
	
	// 3. Isbn ��ȣ�� ��ǰ�� �˻�
	public ArrayList<Book> search(String isbn) {
		ArrayList<Book> temp = new ArrayList<>();
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i).getIsbn().equals(isbn)) 
				temp.add(bm.get(i));
		}
		return temp;
	}
	
	// 4. Title ���� ��ǰ�� �˻��ϴ� ���
	public ArrayList<Book> searchName(String name) {
		ArrayList<Book> temp = new ArrayList<>();
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i).getTitle().contains(name)) 
				temp.add(bm.get(i));
		}
		return temp;		
	}
	
	// 5. Book�� �˻��ϴ� ���
	public ArrayList<Book> searchBook() {
		ArrayList<Book> temp = new ArrayList<>();
		int tempCnt = 0;
		for (int i = 0; i < bm.size(); i++) {
			if(bm.get(i) instanceof Magazine) continue;
			temp.add(bm.get(i));
		}
		return temp;
	}
	
	// 6. Magazine�� �˻��ϴ� ���
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
	
	// 7. Magazine�� ���� ������ �˻��ϴ� ���
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
	
	// 8. ���ǻ�� �˻��ϴ� ���
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
	
	// 9. �������� �˻� ���
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
	
	// 10. ����� ��� ������ �ݾ� �հ踦 ���ϴ±��
	public int totalPrice() {
		int total = 0;
		for (int i = 0; i < bm.size(); i++) {
			total += bm.get(i).getPrice();
		}
		return total;
	}
	
	// 11. ����� ��� ������ �ݾ� ����� ���ϴ� ���
	public double totalAverage() {
		int total = totalPrice();
		double avg = (double)total / bm.size();
		return avg;
	}
	
	public int getSize() {
		return bm.size();
	}

}
