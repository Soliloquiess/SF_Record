package com.off.day3;

import java.io.*;
import java.util.*;

public class JUN16926_ArrayRotation3 {

	static int R, C, num, spin;
	// r, b,l,u,(우, 하, 좌, 상)<-<-, ^^, ->->, vv
	// 왼쪽 <-오른쪽, 위<-아래, 왼쪽->오른쪽, 위->아래 순으로 이동 시킬거임
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		spin = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input

		num = Math.min(R, C) / 2;// 한번 회전시마다 배열전체 이동 횟수는 n/2만 해도 됨
		for (int i = 0; i < spin; i++) {
			rotationMap();
		}

		resultPrint();
	}

	// 1회회전: (0,0)부터 한바퀴& (1,1)부터 한바퀴, (2,2)부터 한바퀴 해서 n/2번 돌면 -> 1회 회전 완성
	private static void rotationMap() {
		for (int n = 0; n < num; n++) {

			int temp = map[n][n];// 한바퀴 돌 시작점. (0,0),(1,1),(2,2)....

			int dir = 0; // 몇번 꺾이면서 순환했는지 체크. 옮기는 방향값
			int curX = n, curY = n;

			while (dir < 4) {// 4방향 꺽을거라
				// nx, ny: 현재칸으로 이사 올 위치. curX, curY:현재 위치(여기로 이사와야 함)
				int nx = curX + dx[dir];// right 계산. 좌 <- 우에 있는 애가 좌로 와야 되니깐
				int ny = curY + dy[dir];

				if (nx >= n && ny >= n && nx < R - n && ny < C - n) {
					map[curX][curY] = map[nx][ny]; // 현재위치로 이사시키고
					curX = nx; // 현재 점을 다음점의 값으로 바꾸고 while문 다시 ㄱㄱ
					curY = ny;
				} else {
					dir++; // 다음 점이 범위를 벗어남 == 꺾어야되는 타이밍
				}
			}
			map[n + 1][n] = temp;// 행은 하나 증가하고 열은 그대로
		}
	}

	private static void resultPrint() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append('\n');
		}
		sb.append('\n');
		System.out.println(sb.toString());
	}

}
