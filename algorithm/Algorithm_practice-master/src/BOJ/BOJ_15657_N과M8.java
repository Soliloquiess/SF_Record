package BOJ;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_15657_N��M8 {
	static int N, M;
	// static boolean[] visited;
	static int[] a; // ���� ��°��� ���� �迭
	static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] temp = br.readLine().split(" ");// temp�� " "�� �������� String�� ���� ����.
		N = Integer.parseInt(temp[0]); // String�� int�� ��ȯ �� ����.
		M = Integer.parseInt(temp[1]);

		// visited = new boolean[N];
		a = new int[N];
		input = new int[N];

		temp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(input);
		dfs(0, bw, input[0]);
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int depth, BufferedWriter bw, int com) {
		if (depth == M) {// ���� ����.
			try {
				for (int i = 0; i < M; i++) {
					bw.write(String.valueOf(a[i]) + " ");
				}
				bw.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}

		for (int i = 0; i < input.length; i++) {
			// if (!visited[i]) {
			if (com <= input[i]) {
				// visited[i] = true;
				a[depth] = input[i];
				dfs(depth + 1, bw, input[i]);
				// visited[i] = false;

			}
			// }
		}
	}
}