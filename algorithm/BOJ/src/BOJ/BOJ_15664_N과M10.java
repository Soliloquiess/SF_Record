package BOJ;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_15664_N��M10 {
	static int N, M;
	static int[] visited = new int[10001];
	static ArrayList<Integer> a;
	static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] temp = br.readLine().split(" ");// temp�� " "�� �������� String�� ���� ����.
		N = Integer.parseInt(temp[0]); // String�� int�� ��ȯ �� ����.
		M = Integer.parseInt(temp[1]);

		input = new int[N];

		temp = br.readLine().split(" ");
		Set<Integer> s = new TreeSet<Integer>();
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(temp[i]);
			s.add(t); // TreeSet�� add
			visited[t]++; // �� ��ȣ�� �°� ī��Ʈ
		}
		a = new ArrayList<Integer>(s); // arraylist�� Ʈ������ �־���.
		dfs(0, bw, "", a.get(0));
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int depth, BufferedWriter bw, String str, int com) {
		if (depth == M) {// ���� ����.
			try {
				bw.write(str + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}

		for (int i = 0; i < a.size(); i++) {
			if (visited[a.get(i)] > 0 && com <= a.get(i)) {
				visited[a.get(i)]--;
				dfs(depth + 1, bw, str + a.get(i) + " ", a.get(i));
				visited[a.get(i)]++;

			}
		}
	}
}