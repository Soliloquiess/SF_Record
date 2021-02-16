package com.off.day6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		IBookManagerImpl bm = new IBookManagerImpl();
		
		
		bm.add( new Book("00001","Java ��","����","jjja.kr",10000,"�ڹٱ⺻����"));
		bm.add( new Book("00002","Java ��","���߻�","jjjb.kr",20000,"c++����"));
		bm.add( new Book("00003","�м�����","�̱���","kkkc.kr",50000,"SW��"));
		bm.add( new Book("00004","�輳����","������","kkkd.kr",10000,"HW��"));
		bm.add( new Book("00005","����м�","�輺��","kkke.kr",10000,"12��"));

		bm.add( new Magazine("12344","Java�ް���!","ȫ��ȣ","java.com",5000,"ù����",2018,2));
		bm.add( new Magazine("25233","c�ް���!","ȫ��ȣ","jaaa.com",10000,"2����",2017,2));
		bm.add( new Magazine("12423","c++�ް���!","ȫ��ȣ","jada.com",5000,"3����",2014,2));
		bm.add( new Magazine("11888","J�ް���!","ȫ��ȣ","ja2a.com",20000,"4����",2012,2));
		bm.add( new Magazine("12357","Jaa�ް���!","ȫ��ȣ","j3va.com",10000,"5����",2011,2));
		
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
			ArrayList<Book> temp; // ������ �����ϴ� Movie�迭
			
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
				bm.add(m);
				
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
				bm.add(t);
				
				break;
			case 2: // 2. ��ȭ ���� ��ü �˻�
				temp = bm.search();
				for(int i = 0; i < bm.getSize() ; i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
			case 3: // 3. Isbn���� ������ �˻�
				System.out.print("Isbn�� �Է��ϼ��� : ");
				str = scan.next();
				temp = bm.search(str);
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
			case 4: // 4. Title�� ������ �˻�
				System.out.print("Title�� �Է��ϼ��� : ");
				str = scan.next();
				temp = bm.searchName(str);
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
			case 5: // 5. Book�� �˻��ϴ� ���
				temp = bm.searchBook();
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
			case 6: // 6. Magazine�� �˻��ϴ� ���
				temp = bm.searchMagazine();
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
				
			case 7: // 7. Magazine�� ���� ������ �˻��ϴ� ���
				System.out.print("�⵵�� �Է��ϼ��� : ");
				input = scan.nextInt();
				temp = bm.searchYear(input);
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
				
			case 8: // 8. ���ǻ�� �˻��ϴ� ���.
				System.out.print("���ǻ縦 �Է��ϼ��� : ");
				str = scan.next();
				temp = bm.searchPub(str);
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
				
			case 9: // 9. �������� �˻� ���
				System.out.print("���ݸ� �Է��ϼ��� : ");
				input = scan.nextInt();
				temp = bm.searchPrice(input);
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
				
			case 10: // 10. ����� ��� ������ �ݾ� �հ踦 ����
				int total = bm.totalPrice();
				System.out.println("�ݾ��� �հ� : " + total);
				break;
				
			case 11: // 11. ����� ��� ������ �ݾ� ����� ����
				double avg = bm.totalAverage();
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
