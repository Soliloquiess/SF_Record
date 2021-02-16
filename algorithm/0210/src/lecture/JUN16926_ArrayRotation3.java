package com.off.day3;

import java.io.*;
import java.util.*;

public class JUN16926_ArrayRotation3 {

	static int R, C, num, spin;
	// r, b,l,u,(��, ��, ��, ��)<-<-, ^^, ->->, vv
	// ���� <-������, ��<-�Ʒ�, ����->������, ��->�Ʒ� ������ �̵� ��ų����
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

		num = Math.min(R, C) / 2;// �ѹ� ȸ���ø��� �迭��ü �̵� Ƚ���� n/2�� �ص� ��
		for (int i = 0; i < spin; i++) {
			rotationMap();
		}

		resultPrint();
	}

	// 1ȸȸ��: (0,0)���� �ѹ���& (1,1)���� �ѹ���, (2,2)���� �ѹ��� �ؼ� n/2�� ���� -> 1ȸ ȸ�� �ϼ�
	private static void rotationMap() {
		for (int n = 0; n < num; n++) {

			int temp = map[n][n];// �ѹ��� �� ������. (0,0),(1,1),(2,2)....

			int dir = 0; // ��� ���̸鼭 ��ȯ�ߴ��� üũ. �ű�� ���Ⱚ
			int curX = n, curY = n;

			while (dir < 4) {// 4���� �����Ŷ�
				// nx, ny: ����ĭ���� �̻� �� ��ġ. curX, curY:���� ��ġ(����� �̻�;� ��)
				int nx = curX + dx[dir];// right ���. �� <- �쿡 �ִ� �ְ� �·� �;� �Ǵϱ�
				int ny = curY + dy[dir];

				if (nx >= n && ny >= n && nx < R - n && ny < C - n) {
					map[curX][curY] = map[nx][ny]; // ������ġ�� �̻��Ű��
					curX = nx; // ���� ���� �������� ������ �ٲٰ� while�� �ٽ� ����
					curY = ny;
				} else {
					dir++; // ���� ���� ������ ��� == ����ߵǴ� Ÿ�̹�
				}
			}
			map[n + 1][n] = temp;// ���� �ϳ� �����ϰ� ���� �״��
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
