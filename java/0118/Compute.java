package com.java.first;

import java.util.Scanner;

public class Compute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int num1 =sc.nextInt();
		int num2 =sc.nextInt();
		
		int multi = num1*num2;
		int share = num1/num2;
		
		System.out.println("��="+ multi);
		System.out.println("��="+ share);
		
		
		
	}

}
