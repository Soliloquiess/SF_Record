package com.ssafy.algo;

public interface IProductMgr {
	void input(int menu, Product pd);
	void entireSearch(String str);
	void partSearch(String str);	
	void  searchName(String str); 
	void  searchTV(String str);
	void searchRef(String str);
	void Over400LRef();
	void Over50InchTV();
	void ModiProduct(String str, int p);
	void DelProduct(String str);
	void Sum();
}
