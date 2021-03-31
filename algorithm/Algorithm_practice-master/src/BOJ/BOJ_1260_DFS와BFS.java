package BOJ;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1260_DFS와BFS {
/*
4 5 1
1 2
1 3
1 4
2 4
3 4
 */
	static int[][] map; 
	static boolean[] visit; 
	static int n,m,v;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 정점의 개수 (node)
		m = sc.nextInt(); // 간선의 개수 (line)
		v = sc.nextInt(); // 탐색을 시작할 정점의 번호 (start)
		
		map = new int[n+1][n+1]; // 인접 행렬 (인덱스 활용하기 위해 +1)
		visit = new boolean[n+1]; // 방문 여부(방문한 배열)
		
		int num1, num2; // 간선을 연결하는 두 정점의 번호
		
		for(int i=1; i<=m; i++){
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			map[num1][num2] = map[num2][num1] = 1; // 정점간의 연결상태를 1로 표시
		}
		
		dfs2(v); // DFS 수행
		ResetVisit();
		bfs(v); // BFS 수행
	}
	
	// 방문 정점 초기화
	public static void ResetVisit(){
		for (int i=1; i<n+1; i++){
			visit[i] = false;
		}
		System.out.println();
	}
	
	// 깊이 우선 탐색 (Depth First Search) - 재귀함수
	public static void dfs(int d) {
		visit[d] = true; // 방문한 정점임을 체크
		System.out.print(d + " ");
		
		for (int i=1; i<n+1; i++){
			if(map[d][i] == 1 & !visit[i]) { // 간선으로 연결되었으며 아직 방문하지 않은 정점
				dfs(i);
			}
		}
	}
	
	// 깊이 우선 탐색 (Depth First Search) - 스택
	public static void dfs2(int d) {
		Stack<Integer> stack = new Stack<>();
		stack.push(d);
		int p; // 탐색중인 정점
		boolean flag;
		
		visit[d] = true;
		System.out.print(d + " ");
		
		while (!stack.isEmpty()){
			p = stack.peek();
			flag = false;
			
			for (int i=1; i<n+1; i++){
				if(map[p][i] == 1 & !visit[i]) { // 간선으로 연결되었으며 아직 방문하지 않은 정점 
					stack.push(i);
					visit[i] = true;
					System.out.print(i + " ");
					flag = true;
					break;
				}
			}
			
			// 반복문에서 조건에 충족하지 않았을 경우 해당 정점 제거
			if (!flag) {
				stack.pop();
			}
		}
	}
	
	// 너비 우선 탐색 (Breadth First Search) - 큐
	public static void bfs(int b){	
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(b);
		visit[b] = true; // 방문한 정점임을 체크
		
		
		while (!queue.isEmpty()){
			b = queue.poll();	//넣자마자 뻈네 ㅇㅅㅇ;;
			System.out.print(b + " ");
			
			for (int i=1; i<n+1; i++){
				if(map[b][i] == 1 & !visit[i]) { // 간선으로 연결되었으며 아직 방문하지 않은 정점 
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}

//https://sundries-in-myidea.tistory.com/4
//덤으로 이 아재꺼도 보자.




//import java.io.IOException;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class BOJ_1260_DFS와BFS {
//
//
//
//public class Main {
//	static int node[][]; // 인접행렬 배열
//	static int check[]; // 노드의 방문여부 표시 배열
//	static Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐
//	static void dfs(int x) { // DFS 메소드 재귀호출 반복한다.
//		if(check[x] == 1) return; //이미 방문한 노드라면 종료한다.
//		
//		check[x] = 1; //방문하지 않은 노드라면 방문여부를 표시하고 출력한다.
//		System.out.print(x+" ");
//		for(int i =1;i<node.length;i++) { // 인접행렬의 경우 행열이 대각선을 기준으로 대칭이 되므로 행 또는 열을 기준으로만 탐색하면된다.			
//			if(node[x][i]==1) { // 방문하지 않은 노드의 인접 노드일 경우
//				
//				dfs(i); // 해당 노드로 이동
//			}
//		}
//	}
//	
//	static void bfs(int x) { //BFS 메소드 큐를 이용해 구현
//		      
//		queue.offer(x); // 큐에 시작 노드 삽입
//		check[x] = 1; // 시작 노드를 방문 표시
//		while(!queue.isEmpty()) { // 공백큐가 될 때까지 반복
//			x = queue.poll(); // 큐에서 하나 꺼낸다.
//			System.out.print(x+" "); // 출력
//			for(int i =1;i<node.length;i++) { // 큐에서 꺼낸 노드와 연결된 노드를 탐색			
//				if(check[i]!=1 && node[x][i]==1 ) {	// 큐에서 꺼낸 노드와 연결된 노드가 방문하지 않았던 노드라면
//					queue.offer(i); // 큐에 삽입 후
//					check[i] =1; // 방문 표시
//				}
//			}
//		}
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);	
//		
//		int n= sc.nextInt(); // 정점의 개수
//		int m = sc.nextInt(); // 간선의 개수 
//		int v = sc.nextInt(); // 탐색 시작 노드
//		
//		node = new int[n+1][n+1];
//		check = new int[n+1];
//		
//		for(int i=0; i<m;i++) { // 인접행렬로 그래프를 구현
//			
//			int a =sc.nextInt();
//			int b = sc.nextInt();
//			node[a][b] =1;
//			node[b][a]= 1;
//		}
//		
//		
//		
//		dfs(v);
//		Arrays.fill(check, 0); // DFS이후 동일한 방문 여부배열을 사용하기 때문에 다시 0으로 초기화 해준다.
//		System.out.println("");
//		bfs(v);
//		
//	}
//	
//}