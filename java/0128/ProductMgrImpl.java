package com.ssafy.algo;

import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr{
	static int cnt;
	ArrayList<Product> pdarr = new ArrayList<>();
	@Override
	public void input(int menu, Product pd) {
		// TODO Auto-generated method stub
		if(menu==1) pdarr.add((TV)pd); //TV
		else pdarr.add((Refridgerator)pd); //냉장고
		cnt++;
	}//데이터 입력받기

	@Override
	public void entireSearch(String str) {
		// TODO Auto-generated method stub
		boolean check=false;
		for (int i = 0; i < cnt; i++) {
			if (str.equals(pdarr.get(i).name) || str.equals(pdarr.get(i).numb)){
				System.out.println("검색 결과 입니다.");
				System.out.println(pdarr.get(i));
				check = true;
				break;
			}
		}
		if (!check)
			System.out.println("찾으시는 제품이 없습니다.");
	}//전체 데이터 찾기

	@Override
	public void partSearch(String str) {
		// TODO Auto-generated method stub
		boolean check=false;
		for (int i = 0; i < cnt; i++) {
			if (pdarr.get(i).name.contains(str) ||pdarr.get(i).numb.contains(str)){
				System.out.println("검색 결과 입니다.");
				System.out.println(pdarr.get(i));
				check = true;
			}
		}
		if (!check)
			System.out.println("찾으시는 제품이 없습니다.");
	}//부분 검색 기능

	@Override
	public void searchName(String str) {
		// TODO Auto-generated method stub
		boolean check=false;
		for (int i = 0; i < cnt; i++) {
			if (pdarr.get(i).name.contains(str)){
				System.out.println("검색 결과 입니다.");
				System.out.println(pdarr.get(i));
				check = true;
				break;
			}
		}
		if (!check)
			System.out.println("찾으시는 제품이 없습니다.");
	}//이름으로 찾기

	@Override
	public void searchTV(String str) {
		// TODO Auto-generated method stub
		boolean check = false;
		int i = 0;
		for (i = 0; i < cnt; i++) {
			if (pdarr.get(i) instanceof TV) {
				if (str.equals(pdarr.get(i).name) || str.equals(pdarr.get(i).numb)) {
					System.out.println("TV 검색 결과 입니다.");
					System.out.println(pdarr.get(i));
					check = true;
					break;
				}
			}
		}
		if (!check)
			System.out.println("찾으시는 제품이 없습니다.");
	}//TV만 찾기

	@Override
	public void searchRef(String str) {
		// TODO Auto-generated method stub
		boolean check = false;
		int i = 0;
		for (i = 0; i < cnt; i++) {
			if (!(pdarr.get(i) instanceof Refridgerator)) {
				if (str.equals(pdarr.get(i).name) || str.equals(pdarr.get(i).numb)) {
					System.out.println("냉장고 검색 결과 입니다.");
					System.out.println(pdarr.get(i));
					check = true;
					break;
				}
			}
		}
		if (!check)
			System.out.println("찾으시는 제품이 없습니다.");
	}//냉장고만 찾기

	@Override
	public void Over400LRef() {
		// TODO Auto-generated method stub
		boolean check = false;
		int i = 0;
		System.out.println("##### 용량 400L이상 냉장고 #####");
		for (i = 0; i < cnt; i++) {
			if ((pdarr.get(i) instanceof Refridgerator)) {
				Refridgerator tmpr = (Refridgerator) pdarr.get(i);
				if (tmpr.getsize()>=400) {
					System.out.println(pdarr.get(i));
					check = true;
				}
			}
		}
		if (!check)
			System.out.println("찾으시는 제품이 없습니다.");
	}//400리터 이상 냉장고 찾기

	@Override
	public void Over50InchTV() {
		// TODO Auto-generated method stub
		boolean check = false;
		int i = 0;
		System.out.println("##### 50인치 이상 TV #####");
		for (i = 0; i < cnt; i++) {
			if (pdarr.get(i) instanceof TV) {
				TV tmpr = (TV) pdarr.get(i);
				if (tmpr.getinch()>=50) {
					System.out.println(pdarr.get(i));
					check = true;
				}
			}
		}
		if (!check)
			System.out.println("찾으시는 제품이 없습니다.");
	}//50인치 TV만 찾기

	@Override
	public void ModiProduct(String str, int p) {
		// TODO Auto-generated method stub
		boolean check = false;
		int i = 0;
		for (i = 0; i < cnt; i++) {
				if (str.equals(pdarr.get(i).name)) {
					pdarr.get(i).price = p;
					System.out.println("수정된 결과: ");
					System.out.println(pdarr.get(i));
					check = true;
			}
		}
		if (!check)
			System.out.println("찾으시는 제품이 없습니다.");
	}//제품 수정하기

	@Override
	public void DelProduct(String str) {
		// TODO Auto-generated method stub
		boolean check = false;
		int i = 0;
		for (i = 0; i < cnt; i++) {
				if (str.equals(pdarr.get(i).name)) {
					System.out.println("삭제될 제품: ");
					System.out.println(pdarr.get(i));
					pdarr.remove(i);
					check = true;
					cnt--;
			}
		}
		if (!check)
			System.out.println("찾으시는 제품이 없습니다.");
	}//제품 삭제하기

	@Override
	public void Sum() {
		// TODO Auto-generated method stub
		int i = 0, sum = 0;
		for (i = 0; i < cnt; i++) {
			sum += (pdarr.get(i).price * pdarr.get(i).stock);
		}
		System.out.println("총 재고상품의 합계는 "+sum+"원 입니다.");
	}//전체 재고상품의 총 합계 구하기

}//end of class

