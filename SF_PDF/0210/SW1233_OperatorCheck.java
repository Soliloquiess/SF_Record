package com.off.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1.정점이 연산자 일때 자식은
 *  1)연산자 + 연산자
 *  2)연산자 + 숫자
 *  3)숫자 + 숫자
 *  4)숫자+연산자는 안됨
 *  
   2.정점이 숫자일때 자식은 없어야 함   
*/
public class SW1233_OperatorCheck {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;//정점 개수
		char[] tree;
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];//1번 정점부터~
			
			boolean flag = true;//식의 휴효성 체크 
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());//정점 번호
				tree[index] = st.nextToken().charAt(0);//정점이 가지는 값(연산자 OR 숫자)				
			}//입력
			
			//모든 정점에 대해 조사
			int left, right;
			for (int j = 1; j <= N; j++) {
				left = j * 2;
				right = left + 1;
				
				//1.정점이 연산자인 경우
				if(!Character.isDigit(tree[j])) {//연산자
					if(left <= N && right <= N) {//왼쪽, 오른쪽 자식이 있고
						if(Character.isDigit(tree[left]) &&
								!Character.isDigit(tree[right])) {
							flag = false;
						}//안되는 경우만 체크
					}else {//자식이 없으면
						flag = false;
					}
					
				}else{//2.정점이 숫자인 경우 -> 자식이 있으면 안됨
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
