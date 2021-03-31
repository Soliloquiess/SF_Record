package BOJ;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
public class BOJ_15649_N��M_1 {
	static int N, M;
	static boolean[] visited;
	static int[] a; // ���� ��°��� ���� �迭
//3 1
//4 2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");// temp�� " "�� �������� String�� ���� ����.
		N = Integer.parseInt(temp[0]); // String�� int�� ��ȯ �� ����.
		M = Integer.parseInt(temp[1]);

		visited = new boolean[N + 1];
		a = new int[N + 1];
		dfs(1);
	}

	static void dfs(int depth) {
		if (depth == M + 1) {// ���� ����
			for (int i = 1; i <= M; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				a[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}

*/

//import java.util.*;
//public class BOJ_15649_N��M_1 {
//    static boolean[] c = new boolean[10];
//    static int[] a = new int[10];
//    static void go(int index, int start,int n, int m) {
//        if (index == m) {
//            for (int i=0; i<m; i++) {
//                System.out.print(a[i]);
//                if (i != m-1) System.out.print(' ');
//            }
//            System.out.println();
//            return;
//        }
//        for (int i=1; i<=n; i++) {
//        	if (c[i]) continue;
//            c[i] = true;
//            a[index] = i;
//            go(index+1, i+1, n, m);
//            c[i] = false;
//        }
//    }   
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        go(0,1,n,m);
//    }
//}

 



import java.util.*;

public class BOJ_15649_N��M_1 {
	static int m,n; // N�� M�� �Է¹޴´�.
	static int list[],check[]; // ������ �湮���θ� üũ �� �湮�迭�� ����� ���� �� �迭�� ����
	
	static void dfs(int cnt) { // DFS�޼ҵ�, �ݺ�Ƚ���� ���ڷ� �޴´�. �ʱ� 0���� ����
			
		if(cnt == m) { // 0���� M������ �ݺ������� �ϳ��� ó���� �ϼ�
        			   // �������� �������δ� �̺κ��� ��Ʈ��ŷ�� �ش��Ѵٰ� �����Ѵ�.
                       // M���� ū Ƚ���� ������� �ʰ� �����Ѵ�.
			for(int i=0;i<m;i++) { // ���� ����迭�� ���
				System.out.print(list[i]+" ");
			}
			System.out.println("");
			return; // DFS ���� 
		}
		
		for(int i =1;i<=n;i++) { // ���� ������ 1���� N�����̴�.
			
			if(check[i]==1) continue; // �̹� �湮�� �迭�̸� �ǳʶڴ�.
			check[i]=1; // �湮���� �ʾҴٸ�, �湮ó�� ��
			list[cnt]=i; // ���� �ݺ�Ƚ���� �ش��ϴ� �迭�� i���� �ִ´�.
			dfs(cnt+1); // �ݺ�Ƚ���� ������Ų��.
			check[i]=0; // dfs�� ���� �Ŀ��� �ٽ� �湮���θ� 0���� �ʱ�ȭ�Ѵ�.
			
			
		}
		
		
	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		n = sc.nextInt(); 
		m = sc.nextInt(); 
		
		check = new int[9]; // n�� m�� �ִ����
		list = new int [9];
		dfs(0);
	}
	
}


//
//
//import java.util.Scanner;
//
//public class BOJ_15649_N��M_1 {
// 
//	public static int[] arr;
//	public static boolean[] visit;
// 
//	public static void main(String[] args) {
// 
//		Scanner in = new Scanner(System.in);
// 
//		int N = in.nextInt();
//		int M = in.nextInt();
// 
//		arr = new int[M];
//		visit = new boolean[N];
//		dfs(N, M, 0);
// 
//	}
// 
//	public static void dfs(int N, int M, int depth) {
//		if (depth == M) {
//			for (int val : arr) {
//				System.out.print(val + " ");
//			}
//			System.out.println();
//			return;
//		}
// 
//		for (int i = 0; i < N; i++) {
//			if (!visit[i]) {
//				visit[i] = true;
//				arr[depth] = i + 1;
//				dfs(N, M, depth + 1);
//				visit[i] = false;
//			}
//		}
//	}
// 
//}
//
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
// 
//public class BOJ_15649_N��M_1 {
// 
//	public static int[] arr;
//	public static boolean[] visit;
//	public static StringBuilder sb = new StringBuilder();
// 
//	public static void main(String[] args) throws IOException {
// 
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 
//		StringTokenizer st = new StringTokenizer(br.readLine());
// 
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
// 
//		arr = new int[M];
//		visit = new boolean[N];
//		dfs(N, M, 0);
//		System.out.println(sb);
// 
//	}
// 
//	public static void dfs(int N, int M, int depth) {
//		if (depth == M) {
//			for (int val : arr) {
//				sb.append(val).append(' ');
//			}
//			sb.append('\n');
//			return;
//		}
// 
//		for (int i = 0; i < N; i++) {
//			if (!visit[i]) {
//				visit[i] = true;
//				arr[depth] = i + 1;
//				dfs(N, M, depth + 1);
//				visit[i] = false;
//			}
//		}
//	}
// 
//}