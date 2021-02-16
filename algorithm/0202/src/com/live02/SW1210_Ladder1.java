package com.live02;

import java.util.Scanner;

public class SW1210_Ladder1 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		for (int tc = 1; tc<=10; tc++)
		{
			sc.nextLine();//tc번호, 안씀
			String[][] ladder = new String[100][100];
			//입력-행단위로 입력
			for(int j = 0; j<100;j++)
			{
				ladder[j] = sc.nextLine().split(" ");
			}
			//확인
			//sout(Arrays.deepToString(ladder));
			
			//도착점 위치 찾기 ladder[99][x]
			int end = 0;
			for(int j = 0; j<100;j++)
			{
				if(ladder[99][j].contentEquals("2")) {
					end = j;
					break;
				}
			}
			//ladder[99][end] 위치~ 출발점까지 조사
			
			int x = 99, y= end; //도착점 좌표
			while(x>=0) {
				//1. 오른쪽으로 이동 가능한 지 -> 계속 오른쪽으로 이동
				if((y+1<100) && ladder[x][y+1].contentEquals("1")) {
					//계속 오른쪽으로 이동
					do {
						y++;	//계속 오른쪽으로 이동
					}
					while((y+1<100)&& ladder[x][y+1].equals("1"));
				}
				//2.왼쪽으로 이동 가능한 지.->계속 왼쪽으로 이동.
				else if((y-1>= 0)&&ladder[x][y-1].equals("1")) {
					do {
						y--;//계속 왼쪽으로 이동
					}
					while((y-1>=0)&& ladder[x][y-1].equals("1"));
				}
				
				//3.위로 이동
				x--;
			}//while
			System.out.println("#"+tc+" "+y);
		}//for
	}//main
}//class
