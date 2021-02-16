package swexpert.day0205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpert0205_1 {
	static int size;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			
			for(int i = 0; i < size; i++) {  // input
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < size; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int[] res = {Integer.MAX_VALUE, 0};  // ¹øÈ£, ±íÀÌ
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					int search = search(i, j, 1);
					if(search > res[1]) {
						res[0] = map[i][j];
						res[1] = search;
					} else if(search == res[1])
						res[0] = res[0] > map[i][j] ? map[i][j] : res[0];
				}
			}
			
			sb.append("#" + test_case + " " + res[0] + " " + res[1] + "\n");
		}
		System.out.println(sb.toString());
	}
	
	static int search(int i, int j, int res) {
		for(int idx = 0; idx < 4; idx++) {
			int x = i + dx[idx];
			int y = j + dy[idx];
			if (x >= 0 && x < size && y >= 0 && y < size && map[i][j] + 1 == map[x][y])
				return search(x, y, res + 1);
		}
		return res;
	}
}
