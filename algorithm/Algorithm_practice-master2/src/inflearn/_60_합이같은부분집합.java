package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _60_���̰����κ����� {

static int n,  total = 0;
static int[]a =new int[11];
static Boolean flag = false;
	public static void DFS(int L, int sum) {		//�κ������� ��
		if (sum > (total / 2)) return;		//sum �� ������ �Ѿ�� �� �� �ʿ䰡 ������.
		if (flag == true) return;
		if (L == n + 1) {
			if (sum == (total - sum)) {		//��Ż�� �����ִ� ���Ҹ� ���� ������ ���Ѱ��� ������ 
				
				flag = true; //�÷��װ� ���̸� yes��� ��
			}
		}
		else {
			DFS(L + 1, sum + a[L]);
			//sum�� 0�̿��ٰ� ù���� ���ҿ� �ִ��� ���ϴ� ��
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
			DFS(1, 0);		//1�� ���� �Ѿ�� 0�� ���� �Ѿ ��.
			if (flag) System.out.printf("YES\n");
			else System.out.printf("NO\n");
		}
}

