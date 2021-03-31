package com.ssafy;

public class WS_algo2 {
	public static void main(String[] args) {
		

	
		int N = 3;
		//1.구해야 하는 답을 문장으로 한번 써보기
		// 길이가 N인 막대를 만드는 방법의 수
		//2. 방법의 수를 저장할 배열(N)
		int[]D = new int[N+1];
		
		//3.초기값
		D[1]= 2;	//길이가 1인 막대를 만드는 방법의 수(파란색 OR 노란색)
		D[2]= 5;	//길이가 1인 막대를 만드는 방법의 수
		
		for(int i =3; i<=N;i++) {
	//		N번쨰층에 노랑색 칠할수 있는 경우는 N-1
			//전체 길이가 N인 경우 막대기 맨 뒤에 노란색 막대를 놓는 경우가 1가지. 
			//전체 길이가 N인 경우: 맨 뒤에 노란색/파란색 막대 놓는 경우, 빨간색 막대를 놓는 경우.
			D[i] = D[i-1] +D[i-1]+D[i-2];	//이 점화식 만들어낼줄 알아야.
		}
		System.out.println(D[N]);
	}
}