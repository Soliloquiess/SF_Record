package extra.s3.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 3. 22.
 * @see
 * @mem
 * @time
 * @caution [고려사항] [입력사항] [출력사항]
 * 21,048 kb, 143 ms
 */
public class SWEA_D4_가능한시험점수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	static int N;
	static int score[];
	static boolean visited[];

	static int Answer;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));

		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			score = new int[N];
			tokens = new StringTokenizer(input.readLine(), " ");
			int total = 0;
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(tokens.nextToken());
				total += score[i];
			}
			// 맞을 수 있는 점수들을 표현해줄 배열
			visited = new boolean[total + 1];

			Answer = 0;
			visited[0] = true;// 0점은 언제나 존제한다.
			solve(0, total);
			output.append("#").append(t).append(" ").append(Answer).append("\n");
		}
		System.out.println(output);
	}

	static void solve(int n, int max) {
		if (n == N) {
			// 끝~~ --> 결과 확인 - 배열에 몇 개가 체크되어있는지 살펴보자.
			for(boolean bool: visited) {
				if(bool) {
					Answer++;
				}
			}
			return;
		}

		for (int i = max; i >= 0; i--) {
			if (visited[i]) {
				visited[i + score[n]] = true;
			}
		}
		solve(n + 1, max);
	}

	private static String src = "2\r\n" +
			"3\r\n" +
			"2 3 5\r\n" +
			"10\r\n" +
			"1 1 1 1 1 1 1 1 1 1";
}
