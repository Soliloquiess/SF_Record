package BOJ;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1260_DFS��BFS {

	static int[][] map; 
	static boolean[] visit; 
	static int n,m,v;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // ������ ���� (node)
		m = sc.nextInt(); // ������ ���� (line)
		v = sc.nextInt(); // Ž���� ������ ������ ��ȣ (start)
		
		map = new int[n+1][n+1]; // ���� ��� (�ε��� Ȱ���ϱ� ���� +1)
		visit = new boolean[n+1]; // �湮 ����
		
		int num1, num2; // ������ �����ϴ� �� ������ ��ȣ
		
		for(int i=1; i<=m; i++){
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			map[num1][num2] = map[num2][num1] = 1; // �������� ������¸� 1�� ǥ��
		}
		
		dfs(v); // DFS ����
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
			b = queue.poll();
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