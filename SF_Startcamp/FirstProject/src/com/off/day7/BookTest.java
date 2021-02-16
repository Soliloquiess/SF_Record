package com.off.day7;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		IBookManagerImpl bm = new IBookManagerImpl();
		
	
		
		while(true) {
			System.out.println("<<< 책 관리 프로그램 >>>");
			System.out.println("0. Magazine 정보 입력");
			System.out.println("1. Book 정보 입력");
			System.out.println("2. 책 정보 전체 검색");
			System.out.println("3. 도서 판매");
			System.out.println("4. 도서 구매");
			System.out.println("5. 총 재고 금액 구하기");
			System.out.println("8. 종료");
			System.out.print("원하는 번호를 선택하세요. ");
			int select = scan.nextInt();
			scan.nextLine();
			String str; // 입력받는 문자열
			String str2; // 입력받는 문자열2
			int input; // 연도 혹은 가격을 입력받을 문자열
			ArrayList<Book> temp; // 정보를 저장하는 Movie배열
			
			switch(select) {
			case 0: // 0. Magazine 정보 입력
				Magazine m = new Magazine();
				System.out.print("isbn  >> ");
				m.setIsbn(scan.nextLine());
				System.out.print("제목 >> ");
				m.setTitle(scan.nextLine()); 
				System.out.print("가격 >> ");
				m.setPrice(scan.nextInt());
				scan.nextLine();
				System.out.print("수량 >> ");
				m.setQuantity(scan.nextInt());
				scan.nextLine();
				System.out.print("월 >> ");
				m.setMonth(scan.nextInt());
				scan.nextLine();
				bm.add(m);
				
				break;
			case 1: // 1. 책 정보 입력
				Book t = new Book();
				System.out.print("isbn  >> ");
				t.setIsbn(scan.nextLine());
				System.out.print("제목 >> ");
				t.setTitle(scan.nextLine()); 
				System.out.print("가격 >> ");
				t.setPrice(scan.nextInt());
				scan.nextLine();
				System.out.print("수량 >> ");
				t.setQuantity(scan.nextInt());
				scan.nextLine();
				bm.add(t);
				
				break;
			case 2: // 2. 책 정보 전체 검색
				temp = bm.search();
				for(int i = 0; i < bm.getSize() ; i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
			case 3: // 3. 도서 판매
				System.out.print("Isbn을 입력하세요 : ");
				str = scan.next();
				System.out.print("판매할 양 입력하세요 : ");
				input = scan.nextInt();
		
				try {
					bm.sell(str, input);
				} catch (QuantityException e) {
					System.out.println("양이 부족합니다.!");
				} catch (ISBNNotFoundException e) {
					System.out.println("없는 ISBN입니다.!");
				}
				break;
			case 4: // 4. 도서 구매
				System.out.print("Isbn을 입력하세요 : ");
				str = scan.next();
				System.out.print("구매할 양 입력하세요 : ");
				input = scan.nextInt();
				
				
				try {
					bm.buy(str, input);
				} catch (ISBNNotFoundException e) {
					System.out.println("없는 ISBN입니다.!");
				}		
				break;
			case 5: // 5. 총 재고 금액 구하여 리턴
				System.out.println( "총 재고 금액 : " + 
						bm.getTotalAmount());

				break;				

			case 8: 
				return;
			default:
				System.out.println("다른 번호를 입력하세요");
			} // end of switch
			System.out.println("");
			
		} 
	} 
} 
