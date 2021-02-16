package com.algo05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*1. 1~N -> Q
 *2. K-1��° ������� -> ������ Q�� �ǵڷ� ������ 
 *3. K��° POLL ->���
 *4. Q���� ������� 1�� ���������� �ݺ� (���� 1���� �ٷ� ������ ����ϸ� ��) 
 * */
public class JUN1158_Josephus {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//�����
		int K = Integer.parseInt(st.nextToken());//������ ���� 
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		Queue<Integer> q = new LinkedList<>();
		
		//1~N�� OFFER
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
				
		while(q.size() != 1) {
			for (int i = 0; i < K-1; i++) {//K-1 ���� ����鿡 ���� �۾�
				q.offer(q.poll());
			}
			
			//K��° ����� ����
			sb.append(q.poll() + ", ");			
		}
		
		//Q�ȿ� ���� ��� 1��
		sb.append(q.poll() + ">");		
		System.out.println(sb);		
	}
}