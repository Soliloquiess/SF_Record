package com.io;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/*
 * ����� �����ؼ� ����ȭ ����ȭ�� �˾Ƶ���.
 * ��ü ����ȭ(Serialization):��ü�� ��Ʈ���� ���� �̵� �� �� ��ü ���� �����Ͱ� **���ӵ�**
 * ����Ʈ ������
 * ��ȯ�Ǿ� ���۵Ǵ� �۾� 
 * --> ��ü�� ��Ʈ���� ���� �̵� �ɋ� �ݵ�� ����ȭ�� �Ǿ� �־�� ��.
 * -->���� : java.io.Serializable �������̽��� �����ϸ� ��.
 */


class Card implements Serializable{ //����ȭ �Ȱ�
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
		//Card ��ü�� �����ؼ� ��Ʈ���� ���� �̵����� ���Ͽ� ����
		Card mycard = new Card(12345, "julie");
		
		//File�� ����
		FileOutputStream fos = new FileOutputStream("card.ser");//node stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);//filter stream
		oos.writeObject(mycard);//��ü����
		
		oos.close();
		fos.close();
		
		//File���� �ҷ�����
		FileInputStream fis = new FileInputStream("card.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Card c = (Card)ois.readObject();
		
		System.out.println(c.getNum());
		System.out.println(c.getName());
		
		ois.close();
		fis.close();

	}
	
}
