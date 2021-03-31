package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


//C++���� �ִ����� ���� �����ϱ� �ڹٿ��� �ִ����� �ȴ�. �Ʒ��� 73������ �ڹٿ��� �ּ���
public class _74_�ּ��� {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		st = new StringTokenizer(br.readLine(), " ");
		

		int a;
//		priority_queue<int> pQ;	//�켱���� ť �ڷ����� int ����
		PriorityQueue<Integer> pQ = new PriorityQueue<>();

		
		while (true) {
			a = Integer.parseInt(br.readLine());
			if (a == -1) break;		//a�� -1�̸� ����
			if (a == 0) {			//a�� 0�̸� ť�� ��������� -1 ���
				if (pQ.isEmpty()) {
					System.out.printf("-1\n");//�̰� ���̸� -1 ���(������� ������)
				}
				else {				//a�� 0�ε� ť�� ������� ������ max�� ���.
					System.out.printf("%d\n", pQ.peek());	//pQ.top�갡 ��Ʈ��. �׸��� �� ��Ŵ.
					pQ.poll();		//�� ��Ű�� ��Ʈ���� ���ŵ�.
				}
			}
			else pQ.add(a);
		}
	}
}

