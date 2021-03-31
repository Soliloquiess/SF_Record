package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _65_�̷�Ž��DFS {

	static int map[][] = new int [10][10];
	static int[][]ch= new int [10][10];
	static int dx[] = { 1, 0, -1, 0 };	//dx=1,dy=0 �� 6�� ���� -1,0�̸� 12�� 0,1�� 3�ù��� 0 -1�� 9�� ����
	static int dy[] = { 0, 1, 0, -1 };	//���� ������ ���� x�� �� y�� ��
	static int cnt = 0;	
	
	static  void DFS(int x, int y) {
		int xx, yy, i;
		if (x == 7 && y == 7) {	//��������.
			cnt++;		//�������� �����ϱ� cnt++
		}

		else {		//���⼭ �����
			for (i = 0; i < 4; i++) {
				xx = x + dx[i];			//������������ dx�����ָ� ������ ����ǥ
				yy = y + dy[i];			//��������.
				if (xx < 1 || xx>7 || yy < 1 || yy>7)		//������ ������ ���.
					continue;		//��Ƽ���� �ؿ��κ� �����ʰ� ����������.
				if (map[xx][yy] == 0 && ch[xx][yy] == 0) {		//���� Ž��.
					//�Ѿ���� ������ ������� Ȯ��.
					//�� ���ڿ� �湮���� �ʾҴ���.
					ch[xx][yy] = 1;
					DFS(xx, yy);
					ch[xx][yy] = 0;	//üũ �ߴ��� �� Ǯ����� �Ѵ�.
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st; 
			Scanner sc= new Scanner(System.in);
			

				//freopen("input.txt", "rt", stdin);
//				scanf("%d %d", &n, &m);
			int i, j;
			for (i = 1; i <= 7; i++) {
				

				st = new StringTokenizer(br.readLine()," ");
				
				for (j = 1; j <= 7; j++) {
//					scanf("%d", &map[i][j]);
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ch[1][1] = 1;		//1�� 1�� ���� ���
			DFS(1, 1);			//1�� 1���� �Ѿ.
			System.out.printf("%d\n", cnt);		//cnt ������ ��.

	}
}
