package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		int height = sc.nextInt();
		int weight = sc.nextInt();
		
		int obesity = weight+100-height;
		if(obesity>0)
		{
			System.out.println("�񸸼�ġ�� "+obesity+"�Դϴ�.\n����� ���̱���.");
		}
		else 
		{
			System.out.println("�� X");
		}
	}

}
