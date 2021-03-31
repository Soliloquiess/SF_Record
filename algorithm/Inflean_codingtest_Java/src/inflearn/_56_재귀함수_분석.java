package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//재귀는 스택 사용



public class _56_재귀함수_분석 {
	
	
public static void DFS(int x) {
		if (x == 0) return;		//재귀 종료지점 설정 안하면 무한루프에 빠짐.
		else {
			DFS(x - 1);
			System.out.printf("%d ", x);
	}
}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc= new Scanner(System.in);
		st = new StringTokenizer(br.readLine()," ");
		

		
			//freopen("input.txt", "rt", stdin);
			int n;
//			scanf("%d", &n);
		
			n= Integer.parseInt(st.nextToken());
			DFS(n);
			
			
	}
	
	
}
