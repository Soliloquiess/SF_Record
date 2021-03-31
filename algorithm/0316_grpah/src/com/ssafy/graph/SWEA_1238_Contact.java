package com.ssafy.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_Contact {
	static int [][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt(); //�Է� ������ �� ����
			int start = sc.nextInt(); //������
			
			map = new int[101][101]; //1~100
			for(int i =0;i<N/2;i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map [from][to] = 1;
			}
			System.out.println("#" + tc +" "+ bfs(start));
		}
	}
	private static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int [] visited = new int[101]; //������ �湮����. ���°�� �湮�Ѱ��� �� ���� ���� ����.
		//�Ҹ������� ���ϰ� ���� �־ Ȯ���Ϸ� int�迭�� ����
		int visitSeq = 0, ans =0; //������ �湮������ �����ϴ� ����.
		q.offer(start);
		visited[start] = 1; //���������̴ϱ�.
		//�̰� ������ Ȯ�� ť�� �ְ� Ȯ���ϱ� ���� 1�� �־���.
		while(!q.isEmpty()) {
			int current = q.poll();//��������
			for(int i =1; i<101;i++) {	//���� ������ current �����ε� ������ �������ֳ� ����.
				if(map[current][i] ==1&&visited[i] ==0) {
					q.offer(i);
					visited[i] = visited[current] +1;
				}
			}
			//while�� ���鼭 �湮 ������ visitSeq�� �����ϰڴ�.
			visitSeq = visited[current]; //�� ������ ���°�� �湮 �Ȱų�.
			//visitSeq�� �������� �湮�� �ְ� ���°�� ��������. �湮 ���� ��� ����.
			//��� ���� while�� �����ǵ� �� ������ ���������� ó���� ������ �湮������ ����.
		}
		//visitSeq : ���������� ó���� ������ �湮 ���� ���� ����Ǿ� ����.
		
		for(int i= 1; i<101;i++) {
			if(visitSeq == visited[i]) {
				ans = (ans>i)?ans:i;	//������ ��ȣ
			}
		}
		return ans;
		
	}
}


















