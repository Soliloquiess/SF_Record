package com.live02;

import java.util.Scanner;

public class SW1210_Ladder1 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		for (int tc = 1; tc<=10; tc++)
		{
			sc.nextLine();//tc��ȣ, �Ⱦ�
			String[][] ladder = new String[100][100];
			//�Է�-������� �Է�
			for(int j = 0; j<100;j++)
			{
				ladder[j] = sc.nextLine().split(" ");
			}
			//Ȯ��
			//sout(Arrays.deepToString(ladder));
			
			//������ ��ġ ã�� ladder[99][x]
			int end = 0;
			for(int j = 0; j<100;j++)
			{
				if(ladder[99][j].contentEquals("2")) {
					end = j;
					break;
				}
			}
			//ladder[99][end] ��ġ~ ��������� ����
			
			int x = 99, y= end; //������ ��ǥ
			while(x>=0) {
				//1. ���������� �̵� ������ �� -> ��� ���������� �̵�
				if((y+1<100) && ladder[x][y+1].contentEquals("1")) {
					//��� ���������� �̵�
					do {
						y++;	//��� ���������� �̵�
					}
					while((y+1<100)&& ladder[x][y+1].equals("1"));
				}
				//2.�������� �̵� ������ ��.->��� �������� �̵�.
				else if((y-1>= 0)&&ladder[x][y-1].equals("1")) {
					do {
						y--;//��� �������� �̵�
					}
					while((y-1>=0)&& ladder[x][y-1].equals("1"));
				}
				
				//3.���� �̵�
				x--;
			}//while
			System.out.println("#"+tc+" "+y);
		}//for
	}//main
}//class
