package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _24_jollyjumpers {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc = new Scanner(System.in);
		int n, i, now, pre, pos;
//		scanf("%d", &n);
		n = sc.nextInt();
//		vector<int> ch(n);
		int [] ch = new int [n];
		//�̷��� ���� n-1������ �迭�� �����ǰ� �� ���� ������� 0���� �ʱ�ȭ�ȴ�.

//		scanf("%d", &pre); //�굵 ù��° ���� �д°�
		pre = sc.nextInt();
		for (i = 1; i < n; i++) {
//			scanf("%d", &now);
			now = sc.nextInt();
			pos = Math.abs(pre - now);		//���밪 �Լ� ȣ��.
			if (pos > 0 && pos < n && ch[pos] == 0) ch[pos] = 1;	

			//0 ~n�� ���� �ȿ� �ִ��� �׸��� 5�� �־��ٰ� ������ �迭 0~4 ������ �迭 ������ 0���� ������ 1 ����.(�ߺ�üũ �ǹ̵� ����)
			//�׸��� (pos > 0 && pos < n) �긦 ���� �ִµ� ���� ��� n = 5, 1 4 2 3 9 �� �Է��ϸ� ���� 3 2 1 6 �ε�  �׷� ch[6]=0�� �ǰ� �ȴ�.
			//�ٵ� �迭�� ch[0]~ch[4]�����̹Ƿ� ch[6]�� ���´�. �׷��� �� �κ��� �������� ����� ���� (pos > 0 && pos < n)
			//�� �κ��� ���� �����ϰ� ���� ����� �ٷ� ����� �Ѵ�.


			else {		//if�� ���� ���ҽ� (�ߺ��ϰų� �ҽ�) �ٷ� no����ϰ� ����.
				System.out.println("NO");
				
			}
			pre = now; //pre�� ������ now�� �ǰ� �� ���� ,	�� now�� ���� ������ ��ȯ�ǰ� �о���̴°� now ��
		}
		System.out.println("YES");
		
	}
}