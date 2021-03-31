package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class DP1_MinCoinTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		int[] D = new int [money+1]; //각 금액에 대한 최소 동전개수
		
		//D[i-1], D[i-4],D[i-6]
//		1+D[1-1]= 1+D[0];
//		1+D[4-4] = 1+D[0];
//		1+D[6-6] = 1+D[0];
		D[0]=0;	//사실 int형 배열은 0으로 초기화 되서 하나마나
		for(int i =1; i<=money; i++) {
			int min = Integer.MAX_VALUE;
			if(D[i-1]+1<min) min = D[i-1] +1;
			if (i>=4 && D[i-4]+1<min) min = D[i-4]+1;
			if(i>=6 && D[i-6]+1<min) min = D[i-6]+1;
			//각각의 상황 다 봐야해서 else if 쓰면 안됨.
			
			D[i]= min;
		}
		System.out.println(D[money]);
		System.out.println(Arrays.toString(D));
	}
}
