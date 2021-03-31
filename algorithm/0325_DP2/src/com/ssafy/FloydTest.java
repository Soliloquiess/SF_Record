package com.ssafy;

import java.util.Scanner;

/*
 * 모든 정점 간의 최소 비용
 * 음수도 허용,
 * for 3개 사용
 * for - 경유지
 * 		for - 출발지
 * 			for - 도착지
 */
public class FloydTest {
		static final int INF =999;
		static int N, adjMatrix[][];
		static String src= "5\r\n"+
				
				"0 4 2 5 0\r\n"+
				"0 0 1 0 4\r\n"+
				"1 3 0 1 2\r\n"+
				"-2 0 0 0 2\r\n"+
				"0 -3 3 1 0";
	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner (src);
		N = sc.nextInt();
		adjMatrix = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j =0; j<N;j++) {
				adjMatrix[i][j] = sc.nextInt();
				
				if(i!=j && adjMatrix[i][j] ==0) {	//인접해 있지 않은 경우
					//i랑 j가 같지 않고 i에서j로 가는 값이 0이면 갈수 가 없다.(i와 j가 같으면 자기자신한테 오는거)
					//자기자신한테 오는 정보는 아닌데 그 값이 0이라면 서로 인접해있지 않다.
					adjMatrix[i][j]= INF;//음수도 있어서 최소비용이 0이되는 경우도 있기에 다른 값을 넣어줬다.
				}
			}
				
		}
		System.out.println("입력값");
		print();
		
		//최소비용 계산하러 감.(플루이드는 루프 3번만 돌리면 끝)
		for(int via =0; via<N; via++) {	//경유지
			for(int from = 0; from<N; from++) {	//출발지(여기가 값이 계속 바뀔거)
				if(via == from) continue;
				for(int to=0; to<args.length; to++) {	//도착지
					if(from == to || via == to)	//3개가 다 똑같은 경우도 의미가 없음.
					{	continue;
				
					}
					if(adjMatrix[from][to] > adjMatrix[from][via] + adjMatrix[via][to]) {//from에서 to로 가는 비용.
	//					from에서 to로 가는 비용이 얼마인가. 맨 처음이면 다이렉트로 가는 비용이 더 크다.
						adjMatrix[from][to] = adjMatrix[from][via] + adjMatrix[via][to];
					}
				}
			}
			print();
		}
	}
	private static void print() {
		for(int i =0; i<N; i++) {
			for(int j =0; j<N; j++) {
				System.out.print(adjMatrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("----------");
	}
}

// 0으로 들어오는건 자기 자신한테 오는 거.


// 맨 처음이 초기상태(입력값 받은 그대로)
// 경유지 고정하고 출발지 고정하고 돌림


// 처음에는 초기값이 999여서 갈 수 없는 점. 한번 경유지 고정하고 경유지 거친다음 오니까 갈수 있음(비용은 0)

// 출발점 바꾸고 도착지를 바꿔가며 값들을 단계별로 확인.

//경유지란 경유지 다 사용하고 모든 경유지와 모든 출발점 다 사용. 각 도착점을 다 테스트 한다.

//입력 받은 데이터 가지고 그림그리며 테스트 해보자.
//음수가 있어도 괜찮다. 다만 사이클이 있으면 안된다.