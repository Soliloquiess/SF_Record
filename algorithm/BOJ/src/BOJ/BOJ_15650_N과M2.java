package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15650_N��M2 {
	static int N, M;
	static boolean[] visited;
	static int[] a; // ���� ��°��� ���� �迭

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");// temp�� " "�� �������� String�� ���� ����.
		N = Integer.parseInt(temp[0]); // String�� int�� ��ȯ �� ����.
		M = Integer.parseInt(temp[1]);

		visited = new boolean[N + 1];
		a = new int[N + 1];
		dfs(1, 1);
	}

	static void dfs(int depth, int com) {
		if (depth == M + 1) {// ���� ����
			for (int i = 1; i <= M; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && com <= i) {
				visited[i] = true;
				a[depth] = i;
				dfs(depth + 1, i);
				visited[i] = false;
			}
		}
	}
}

/*
import java.util.*;

public class BOJ_15650_N��M2 {
	static int m,n; // M�� N����

	static int list[],check[]; // ����� ���� �� list�迭�� �湮 ���θ� üũ �� �湮 �迭
	
	static void dfs(int idx,int cnt) { // DFS�޼ҵ�, �ݺ����� ���ۺκ��� ��������� �ϹǷ� ���ڸ� �ϳ� �� �߰��Ѵ�.
  	
		if(cnt == m) { // ������ �������� �̾��� ������ ���� �����ϸ� �����ϴ� �κ��� �����ϴ�.
			for(int i=0;i<m;i++) {
				System.out.print(list[i]+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i =idx+1;i<=n;i++) { // �ݺ����� ���� �κ��� ��������� �Ѵ�.
        							 // �ʱ⿡ ������ ���� �ι� ° �ڸ��� 1���� N���� Ž�� 
                                     // 2�� ������ ���� �ι� ° �ڸ��� 3���� N���� Ž��
                                     // 3���� ������ ���� �ι� ° �ڸ��� 4���� N���� Ž��.. �ݺ��̴�.
			if(check[i]==1) continue; // �����ϴ�. �̹� �湮�� ���� �ѱ��.
			check[i]=1; // �湮���� ���� ���� �湮 ó�� ��
			list[cnt]=i; // cnt���� �ڸ��� i�� ��, �ʱ⿡�� 0���ε���(ù ��° �ڸ�)�� 1�̴�.
			dfs(i,cnt+1); // ������ i������ ū ��츦 Ž���ؾ� �ϹǷ� i�� ���� �� �ݺ��� ���ۺκп��� +1 ���ִ� ��
			check[i]=0; // ��� ã�� �Ŀ��� �ٽ� �湮 ���θ� �ʱ�ȭ
	
		}

	}
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		n = sc.nextInt(); 
		m = sc.nextInt(); 
		
		check = new int[9];
		list = new int [9];
		dfs(0,0); // �ʱ��� ������ 1���� N���� Ž���ؾ� �ϹǷ� 0�� ����
	}
	
}

*/


//import java.util.*;
//public class BOJ_15650_N��M2 {
//    static boolean[] c = new boolean[10];
//    static int[] a = new int[10];
//    static void go(int index, int start, int n, int m) {
//        if (index == m) {
//            for (int i=0; i<m; i++) {
//                System.out.print(a[i]);
//                if (i != m-1) System.out.print(' ');
//            }
//            System.out.println();
//            return;
//        }
//        for (int i=start; i<=n; i++) {
//        	//N�� M1���� �ٸ��� i�� start���� �����ϰ� start�Ű������� �ϳ� �߰��ؼ� �޾ƿԴ�.
//        	
//            if (c[i]) continue;
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


/*

import java.util.Scanner;

public class Main {
 
	public static int[] arr;
	public static int N, M;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		M = in.nextInt();
 
		arr = new int[M];
        
		dfs(1, 0);
 
	}
 
	public static void dfs(int at, int depth) {
 
		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
        
		for (int i = at; i <= N; i++) {
 
			arr[depth] = i;
			dfs(i + 1, depth + 1);
 
		}
	}
}





import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
 
	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
 
		arr = new int[M];
        
		dfs(1, 0);
		System.out.println(sb);
 
	}
 
	public static void dfs(int at, int depth) {
 
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
        
		for (int i = at; i <= N; i++) {
 
			arr[depth] = i;
			dfs(i + 1, depth + 1);
 
		}
	}
}
*/






/*
import java.util.Scanner;

class Main {
	static int n,m;	
	static void dfs(int[] a,boolean[] check,int v,int cnt) {
		if(cnt == m) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		
		for(int i=v;i<check.length;i++) {
			if(!check[i]) {
				check[i] = true;
				a[cnt] = i;
                // ���� Ž�� �� �ڽ��� ������ �ڽ�+1 ���� �ݺ��ϸ� �ڽź��� ū �������� ������ ����ϰ� �ȴ�.
                // ���޾� �ڱ� �ڽ��� ������� �ʱ� ������ �� �� ������.
				dfs(a,check,i+1,cnt+1); 
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		
		int a[] = new int[m];
		boolean check[] = new boolean[n+1];
		
		dfs(a,check,1,0);
		
	}
}

*/

