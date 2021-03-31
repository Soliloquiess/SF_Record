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
		if (v == n) {			//v가 종착점에 왔으면
			if (sum < cost) cost = sum;		//sum이 코스트보다 작으면 코스트를 sum으로 바꿔줌,
		}
		else {			//아니면 계속 돔.
			for (i = 1; i <= n; i++) {
				if (map[v][i] > 0 && ch[i] == 0) {		//v에서 i로 갈 수 있는지 계속 물어봄. 0보다 크면 연결 되어 있음.
					//==0은 방문 안 한거.
					ch[i] = 1;	//
					DFS(i, sum + map[v][i]);		//vertex엔 i가 넘어감. sum에 가중치값 더해줌.
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
			map[a][b] = c;		//a에서 b로 가는데 가중치 값은 c다.
		}
		ch[1] = 1;		//1번부터 출발하는데 방문했다고 하고
		DFS(1, 0);		//1번부터 가고 비용값(sum) 더해갈껀데 맨 처음엔 0
		System.out.printf("%d\n", cost);

	}
}