package com.ssafy.algo;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		ProductManager pm = new ProductManager();

		pm.add(new Product(1001,"갤럭시",1000,5));
		
		while(true) {
			System.out.println("<<< 재고 관리 프로그램 >>>");
			System.out.println("1. 정보 입력");
			System.out.println("2. 전체 검색");
			System.out.println("3. 상품번호 검색");
			System.out.println("4. 상품번호로 상품 삭제");
			System.out.println("0. 종료");
			System.out.print("원하는 번호를 선택하세요. ");
			int select = scan.nextInt();
			scan.nextInt();
			int str; // 입력받는 숫자
			Product[] temp; // 정보를 저장하는 Movie배열
			
			switch(select) {
			case 1: // 1. 상품 정보 입력
				Product t = new Product();
				System.out.print("상품번호  >> ");
				
				t.setnumber(scan.nextInt());
				System.out.print("상품명 >> ");
				
				t.setName(scan.nextLine()); 
				System.out.print("상품가격 >> ");
				
				t.setPrice(scan.nextInt());
				scan.nextLine();
				
				System.out.print("상품수량 >> ");
				
				t.setAmount(scan.nextInt());
				scan.nextLine();
				
				pm.add(t);
				
				break;
			case 2: // 2. 상품 정보 전체 검색
				temp = pm.search();
				for(int i = 0; i < pm.getSize() ; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
			case 3: // 3. 상품번호로 상품을 검색
				System.out.print("상품번호를 검색하세요 : ");
				str = scan.nextInt();
				temp = pm.search(str);
				for(int i = 0; temp[i] != null; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
			
			case 4: // 4. 상품번호로 상품을 삭제
				System.out.print("상품번호를 입력하세요 : ");
				str = scan.nextInt();
				pm.delete(str);
				break;
			case 0: // 0 종료
				System.exit(0);
				break;
			default:
				System.out.println("다른 번호를 입력하세요");
			}
			System.out.println("");
			
		} // end of while
	} // end of main
} // end of class
