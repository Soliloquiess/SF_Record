package com.algo05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*1. 1~N -> Q
 *2. K-1번째 사람들은 -> 꺼내서 Q의 맨뒤로 보내기 
 *3. K번째 POLL ->출력
 *4. Q안의 사람들이 1명 남을때까지 반복 (남은 1명은 바로 꺼내서 출력하면 됨) 
 * */
public class JUN1158_Josephus {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//사람수
		int K = Integer.parseInt(st.nextToken());//삭제될 순서 
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		Queue<Integer> q = new LinkedList<>();
		
		//1~N개 OFFER
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
				
		while(q.size() != 1) {
			for (int i = 0; i < K-1; i++) {//K-1 명의 사람들에 대해 작업
				q.offer(q.poll());
			}
			
			//K번째 사람은 삭제
			sb.append(q.poll() + ", ");			
		}
		
		//Q안에 남은 사람 1명
		sb.append(q.poll() + ">");		
		System.out.println(sb);		
	}
}