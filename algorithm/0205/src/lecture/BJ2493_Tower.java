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
		HashMap<Integer,Integer> m = new HashMap<>(); //���̿� �ε���

		int tc=Integer.parseInt( br.readLine()); //���� �Է�
		StringTokenizer st = new StringTokenizer(br.readLine()); //���� �Է�
		int[] in=new int[tc+1];
		for(int i=1;i<=tc;i++) {
			in[i]=Integer.parseInt(st.nextToken()); //�迭�� ���� ����
		}
		
		for(int i=1;i<=tc;i++) {
			m.put(in[i], i);
			while(!tower.isEmpty()) { //stack�� ���� �ϳ��� ������
				if(tower.peek()>in[i]) { //stack�� �� ū�� �ִٸ� 
					sb.append(m.get(tower.peek())+" "); //�ش� Ÿ���� �ε����� �ҷ��ͼ� ���
					tower.push(in[i]); //���� ���� ���� Ÿ�� ������ �ڽ��� �־���
					break;
				}
				else { //���� �Է��� �� ���� ���� ���
					tower.pop(); //�ʿ�����Ƿ� pop ������
				}
			}
			if(tower.isEmpty()) { //�ݺ��� ������ ���Դµ� stack�� ����ٸ�
				tower.push(in[i]); //�ڱ� �ڽ��� �־��ְ�
				sb.append(0+" "); //���� �� �ִ� Ÿ���� �����Ƿ� 0
			}
		}
		System.out.println(sb.toString());		
	}
}
