package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18_�������� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine()," ");		

		int n, val, i, num, cnt = 0, max = -2147000000;
		
		n= Integer.parseInt(st.nextToken());
		val = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");	
//		
		for (i = 1; i <= n; i++) {
			num = Integer.parseInt(st.nextToken());
			if (num > val) cnt++;
			else cnt = 0;
			if (cnt > max) max = cnt;
		}
		if (max == 0) System.out.println("-1");		//�溸���� ������ -1�� ����ؾ� �Ѵ�.(���� �ѹ��� �ȵǸ� ��� 0 �׸��� n��ŭ �� ���� max�� 0�̿����Ƿ� -1 ���)

		else System.out.println(max);
	}
}