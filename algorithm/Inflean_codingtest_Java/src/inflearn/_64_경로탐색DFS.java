package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _64_���Ž��DFS {
	

static int [][]map= new int[30][30];
static int []ch= new int[30];
static int cnt = 0, n;
static int []path = new int[30];

static int m, i, j, a, b, c;

static void DFS(int v, int L) {
	int i, j;
	if (v == n) {
		cnt++;
		for (j = 0; j < L; j++) {
			System.out.printf("%d ", path[j]);
		}
		System.out.println("");
	}
	else {
		for (i = 1; i <= n; i++) {
			if (map[v][i] == 1 && ch[i] == 0) {		//[v]�� ���� ���� [i]�� �Ѿ ���� �Ѿ �� ������ 1�� ��.map[v][i]==1��
				ch[i] = 1;		//�̰� ���� �Ǵ���.
				path[L] = i;
				DFS(i, L + 1);
				ch[i] = 0;	//�ѱ�� üũ Ǯ����ߵ�.
			}
		}
	}
}


public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc= new Scanner(System.in);
		st = new StringTokenizer(br.readLine()," ");
		
		

			//freopen("input.txt", "rt", stdin);
//			scanf("%d %d", &n, &m);
			n= Integer.parseInt(st.nextToken());
			m= Integer.parseInt(st.nextToken());
			
			
			for (i = 1; i <= m; i++) {
//				scanf("%d %d", &a, &b);

				st = new StringTokenizer(br.readLine()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}
			ch[1] = 1;
			path[0] = 1;
			DFS(1, 1);
			System.out.printf("%d\n", cnt);
		}

}