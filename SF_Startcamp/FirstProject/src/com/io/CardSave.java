package com.io;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/*
 * 입출력 관련해서 직렬화 개념화를 알아두자.
 * 객체 직렬화(Serialization):객체가 스트림을 통해 이동 될 떄 객체 안의 데이터가 **연속된**
 * 바이트 단위로
 * 변환되어 전송되는 작업 
 * --> 객체가 스트림을 통해 이동 될떄 반드시 직렬화가 되어 있어야 함.
 * -->조건 : java.io.Serializable 인터페이스를 구현하면 됨.
 */


class Card implements Serializable{ //직렬화 된거
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
