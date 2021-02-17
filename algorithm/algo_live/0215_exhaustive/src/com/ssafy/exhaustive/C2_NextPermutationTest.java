package com.ssafy.exhaustive;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author THKim
 */
public class C2_NextPermutationTest {

	static int N,R;
	static int[] input;
	static int[] P;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		P = new int[N]; // N 크기의 flag 배열
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		int cnt = 0;
		while(++cnt<=R) P[N-cnt]=1;
		
		do {
			for (int i = 0; i < N; i++) {
				if(P[i]==1) System.out.print(input[i]+" ");
			}
			System.out.println();
			
		}while(np(P));
	}
	
	private static boolean np(int[] arr) {
		
		//STEP 1
		int i=N-1;
		while(i>0 && arr[i-1]>=arr[i]) --i;
		
		if(i==0) return false;
		
		//STEP 2
		int j=N-1;
		while(arr[i-1]>=arr[j])	--j;
		
		//STEP 3
		swap(arr,i-1,j);
		
		//STEP 4
		int k=N-1;
		while(i<k) {
			swap(arr,i++,k--);			
		}
		return true;
	}
	
	private static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}












