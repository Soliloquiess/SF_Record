package com.live01;

public class RecursiveTest {
	public static void main(String[] args) {
		//1. recur(): start, end, step 반복문처럼 한 줄에 출력해주는 함수
		recur(0,5,1);
		recur(1,10,2);
		
		//2. sum(): start, end . start~end 까지의 합을 구하는 함수
		sum(1,10);
	}
	
	static void recur (int start, int end, int step) {
		//1. 종료파트
		if(start>end)
		{
			System.out.println();
		}
		//2. 반복파트-출력하고 재귀호출
		
		else {
			System.out.println(start+" ");
			recur(start+step,end,step);
		}
	}
	
	static int tmp =0;
	static void sum(int start, int end) {
		//1. 종료파트
		if(start>end) {
			System.out.println("합: "+tmp);
		}
		//2.반복파트-누적, 재귀호출
		else {
			tmp+= start;
			sum(start+1,end);
		}
		
	}
}
