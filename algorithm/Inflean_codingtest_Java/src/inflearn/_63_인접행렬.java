package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _63_������� {
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
			map[a][b] = c;		//a�������� b�������� ����. ����ġ ���� c��.
			//����׷����ϋ���
			//map[a][b] = 1;	//�̷��� ������ �ȴ�/
			//�������̸�
			//map [a][b]=1; 
			//map[b][a]=1;
			//�̷��� �ΰ��� 1�� �־�� a���� b���°� b���� a���°� 
			//�� ������ ����ġ�̹Ƿ� ����ġ �� c�� �־��� ��.
		}
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.printf("\n");
		}
	}
}