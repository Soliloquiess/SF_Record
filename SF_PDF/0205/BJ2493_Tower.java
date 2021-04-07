package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493_Tower {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> tower = new Stack<>();
		HashMap<Integer,Integer> m = new HashMap<>(); //높이와 인덱스

		int tc=Integer.parseInt( br.readLine()); //갯수 입력
		StringTokenizer st = new StringTokenizer(br.readLine()); //높이 입력
		int[] in=new int[tc+1];
		for(int i=1;i<=tc;i++) {
			in[i]=Integer.parseInt(st.nextToken()); //배열에 높이 저장
		}
		
		for(int i=1;i<=tc;i++) {
			m.put(in[i], i);
			while(!tower.isEmpty()) { //stack에 뭔가 하나라도 있을때
				if(tower.peek()>in[i]) { //stack에 더 큰게 있다면 
					sb.append(m.get(tower.peek())+" "); //해당 타워의 인덱스를 불러와서 출력
					tower.push(in[i]); //기존 가장 높은 타워 다음에 자신을 넣어줌
					break;
				}
				else { //새로 입력한 값 보다 작을 경우
					tower.pop(); //필요없으므로 pop 시켜줌
				}
			}
			if(tower.isEmpty()) { //반복을 끝내고 나왔는데 stack에 비었다면
				tower.push(in[i]); //자기 자신을 넣어주고
				sb.append(0+" "); //받을 수 있는 타워가 없으므로 0
			}
		}
		System.out.println(sb.toString());		
	}
}
