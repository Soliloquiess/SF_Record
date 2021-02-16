package com.live01;

import java.util.Scanner;

public class R3_CombinationCountTest {

	// n개 중 k개를 뽑는 조합의 경우의 수 리턴 
	public static int combination(int n, int k){
		if(n==k || k == 0){
			return 1;
			
		}else
		// n-1번째까지 k개를 다 뽑는 경우의 수(n번째원소 조합에 포함시키지 않음)와 combination(n-1, k-1) 
		// n-1번째까지 k-1개를 다 뽑는 경우의수(n번째원소 조합에 포함시킴)를 더한다. combination(n-1, k)
		return combination(n-1, k-1) +  combination(n-1, k);	
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		
		System.out.println(combination(n, k));
		
	}

}
