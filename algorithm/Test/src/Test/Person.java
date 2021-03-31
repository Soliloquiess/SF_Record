package Test;

public class Person {

	String name;
	int age;
	boolean isMarried;
	int numberOfChildren;

	public void printMyChildren(boolean isMarrid, int numberOfChildren ) {
		if(isMarrid==false) {
			System.out.println("나는 미혼입니다.");
		}
		else if(isMarrid==true) {
			System.out.println("나는 기혼이고 자녀는 " +numberOfChildren + "명 입니다.");
		}
	}
}
