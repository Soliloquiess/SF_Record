package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _09_����Ǿ�� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int []cnt =new int[50001];
		int n, i, j;
		n = Integer.parseInt(br.readLine());
		for (i = 1; i <= n; i++) {
			for (j = i; j <= n; j = j + i) {	//j�� j+i(i�� ����� ���ƾ�)
				//�迭�� �ְ� �迭 �� ���� 1�� �� ����. �ش� ���� �迭 ������ �� ���� ������Ű�� ��.
				cnt[j]++;
			}
		}
		for (i = 1; i <= n; i++) {
			System.out.print(cnt[i]+" ");
		}
	}
}
