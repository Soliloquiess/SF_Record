package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _06_���ڸ�_���� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
				
		int res = 0, cnt = 0, i;
//		scanf("%s", &a);
		String str = br.readLine();
		char [] a = str.toCharArray();
		for (i = 0; i<str.length(); i++) {
			if (a[i] >= 48 && a[i] <= 57) {			
				//0~9 ('0'=48 ~'9'=57)
				res = res * 10 + (a[i] - 48);
				//���� ������ �ڸ��� ����.
			}
		}
		System.out.printf("%d\n", res);
		for (i = 1; i <= res; i++) {
			if (res % i == 0) cnt++;
			//��� ���.
		}
		System.out.printf("%d\n", cnt);
	}
}