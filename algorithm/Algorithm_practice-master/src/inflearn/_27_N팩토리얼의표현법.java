package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _27_N���丮����ǥ���� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc= new Scanner(System.in);
		int n, i, j, tmp;
//		scanf("%d", &n);
		n = Integer.parseInt(br.readLine());
//		vector<int> ch(n + 1);	//�� ��Ұ� 0�� �迭�� n������ �ִ� �迭�� ����.
		int []ch = new int[n+1];
		//1�� �Ҽ� �ƴϹǷ� ���μ����� �ϸ� �ȵ�(�迭 ä��� �ȵ�)

		for (i = 2; i <= n; i++) {		//2���� ���μ� ���� �ؼ�  �迭 ä��.
			tmp = i;
			j = 2;
			while (true) {
				if (tmp % j == 0) {		//tmp�� j�� ���� �������� �ϴ� �� ����.		�Ҽ��鸸 ���⼭ �߰� ��.
					
					tmp = tmp / j;		//���� �������� ������ �ٲ��
					ch[j]++;			//�׸��� �μ��� �߰� �Ǿ���. �׸��� ���ؾ� ��.
				}
				else j++;				//���� �������� ������ j����
				if (tmp == 1) break;
			}
		}
//		printf("%d! = ", n);
		System.out.printf("%d! = ", n);;
		for (j = 2; j <= n; j++) {
			if (ch[j] != 0) System.out.printf("%d ", ch[j]);
			//üũ�� �Ȱ͸� ���� ����ϸ� ��.
		}

	}
}

