package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _23_���Ӻκ��������� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc= new Scanner(System.in);
		int n, i, pre, now, cnt, max;
		
		n = Integer.parseInt(br.readLine());
		pre = sc.nextInt();
		cnt = 1;
		max = 1;

		for (i = 2; i <= n; i++) {
//			scanf("%d", &now);	//pre ���� ����.
			now = sc.nextInt();
			if (now >= pre) {
				cnt++;
				if (cnt > max) max = cnt;
			}
			else cnt = 1;	//���� ���� ���ڰ�  �տ� ���ں��� ������ cnt�� 1�� �����
			pre = now;		//���� ���ڸ� pre��  ���� �ٽ� ����.
		}
		System.out.println(max);
	}
}