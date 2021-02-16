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
		permutation(0,0); // �� ó���� �����ϱ�.
		//ó�� �÷��״� 0
		
	}
	
	private static void permutation(int cnt, int flag) {
		
		if(cnt ==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 0; i<N; i++) {	//��ǲ�迭�� �ε���
			if((flag & 1<<i)!=0) continue;
			//���� ���ϴ� �ڸ��� ��Ʈ�� �� 0���� �ϰ� ���ϴ� �ڸ��� �ϱ����� ����Ʈ�ڸ� �� 0���� ����� �����ڸ��� 1���� �Ǵ��ϱ� ����
//			&���� �ְ� ���� ��Ʈ�÷��׿� ���� ���ϴ� ��Ʈ ���ؼ� ����� ������ | ������ ����.
			
			numbers[cnt] = input[i];
			
			permutation(cnt+1, flag+1<<i);
			
			
//			if(isSelected[i]) continue;
//			
//			numbers[cnt] = input[i];
//			isSelected[i] = true;//i ��ġ�� �ִ� �ε����� ��������� �˷��ְ�
//			permutation(cnt+1);//�� �ٿ���� �Ѿ
//			isSelected[i] = false;//���ƿ��� �� �ڸ��� ���� �ǵ���(�ٸ� �� �����Ŵϱ�
			
		
		}
	}
}
