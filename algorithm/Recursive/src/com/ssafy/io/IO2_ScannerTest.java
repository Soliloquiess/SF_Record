package com.ssafy.io;

import java.util.Scanner;

public class IO2_ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1= "�� \n��\n";
		Scanner sc = new Scanner(s1);
		System.out.println("���� ���ڿ�:" + sc.next());
		System.out.println("���� ���ڿ�:"+sc.next());
		System.out.println("\n=====================");
		
		String s2= "�� ��\n";
		Scanner sc2 = new Scanner(s2);
		System.out.println("���� ���ڿ�:"+sc2.nextLine());
		System.out.print("========================");
		
		String s3 = "��\n ��\n";
		Scanner sc3 = new Scanner(s3);
		System.out.print("���� ���ڿ�:"+sc3.nextLine());
		System.out.print("���� ���ڿ�:"+sc3.nextLine());

	}

}
