package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _61_Ư����_����� {

static int []a = new int[11];
static int n, m, cnt = 0;
static Boolean flag = false;
	public static void DFS(int L, int sum) {
		if (L == n + 1) {		//������ N+1 �̸� ���������� �°���.
			if (sum == m) {
				cnt++;
			}
		}
		else {
			DFS(L + 1, sum + a[L]);		//���� ���� �� ���Ҵ� ���ϱ�� �����Ѵ�.
			DFS(L + 1, sum);			//���� �� ���� (�� ���� ���� �� �ϰ� ���� ������ ���ڴ�.)
			DFS(L + 1, sum - a[L]);		//������ �����ϰڴ�.
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
			DFS(1, 0);		//1�� ���� �Ѿ�� 0�� ���� �Ѿ ��.
			if (cnt == 0)System.out.printf("-1\n");
			else System.out.println(cnt);
		}
}


