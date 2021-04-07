package oa.perm0728;

import java.util.Arrays;
import java.util.Scanner;

// nCr 

public class CombinationTest {

	// 1,2,3
	// 3C2 = 3!/1!2! = 3
	static int N,R;
	static int[] input,numbers;
	static int totalCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		combination(0,0);
		System.out.println("총 경우의 수 : "+totalCount);
	}

	private static void combination(int cnt,int start) {
		//하나의 조합이 완성되면 화면에 출력하기
		if(cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=start; i<N; ++i) {
			numbers[cnt] = input[i];
			combination(cnt+1,i+1);
		}
	}
}
