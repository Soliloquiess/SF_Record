package com.ssafy.io;

import java.util.Scanner;

public class IO3_ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("기수:" + sc.nextInt());
//		System.out.println("이름:" + sc.next());
		//next는 첫번째부터 유효문자 읽어들임.
		sc.nextLine();//버림
		System.out.println("이름:" + sc.nextLine());
	}

}
