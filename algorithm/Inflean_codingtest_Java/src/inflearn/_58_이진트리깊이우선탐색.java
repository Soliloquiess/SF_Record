package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _58_����Ʈ�����̿켱Ž�� {
	public static void DFS(int x) {
		if (x > 7) return;
		else {
			
			System.out.printf("%d ", x);		//�� ��¹��� ���� ����, ����, ������ȸ�� �����ȴ�.
			DFS(x * 2);		//���� �ڽĳ��
			//System.out.printf("%d ", x); //���� ��ȸ
			DFS(x * 2 + 1);		//������ �ڽĳ��
			//System.out.printf("%d ", x); //������ȸ
			//���������� ������ȸ ���
		}
	}
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st; 
			Scanner sc= new Scanner(System.in);
//			st = new StringTokenizer(br.readLine()," ");
//			
//			//freopen("input.txt", "rt", stdin);
//			int n;
//			n= Integer.parseInt(st.nextToken());
			DFS(1);
		}
	}
