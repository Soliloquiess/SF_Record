package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _72_���ֱ��ϱ� {

	public static void main(String[] args) throws IOException {

		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
//		queue<int> Q;
		Queue<Integer> Q = new LinkedList<>(); //int�� queue ����, linkedlist �̿�

		int i,n,k;
//		scanf("%d %d", &n, &k);
		n= Integer.parseInt(st.nextToken());
		k= Integer.parseInt(st.nextToken());
		for (i = 1; i <= n; i++) {		//���� Ǫ��
			Q.add(i);	//Q.push(i);
		}
		while (!Q.isEmpty()) {
			for (i = 1; i < k; i++) {		//�� ������� �ڷ� Ǫ�õ�(������ �������� �� �ƴ�) k��� ��ģ �������.
				Q.add(Q.peek());		//�� �տ� �ִ� ���� �ڷ� Ǫ��
				Q.poll();				//�׸��� �� ���� ���� �� ��Ŵ
//				Q.push(Q.front());		//�� �տ� �ִ� ���� �ڷ� Ǫ��
//				Q.pop();				//�׸��� �� ���� ���� �� ��Ŵ
			}
			Q.poll();	//Q.pop();
			if (Q.size() == 1) {		//ť�� �ڷ� � �ֳ�. 
				//�ڷᰡ 1�϶� ������ 1�� ����. �� �� ���
				System.out.printf("%d\n", Q.peek());
				Q.poll();
//				printf("%d\n", Q.front());
//				Q.pop();
			}
		}
	}
}