package com.off.day2;

import java.util.LinkedList;
import java.util.Scanner;

public class SW1225_MakeCrypto {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();//tc 갯수
			numbers.clear();
			
			//입력
			for (int i = 0; i < 8; i++) {
				numbers.offer(sc.nextInt());				
			}
			boolean isDone = false;//암호 완성 여부
			
		//label	
		here:while(!isDone) {
				for (int i = 1; i <= 5; i++) {//1 cycle
					int num = numbers.poll() - i;
					
					if(num <= 0) {//0보다 작거나 같으니까 0으로 셋팅
						num = 0;
						isDone = true;
					}
					numbers.offer(num);//list에 맨뒤에 추가					
					if(isDone) {
						break here;
					}//if					
				}//for				
			}//while	
			
			//출력
			System.out.print("#" + tc + " ");
			for(int no:numbers) {
				System.out.print(no + " ");
			}
			System.out.println();
		}//tc for
	}//main
}//class




