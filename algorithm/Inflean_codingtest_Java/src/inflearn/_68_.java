package inflearn;


import java.util.ArrayList;
import java.util.Scanner;

public class _68_ {
	static int[][] map = new int[30][30];
	static int []ch = new int[30];
	static int cnt =0;
	static int n,m; 
	static int cost = 2147000000;
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<ArrayList<Integer>> graph;
//	static int[] ch;
	public static void DFS(int v, int sum) {
		int i;
		if (v == n) {	//cost������ ������ ��
			if (sum < cost) cost = sum;
		}
		else{
			for(int nv : graph.get(v)){
				if(ch[nv]==0){
					ch[nv]=1;
					DFS(map[v][i].x, sum + map[v][i].y);		//����ġ �� ���ذ��°� x=first, y= second�� ����.(���󿡼� fisrt,second��)
					//map.x�� pair ��Ұ� �ӷ� ���еǴµ� �� ��, y�� �� ��(1���� 2���� ���)�� �����ϸ� ��.
					
					ch[nv]=0;
				}
			}
		}
	}
	
	public static void main(String[] args){
//		int m, i, a, b, c;
		scanf("%d %d", &n, &m);
		for (i = 1; i <= m; i++) {
			scanf("%d %d %d", &a, &b, &c);
			map[a].push_back(make_pair(b, c));	//a��� �������� ���� push_back �ϰ� ���̶�� ���� ����ڷ� ����.
			//b,c�־��µ� b�� ù��° �ڷ�� ���� a���� b�� ���ٴ� ��(a���� ���� �ִ� ����) c�� ����ġ��(����ġ ����׷��� ��������Ʈ)
		}
		ch[1] = 1;
		DFS(1, 0);
		printf("%d\n", cost);
		return 0;
	}
}