package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


//int�� ������ ������ �ȵȴ�. 1000! �̷��� ���ϸ� �ǰ� ���� �ɸ��� ��.
//27�� ���μ� ���� �ߴ��� �����ؾ�.
//10 �����ϸ� 1*2*3*4*5*6*7*8*9*10
				//�̰� 4= 2*2, 6=2*3 �̷��ŷ� �ٲ��.
//���μ� ���� �ϸ鼭 2��� �μ� ������ 5��� �μ� ���� ����.

public class _28_N�������丮���ǰ��� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc= new Scanner(System.in);
		int n, i, j, tmp, cnt1 = 0, cnt2 = 0;
//		scanf("%d", &n);
		n =Integer.parseInt(br.readLine());
		for (i = 2; i <= n; i++) {
			tmp = i;
			j = 2;
			while (true) {
				if (tmp % j == 0) {	//���� �������� 2��cnt1, 5�� cnt2�� ���� ����
					if (j == 2) cnt1++;
					else if (j == 5) cnt2++;
					tmp = tmp / j;
				}
				else j++;
				if (tmp == 1) break;
			}
		}
		if (cnt1 < cnt2) System.out.printf("%d\n", cnt1);
		else System.out.printf("%d\n", cnt2);
	}

}



