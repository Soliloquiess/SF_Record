package com.off.day6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		IBookManagerImpl bm = new IBookManagerImpl();
		
		
		bm.add( new Book("00001","Java 다","김상사","jjja.kr",10000,"자바기본문법"));
		bm.add( new Book("00002","Java 라","김중사","jjjb.kr",20000,"c++문법"));
		bm.add( new Book("00003","분석설계","이근희","kkkc.kr",50000,"SW모델"));
		bm.add( new Book("00004","계설석분","전우형","kkkd.kr",10000,"HW모델"));
		bm.add( new Book("00005","설계분석","김성식","kkke.kr",10000,"12모델"));

		bm.add( new Magazine("12344","Java메거진!","홍진호","java.com",5000,"첫걸음",2018,2));
		bm.add( new Magazine("25233","c메거진!","홍정호","jaaa.com",10000,"2걸음",2017,2));
		bm.add( new Magazine("12423","c++메거진!","홍기호","jada.com",5000,"3걸음",2014,2));
		bm.add( new Magazine("11888","J메거진!","홍백호","ja2a.com",20000,"4걸음",2012,2));
		bm.add( new Magazine("12357","Jaa메거진!","홍시호","j3va.com",10000,"5걸음",2011,2));
		
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
			ArrayList<Book> temp; // 정보를 저장하는 Movie배열
			
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
				bm.add(m);
				
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
				bm.add(t);
				
				break;
			case 2: // 2. 영화 정보 전체 검색
				temp = bm.search();
				for(int i = 0; i < bm.getSize() ; i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
			case 3: // 3. Isbn으로 정보를 검색
				System.out.print("Isbn을 입력하세요 : ");
				str = scan.next();
				temp = bm.search(str);
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
			case 4: // 4. Title로 정보를 검색
				System.out.print("Title을 입력하세요 : ");
				str = scan.next();
				temp = bm.searchName(str);
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
			case 5: // 5. Book만 검색하는 기능
				temp = bm.searchBook();
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
			case 6: // 6. Magazine만 검색하는 기능
				temp = bm.searchMagazine();
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
				
			case 7: // 7. Magazine중 올해 잡지만 검색하는 기능
				System.out.print("년도를 입력하세요 : ");
				input = scan.nextInt();
				temp = bm.searchYear(input);
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
				
			case 8: // 8. 출판사로 검색하는 기능.
				System.out.print("출판사를 입력하세요 : ");
				str = scan.next();
				temp = bm.searchPub(str);
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
				
			case 9: // 9. 가격으로 검색 기능
				System.out.print("가격를 입력하세요 : ");
				input = scan.nextInt();
				temp = bm.searchPrice(input);
				for(int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i).toString());					
				}
				break;
				
			case 10: // 10. 저장된 모든 도서의 금액 합계를 구함
				int total = bm.totalPrice();
				System.out.println("금액의 합계 : " + total);
				break;
				
			case 11: // 11. 저장된 모든 도서의 금액 평균을 구함
				double avg = bm.totalAverage();
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
