package com.ssafy.algo;


import java.util.Scanner;

public class ProductMgr extends Product {

	public Product input() {
		Product tmp = new Product();

		Scanner sc = new Scanner(System.in);
		System.out.print("TV는 1번, 냉장고는 2번을 입력하세요.");
		int menu = sc.nextInt();

		System.out.print("제품 번호: ");
		String tmpnum = sc.next();
		System.out.print("제품 이름: ");
		String tmpnam = sc.next();
		System.out.print("제품 가격: ");
		String tmpp = sc.next();
		System.out.print("재고 수량: ");
		String tmpst = sc.next();

		if (menu == 1) { // TV일때
			System.out.print("제품 크기: ");
			String tmpsz = sc.next();
			System.out.print("제품 타입: ");
			String tmptp = sc.next();
			tmp = new TV(tmpnum, tmpnam, Integer.parseInt(tmpp), Integer.parseInt(tmpst), Integer.parseInt(tmpsz),
					tmptp);
		} else { // 냉장고일때
			System.out.print("제품 용량: ");
			String tmpsz = sc.next();
			tmp = new Refridgerator(tmpnum, tmpnam, Integer.parseInt(tmpp), Integer.parseInt(tmpst),
					Integer.parseInt(tmpsz));
		}
		sc.close();
		return tmp;
	}// input
	
	public void searchNUM(Product[] pd, String num, int cnt) {
		for (int i = 0; i < cnt; i++) {
			if (num.equals(pd[i].numb)) {
				System.out.println(pd[i]);
				return;
			}
		}
		System.out.println("검색 결과가 없습니다.");
	}// 제품 번호로 찾기

	public void searchNAME(Product[] pd, String na, int cnt) {
		for (int i = 0; i < cnt; i++) {
			if (na.equals(pd[i].name)) {
				System.out.println(pd[i]);
				return;
			}
		}
		System.out.println("검색 결과가 없습니다.");
	}// 제품명으로 찾기
	
	public void searchEvery(Product[] pd, int cnt) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색 조건을 선택하세요. ");
		System.out.println("1. 제품 번호 || 2. 제품 이름 || 3. TV정보 출력 || 4. 냉장고정보 출력 ");
		int select = sc.nextInt();
		if(select == 1) {
			System.out.println("제품의 번호를 입력하세요. ");
			String tmpn = sc.next();
			searchNUM(pd, tmpn, cnt);
		} else if(select == 2) {
			System.out.println("제품의 이름을 입력하세요. ");
			String tmpn = sc.next();
			searchNAME(pd, tmpn, cnt);
		} else if(select == 3) { 
			for (int i = 0; i < cnt; i++) {
				if(pd[i] instanceof TV) {
					System.out.println(pd[i]);
				}
			}
		} else if(select ==4) {
			for (int i = 0; i < cnt; i++) {
				if(pd[i] instanceof Refridgerator) {
					System.out.println(pd[i]);
				}
			}
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
		
		sc.close();
	}// 전체 검색해서 찾기
	
	public void del(Product[] pd, int cnt) {
		Scanner sc = new Scanner(System.in);
		System.out.println("제품의 번호를 입력하세요. ");
		String tmpn = sc.next();
		
		for (int i = 0; i < cnt; i++) {
			if(tmpn.equals(pd[i].numb)) {
				for (int j = i; j < cnt; j++) {
					for (int k = j+1; k < cnt; k++) {
						pd[j] = pd[k];
					}
				} //삭제하고 cnt값 하나 줄이기.. 리스트 쓰면 빠르다함
				cnt--;
			}
		}
		sc.close();
	} //삭제하기

	
	public long price(Product[] pd, int cnt) {
		long re = 0;
		for (int i = 0; i < cnt; i++) {
			re += pd[i].stock * pd[i].price;
		}
		return re;
	}
}
