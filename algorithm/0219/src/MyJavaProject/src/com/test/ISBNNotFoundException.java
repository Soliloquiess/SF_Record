package com.test;

/**
 * �������� ��ȣ�� �������� �ʴ� ���������� ��Ÿ���� Ŭ����
 */
public class ISBNNotFoundException  {

	/**	�������� �ʴ� ���� ������ȣ */
	private String isbn;
	
	/** ������ȣ�� �޾� �����ϴ� ������ */
	public ISBNNotFoundException(String isbn) {		
		this.isbn = isbn;
	}	
	
	@Override
	public String toString() {
		return "ISBNNotFoundException [isbn=" + isbn + "]";
	}



	public String getIsbn() {
		return isbn;
	}
}
