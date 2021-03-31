package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _35_Special_Sort {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc = new Scanner(System.in);
		
		int  n, tmp, min, i, j;
		int []a = new int[101];
//		scanf("%d", &n);
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for (i = 0; i < n; i++) {
//			scanf("%d", &a[i]);
			a[i] = Integer.parseInt(st.nextToken());
		}
		for (i = 0; i < n - 1; i++) {
			for (j = 0; j < n - i - 1; j++) {
				if (a[j] > 0 && a[j + 1] < 0) { //
					//j�� ����(j�� ���) �׸��� j+1�� ������ ���� �ڸ��ٲ� �ض�.
					//�׸��� a[j + 1] < 0 �� ������ ������ �ٲ��� ���� �Էµ� �״�θ� ����ؾ� �ϹǷ�
					//�׳� if (a[j] > 0 && a[j + 1] < 0) �κп� ������ ���� ���غ��鼭 �����غ���.

					//if (a[j] > a[j + 1]) �� ���� ������������ ���ĵǴ� ��������(�̷��� ���� ���̳ʽ� ���� �� ����)

					//���� �˰���(if()���� ������ ���� �߿�
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

	