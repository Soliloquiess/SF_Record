package com.ssafy.back;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
5 5
.xx..
..x..
.....
...x.
...x.
 */
/**
 * @author THKim
 */
public class B2_RestaurantTest {

	static int R,C, cnt = 0;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		makePipe();
		System.out.println(cnt);
	}
	private static void makePipe() {
		cnt = 0;
		// 윗행부터 시도
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			dfs(i,0);
		}
	}
	
	static int[] dr = {-1,0,1};
	private static boolean dfs(int r, int c) {
		
		if(c==C-1) {
			cnt++;
			return true;//파이프놓기 성공
		}
		
		int nr, nc = c+1;
		for (int d = 0; d < 3; d++) {
			nr = r +dr[d];
			if(nr<0 || nr>=R || map[nr][nc]=='x' || visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			if(dfs(nr,nc)) return true;
//			visited[nr][nc] = false; // 실패했던 흔적 되돌리지 않기 : 뒤의 선택지의 방향은 현재보다 유리하지 않은 상황이고 결국 같은 상황 되풀이
		}
		
		return false;
	}

}













