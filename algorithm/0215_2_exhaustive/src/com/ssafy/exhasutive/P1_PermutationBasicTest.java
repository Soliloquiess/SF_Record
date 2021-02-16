package com.ssafy.exhasutive;

import java.util.Arrays;
import java.util.Scanner;

public class P1_PermutationBasicTest {

	static int N;
	static int[] input, numbers;
	static boolean[] isSelected;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N];
		for(int i = 0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0); // 맨 처음은 없으니까.
		
	}
	private static void permutation(int cnt) {
		
		if(cnt ==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 0; i<N; i++) {	//인풋배열의 인덱스
			if(isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;//i 위치에 있는 인덱스가 사용중임을 알려주고
			permutation(cnt+1);//그 다움수로 넘어감
			isSelected[i] = false;//돌아오면 그 자리의 수를 되돌림(다른 수 뽑을거니까
		}
	}
}
