package com.ex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * ��������Ʈ�� �÷������� �����ϸ� �����ϴ� Ŭ����
 */
public class BookManagerImpl implements IBookManager {
	
	private ArrayList<Book> books = null; // �迭 ��� List������ �÷��� ���
	
	
	private static IBookManager instance = new BookManagerImpl();
	
	private BookManagerImpl() { // �ܺο��� ��ü ������ ���� ���ϵ��� ���� �����ڸ�  private���� ���� ������
		loadData();				// ��ü ������ ������ ����� �����͸� �ε��Ѵ�. 
	}

	public static IBookManager getInstance() {
		return instance;
	}

	
	@Override
	public void add(Book book) {
		books.add(book);	// ����Ʈ �������� �߰�
	}
	
	@Override
	public void remove(String isbn){
		final int size = books.size();	// ����Ǿ� �ִ� �������� Ȯ��
		int i;
		for (i = 0; i < size; ++i) {
			// ������ ������ ã�Ҵٸ� �ش� ���� ��ġ�� �̿��Ͽ� ����Ʈ���� ���� ����
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
		return books;			// �÷��� ������ �迭�� ���� �� �迭 ���� 
	}

	@Override
	public Book searchByIsbn(String isbn) {	
	
		for (Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}		
		return null;
	}
	
	@Override
	public ArrayList<Book> searchByTitle(String title) {
		// ������ �����ϴ� ������ ������ �� �� �����Ƿ� �÷����� Ȱ���Ͽ� ���� �� �������� �迭�� �ٲپ� ��ȯ�Ѵ�.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(book.getTitle().contains(title)) temp.add(book);
		}
		return temp; 			// �÷����� ������ �迭�� ���� �� ����
	}

	@Override
	public ArrayList<Magazine> getMagazines() {
		// ������ ������ �� �� �����Ƿ� �÷����� Ȱ���Ͽ� ���� �� �������� �迭�� �ٲپ� ��ȯ�Ѵ�.
		ArrayList<Magazine> temp = new ArrayList<Magazine>();
		for (Book book : books) {
			if(book  instanceof Magazine) temp.add((Magazine)book);
		}		
		return temp; 					// �÷����� ������ �迭�� ���� �� ����
	} 	
	
	@Override
	public Book[] getBooks() {
		// �Ϲ� ������ ������ �� �� �����Ƿ� �÷����� Ȱ���Ͽ� ���� �� �������� �迭�� �ٲپ� ��ȯ�Ѵ�.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(!(book  instanceof Magazine)) temp.add(book);
		}
		Book[] result = new Book[temp.size()];	// ��ȸ ����� ���� �÷����� ũ�⸦ Ȱ���Ͽ� �迭 ����
		return temp.toArray(result); 			// �÷����� ������ �迭�� ���� �� ����
	}
	
	@Override
	public int getTotalPrice() {
		int total = 0;
		for (Book book : books) {
			total += book.getPrice();
		}
		return total;
	}
	
	@Override
	public double getPriceAvg() {
		return (double)getTotalPrice()/ books.size();
	}
	
	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book book = searchByIsbn(isbn);				// ������ȣ ���� ��ȸ
		if(book == null) throw new ISBNNotFoundException(isbn); // ������ȣ ���� ��ȸ ���н� ISBNNotFoundException ����� ���� ���� �߻���Ŵ
		
		int res = book.getQuantity() - quantity;	// �Ǹ� �� ���ο� ��� ���� ���
		if(res < 0) throw new QuantityException();	// ������ ������ QuantityException ����� ���� ���� �߻���Ŵ
		
		book.setQuantity(res); 						// �Ǹ��� ���� ���������� ������ ����
	}
	
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book book = searchByIsbn(isbn);						// ������ȣ ���� ��ȸ
		if(book == null) throw new ISBNNotFoundException(isbn); // ������ȣ ���� ��ȸ ���н� ISBNNotFoundException ����� ���� ���� �߻���Ŵ
		
		book.setQuantity(book.getQuantity() + quantity);	// ���� ���� ���ο� ��� ���� ����Ͽ� ��� ���� ���� 
	}
	
	/**
	 * ���Ͽ��� ��������Ʈ�� �ε��Ѵ�.
	 */
	private void loadData() {
		File f = new File("book1.dat");
		if(f.exists()) {	// ������ �����ϸ� ���Ͽ��� ������ �б�
			// ���Ͽ��� �о���� ���� FileInputStream�� ���� �� ����� ��������Ʈ ��ü�� �о���� ���� ObjectInputStream�� �����Ѵ�.
			try(ObjectInputStream in  = new ObjectInputStream(new FileInputStream(f))){	
				books = (ArrayList<Book>) in.readObject();			// ��������Ʈ ��ü�� ���Ͽ��� �о����			
			} catch (Exception e) {
				System.out.println("[SYSTEM]���� �б⿡ �����Ͽ����ϴ�.");
				e.printStackTrace();
			} 
		}else {				// ������ �������� ������ ���ο� ����Ʈ ����
			books = new ArrayList<Book>();
		}
	}
	/**
	 * ��������Ʈ�� ���Ͽ� �����Ѵ�.
	 */
	@Override
	public void saveData() {
		// ���Ͽ�  �����ϱ� ���� FileOutputStream�� ���� �� ��������Ʈ ��ü�� �����ϱ� ���� ObjectOutputStream�� �����Ѵ�.
		try(ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream("book1.dat"))){
			out.writeObject(books);	// ��������Ʈ ��ü�� ���Ͽ� �����ϱ�				
		} catch (Exception e) {
			System.out.println("[SYSTEM]���� ���⿡ �����Ͽ����ϴ�.");
			e.printStackTrace();
		} 
	}

	@Override
	public ArrayList<Book> sortedByIsbn() {
		Collections.sort(books);
		return books;
	}

	@Override
	public ArrayList<Book> sortedByTitle() {
		Collections.sort(books, (b1, b2)->b1.getTitle().compareTo(b2.getTitle()));
		return books;
	}
}
