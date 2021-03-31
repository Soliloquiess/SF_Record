package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _59_부분집합DFS {
	static int n;
	static int []ch = new int[100];
	public static void DFS(int L) {
		int i;
		if (L == n + 1) {
			for (i = 1; i <= n; i++) {
				if (ch[i] == 1) System.out.printf("%d ", i);	//체크된 놈의 인덱스를 출력.
			}
			System.out.println("");
		}
		//이진트리로 계속 호출
		else {
			ch[L] = 1;
			DFS(L + 1);
			ch[L] = 0;
			DFS(L + 1);
		}
	}
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st; 
			Scanner sc= new Scanner(System.in);
			st = new StringTokenizer(br.readLine()," ");
			
			//freopen("input.txt", "rt", stdin);
			
			n= Integer.parseInt(st.nextToken());
			DFS(1);
		}
}

