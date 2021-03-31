package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _57_재귀함수_이진수_출력 {
	
public static void DFS(int x) {
	if (x == 0) return;
	else {
		DFS(x / 2);
		System.out.printf("%d", x % 2);
	}
}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc= new Scanner(System.in);
		st = new StringTokenizer(br.readLine()," ");
		
		//freopen("input.txt", "rt", stdin);
		int n;
		n= Integer.parseInt(st.nextToken());
		DFS(n);
	}
}
