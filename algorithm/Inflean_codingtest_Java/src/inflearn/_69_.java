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
			
		 
//			map[a].push_back(b);	//a���� b�� �� �� �ֵ�.
			
			graph.get(a).add(b);
//			map[b].push_back(a);	//b���� a�� �� �� �ִ�.
		}
		Q[++back] = 1;				//ť��� �ڷᱸ���� �� �ְ� ������Ŵ.		 //�ڷᱸ�� ��Ʈ��� back���� �ְ� ���� ������Ŵ -1�̿��� 0�� ��.
		//�� ���� �������Ѽ� 1 ����.
		ch[1] = 1;					//1�� ��Ʈ��� �湮�ߴٰ� üũ �־���. ////1�� ��Ʈ���� �湮�ߴٰ� üũ �־���
		while (front < back) {		//�̰� �������� ť ����.
			x = Q[++front];			//�������� front
			System.out.printf("%d ", x);
			for (int nv : graph.get(x)) {
				if (ch[nv] == 0) {		//max[x][i]�� x�� ����� ��� ��ȣ. ���� �� ���ִٸ� �湮�ϴ°�
					ch[nv] = 1;
					Q[++back] = nv;
				}
			}
		}
	}
}