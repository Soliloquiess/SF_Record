


package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//C++���� �ּ����� ���� �����ϱ� �ڹٿ��� �ִ����� �ȴ�. �Ʒ��� 74������ �ڹٿ��� �ִ���
public class _73_�ִ��� {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		st = new StringTokenizer(br.readLine(), " ");
		

//		priority_queue<int> pQ;

		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		
		while (true) {
//			scanf("%d", &a);
			int a = Integer.parseInt(br.readLine());
			if (a == -1) break;
			if (a == 0) {
				if (pQ.isEmpty()) System.out.printf("-1\n");
				else {
					System.out.printf("%d\n", -pQ.peek());		//���⵵ ����� �� - �ٿ��ָ� ��. ������ ����.
					pQ.poll();
				}
			}
			else pQ.add(-a);		//-a�� �ٲ��ָ� �� ���� ���� ��Ʈ�� ���� ȿ��. �������� ���밪���� �ϸ� ������
		}
	}
}