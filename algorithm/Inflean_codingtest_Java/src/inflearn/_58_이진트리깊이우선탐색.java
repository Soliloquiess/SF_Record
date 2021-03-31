package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _58_이진트리깊이우선탐색 {
	public static void DFS(int x) {
		if (x > 7) return;
		else {
			
			System.out.printf("%d ", x);		//이 출력문에 따라 중위, 후위, 전위순회가 결정된다.
			DFS(x * 2);		//왼쪽 자식노드
			//System.out.printf("%d ", x); //중위 순회
			DFS(x * 2 + 1);		//오른쪽 자식노드
			//System.out.printf("%d ", x); //후위순회
			//병합정렬이 후위순회 사용
		}
	}
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st; 
			Scanner sc= new Scanner(System.in);
//			st = new StringTokenizer(br.readLine()," ");
//			
//			//freopen("input.txt", "rt", stdin);
//			int n;
//			n= Integer.parseInt(st.nextToken());
			DFS(1);
		}
	}
