package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_���̷��� {

	/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
	 */
	static int N, M, result;
	static boolean[][] conn;	// ��ǻ�� ���� ������ ��Ÿ���� ���� �迭
	static boolean[] visited;	// �湮�� üũ�ϱ� ���� �迭

	public static void main(String[] agrs) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		conn = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; M >= i; ++i) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			conn[first][second] = true;
			conn[second][first] = true;
		}		// 1 �� 2�� ���� �Ǿ� �ִٴ� ���� 2�� 1�� ���� �Ǵ°�.

		dfs(1);
		System.out.println(result);

	}

	static void dfs(int start) {
		visited[start] = true;	// �湮 ó�� 
		for (int i = 1; N >= i; ++i) {	// ��� ��ǻ�͸� ���鼭 
        								// ����� ��ǻ���̸鼭 �湮���� ���� ��ǻ�͸� Ȯ��
			if (conn[start][i] == true && visited[i] == false) {
					result++;	// ���ǿ� �ش�Ǹ� +1 
					dfs(i);		// ���ǿ� �ش�Ǵ� ��ǻ�͸� �������� �ݺ�
				}
			}
		}

}
 