package com.ssafy;

public class WS_algo1 {
	public static void main(String[] args) {
		int N = 8;
		//1.구해야하는 답을 문장으로 한 번 써보기
		//N층의 아파트를 칠할 수 있는 방법의 수
		
		
		//2.작은 문제의 답을 배열(N)에 저장.
		int [][] D = new int[N+1][2];
		D[1][0] = 1;	//노란색	//1층부터(0층은 없으므로)
		D[1][1] = 1;	//1층에서 사용할 수 있는 파랑색 가지수
		
		for(int i =2; i<=N; i++) {
			D[i][0] = D[i-1][0] +D[i-1][1];
			D[i][1] = D[i-1][0];
		}
		System.out.println(D[N][0]+D[N][1]);
	}
}
