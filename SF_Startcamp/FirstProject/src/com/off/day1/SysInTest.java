package com.off.day1;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SysInTest {

	public static void main(String[] args) throws IOException 
	{
//		�����߻�
		Random ran = new Random();
		int result = ran.nextInt(11); //0~10
		
//		system.out // ǥ�����(Console)
//		system.in//ǥ���Է�(keyboard)

//		Ű����� ���� �Է��ϸ� ���� ��ü�� �ԷµǴ°� �ƴ϶� �ڵ尪�̶�� ���ڰ� ��� ��µ�.
//		�ѹ� ��ȯ�۾��� �� ����� �Ѵ�.
//		int result = System.in.read(); //Ű���� �Է¹ޱ�
//		System.out.println(result);
//		System.out.println((char)result);
	
//		�������� ���� new�� �����ϰ� ����ؾ� �ȴ�. 
//		��ĳ�ʴ� �� �״�� ��ĵ �ϴ� �� �ϰ�
//		ctrl+shift+O ������
		
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextInt());
		System.out.println(sc.next()); 	//String�� �Է� �ϰڱ���
		
		
	}
}