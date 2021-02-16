package com.off.day5;

import com.off.day4.sol.Book;
import com.off.day4.sol.Magazine;

public interface  IBookManager {

	public void add(Book book);
// ������ ��ü �˻� ���
	public Book[] getList();
	public void remove(String isbn);
//  Isbn ��ȣ�� ��ǰ�� �˻�
	public Book searchByIsbn(String isbn); //Ư����ȣ�� å�� �˻��� ����
	// Title ���� ��ǰ�� �˻��ϴ� ���
	public Book[] searchByTitle(String title);
	// ������ �˻��ϴ� ���
	public Magazine[] getMagazines();
	// �Ҽ�å�� �˻��ϴ� ���
	public Book[] getNovel();
	
	//  ����� ��� ������ �ݾ� �հ踦 ���ϴ±��
	public int getTotalPrice();

	//  ����� ��� ������ �ݾ� ����� ���ϴ� ���
	public double getPriceAvg();
	public int getSize();
}
