package com.ssafy.algo;

import java.util.Arrays;

//DAO(CRUD)
public class ProductManager {
	private Product[] products = new Product[1000];
	private int index;
	
	
	
	public void add(Product p)
	{
		products[index++] = p;
	}
	
	
	
	public Product[] search()
	{
		return products;
	}
	
	
	
	public Product search(int number)
	
	{
		for(int i = 0; i<index;i++)
		{
			if(products[i].getnumber()==number)
				return products[i];
		}
		return null;
	}
	
	
	
	public void delete(int number) {
		for (int i = 0; i < index; i++) {
			// ��ġ�Ѵٸ� ������ �����
			if(products[i].getnumber()==number) {
				
				// ����� �۾�
				for(int j = i; j < index-1; j++) {
					products[j] = products[j+1];
				}
				i--; // �� ��ġ�� �ٽ� ���ؾ��Ѵ�
				index--; // ��ȿ�� ������ ������ �ϳ� ���δ�.
				System.out.println("�����Ǿ����ϴ�!");
			}
		}
	}
	
	public Product[] priceList(int price)
	{
		Product[] plist = new Product[index];
		int j=0;
		for(int i =0; i<index; i++)
		{
			if(price>products[i].getPrice()) 
				plist[j++] =products[i];
		}
		return Arrays.copyOfRange(plist, 0, j);
	}



	public int getSize() {
		// TODO Auto-generated method stub
		return index;
	}
	
}
