package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19_�г������� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine()," ");		

		int n, i, cnt = 0,  max;
		int []h = new int[101];
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");	
		for (i = 1; i <= n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		max = h[n];	//�� �ڸ� �ƽ��� ��
		for (i = n - 1; i >= 1; i--) {		//�� �ڿ��� ���� ������ ���鼭 ���Ѵ�.(for���� �Ųٷ� ���� �Ѵ�.)
			if (h[i] > max) {
				max = h[i];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}