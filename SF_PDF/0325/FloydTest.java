package com.algo12;

import java.util.Scanner;

/* 플로이드: 모든 정점 간의 최소 비용
 * 음수도 허용, 사이클은 x
 *  for 3개 사용
 *  for-경유지
 *  	for-출발지
 *  		for-도착지
 *  
5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2
-2 0 0 0 2
0 -3 3 1 0

5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2
2 0 0 0 2
0 3 3 1 0  
 * */
public class FloydTest {
	static final int INF = 999;
	static int N, adjMatrix[][];
	static String src = "5\r\n" + 
			"0 4 2 5 0\r\n" + 
			"0 0 1 0 4\r\n" + 
			"1 3 0 1 2\r\n" + 
			"-2 0 0 0 2\r\n" + 
			"0 -3 3 1 0";
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		N = sc.nextInt();
		adjMatrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = sc.nextInt();
				
				if(i != j && adjMatrix[i][j] == 0) {//인접해 있지 않은 경우
					adjMatrix[i][j] = INF;
				}				
			}
		}//입력끝
		System.out.println("입력값");
		print();	
		
		//최소 비용 계산 하러 감
		//경유지 -> 출발지 -> 도착지
		for (int via = 0; via < N; via++) {//경유지
			for (int from = 0; from < N; from++) {//출발지
				if(via == from) continue;
				
				for (int to = 0; to < N; to++) {//도착지
					if(from == to || via == to) continue;
					
					if(adjMatrix[from][to] > adjMatrix[from][via] + adjMatrix[via][to]) {
						adjMatrix[from][to] = adjMatrix[from][via] + adjMatrix[via][to];
					}
				}
			}
			print();
		}
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjMatrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("--------------------------------");
	}
}
