package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST1_KruskalTest {
	
	static class Edge implements Comparable<Edge>{
		int from , to, weight;
		//간선 스스로가 다른 간선과 자기 스스로 비교(나에서 상대를 뺸다)
//		항상 나를 기준으로 상대를 뺴는 연산(내림 차순이면 순서만 뒤집어라. )

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
//			return this.weight -o.weight;
			return Integer.compare(this.weight, o.weight);
//			만약 값이 음수랑 섞일거 같다 생각하면 Integer.comapre이용해서 음수 발생하면 언더플로 양수에 음수 뺴지면 오버플로우 발생하니까
//			내부적으로 이렇게 써도 됨 . 알아서 내부적으로 앞에서 뒤를 뻄(부호를 크기검사해서 알아서 줌.)
		}
		
		
		
	}
	
	static int V,E;	//알트 쉬프트 R 키누르면 리네임(rename), V는 정점 개수, E는 간선 개수.
	static int parents[];
	static Edge[] edgeList; //간선 리스트 만들 거(간선 개수 줄거라 배열로 만듬.
	//간선 개수 모르면 어레이리스트 쓰면 좋지만 간선 들어오는 개수 알면 배열 안 쓸 이유가 없으니까 배열로 써도 된다.
	static void make() {	// 크기가 1인 단위집합을 만든다.
		for(int i =0; i<V; i++) {
			parents[i] = i;	//자기 배열 위치에 자기 값 넣음.	자기 자신이 대표자
		}
	}
	
	//2. 대표자를 찾는 메서드
	static int findSet(int a) {	//find는 들어온 원소의 대표자를 찾아줌(재귀하면서 파라미터가 a였는데 a의 부모를 집어넣어서
		//a의 부모의 부모를 찾아가면서 어느 순간 꼭대기까지 가면 조건 만족해서 찾은 a값을 리턴.
		if(parents[a]==a) return a;	//내가대표면 그냥 리턴.	자기자신과 같으면 자기가 대표자라서 바로리턴
		//부모에도 부모가 있을 수 있고 계속 올라감.
//		return findSet(parents[a]);		//path Compression 전
		return parents[a] =  findSet(parents[a]);		//path Compression 후
		//아니면 다른 원소 들어있었으면 더 위로 올라가서 대표자 찾는 거.
		//찾은 부모값을 a의 부모값으로 다시 집어넣음.
		//올라가서 찾은 대표값을 리셋.
	}
	
	static boolean union(int a, int b) {	//유니온의 리턴값은 꼭 필요하진 않지만 잘 합쳐졌는지 확인해야 될 경우들이 있다.
		//아예 리턴값 활용하게 쓰는게 훨씬 좋은거 같다.
		//앞쪽에 있는 a에 뒤쪽에 있는 b를 넣는다.
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		//얘들은 매개변수로만 쓰고 짱 끼리 합치는 거.
		if(aRoot == bRoot) {	//두 조직의 짱이 같은 상황이면 이미 같은 조직이므로 합칠 필요가 없음.
			return false;	//합치지 못한 결과 리턴.
		}
		
		parents[bRoot] = aRoot;	//aRoot의 값 가져다 b에 넣는게 아니라 b의부모를 연결해서 대표자와 대표자끼리 작업하게 함.
		//b의 대표자 집어넣음.
		//이거 잘 기억하면 문제 풀때 적용하기 쉽다.
		//b루트의 부모를 a루트로 바꿔줌.
		return true;
		//나중에 랭크 이용하면 랭크 비교해서 랭크가 높은 쪽에 낮은 쪽 붙이고 둘의 랭크 같으면 자식의 랭크 하나 올려주는 이런 코드가 필요
		//path 압축햇을때 랭크 관리 쉽지않음.
	}
	
	//여기까지 서로소 집합 구성하는 부분.
	
	public static void main(String[] args) throws IOException {
		//메인에서 최소신장트리 만들기 위해 유니온 활용만 하면 됨.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int [V];	//정점개수 배열
		edgeList = new Edge[E];	//간선 개수 배열
	
		for(int i =0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}	//간선 리스트
	
		//1. 간선 리스트 가중치 기준 오름차순 정렬
		Arrays.sort(edgeList);	//(이미 위에서 오름차순 정렬해서 호출만 하면 끝)
		
		//여기서 부터 유니온 파인드 작업
		make();
		int result = 0; //가중치의 합 구할 변수
		int count = 0; // 선택한 간선 수(몇개 선택했는지 카운트 해야됨
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {	// 이 결과가 true면 싸이클이 발생하지 않았다면 서로 다른집합.
				result += edge.weight;
				if(++count ==V-1) break;	//정점 -1 개수가 되면 더 볼 필요가 없음
				
			}
		}
//		간선이 union되면 그 때 비용 누적 시키고 카운트 올리고 카운트가 정점-1개수가 되면 빠져나옴
//		답은 그때까지 누적된 result를 찍으면 된다.
		System.out.println(result);
	}
	
}
