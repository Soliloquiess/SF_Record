package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {

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
	static boolean[][] conn;	// 컴퓨터 간의 연결을 나타내기 위한 배열
	static boolean[] visited;	// 방문을 체크하기 위한 배열

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
		}		// 1 과 2가 연결 되어 있다는 것은 2와 1도 연결 되는것.

		dfs(1);
		System.out.println(result);

	}

	static void dfs(int start) {
		visited[start] = true;	// 방문 처리 
		for (int i = 1; N >= i; ++i) {	// 모든 컴퓨터를 돌면서 
        								// 연결된 컴퓨터이면서 방문하지 않은 컴퓨터를 확인
			if (conn[start][i] == true && visited[i] == false) {
					result++;	// 조건에 해당되면 +1 
					dfs(i);		// 조건에 해당되는 컴퓨터를 기준으로 반복
				}
			}
		}

}
 