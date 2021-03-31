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
		if (v == n) {	//cost꽉차면 끝내는 거
			if (sum < cost) cost = sum;
		}
		else{
			for(int nv : graph.get(v)){
				if(ch[nv]==0){
					ch[nv]=1;
					DFS(map[v][i].x, sum + map[v][i].y);		//가중치 값 더해가는거 x=first, y= second라 생각.(영상에선 fisrt,second씀)
					//map.x는 pair 요소가 ㅣ로 구분되는데 그 앞, y는 그 뒤(1번쨰 2번쨰 요소)라 생각하면 됨.
					
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
			map[a].push_back(make_pair(b, c));	//a라는 정점에서 가고 push_back 하고 맵이라는 곳에 페어자료 넣음.
			//b,c넣었는데 b가 첫번째 자료로 들어가고 a에서 b로 간다는 뜻(a에서 갈수 있는 정점) c는 가중치값(가중치 방향그래프 인접리스트)
		}
		ch[1] = 1;
		DFS(1, 0);
		printf("%d\n", cost);
		return 0;
	}
}