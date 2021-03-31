package Test;

public class Book {
	// private ���������ڸ� ���� static Ű����� �� �ڽ��� ��ü�� ������ �������� book
	private static Book book = null; 
	int id;
	String name;
	// private���� �����Ͽ� �ܺο��� new Ű���带 ����� ��ü�� ���� ���ϰ� ���´�.
	private Book() {} 

	// static �޼ҵ��̹Ƿ� ��ü�� �������� �ʰ� Book.getInstance()�� ������ �����ϴ�.
	public static Book getInstance() {
		// ���� book�� null�̸�?
		if(book == null) {
			// new Ű���带 ����Ͽ� ���ο� ��ü�� �����Ѵ�.
			// private�̹Ƿ� ���⼭�ۿ� ��� ����
			book = new Book();
		}
		// book�� ����. book�� null�� �ƴϸ� ������ ������ ��ü�� �����Ѵ�.
		return book;
	}
}