package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _26_������ {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc = new Scanner(System.in);
		int i, j, n, cnt = 0;
//		scanf("%d ", &n);
		
		n = Integer.parseInt(br.readLine());
//		vector<int> a(n + 1);			//	N+1�ؾ� 0~N���� �� �迭�� ����Ƿ�
		int [] a = new int [n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (i = 1; i <= n; i++) {
//			scanf("%d", &a[i]);
			a[i] = Integer.parseInt(st.nextToken());
		}
//		printf("1 ");	//ù��° ����� �׳� 1��
		System.out.print("1 ");
		for (i = 2; i <= n; i++) {		//ù��°�� 1���� �����ϹǷ� 2���� ����.
			cnt = 0;		//�� ������� �ʱ�ȭ(j ���� ���� ���� �ʱ�ȭ �����. j�� i��� ����̹Ƿ�)
			for (j = i - 1; j >= 1; j--) {
				if (a[j] >= a[i]) cnt++;			//�տ� �޸��� �ִ� ����� + ���ִ°���.
				//a[j]�� �� �տ� �޸��� �ִ� ���. �� �տ� �ִ� ����� ���� ũ�ų� ������ ��ĥ �� �����Ƿ� ����� �з���.
				// �׸��� ī���� ������. i��� ����� ��� ���.
			
			}
//			printf("%d ", cnt + 1);			//cnt�� 0�̿����Ƿ� +1
			System.out.printf("%d ", cnt + 1);	
		}

	}	
}
	
