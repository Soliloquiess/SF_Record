package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _61_특정수_만들기 {

static int []a = new int[11];
static int n, m, cnt = 0;
static Boolean flag = false;
	public static void DFS(int L, int sum) {
		if (L == n + 1) {		//레벨이 N+1 이면 종료지점에 온거임.
			if (sum == m) {
				cnt++;
			}
		}
		else {
			DFS(L + 1, sum + a[L]);		//레벨 증가 이 원소는 더하기로 지정한다.
			DFS(L + 1, sum);			//레벨 또 증가 (이 원소 적용 안 하고 다음 레벨로 가겠다.)
			DFS(L + 1, sum - a[L]);		//음수로 적용하겠다.
		}
	}
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st; 
			Scanner sc= new Scanner(System.in);
			st = new StringTokenizer(br.readLine()," ");
			
			int i;
//			scanf("%d", &n);
			n= Integer.parseInt(st.nextToken());

			m= Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			
			for (i = 1; i <= n; i++) {
//				scanf("%d", &a[i]);
				a[i] = Integer.parseInt(st.nextToken());


			}
			DFS(1, 0);		//1은 레벨 넘어가고 0은 합이 넘어간 거.
			if (cnt == 0)System.out.printf("-1\n");
			else System.out.println(cnt);
		}
}


