package com.ssafy.algo;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgrImpl menual = new ProductMgrImpl();
		
		Product pd =new TV("1234","LGTV",59000,5,30,"LCD");
		Product pd1=new TV("1234","삼성TV",69000,4,50,"LCD");
		Product pd2=new Refridgerator("2345","LG냉장고",123000,1,400);
		Product pd3=new Refridgerator("3456","쌤쑝냉장고",97900,5,90);
		
		//데이터입력
		menual.input(1, pd);
		menual.input(1, pd1);
		menual.input(2, pd2);
		menual.input(2, pd3);
		
		System.out.println("-------------------------------------------");
		//전체 데이터 찾기
		menual.entireSearch("1234");
		menual.entireSearch("2345"); //찾으시는 제품이 없습니다.

		System.out.println("-------------------------------------------");
		//부분 검색 기능
		menual.partSearch("LG");
		menual.partSearch("쌤"); 

		System.out.println("-------------------------------------------");
		//이름으로 찾기
		menual.searchName("LG");
		menual.searchName("삼성TV");

		System.out.println("-------------------------------------------");
		//TV만 찾기
		menual.searchTV("LG냉장고"); //찾으시는 제품이 없습니다.
		menual.searchTV("LGTV");

		System.out.println("-------------------------------------------");
		//냉장고만 찾기
		menual.searchRef("삼성TV");
		menual.searchRef("쌤쑝냉장고"); //찾으시는 제품이 없습니다.

		System.out.println("-------------------------------------------");
		//400리터 이상 냉장고 찾기
		menual.Over400LRef();

		System.out.println("-------------------------------------------");
		//50인치 이상 TV찾기
		menual.Over50InchTV();

		System.out.println("-------------------------------------------");
		//제품 이름과 가격 받아서 수정하기
		menual.ModiProduct("LGTV", 59000); //수정된 값 출력

		System.out.println("-------------------------------------------");
		//제품 삭제
		menual.DelProduct("LGTV"); //삭제될 제품: 

		System.out.println("-------------------------------------------");
		//전체 재고상품의 총 합계 구하기
		menual.Sum(); //총 재고상품의 합계는 686500원 입니다.
		System.out.println("-------------------------------------------");
	}//end of main
}//end of class
