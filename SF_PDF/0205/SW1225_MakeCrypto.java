package com.off.day2;

import java.util.LinkedList;
import java.util.Scanner;

public class SW1225_MakeCrypto {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();//tc ����
			numbers.clear();
			
			//�Է�
			for (int i = 0; i < 8; i++) {
				numbers.offer(sc.nextInt());				
			}
			boolean isDone = false;//��ȣ �ϼ� ����
			
		//label	
		here:while(!isDone) {
				for (int i = 1; i <= 5; i++) {//1 cycle
					int num = numbers.poll() - i;
					
					if(num <= 0) {//0���� �۰ų� �����ϱ� 0���� ����
						num = 0;
						isDone = true;
					}
					numbers.offer(num);//list�� �ǵڿ� �߰�					
					if(isDone) {
						break here;
					}//if					
				}//for				
			}//while	
			
			//���
			System.out.print("#" + tc + " ");
			for(int no:numbers) {
				System.out.print(no + " ");
			}
			System.out.println();
		}//tc for
	}//main
}//class




