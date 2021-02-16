package com.ssafy.exhasutive;

import java.util.Arrays;
import java.util.Scanner;

//nPn
public class P4_PermutationNPTest {
	
	static int N;
	static int[] input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		input = new int[N];
		
		for(int i = 0; i< N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);	//오름차순 정렬하여 가장 작은 순열의 상태로 만듬
	
		do {
			System.out.println(Arrays.toString(input));
		}while(np());
	}

	public static boolean np() {
		int i = N-1;
		while(i>0&&input[i-1]>=input[i]) --i;
			//현재위치의 앞쪽 녀석이 현재보다 같거나 큰 모습이면 올라가는 모습
			//-1인건 없으니까 내 앞에 누가 있을떄 까지만 가능 그래서i가 0보다 크긴 해야됨.
		//더이상 앞 자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열의 상태(마지막 순열의 상태)
		if(i==0) return false;
		
		int j = N-1;
		while(input[i-1]>=input[j]) --j;
		
		swap(i-1,j);
		
		int k = N-1;
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}
	
	private static void swap(int i, int j)
	{
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
