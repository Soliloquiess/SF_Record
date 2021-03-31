package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _76_���װ�� {
	
	static int[][] dy= new int[21][21];

	//5C3 �� ���� ����ϳ�. 4C2+ 4C3	�ڱⰡ ������ �κ����� �ڱⰡ �������� ���� �κ����� 2���� �и� ����.
	//���� ���������� �ƴҼ� �ִ°�� 2������ ���� ����.
	//4C2�� �ϴ� 5�� ������ ���� ������ 4���� �ƹ��� �Ͷ� . 4C3�� 4���� 3�� �̾ƶ� 5�� ���� ���� �ʰڴٶ�� �ǹ�.
	//5���� �л��� �ִ� ġ�� 
	static int C(int n, int r) {
		if (dy[n][r] > 0) return dy[n][r];	//�� ���� �ִٸ� ������.(���������� 0�ε� 0���� ũ�� ���� ��Ͱ� ���鼭 �������� �����)
		//�̰� �޸������̼�. �迭�� �����ߴٰ� ���� �ִ� ���� ������ ���� ���� ���� �ٷ� ����. (���� 13:10 ����)
		//���� 0���� ũ�� ���� �������� ������ �Ȱ�. �׷� ��ķ� ���� ���� ������ �迭�� �ִ� �� ���� �����ع����� ��.

		if (n == r || r == 0) return 1;		//n�� r�� �������ų� r�� 0�Ǿ��� �� �����ϰ� 
		else return dy[n][r] = C(n - 1, r) + C(n - 1, r - 1);		//�� �ܿ��� DFS�� (���⼱ DFS�� C�� �̸� �ٲ�,) �� ���� n-1 �ϰ� r-1�� ���� ����
		//�׳� r�� ���� �������� �ʴ°� (5��)	r-1�� ���� �ڽĳ�� r�� ������ �ڽĳ��
		//dy[n][r]�� �ְ� C(n - 1, r) + C(n - 1, r - 1); �� ���� ���� ������ ���� 3,2 ���� ������ 3�� 2�� ���� �޴µ� �� ����
		//nr�� 3�� 2���� �����ϰ� �� ���� ���� �޴°�.
		//�̷��� �ϸ� ������ ��Ͱ� ������ ������ ������.

	}

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		

		int n, r;
//		scanf("%d %d", &n, &r);
		n= Integer.parseInt(st.nextToken());

		r= Integer.parseInt(st.nextToken());
		System.out.printf("%d\n", C(n, r));
	}
}

