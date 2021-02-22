package com.ex;

/**
 * �������� ��ȣ�� �������� �ʴ� ���������� ��Ÿ���� Ŭ����
 */
public class ISBNNotFoundException extends Exception {

	/**	�������� �ʴ� ���� ������ȣ */
	private String isbn;
	
	/** ������ȣ�� �޾� �����ϴ� ������ */
	public ISBNNotFoundException(String isbn) {
		super(isbn+"������ȣ�� �������� �ʽ��ϴ�.");
		this.isbn = isbn;
	}
	/**
	 * �������� �ʴ� ���� ������ȣ�� ��ȯ�Ѵ�.
	 * @return �������� �ʴ� ���� ������ȣ
	 */
	public String getIsbn() {
		return isbn;
	}
}
