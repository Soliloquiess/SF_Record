package com.ssafy.algo;



import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		Product[] pd = new Product[10];
		ProductMgr me = new ProductMgr();
//		공통: 제품 번호, 제품 이름, 가격, 재고 수량
//		+TV: 인치, 제품타입
//		+냉장고: 용량
//		pd[0]=new TV("73546987","삼성TV",99000,1,50,"LCD");
//		pd[1]=new Refridgerator("73546900","LG",9800000,1,100);
//		pd[2]=new Refridgerator("73546901","LG",9790000,5,90);
		int or = 0;

		while (true) {
			System.out.println(" ############################### ");
			System.out.println("# 1. 상품 입력  2. 전체 검색  3. 번호 검색  #");
			System.out.println("# 4. 이름 검색  5. 상품 삭제  6. 재고 금액  #");
			System.out.println("# 0. 종료                                                  #");
			System.out.println(" ############################### ");

			or = sc.nextInt();

			if (or == 0) {
				System.out.println("EXIT");
				break;
				
			} else if (or == 1) { // 상품 입력
				pd[cnt] = me.input();
				cnt++;
			} else if (or == 2) { // 상품 전체 검색 (상품 이름, 번호, TV정보, 냉장고정보 포함)
				me.searchEvery(pd, cnt);
			} else if (or == 3) { // 번호 검색
				System.out.print("제품의 번호를 입력하세요. ");
				String num = sc.next();
				me.searchNUM(pd, num, cnt);
			} else if (or == 4) { // 이름 검색
				System.out.print("제품의 이름를 입력하세요. ");
				String nam = sc.next();
				me.searchNAME(pd, nam, cnt);
			} else if (or == 5) { // 상품 삭제
				me.del(pd, cnt);
			} else if (or == 6) { // 재고 금액
				System.out.println("재고의 총 금액은 " + me.price(pd, cnt) + "원 입니다.");
			} else {
				System.out.println("ERROR");
				break;
			}
		} // while

		sc.close();
	}// main

}// class
