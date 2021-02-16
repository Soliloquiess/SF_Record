package com.ssafy.exhasutive;

import java.util.Arrays;
import java.util.Scanner;

public class P3_PermutationBitmaskTest {

	static int N;
	static int[] input, numbers;
	
//	static boolean[] isSelected;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		numbers = new int[N];
		
		
//		isSelected = new boolean[N];
		
		
		for(int i = 0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0,0); // 맨 처음은 없으니까.
		//처음 플래그는 0
		
	}
	
	private static void permutation(int cnt, int flag) {
		
		if(cnt ==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 0; i<N; i++) {	//인풋배열의 인덱스
			if((flag & 1<<i)!=0) continue;
			//내가 원하는 자리의 비트를 다 0으로 하고 원하는 자리만 하기위해 시프트자리 다 0으로 만들고 기존자리가 1인지 판단하기 위해
//			&연산 주고 기존 비트플래그에 내가 원하는 비트 더해서 만들고 싶을떄 | 연산을 쓴다.
			
			numbers[cnt] = input[i];
			
			permutation(cnt+1, flag+1<<i);
			
			
//			if(isSelected[i]) continue;
//			
//			numbers[cnt] = input[i];
//			isSelected[i] = true;//i 위치에 있는 인덱스가 사용중임을 알려주고
//			permutation(cnt+1);//그 다움수로 넘어감
//			isSelected[i] = false;//돌아오면 그 자리의 수를 되돌림(다른 수 뽑을거니까
			
		
		}
	}
}
