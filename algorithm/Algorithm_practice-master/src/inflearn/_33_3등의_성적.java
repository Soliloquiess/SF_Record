package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _33_3����_���� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc = new Scanner(System.in);
		
		int  n, tmp, idx, i, j, cnt = 0;
		int [] a = new int[101];
//		scanf("%d", &n);
		
		n= Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		for (i = 0; i < n; i++) {
//			scanf("%d", &a[i]);
			a[i] = Integer.parseInt(st.nextToken());
		}
		for (i = 0; i < n - 1; i++) {
			idx = i;
			for (j = i + 1; j < n; j++) {
				if (a[j] > a[idx]) idx = j;
			}
			tmp = a[i];
			a[i] = a[idx];
			a[idx] = tmp;
		}
		//�� �κб����� �� ������ �������� �״�� ���.

		//�� ���� �������� ���� �ǰ� ����.
		for (i = 1; i < n; i++) {	//0�� ���� �ڷ� ������ 1������ ���ƾ� �ȴ�.
			if (a[i - 1] != a[i]) cnt++;		//a�� i-1�� ����.  ���ʰ� ���� ������ ++���ִ� ��.
			if (cnt == 2) {		//3�� ����ϴ°�.
				System.out.printf("%d\n", a[i]);
				break;
			}
		}
	}
}