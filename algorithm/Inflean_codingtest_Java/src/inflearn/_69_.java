package inflearn;



import java.util.*;

public class _69_ {
//	static int n;
//	static int[][] map;
//	static boolean[] visit;
//	
//	public static void bfs(int x) {
//		Queue <Integer> q = new LinkedList<>();
//		q.add(x);
//		visit[x] = true;
//		
//		while(!q.isEmpty()) {
//			x = q.poll();
//			System.out.print((x + 1) + " ");
//			
//			for(int i = 0; i < n; i++) {
//				if(map[x][i] == 1 && visit[i] == false) {
//					q.add(i);
//					visit[i] = true;
//				}
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		map = new int[n][n];
//		visit = new boolean[n];
//		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				map[i][j] = sc.nextInt();
//			}
//		}
//		bfs(0);
//	}
//}
	
	static Scanner sc = new Scanner(System.in);
//	static ArrayList<ArrayList<Integer>> graph;
	static int[] Q =new int[100];
	static int front = -1, back = -1;
	static int [] ch =new int[10];
	
	public static void main(String[] args){
		int i, a, b, x;
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for( i=0; i<=6; i++){
			graph.add(new ArrayList<Integer>());
		}
		
		for (i = 1; i <= 6; i++) {
//			scanf("%d %d", &a, &b);
			a= sc.nextInt();
			b = sc.nextInt();
			
		 
//			map[a].push_back(b);	//a에서 b로 갈 수 있따.
			
			graph.get(a).add(b);
//			map[b].push_back(a);	//b에서 a로 갈 수 있다.
		}
		Q[++back] = 1;				//큐라는 자료구조에 백 넣고 증가시킴.		 //자료구조 루트노드 back으로 넣고 먼저 증가시킴 -1이였다 0이 됨.
		//백 먼저 증가시켜서 1 만듬.
		ch[1] = 1;					//1번 루트노드 방문했다고 체크 넣어줌. ////1번 루트노드는 방문했다고 체크 넣어줌
		while (front < back) {		//이게 같아지면 큐 끝남.
			x = Q[++front];			//꺼낼때는 front
			System.out.printf("%d ", x);
			for (int nv : graph.get(x)) {
				if (ch[nv] == 0) {		//max[x][i]가 x와 연결된 노드 번호. 연결 안 되있다면 방문하는거
					ch[nv] = 1;
					Q[++back] = nv;
				}
			}
		}
	}
}