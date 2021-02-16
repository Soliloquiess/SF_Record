package com.off.day3;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		

		Scanner scan = new Scanner(System.in);
		//Manager ����
		//BookManager man = new BookManager();//�ȵ�
		BookManager man = BookManager.getInstance();
		BookManager man2 = BookManager.getInstance();
		
		Book b1 = new Book("12345", "�ڹٿ�������", "����", "green house", 
				25000, "�ڹ� ���� �Թ���");
		
		Book b2 = new Book("45662", "���� �� ġ� �Ծ�����", "james kay", 
				"red house", 18000, "ġ�� �����̾߱�");
		
//		man.add(b1);
//		man.add(b2);
//		Book[] list = man.getList();
//		
//		for(Book bb: list)
//			System.out.println(bb);
//		
//		System.out.println("------------------");
//		Book b = man.searchByIsbn("12345");
//		if(b != null) {
//			System.out.println(b);
//			
//		}else {
//			System.out.println("ã�� å�� �����ϴ�.");
//		}
//		System.out.println("------------------");
//		man.remove("12345");
//		list = man.getList();
//		
//		for(Book bb: list)
//			System.out.println(bb);
		
		while(true) {
			System.out.println("<<< å ���� ���α׷� >>>");
			System.out.println("0. Magazine ���� �Է�");
			System.out.println("1. Book ���� �Է�");
			System.out.println("2. å ���� ��ü �˻�");
			System.out.println("3. Isbn �˻�");
			System.out.println("4. Title �˻�");
			System.out.println("5. Book�� �˻�");
			System.out.println("6. Magazine�� �˻�");
			System.out.println("7. Magazine�� ���� ������ �˻�");
			System.out.println("8. ���ǻ�� �˻�");
			System.out.println("9. �������� �˻�");
			System.out.println("10. ����� ��� ������ �ݾ� �հ� ���");
			System.out.println("11. ����� ��� ������ �ݾ� ��� ���");
			System.out.println("99. ����");
			System.out.print("���ϴ� ��ȣ�� �����ϼ���. ");
			int select = scan.nextInt();
			scan.nextLine();
			String str; // �Է¹޴� ���ڿ�
			int input; // ���� Ȥ�� ������ �Է¹��� ���ڿ�
			Book[] temp; // ������ �����ϴ� Movie�迭
			
			switch(select) {
			case 0: // 0. Magazine ���� �Է�
				Magazine m = new Magazine();
				System.out.print("isbn  >> ");
				m.setIsbn(scan.nextLine());
				System.out.print("���� >> ");
				m.setTitle(scan.nextLine()); 
				System.out.print("�۰� >> ");
				m.setAuthor(scan.nextLine());
				System.out.print("���ǻ� >> ");
				m.setPublisher(scan.nextLine());
				System.out.print("���� >> ");
				m.setPrice(scan.nextInt());
				scan.nextLine();
				System.out.print("���� >> ");
				m.setDesc(scan.nextLine());
				System.out.print("�⵵ >> ");
				m.setYear(scan.nextInt());
				scan.nextLine();
				System.out.print("�� >> ");
				m.setMonth(scan.nextInt());
				scan.nextLine();
				man.add(m);
				
				break;
			case 1: // 1. å ���� �Է�
				Book t = new Book();
				System.out.print("isbn  >> ");
				t.setIsbn(scan.nextLine());
				System.out.print("���� >> ");
				t.setTitle(scan.nextLine()); 
				System.out.print("�۰� >> ");
				t.setAuthor(scan.nextLine());
				System.out.print("���ǻ� >> ");
				t.setPublisher(scan.nextLine());
				System.out.print("���� >> ");
				t.setPrice(scan.nextInt());
				scan.nextLine();
				System.out.print("���� >> ");
				t.setDesc(scan.nextLine());
				man.add(t);
				
				break;
			case 2: // 2. ��ȭ ���� ��ü �˻�
				temp = man.getList();
				for(int i = 0; i < man.getSize() ; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
//			case 3: // 3. Isbn���� ������ �˻�
//				System.out.print("Isbn�� �Է��ϼ��� : ");
//				str = scan.next();
//				temp = man.searchByIsbn(str);
//				for(int i = 0; temp[i] != null; i++) {
//					System.out.println(temp[i].toString());					
//				}
//				break;
			case 4: // 4. Title�� ������ �˻�
				System.out.print("Title�� �Է��ϼ��� : ");
				str = scan.next();
				temp = man.searchByTitle(str);
				for(int i = 0; temp[i] != null; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
			case 5: // 5. Book�� �˻��ϴ� ���
				temp = man.getBooks();
				for(int i = 0; temp[i] != null; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
			case 6: // 6. Magazine�� �˻��ϴ� ���
				temp = man.getMagazines();
				for(int i = 0; temp[i] != null; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
				
//			case 7: // 7. Magazine�� ���� ������ �˻��ϴ� ���
//				System.out.print("�⵵�� �Է��ϼ��� : ");
//				input = scan.nextInt();
//				temp = man.get(input);
//				for(int i = 0; temp[i] != null; i++) {
//					System.out.println(temp[i].toString());					
//				}
//				break;
				
//			case 8: // 8. ���ǻ�� �˻��ϴ� ���.
//				System.out.print("���ǻ縦 �Է��ϼ��� : ");
//				str = scan.next();
//				temp = man.searchPub(str);
//				for(int i = 0; temp[i] != null; i++) {
//					System.out.println(temp[i].toString());					
//				}
//				break;
				
//			case 9: // 9. �������� �˻� ���
//				System.out.print("���ݸ� �Է��ϼ��� : ");
//				input = scan.nextInt();
//				temp = man.searchPrice(input);
//				for(int i = 0; temp[i] != null; i++) {
//					System.out.println(temp[i].toString());					
//				}
//				break;
				
			case 10: // 10. ����� ��� ������ �ݾ� �հ踦 ����
				int total = man.getTotalPrice();
				System.out.println("�ݾ��� �հ� : " + total);
				break;
				
			case 11: // 11. ����� ��� ������ �ݾ� ����� ����
				double avg = man.getTotalAverage();
				System.out.println("�ݾ��� ��� : " + avg);
				break;
				
			case 99: // 0 ����
				System.exit(0);
				break;
			default:
				System.out.println("�ٸ� ��ȣ�� �Է��ϼ���");
			} // end of switch
			System.out.println("");
			
		} // end of while
	} // end of main
} // end of class
