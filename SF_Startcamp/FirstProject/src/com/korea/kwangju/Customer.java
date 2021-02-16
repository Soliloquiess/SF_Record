package com.korea.kwangju;

//캡슐화
public class Customer {
	//field-private
	private int num;
	private String name;
	private String address;
	
	//getter/setter 메서드 -public
	public int getNum() {
//		if()//권한체크.login check 
		return num;
	}
	public void setNum(int num) {
		if(num>0)
		{
			this.num = num;
		}
		else 
		{
			System.out.println("번호는 양의 숫자입니다.");
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
