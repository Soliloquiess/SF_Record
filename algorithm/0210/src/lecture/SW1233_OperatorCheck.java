package com.off.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1.������ ������ �϶� �ڽ���
 *  1)������ + ������
 *  2)������ + ����
 *  3)���� + ����
 *  4)����+�����ڴ� �ȵ�
 *  
   2.������ �����϶� �ڽ��� ����� ��   
*/
public class SW1233_OperatorCheck {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;//���� ����
		char[] tree;
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];//1�� ��������~
			
			boolean flag = true;//���� ��ȿ�� üũ 
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());//���� ��ȣ
				tree[index] = st.nextToken().charAt(0);//������ ������ ��(������ OR ����)				
			}//�Է�
			
			//��� ������ ���� ����
			int left, right;
			for (int j = 1; j <= N; j++) {
				left = j * 2;
				right = left + 1;
				
				//1.������ �������� ���
				if(!Character.isDigit(tree[j])) {//������
					if(left <= N && right <= N) {//����, ������ �ڽ��� �ְ�
						if(Character.isDigit(tree[left]) &&
								!Character.isDigit(tree[right])) {
							flag = false;
						}//�ȵǴ� ��츸 üũ
					}else {//�ڽ��� ������
						flag = false;
					}
					
				}else{//2.������ ������ ��� -> �ڽ��� ������ �ȵ�
					if(left <= N) {
						flag = false;
					}
				}
				if(!flag)
					break;
			}			
			System.out.println("#" + tc + " " + (flag ? 1: 0));		
		}//tc	
	}//main

}//class
