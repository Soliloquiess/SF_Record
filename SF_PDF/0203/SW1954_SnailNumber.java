package com.off.day1;

import java.util.Scanner;

public class SW1954_SnailNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//testcase 갯수
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();//배열크기
			int[][] map = new int[n][n];
			
			int cnt = 1;//배열 각 칸에 넣을 숫자
			int dir = 1;//진행방향 값. 1 or -1
			int x = 0, y = -1;//시작점
			
			while(true) {
				//우->하->좌->상				
				//우: y가 증가, 좌:y가감소
				for (int k = 0; k < n; k++) {
					y = y + dir;//y값 증가
					map[x][y] = cnt;
					cnt++;
				}
				
				n--;//우->하, 좌->상
				if(n == 0)
					break;
				
				//하: x가 증가, 상: x가 감소
				for (int j = 0; j < n; j++) {
					x = x + dir;
					map[x][y] = cnt;
					cnt++;
				}				
				dir = dir * -1;//-1로 바뀜				
			}//while	
			
			//출력
			System.out.println("#" + tc);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}//for
		
	}//main
}//class
