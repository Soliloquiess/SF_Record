package com.off.day1;

import java.util.Scanner;

public class SW1954_SnailNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//testcase ����
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();//�迭ũ��
			int[][] map = new int[n][n];
			
			int cnt = 1;//�迭 �� ĭ�� ���� ����
			int dir = 1;//������� ��. 1 or -1
			int x = 0, y = -1;//������
			
			while(true) {
				//��->��->��->��				
				//��: y�� ����, ��:y������
				for (int k = 0; k < n; k++) {
					y = y + dir;//y�� ����
					map[x][y] = cnt;
					cnt++;
				}
				
				n--;//��->��, ��->��
				if(n == 0)
					break;
				
				//��: x�� ����, ��: x�� ����
				for (int j = 0; j < n; j++) {
					x = x + dir;
					map[x][y] = cnt;
					cnt++;
				}				
				dir = dir * -1;//-1�� �ٲ�				
			}//while	
			
			//���
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
