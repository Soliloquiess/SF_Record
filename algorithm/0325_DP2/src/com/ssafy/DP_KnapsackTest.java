package com.ssafy;

import java.util.Scanner;

public class DP_KnapsackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int [] weights = new int[N+1];//물건의 무게정보
		int [] profits = new int[N+1];//물건의 가치 정보
		int [][]D = new int[N+1][W+1];//해당 물건까지 고려하여 해당 무게를 만들 떄의 최대 가치
		
		for(int i =1; i<=N;i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
			
		}
		for(int i =1; i<=N;i++) {	//첫 물건부터 고려
			for(int w = 1; w<=W;W++)// 무게 1부터 고려
			{
				if(weights[i]<=w) {//가방에 넣을 수 있는 상황
					//넣을까
					Math.max(D[i-1][w-weights[i]]+profits[i],D[i-1][w]);	//자신이 들어가면서 생기는 가치.
					//말까
					D[i][w] = D[i-1][w];
					
				}else {	//가방에 넣지 못하는 상황
					D[i][w] = D[i-1][w];
					
				}
				//시간복잡도는? for 2번 돌면서 위에거 실행한다 치면 n2
				//근데 재귀적이면 물건이 30개만 되도 2의 30승이였다. 굉장히 큰 차이.
				//계산하는 과정에서 어떤 무게가치들이 쓰일지 모른다.
				//사용되지 않은 애들도 있음. 뒤쪽에서 안 쓰일 수 있음. DP도 다 계산하는데 스마트하게 다한다(스마트한 완탐)
			}
			
		}
		System.out.println(D[N][W]);
		
	}
}
