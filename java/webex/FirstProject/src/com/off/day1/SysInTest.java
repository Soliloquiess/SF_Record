package com.off.day1;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SysInTest {

	public static void main(String[] args) throws IOException 
	{
//		난수발생
		Random ran = new Random();
		int result = ran.nextInt(11); //0~10
		
//		system.out // 표준출력(Console)
//		system.in//표준입력(keyboard)

//		키보드로 값을 입력하면 글자 자체가 입력되는게 아니라 코드값이라는 숫자가 대신 출력됨.
//		한번 변환작업을 또 해줘야 한다.
//		int result = System.in.read(); //키보드 입력받기
//		System.out.println(result);
//		System.out.println((char)result);
	
//		참조형은 전부 new로 생성하고 사용해야 된다. 
//		스캐너는 말 그대로 스캔 하는 애 일것
//		ctrl+shift+O 누르면
		
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextInt());
		System.out.println(sc.next()); 	//String을 입력 하겠구나
		
		
	}
}
