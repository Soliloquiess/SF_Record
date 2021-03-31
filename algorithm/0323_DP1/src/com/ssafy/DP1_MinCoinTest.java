package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class DP1_MinCoinTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		int[] D = new int [money+1]; //�� �ݾ׿� ���� �ּ� ��������
		
		//D[i-1], D[i-4],D[i-6]
//		1+D[1-1]= 1+D[0];
//		1+D[4-4] = 1+D[0];
//		1+D[6-6] = 1+D[0];
		D[0]=0;	//��� int�� �迭�� 0���� �ʱ�ȭ �Ǽ� �ϳ�����
		for(int i =1; i<=money; i++) {
			int min = Integer.MAX_VALUE;
			if(D[i-1]+1<min) min = D[i-1] +1;
			if (i>=4 && D[i-4]+1<min) min = D[i-4]+1;
			if(i>=6 && D[i-6]+1<min) min = D[i-6]+1;
			//������ ��Ȳ �� �����ؼ� else if ���� �ȵ�.
			
			D[i]= min;
		}
		System.out.println(D[money]);
		System.out.println(Arrays.toString(D));
	}
}
