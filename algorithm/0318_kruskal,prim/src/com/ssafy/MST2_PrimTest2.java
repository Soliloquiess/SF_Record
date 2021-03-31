package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST2_PrimTest2 {
	
	public static void main(String[] args) throws IOException {
		//메인에서 최소신장트리 만들기 위해 유니온 활용만 하면 됨.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int [] minEdge = new int[N];
		StringTokenizer st = null;
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0; j<N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());	
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		int result = 0;
		minEdge[0] = 0;
		
		for(int c = 0; c<N; c++) {	
			
			int min  = Integer.MAX_VALUE;//최소값 찾을거니가 큰 값으로 넣고 출발.
			int minVertex =0;
			//신장트리에 연결되지 않은 정점 중 minEdge비용이 최소인 정점.
			for(int i =0; i<N;i++) {	//최소 간선 비용 갖는 애 찾아야
				if(!visited[i] && min>minEdge[i]) {//해당 정점이 아직 신장트리 구성되지 않았고 손 못잡은 애들 중 연결된 애들이 손 뻗을떄 가장 작은 정점으로 연결할수 있는 녀석 찾음 
					min = minEdge[i];
					minVertex = i;	//간선의 비용이 최소인 정점을 돌면서 계속 찾음
					
				}
			}
			//다 돌고나면 신장트리 연결 안된 애들중 간선트리 비용이 가장 적은 애가 선택
			// 맨 처음에는 0으로 세팅한 0번 정점이 나옴
			//minvertex의 가중치 값을 결과치에 누적하고 신장트리에 포함되니까 true로 바꿔줌
			result +=min;
			visited[minVertex] = true;
			
			for(int i =0; i<N; i++) {
				if(!visited[i] && adjMatrix[minVertex][i]!=0 && minEdge[i]>adjMatrix[minVertex][i]) {	//인접여부 따져보고 0이 아니어야 되고 그 녀석이 다른 정점에서 자신으로 오는 간선의 비용이 minVertex에서 i로 오는 간선의 비용보다 크다면  minVertex에서 i로 오는게 더 유리
					//minvertex에서 i 로 오는 간선 비용보다 더 크다면 minvertx에서 i로 오는게 더 유리
					minEdge[i] = adjMatrix[minVertex][i];
				//최소 간선비용은 다른데서 오는거보다 나한테 오는게 더 유리하다고 업데잍 해줌.
				//반복 돌면서 현재 손 ㄷ잡게 된 애들이 자신이 손 뻗었을 때의 간선 비용이 기존의 다른애가 뻗었을때보다 유리하면 다음에 반복 돌때 최소비용의 정점 선택되게 해줌
			
				}

			}
		}

		System.out.println(result);
	}

}
