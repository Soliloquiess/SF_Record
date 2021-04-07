package com.ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Card {
	private int num;
	private String name;
	
	public Card(int num, String name) {		
		this.num = num;
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

public class CardSave{
	
	public static void main(String[] args) throws Exception {
		//Card 객체를 생성해서 스트림을 통해 이동시켜 파일에 저장
		Card mycard = new Card(12345, "julie");
		
		//File에 저장
		FileOutputStream fos = new FileOutputStream("card.ser");//node stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);//filter stream
		oos.writeObject(mycard);//객체저장
		
		oos.close();
		fos.close();
		
		//File에서 불러오기
		FileInputStream fis = new FileInputStream("card.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Card c = (Card)ois.readObject();
		
		System.out.println(c.getNum());
		System.out.println(c.getName());
		
		ois.close();
		fis.close();

	}
	
}
