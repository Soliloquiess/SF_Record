package com.korea.kwangju;

//ĸ��ȭ
public class Customer {
	//field-private
	private int num;
	private String name;
	private String address;
	
	//getter/setter �޼��� -public
	public int getNum() {
//		if()//����üũ.login check 
		return num;
	}
	public void setNum(int num) {
		if(num>0)
		{
			this.num = num;
		}
		else 
		{
			System.out.println("��ȣ�� ���� �����Դϴ�.");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
