package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _60_합이같은부분집합 {

static int n,  total = 0;
static int[]a =new int[11];
static Boolean flag = false;
	public static void DFS(int L, int sum) {		//부분집합의 합
		if (sum > (total / 2)) return;		//sum 이 절반을 넘어가면 더 볼 필요가 없어짐.
		if (flag == true) return;
		if (L == n + 1) {
			if (sum == (total - sum)) {		//토탈과 남아있는 원소를 더한 집합을 더한것이 같으면 
				
				flag = true; //플래그가 참이면 yes라는 뜻
			}
		}
		else {
			DFS(L + 1, sum + a[L]);
			//sum은 0이였다가 첫번쨰 원소에 있던거 더하는 거
			DFS(L + 1, sum);
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
			st = new StringTokenizer(br.readLine()," ");
			
			for (i = 1; i <= n; i++) {
//				scanf("%d", &a[i]);
				a[i] = Integer.parseInt(st.nextToken());
				total += a[i];
			}
			DFS(1, 0);		//1은 레벨 넘어가고 0은 합이 넘어간 거.
			if (flag) System.out.printf("YES\n");
			else System.out.printf("NO\n");
		}
}

