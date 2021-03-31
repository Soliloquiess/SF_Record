package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15655_N��M6 {
	static int N, M;
	static boolean[] visited;
	static int[] a; // ���� ��°��� ���� �迭
	static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");// temp�� " "�� �������� String�� ���� ����.
		N = Integer.parseInt(temp[0]); // String�� int�� ��ȯ �� ����.
		M = Integer.parseInt(temp[1]);

		visited = new boolean[N];
		a = new int[N];
		input = new int[N];

		temp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(input);
		dfs(0,input[0]);
	}

	static void dfs(int depth, int com) {
		if (depth == M) {// ���� ����.
			for (int i = 0; i < M; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < input.length; i++) {
			if (!visited[i] && com <= input[i]) {
				visited[i] = true;
				a[depth] = input[i];
				dfs(depth + 1,input[i]);
				visited[i] = false;
			}
		}
	}
}