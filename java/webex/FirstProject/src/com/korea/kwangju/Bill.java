package com.korea.kwangju;

import com.basic.StaticTest;
import com.korea.seoul.Tommy;	//com.korea.seoul�� ��Ű�� �̸� TOmmy�� Ŭ���� �̸�.
//���� ���ֿ� �ְ� ��̴� ���￡

public class Bill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tommy t = new Tommy();
		t.go();//�� ȣ���� ��.
		
		System.out.println(t.age);
		System.out.println(StaticTest.scount);
		//��Ű�� �޶� ����Ʈ �����.
		//����� �� Ŭ���� �̸� �ϴ°� �Ȱ����� ���� �����ڰ� ��� default��
//		��Ű���� �޶����� �ȵ�.
		StaticTest.go();
	}
}
