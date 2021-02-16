package com.ssafy.algo;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		ProductManager pm = new ProductManager();

		pm.add(new Product(1001,"������",1000,5));
		
		while(true) {
			System.out.println("<<< ��� ���� ���α׷� >>>");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ��ü �˻�");
			System.out.println("3. ��ǰ��ȣ �˻�");
			System.out.println("4. ��ǰ��ȣ�� ��ǰ ����");
			System.out.println("0. ����");
			System.out.print("���ϴ� ��ȣ�� �����ϼ���. ");
			int select = scan.nextInt();
			scan.nextInt();
			int str; // �Է¹޴� ����
			Product[] temp; // ������ �����ϴ� Movie�迭
			
			switch(select) {
			case 1: // 1. ��ǰ ���� �Է�
				Product t = new Product();
				System.out.print("��ǰ��ȣ  >> ");
				
				t.setnumber(scan.nextInt());
				System.out.print("��ǰ�� >> ");
				
				t.setName(scan.nextLine()); 
				System.out.print("��ǰ���� >> ");
				
				t.setPrice(scan.nextInt());
				scan.nextLine();
				
				System.out.print("��ǰ���� >> ");
				
				t.setAmount(scan.nextInt());
				scan.nextLine();
				
				pm.add(t);
				
				break;
			case 2: // 2. ��ǰ ���� ��ü �˻�
				temp = pm.search();
				for(int i = 0; i < pm.getSize() ; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
			case 3: // 3. ��ǰ��ȣ�� ��ǰ�� �˻�
				System.out.print("��ǰ��ȣ�� �˻��ϼ��� : ");
				str = scan.nextInt();
				temp = pm.search(str);
				for(int i = 0; temp[i] != null; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
			
			case 4: // 4. ��ǰ��ȣ�� ��ǰ�� ����
				System.out.print("��ǰ��ȣ�� �Է��ϼ��� : ");
				str = scan.nextInt();
				pm.delete(str);
				break;
			case 0: // 0 ����
				System.exit(0);
				break;
			default:
				System.out.println("�ٸ� ��ȣ�� �Է��ϼ���");
			}
			System.out.println("");
			
		} // end of while
	} // end of main
} // end of class
