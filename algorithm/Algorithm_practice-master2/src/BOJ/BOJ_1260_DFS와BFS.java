package BOJ;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1260_DFS��BFS {
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

		n = sc.nextInt(); // ������ ���� (node)
		m = sc.nextInt(); // ������ ���� (line)
		v = sc.nextInt(); // Ž���� ������ ������ ��ȣ (start)
		
		map = new int[n+1][n+1]; // ���� ��� (�ε��� Ȱ���ϱ� ���� +1)
		visit = new boolean[n+1]; // �湮 ����(�湮�� �迭)
		
		int num1, num2; // ������ �����ϴ� �� ������ ��ȣ
		
		for(int i=1; i<=m; i++){
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			map[num1][num2] = map[num2][num1] = 1; // �������� ������¸� 1�� ǥ��
		}
		
		dfs2(v); // DFS ����
		ResetVisit();
		bfs(v); // BFS ����
	}
	
	// �湮 ���� �ʱ�ȭ
	public static void ResetVisit(){
		for (int i=1; i<n+1; i++){
			visit[i] = false;
		}
		System.out.println();
	}
	
	// ���� �켱 Ž�� (Depth First Search) - ����Լ�
	public static void dfs(int d) {
		visit[d] = true; // �湮�� �������� üũ
		System.out.print(d + " ");
		
		for (int i=1; i<n+1; i++){
			if(map[d][i] == 1 & !visit[i]) { // �������� ����Ǿ����� ���� �湮���� ���� ����
				dfs(i);
			}
		}
	}
	
	// ���� �켱 Ž�� (Depth First Search) - ����
	public static void dfs2(int d) {
		Stack<Integer> stack = new Stack<>();
		stack.push(d);
		int p; // Ž������ ����
		boolean flag;
		
		visit[d] = true;
		System.out.print(d + " ");
		
		while (!stack.isEmpty()){
			p = stack.peek();
			flag = false;
			
			for (int i=1; i<n+1; i++){
				if(map[p][i] == 1 & !visit[i]) { // �������� ����Ǿ����� ���� �湮���� ���� ���� 
					stack.push(i);
					visit[i] = true;
					System.out.print(i + " ");
					flag = true;
					break;
				}
			}
			
			// �ݺ������� ���ǿ� �������� �ʾ��� ��� �ش� ���� ����
			if (!flag) {
				stack.pop();
			}
		}
	}
	
	// �ʺ� �켱 Ž�� (Breadth First Search) - ť
	public static void bfs(int b){	
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(b);
		visit[b] = true; // �湮�� �������� üũ
		
		
		while (!queue.isEmpty()){
			b = queue.poll();	//���ڸ��� �Q�� ������;;
			System.out.print(b + " ");
			
			for (int i=1; i<n+1; i++){
				if(map[b][i] == 1 & !visit[i]) { // �������� ����Ǿ����� ���� �湮���� ���� ���� 
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}

//https://sundries-in-myidea.tistory.com/4
//������ �� ���粨�� ����.




//import java.io.IOException;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class BOJ_1260_DFS��BFS {
//
//
//
//public class Main {
//	static int node[][]; // ������� �迭
//	static int check[]; // ����� �湮���� ǥ�� �迭
//	static Queue<Integer> queue = new LinkedList<>(); // BFS�� ���� ť
//	static void dfs(int x) { // DFS �޼ҵ� ���ȣ�� �ݺ��Ѵ�.
//		if(check[x] == 1) return; //�̹� �湮�� ����� �����Ѵ�.
//		
//		check[x] = 1; //�湮���� ���� ����� �湮���θ� ǥ���ϰ� ����Ѵ�.
//		System.out.print(x+" ");
//		for(int i =1;i<node.length;i++) { // ��������� ��� �࿭�� �밢���� �������� ��Ī�� �ǹǷ� �� �Ǵ� ���� �������θ� Ž���ϸ�ȴ�.			
//			if(node[x][i]==1) { // �湮���� ���� ����� ���� ����� ���
//				
//				dfs(i); // �ش� ���� �̵�
//			}
//		}
//	}
//	
//	static void bfs(int x) { //BFS �޼ҵ� ť�� �̿��� ����
//		      
//		queue.offer(x); // ť�� ���� ��� ����
//		check[x] = 1; // ���� ��带 �湮 ǥ��
//		while(!queue.isEmpty()) { // ����ť�� �� ������ �ݺ�
//			x = queue.poll(); // ť���� �ϳ� ������.
//			System.out.print(x+" "); // ���
//			for(int i =1;i<node.length;i++) { // ť���� ���� ���� ����� ��带 Ž��			
//				if(check[i]!=1 && node[x][i]==1 ) {	// ť���� ���� ���� ����� ��尡 �湮���� �ʾҴ� �����
//					queue.offer(i); // ť�� ���� ��
//					check[i] =1; // �湮 ǥ��
//				}
//			}
//		}
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);	
//		
//		int n= sc.nextInt(); // ������ ����
//		int m = sc.nextInt(); // ������ ���� 
//		int v = sc.nextInt(); // Ž�� ���� ���
//		
//		node = new int[n+1][n+1];
//		check = new int[n+1];
//		
//		for(int i=0; i<m;i++) { // ������ķ� �׷����� ����
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
//		Arrays.fill(check, 0); // DFS���� ������ �湮 ���ι迭�� ����ϱ� ������ �ٽ� 0���� �ʱ�ȭ ���ش�.
//		System.out.println("");
//		bfs(v);
//		
//	}
//	
//}