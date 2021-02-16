package com.off.day3;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		

		Scanner scan = new Scanner(System.in);
		//Manager 생성
		//BookManager man = new BookManager();//안됨
		BookManager man = BookManager.getInstance();
		BookManager man2 = BookManager.getInstance();
		
		Book b1 = new Book("12345", "자바완전정복", "김상우", "green house", 
				25000, "자바 기초 입문서");
		
		Book b2 = new Book("45662", "누가 내 치즈를 먹었을까", "james kay", 
				"red house", 18000, "치즈 도둑이야기");
		
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
//			System.out.println("찾는 책이 없습니다.");
//		}
//		System.out.println("------------------");
//		man.remove("12345");
//		list = man.getList();
//		
//		for(Book bb: list)
//			System.out.println(bb);
		
		while(true) {
			System.out.println("<<< 책 관리 프로그램 >>>");
			System.out.println("0. Magazine 정보 입력");
			System.out.println("1. Book 정보 입력");
			System.out.println("2. 책 정보 전체 검색");
			System.out.println("3. Isbn 검색");
			System.out.println("4. Title 검색");
			System.out.println("5. Book만 검색");
			System.out.println("6. Magazine만 검색");
			System.out.println("7. Magazine중 올해 잡지만 검색");
			System.out.println("8. 출판사로 검색");
			System.out.println("9. 가격으로 검색");
			System.out.println("10. 저장된 모든 도서의 금액 합계 출력");
			System.out.println("11. 저장된 모든 도서의 금액 평균 출력");
			System.out.println("99. 종료");
			System.out.print("원하는 번호를 선택하세요. ");
			int select = scan.nextInt();
			scan.nextLine();
			String str; // 입력받는 문자열
			int input; // 연도 혹은 가격을 입력받을 문자열
			Book[] temp; // 정보를 저장하는 Movie배열
			
			switch(select) {
			case 0: // 0. Magazine 정보 입력
				Magazine m = new Magazine();
				System.out.print("isbn  >> ");
				m.setIsbn(scan.nextLine());
				System.out.print("제목 >> ");
				m.setTitle(scan.nextLine()); 
				System.out.print("작가 >> ");
				m.setAuthor(scan.nextLine());
				System.out.print("출판사 >> ");
				m.setPublisher(scan.nextLine());
				System.out.print("가격 >> ");
				m.setPrice(scan.nextInt());
				scan.nextLine();
				System.out.print("순번 >> ");
				m.setDesc(scan.nextLine());
				System.out.print("년도 >> ");
				m.setYear(scan.nextInt());
				scan.nextLine();
				System.out.print("월 >> ");
				m.setMonth(scan.nextInt());
				scan.nextLine();
				man.add(m);
				
				break;
			case 1: // 1. 책 정보 입력
				Book t = new Book();
				System.out.print("isbn  >> ");
				t.setIsbn(scan.nextLine());
				System.out.print("제목 >> ");
				t.setTitle(scan.nextLine()); 
				System.out.print("작가 >> ");
				t.setAuthor(scan.nextLine());
				System.out.print("출판사 >> ");
				t.setPublisher(scan.nextLine());
				System.out.print("가격 >> ");
				t.setPrice(scan.nextInt());
				scan.nextLine();
				System.out.print("순번 >> ");
				t.setDesc(scan.nextLine());
				man.add(t);
				
				break;
			case 2: // 2. 영화 정보 전체 검색
				temp = man.getList();
				for(int i = 0; i < man.getSize() ; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
//			case 3: // 3. Isbn으로 정보를 검색
//				System.out.print("Isbn을 입력하세요 : ");
//				str = scan.next();
//				temp = man.searchByIsbn(str);
//				for(int i = 0; temp[i] != null; i++) {
//					System.out.println(temp[i].toString());					
//				}
//				break;
			case 4: // 4. Title로 정보를 검색
				System.out.print("Title을 입력하세요 : ");
				str = scan.next();
				temp = man.searchByTitle(str);
				for(int i = 0; temp[i] != null; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
			case 5: // 5. Book만 검색하는 기능
				temp = man.getBooks();
				for(int i = 0; temp[i] != null; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
			case 6: // 6. Magazine만 검색하는 기능
				temp = man.getMagazines();
				for(int i = 0; temp[i] != null; i++) {
					System.out.println(temp[i].toString());					
				}
				break;
				
//			case 7: // 7. Magazine중 올해 잡지만 검색하는 기능
//				System.out.print("년도를 입력하세요 : ");
//				input = scan.nextInt();
//				temp = man.get(input);
//				for(int i = 0; temp[i] != null; i++) {
//					System.out.println(temp[i].toString());					
//				}
//				break;
				
//			case 8: // 8. 출판사로 검색하는 기능.
//				System.out.print("출판사를 입력하세요 : ");
//				str = scan.next();
//				temp = man.searchPub(str);
//				for(int i = 0; temp[i] != null; i++) {
//					System.out.println(temp[i].toString());					
//				}
//				break;
				
//			case 9: // 9. 가격으로 검색 기능
//				System.out.print("가격를 입력하세요 : ");
//				input = scan.nextInt();
//				temp = man.searchPrice(input);
//				for(int i = 0; temp[i] != null; i++) {
//					System.out.println(temp[i].toString());					
//				}
//				break;
				
			case 10: // 10. 저장된 모든 도서의 금액 합계를 구함
				int total = man.getTotalPrice();
				System.out.println("금액의 합계 : " + total);
				break;
				
			case 11: // 11. 저장된 모든 도서의 금액 평균을 구함
				double avg = man.getTotalAverage();
				System.out.println("금액의 평균 : " + avg);
				break;
				
			case 99: // 0 종료
				System.exit(0);
				break;
			default:
				System.out.println("다른 번호를 입력하세요");
			} // end of switch
			System.out.println("");
			
		} // end of while
	} // end of main
} // end of class
