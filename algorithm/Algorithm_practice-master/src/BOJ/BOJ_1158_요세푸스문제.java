package BOJ;

//public class BOJ_1158_�似Ǫ������ {
//
//}

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
 
public class BOJ_1158_�似Ǫ������ {
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		/*
		 *  ������ �κ��� ����� > ��ȣ ���� ������ ���� ������
		 *  �ϰ������� ����ϱ� ���� ������ ���Ҹ� ������ ��������
		 *  �ݺ��ϰ� ������ ���Ҵ� �״�� ����Ѵ�.
		 */
		while(q.size() > 1) {
			
			for(int i = 0; i < K - 1; i++) {
				int val = q.poll();	//ť �� �տ��� ����
				q.offer(val);	//ť �ǵڷ� �־��ش�/
			}
			
			sb.append(q.poll()).append(", ");	//i�� 2�� �Ǹ� sb�� �־���.
		}
 
		// ������ ���� ����� �� > �� �ٿ��ش�.
		sb.append(q.poll()).append('>');
		System.out.println(sb);
	}
 
}