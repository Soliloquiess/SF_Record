package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17_������_���� {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine()," ");		int n, sum = 0, i, j, m, ans;
//		scanf("%d", &n);
		n= Integer.parseInt(st.nextToken());
		for (i = 1; i <= n; i++) {
			
		st = new StringTokenizer(br.readLine()," ");


//			scanf("%d %d", &m, &ans);
			sum = 0;		//sum �� 0�Ǽ� ���ؾ�  �߿��� �� �ι��� �л� ���Ҷ� sum=0���� �ʱ�ȭ �ؾ��Ѵ�. 
			m=Integer.parseInt(st.nextToken());
			ans = Integer.parseInt(st.nextToken());
			//sum =0 �ʱ�ȭ ���ؼ� Ʋ���� ��찡 ����.
			for (j = 1; j <= m; j++) {			//ù��° �л� ���� ���ϰ� 
				sum += j;
			}
			if (ans == sum) 
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}
}