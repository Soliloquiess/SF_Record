package com.off.day1;

import java.util.Scanner;

/* 1.map을 입력. 입력 받고 전차의 위치 찾아놓기
 * 2.명령 갯수, 내용 입력 받기
 * 3.명령어 내용에 따라 동작
 * 	3-1.이동(UDLR)
 *  3-2.SHOOT
 * */
public class SW1873_BattleField {
	//상, 하, 좌, 우: dx[0]dy[0]->-1,0 상
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int H, W;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//1.MAP의 크기 입력
			H = sc.nextInt();
			W = sc.nextInt();
			char[][] map = new char[H][W];
			
			//전차의 좌표 저장하는 배열
			int[] tank = new int[2];
			
			//입력
			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();//한행에 입력이 됨
				
				for (int j = 0; j < map[i].length; j++) {
					switch(map[i][j]) {
						case '<':
						case '>':
						case '^':
						case 'v':
							tank[0] = i;
							tank[1] = j;
							break;
					}
				}			
			}//입력완료. 전차 찾음
			
			//명령 갯수와 내용을 입력
			int N = sc.nextInt();//23
			String command = sc.next();//UDRSL...
			
			//명령어 하나씩 수행
			for (int i = 0; i < N; i++) {
				char c = command.charAt(i);//명령어 한글자
				switch(c) {
					case 'U'://상
						map[tank[0]][tank[1]] = '^';//방향 바꾸기
						move(map, tank, 0);
						break;
						
					case 'D':
						map[tank[0]][tank[1]] = 'v';//방향 바꾸기
						move(map, tank, 1);
						break;
						
					case 'L':
						map[tank[0]][tank[1]] = '<';//방향 바꾸기
						move(map, tank, 2);
						break;
						
					case 'R':
						map[tank[0]][tank[1]] = '>';//방향 바꾸기
						move(map, tank, 3);
						break;
						
					case 'S':
						shoot(map, tank);
						break;							
				}//switch				
			}//for
			
			//출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}//tc
	}//main

	private static void shoot(char[][] map, int[] tank) {
		int dir = 0;
		
		//map[tank[0]][tank[1]]<- '<','>','v','^'
		//1.현재 전차의 방향에 따라 그 방향으로 쏴야 함
		switch(map[tank[0]][tank[1]]) {
			case '^':
				dir = 0;
				break;
				
			case 'v':
				dir = 1;
				break;
				
			case '<':
				dir = 2;
				break;
				
			case '>':
				dir = 3;
				break;
		}
		
		//2.전차의 현재 위치
		int tx = tank[0];
		int ty = tank[1];
		
		//3.가능할 때까지 포탄이 계속 이동하면서 쏠거임
		while(true) {
			//3-1.포탄이 날아갈 새 좌표
			tx = tx + dx[dir];
			ty = ty + dy[dir];
			
			//3-2.새좌표의 유효성
			if(tx < 0 || ty < 0 || tx >= H || ty >= W)
				return;
			
			//3-3.벽돌벽인 경우(평지로 바뀜)
			if(map[tx][ty] == '*') {
				map[tx][ty] = '.';//평지로 바꾸고
				return;
			}
			
			//3-4.강철벽인 경우(그냥 끝)
			else if(map[tx][ty] == '#') 
				return;
		}		
	}

	//지정한 방향의 새 좌표로 전차 이동
	private static void move(char[][] map, int[] tank, int index) {
		//전차의 방향은 이미 바꾸고 왔음
		//1.전차가 이동할 방향의 새 좌표 계산
		int nx = tank[0] + dx[index];//현재 전차의 x좌표 + dx[index]
		int ny = tank[1] + dy[index];
		
		//2.새좌표의 유효성
		if(nx < 0 || ny < 0 || nx >= H || ny >= W)
			return;
		
		//3.이동가능(평지이어야만 가능)
		if(map[nx][ny] == '.') {
			//3-1.새위치에 전차를 이동시킴
			map[nx][ny] = map[tank[0]][tank[1]];
			
			//3-2.원래 전차가 있던 자리는 평지로 바꾸기
			map[tank[0]][tank[1]] = '.';
			
			//3-3.전차의 좌표 갱신
			tank[0] = nx;
			tank[1] = ny;
		}		
	}
}
