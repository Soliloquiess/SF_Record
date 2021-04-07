package com.algo02;

import java.util.Arrays;
import java.util.Scanner;

/* 출발점->도착점 진행하면 첫행의 모든 시작 가능한 열(1)을 조사해야 하니까 너무 많음
 * 도착점->시작점으로 돌아오는 경로를 찾으면 됨
 * 기준이 되는 위치에서 좌우가 상하보다 우선 순위가 높음
 * : 좌우로 이동 가능한지 체크 후 상으로 이동
 * */
public class SW1210_Ladder1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextLine();//tc 번호. 안씀
			String[][] ladder = new String[100][100];
			
			//입력-행 단위로 입력
			for (int j = 0; j < 100; j++) {
				ladder[j] = sc.nextLine().split(" ");
			}
			//확인
			//System.out.println(Arrays.deepToString(ladder));
			
			//도착점 위치 찾기 ladder[99][end]
			int end = 0;
			for (int j = 0; j < 100; j++) {
				if(ladder[99][j].equals("2")) {
					end = j;
					break;
				}
			}
			
			//ladder[99][end]위치~출발점까지 조사
			int x = 99, y = end;//도착점 좌표
			while(x > 0 ) {
				//1.오른쪽으로 이동 가능한지 -> 계속 오른쪽으로 이동
				if((y + 1 < 100) && ladder[x][y + 1].equals("1")) {					
					do {
						y++;//계속 오른쪽으로 이동
					}while((y + 1 < 100) && ladder[x][y + 1].equals("1"));
				}
				
				//2.왼쪽으로 이동 가능한지 ->계속 왼쪽으로 이동
				else if((y - 1 >= 0) && ladder[x][y - 1].equals("1")) {
					do {
						y--;//계속 왼쪽으로 이동
					}while((y - 1 >= 0) && ladder[x][y - 1].equals("1"));
				}				
				//3.위로 이동
				x--;
			}//while	
			
			System.out.println("#" + tc + " " + y);
		}//for
	}//main
}//class
