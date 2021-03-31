package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _34_�������� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc = new Scanner(System.in);
		
		int n, i, j, tmp;
		int []a = new int [101];
//		scanf("%d", &n);
		n = Integer.parseInt(br.readLine());
		
		
		st = new StringTokenizer(br.readLine(), " ");
		for (i = 0; i < n; i++) {
//			scanf("%d", &a[i]);
			a[i] = Integer.parseInt(st.nextToken());
		}

		//j���� ���鼭 ��� ����.
		//���� ū ���� �� �ڷ� ��(���� �� �ʿ� ������. �׷��� �� �ձ��� ���� �ٽ� ����(����)��)
		for (i = 0; i < n - 1; i++) {
			for (j = 0; j < n - i - 1; j++) {			//i�� �� ó���� 0 �׸��� �� ���ڸ��� ���� �ɼ� �� �� �ձ����� ����.
				if (a[j] > a[j + 1]) {		//���� ũ�� �ڿ��� ������ ����.
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
		
		for (i = 0; i < n; i++) {
			System.out.printf("%d ", a[i]);
		}
	}
}