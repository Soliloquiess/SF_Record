package Test;

public class PersonTest {

	static final boolean isMarrid = false;
	static final int numberOfChildren =11;
	public static void main(String[] args) {

		Person personNoname = new Person();
		
		personNoname.printMyChildren(isMarrid,numberOfChildren);
		

	}

}
