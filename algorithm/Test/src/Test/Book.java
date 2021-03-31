package Test;

public class Book {
	// private 접근제한자를 가진 static 키워드로 나 자신의 객체를 가지는 참조변수 book
	private static Book book = null; 
	int id;
	String name;
	// private으로 선언하여 외부에서 new 키워드를 사용해 객체를 생성 못하게 막는다.
	private Book() {} 

	// static 메소드이므로 객체를 생성하지 않고도 Book.getInstance()로 접근이 가능하다.
	public static Book getInstance() {
		// 만약 book이 null이면?
		if(book == null) {
			// new 키워드를 사용하여 새로운 객체를 생성한다.
			// private이므로 여기서밖에 사용 못함
			book = new Book();
		}
		// book을 리턴. book이 null이 아니면 기존에 생성된 객체를 리턴한다.
		return book;
	}
}