package com.ssafy;

import java.util.Arrays;

public class DisjointSetTest {
	static int N;
	static int parents[];
	
	static void make() {	// 크기가 1인 단위집합을 만든다.
		for(int i =0; i<N; i++) {
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
	
	public static void main(String[] args) {
		N=5; //편의상 원소의 개수 5개
		parents = new int[N];//원소 개수만큼 배열 생성
		
		//1.make set 모든 원소들로 상호배타적인 집합 만든다.
		make();

		System.out.println("=====union=====");
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(1,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,4));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,4));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("=====find=====");
		
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
		
	}
}
