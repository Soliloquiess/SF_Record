package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//��ʹ� ���� ���



public class _56_����Լ�_�м� {
	
	
public static void DFS(int x) {
		if (x == 0) return;		//��� �������� ���� ���ϸ� ���ѷ����� ����.
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
