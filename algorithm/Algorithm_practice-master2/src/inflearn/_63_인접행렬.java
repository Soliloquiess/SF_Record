package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _63_인접행렬 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc= new Scanner(System.in);
//		st = new StringTokenizer(br.readLine()," ");
		
		
		int map[][] = new int[21][21];
		int n, m, a, b, c, i, j;
//		scanf("%d %d", &n, &m);
		n= sc.nextInt();
		m= sc.nextInt();

//		st = new StringTokenizer(br.readLine()," ");
		for (i = 1; i <= m; i++) {
//			scanf("%d %d %d", &a, &b, &c);
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			map[a][b] = c;		//a정점에서 b정점으로 간다. 가중치 값은 c다.
			//방향그래프일떄는
			//map[a][b] = 1;	//이렇게 넣으면 된다/
			//무방향이면
			//map [a][b]=1; 
			//map[b][a]=1;
			//이렇게 두개에 1을 넣어야 a에서 b가는거 b에서 a가는거 
			//이 문제는 가중치이므로 가중치 값 c를 넣어준 거.
		}
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.printf("\n");
		}
	}
}