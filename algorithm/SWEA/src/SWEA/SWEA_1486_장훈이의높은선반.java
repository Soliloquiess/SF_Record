package SWEA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author ������
 * @since 2021. 3. 22.
 * @see
 * @mem
 * @time
 * @caution [�������] [�Է»���] [��»���] 
 * ��Ʈ����ŷ: 20,040 kb, 192 ms, ���: 20,428 kb, 113 ms
����ð�
 */
public class SWEA_1486_�������ǳ������� {
//	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//	static StringBuilder output = new StringBuilder();
//	static StringTokenizer tokens;

	static int T;
	static int N, H;
	static int[] heights;
	static int Min;

	public static void main(String[] args) throws IOException {
//		input = new BufferedReader(new StringReader(src));
//		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder("");
//		StringTokenizer tokens;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder output = new StringBuilder("");
		 StringTokenizer tokens;
		int T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			N = Integer.parseInt(tokens.nextToken());
			H = Integer.parseInt(tokens.nextToken());

			heights = new int[N];
			tokens = new StringTokenizer(input.readLine(), " ");
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(tokens.nextToken());
			}
			// System.out.println(Arrays.toString(heights));
			// �Է� �Ϸ�
			// �κ����� --> H�� �Ѵ� ���� ���� ��?
			Min = Integer.MAX_VALUE;
			//byBitMasking();
			combination(0,  0);
			output.append(String.format("#%d %d%n", t, Min));
		}
		System.out.println(output);
	}

	static void combination(int start, int sum) {

		if (sum >= H && sum - H < Min) {
			Min = sum - H;
			return;
		}

		// ������Ȳ
		if (start == N) {
			return;
		}
		// ��� ��Ȳ
		for (int i = start; i < N; i++) {
			combination(i + 1, sum + heights[i]);
		}
	}

	static void byBitMasking() {
		// 1<<N --> ��Ʈ�������� --> X2, �̰��� N�� �ᱹ 2^n
		for (int i = 1; i < (1 << N); i++) { // i: ����� ���� ���¸� ��Ʈ������ ��Ÿ����.
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) { // i�� j ��Ʈ�� ���ԵǾ��ִٸ�..
					sum += heights[j];
					// �̹� �����ߴٸ� �� ��� ������ �ʿ�� ����.
					if (sum - H > Min) {
						break;
					}
				}
			} // for
				// H�� �����鼭 ���̴� �ּ�ȭ ������.
			if (sum >= H && sum - H < Min) {
				Min = sum - H;
			}
		}
	}

//	private static String src = "10\r\n" +
//			"5 16\r\n" +
//			"3 1 3 5 6\r\n" +
//			"2 10\r\n" +
//			"7 7\r\n" +
//			"3 120\r\n" +
//			"83 64 36\r\n" +
//			"4 416\r\n" +
//			"299 239 116 128\r\n" +
//			"5 1535\r\n" +
//			"351 228 300 623 954\r\n" +
//			"10 2780\r\n" +
//			"268 61 201 535 464 168 491 275 578 153\r\n" +
//			"10 1162\r\n" +
//			"73 857 502 826 923 653 168 396 353 874\r\n" +
//			"15 8855\r\n" +
//			"3711 576 9081 3280 1413 6818 5142 2981 1266 484 5757 2451 6961 4862 2086\r\n" +
//			"15 57209\r\n" +
//			"8903 5737 3749 8960 724 6295 1240 4325 8023 3640 2223 639 4161 5330 4260\r\n" +
//			"20 78988\r\n" +
//			"3811 2307 3935 5052 4936 3473 6432 7032 1560 1992 5332 7000 4020 9344 2732 8815 9924 8998 9540 4640\r\n" +
//			"";
}


