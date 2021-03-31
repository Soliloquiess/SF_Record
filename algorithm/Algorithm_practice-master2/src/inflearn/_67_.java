package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class _67_ {
	static int[][] map = new int[30][30];
	static int []ch = new int[30];
	static int n,m; 
	static int cost = 2147000000;
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<ArrayList<Integer>> graph;
//	static int[] ch;
	public static void DFS(int v, int sum) {
		int i;
		if (v == n) {			//v�� �������� ������
			if (sum < cost) cost = sum;		//sum�� �ڽ�Ʈ���� ������ �ڽ�Ʈ�� sum���� �ٲ���,
		}
		else {			//�ƴϸ� ��� ��.
			for (i = 1; i <= n; i++) {
				if (map[v][i] > 0 && ch[i] == 0) {		//v���� i�� �� �� �ִ��� ��� ���. 0���� ũ�� ���� �Ǿ� ����.
					//==0�� �湮 �� �Ѱ�.
					ch[i] = 1;	//
					DFS(i, sum + map[v][i]);		//vertex�� i�� �Ѿ. sum�� ����ġ�� ������.
					ch[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args){
//		scanf("%d %d", &n, &m);
		int m, i, a, b, c;
		n = sc.nextInt();
		m = sc.nextInt();
		for (i = 1; i <= m; i++) {
//			scanf("%d %d %d", &a, &b, &c);
			 a= sc.nextInt();
			 b = sc.nextInt();
			 c =sc.nextInt();
			map[a][b] = c;		//a���� b�� ���µ� ����ġ ���� c��.
		}
		ch[1] = 1;		//1������ ����ϴµ� �湮�ߴٰ� �ϰ�
		DFS(1, 0);		//1������ ���� ��밪(sum) ���ذ����� �� ó���� 0
		System.out.printf("%d\n", cost);

	}
}