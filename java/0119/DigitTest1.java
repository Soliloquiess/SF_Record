package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	 public static void main(String[] args)
	 {
		 Scanner sc = new Scanner(System.in);
		 

		 int number[] = new int[10];
		 
		 while(true)
		 {
			 
			 int input = sc.nextInt();
			 int index = input/10;
			 if( input==0)
			 {
				 
				 break;
			 }
			 number[index]++;
			 
		 }
		 for(int i =0; i<10;i++)
		 {
			 if(number[i]>0)
			 {
				 System.out.println(i +":"+number[i] +"°³");
				
			 }
		 }
	 }
}