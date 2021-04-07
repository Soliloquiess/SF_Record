package com.off.day1;

import java.util.Scanner;

/* 1.map�� �Է�. �Է� �ް� ������ ��ġ ã�Ƴ���
 * 2.��� ����, ���� �Է� �ޱ�
 * 3.��ɾ� ���뿡 ���� ����
 * 	3-1.�̵�(UDLR)
 *  3-2.SHOOT
 * */
public class SW1873_BattleField {
	//��, ��, ��, ��: dx[0]dy[0]->-1,0 ��
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int H, W;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//1.MAP�� ũ�� �Է�
			H = sc.nextInt();
			W = sc.nextInt();
			char[][] map = new char[H][W];
			
			//������ ��ǥ �����ϴ� �迭
			int[] tank = new int[2];
			
			//�Է�
			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();//���࿡ �Է��� ��
				
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
			}//�Է¿Ϸ�. ���� ã��
			
			//��� ������ ������ �Է�
			int N = sc.nextInt();//23
			String command = sc.next();//UDRSL...
			
			//��ɾ� �ϳ��� ����
			for (int i = 0; i < N; i++) {
				char c = command.charAt(i);//��ɾ� �ѱ���
				switch(c) {
					case 'U'://��
						map[tank[0]][tank[1]] = '^';//���� �ٲٱ�
						move(map, tank, 0);
						break;
						
					case 'D':
						map[tank[0]][tank[1]] = 'v';//���� �ٲٱ�
						move(map, tank, 1);
						break;
						
					case 'L':
						map[tank[0]][tank[1]] = '<';//���� �ٲٱ�
						move(map, tank, 2);
						break;
						
					case 'R':
						map[tank[0]][tank[1]] = '>';//���� �ٲٱ�
						move(map, tank, 3);
						break;
						
					case 'S':
						shoot(map, tank);
						break;							
				}//switch				
			}//for
			
			//���
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
		//1.���� ������ ���⿡ ���� �� �������� ���� ��
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
		
		//2.������ ���� ��ġ
		int tx = tank[0];
		int ty = tank[1];
		
		//3.������ ������ ��ź�� ��� �̵��ϸ鼭 �����
		while(true) {
			//3-1.��ź�� ���ư� �� ��ǥ
			tx = tx + dx[dir];
			ty = ty + dy[dir];
			
			//3-2.����ǥ�� ��ȿ��
			if(tx < 0 || ty < 0 || tx >= H || ty >= W)
				return;
			
			//3-3.�������� ���(������ �ٲ�)
			if(map[tx][ty] == '*') {
				map[tx][ty] = '.';//������ �ٲٰ�
				return;
			}
			
			//3-4.��ö���� ���(�׳� ��)
			else if(map[tx][ty] == '#') 
				return;
		}		
	}

	//������ ������ �� ��ǥ�� ���� �̵�
	private static void move(char[][] map, int[] tank, int index) {
		//������ ������ �̹� �ٲٰ� ����
		//1.������ �̵��� ������ �� ��ǥ ���
		int nx = tank[0] + dx[index];//���� ������ x��ǥ + dx[index]
		int ny = tank[1] + dy[index];
		
		//2.����ǥ�� ��ȿ��
		if(nx < 0 || ny < 0 || nx >= H || ny >= W)
			return;
		
		//3.�̵�����(�����̾�߸� ����)
		if(map[nx][ny] == '.') {
			//3-1.����ġ�� ������ �̵���Ŵ
			map[nx][ny] = map[tank[0]][tank[1]];
			
			//3-2.���� ������ �ִ� �ڸ��� ������ �ٲٱ�
			map[tank[0]][tank[1]] = '.';
			
			//3-3.������ ��ǥ ����
			tank[0] = nx;
			tank[1] = ny;
		}		
	}
}
