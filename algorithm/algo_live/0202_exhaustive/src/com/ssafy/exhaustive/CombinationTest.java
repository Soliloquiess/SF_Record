package com.ssafy.exhaustive;

import java.util.Arrays;
/**
 * @author THKim
 */
//nCr
public class CombinationTest {
	
	static int[] numbers;
	static int N=4, R=4;
	
	public static void main(String[] args) {
		numbers = new int[R];
		combination(0, 1);
	}
	
	static void combination(int cnt,int start){
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i=start; i <=N; i++) { // i:시도하는 수
			numbers[cnt] = i;
			combination(cnt+1,i+1);
 		}
		
	}

}
