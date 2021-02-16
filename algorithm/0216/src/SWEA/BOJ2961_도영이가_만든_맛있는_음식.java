package SWEA;

import java.util.Scanner;

public class BOJ2961_도영이가_만든_맛있는_음식 {
	private static int n;
	private static int c;
	private static int[] sour;
	private static int[] bitter;
	private static int[] numbers;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sour = new int[n];// 신맛저장
		bitter = new int[n];// 쓴맛저장, 0번째 인덱스부터 사용
		numbers = new int[n];

		for (int i = 0; i < n; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		for (int i = 1; i < n + 1; i++) {
			c = i;
			combination(0, 0); // n개중 i개 고르는 조합 nCi
		}

		System.out.println(min);
	}// end of main

	/** n개 중 i개를 고르는 조합 */
	private static void combination(int cnt, int index) {

		if (c == cnt) {
			int sum = 0;
			int mul = 1;
			for (int i = 0; i < c; i++) {
				mul *= sour[numbers[i]];
				sum += bitter[numbers[i]];
			}
			min = Math.min(min, Math.abs(sum - mul));
			return;
		}

		for (int i = index; i < n; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}

	}
}// end of class
