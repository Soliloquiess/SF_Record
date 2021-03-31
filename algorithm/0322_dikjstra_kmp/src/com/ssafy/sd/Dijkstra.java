package com.ssafy.sd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int start = 0; //출발점
		int end = V-1;	//도착점.
		int [][] adjMatrix = new int[V][V];//인접행렬
		
		StringTokenizer st = null;
		for(int i =0; i<V;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j  =0; j<V;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [] distance = new int[V];
		boolean [] visited = new boolean[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for(int i =0; i<V;i++) {
			//step1. 처리하지 않은 정점 중 출발지에 가장 가까운 정점 선택
			int min = Integer.MAX_VALUE;
			int current=0; //min의 최소비용에 해당하는 정점번호.
			for(int j =0; j<V; j++) {
				if(!visited[j] && min > distance[j]) {
//					distance의 값 중 최소의 값을 찾아야 하니까.
					min = distance[j];
					current = j;	//current 에 가장 작은 비용을 가진 정점을 저장.
				}
			}
			
			visited[current] = true;
			if(current== end)break; //끝이면 다른곳으로 경유해서 거쳐서 가는 애를 찾을 필요 없다.
			//출발지에서 목적지 가는 모든 경우 비교할 거아니면 여기서 끝내도 된다.
			//step2. 선택된 current를 경유지로 하여 아직 처리하지 않은 다른 정점으로 최소비용을 따져본다.
			for(int j =0; j<V;j++) {
				if(!visited[j] && adjMatrix[current][j]!=0 && distance[j]>min+adjMatrix[current][j]) {
					//출발지에서 current까지 더한게 최소비용 . 출발지에서 j로 오는 비용보다 크면 원래 거보다 거쳐서 오는게 더 유용하다는 의미니까
					distance[j] = min+adjMatrix[current][j];
				}
				
			}
		}
		System.out.println(distance[end]);
		//만약 출발지에서 어떤 경유로 가도 end 못가면 max_value
		//그래서 초기값인 maxvalue면 어떤 식으로 해도 목적지에 못간다.
	}
}
