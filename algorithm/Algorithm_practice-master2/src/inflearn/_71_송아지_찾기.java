package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _71_�۾���_ã�� {

	public static void main(String[] args) throws IOException {

		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		

		int []ch= new int[10001];
		int []d = { 1, -1, 5 };
//		queue<int> Q;
		//freopen("input.txt", "rt", stdin);
		int s, e, x, pos, i;
		Queue<Integer> Q = new LinkedList<>(); //int�� queue ����, linkedlist �̿�

		
//		scanf("%d %d", &s, &e);
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		ch[s] = 1;		//s��� ������ �ٽô� ť�� ���� ���ƶ�. ��������� 0�̾ƴ� 1�̶� ���� �� ������ ������ ����Ѵ�.
		
		Q.add(s);		//������� ����
		while (!Q.isEmpty()) {		//BFSŽ�� �Ͼ. ����ֱ� �������� ��� ��
			x = Q.peek();
			Q.poll();			//ù��° �ڷ� ����.
			for (i = 0; i < 3; i++) {		//���⼭ ���.
				pos = x + d[i];				// ���������� x ���⿡ ���ϱ⸦ �ϰų� ���⸦ �ϰų� �ϸ� ������ ����.	��� ���µ� �� ������ ���ϴ� �������� Ȯ��
				//�� �۾����� �ִ� pos�� �ƴ� �ٷ� �������� ����ϳ�? ��������� 1�� üũ�ؼ�. ��������� ���� 0�̿���. ������������ 1�� ũ�� �Ǿ�����.
				
				if (pos <= 0 || pos > 10000) continue;		//pos�� ����.
				if (pos == e) {		//pos=e�� �츮�� ���ϴ� ���� ����.
					System.out.printf("%d\n", ch[x]);
					System.exit(0);		//�̷��� ���α׷� ��ü�� �����.
				}
				if (ch[pos] == 0) {		// ch��� �迭�� �湮 �ߴ��� üũ�迭�� ������ �Ÿ��迭�� �� 
					ch[pos] = ch[x] + 1;		// x�������� ���µ� �ּ�Ƚ���� �������. �ű⿡ pos���� ���ϱ� +1�� ����.
					//ch��� �迭�� �ּ�Ƚ���� �Ÿ����� �� ������.
					Q.add(pos);	//Q.push(pos)
				}
			}
		}
	}
}