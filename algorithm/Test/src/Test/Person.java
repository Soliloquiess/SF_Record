package Test;

public class Person {

	String name;
	int age;
	boolean isMarried;
	int numberOfChildren;

	public void printMyChildren(boolean isMarrid, int numberOfChildren ) {
		if(isMarrid==false) {
			System.out.println("���� ��ȥ�Դϴ�.");
		}
		else if(isMarrid==true) {
			System.out.println("���� ��ȥ�̰� �ڳ�� " +numberOfChildren + "�� �Դϴ�.");
		}
	}
}
