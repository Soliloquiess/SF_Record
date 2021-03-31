package com.ssafy.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_Contact {
	static int [][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt(); //입력 데이터 총 갯수
			int start = sc.nextInt(); //시작점
			
			map = new int[101][101]; //1~100
			for(int i =0;i<N/2;i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map [from][to] = 1;
			}
			System.out.println("#" + tc +" "+ bfs(start));
		}
	}
	private static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int [] visited = new int[101]; //정점의 방문여부. 몇번째로 방문한건지 그 값도 같이 저장.
		//불리언으로 안하고 값을 넣어서 확인하려 int배열로 선언
		int visitSeq = 0, ans =0; //정점의 방문순서를 저장하는 변수.
		q.offer(start);
		visited[start] = 1; //시작정점이니까.
		//이건 쌍으로 확인 큐에 넣고 확인하기 위해 1로 넣어줌.
		while(!q.isEmpty()) {
			int current = q.poll();//시작정점
			for(int i =1; i<101;i++) {	//현재 꺼낸건 current 정점인데 누구랑 인접해있나 보자.
				if(map[current][i] ==1&&visited[i] ==0) {
					q.offer(i);
					visited[i] = visited[current] +1;
				}
			}
			//while문 돌면서 방문 순서를 visitSeq에 저장하겠다.
			visitSeq = visited[current]; //이 정점이 몇번째에 방문 된거냐.
			//visitSeq는 마지막에 방문한 애가 몇번째로 저장한지. 방문 순서 계속 저장.
			//어느 순간 while문 끝날건데 이 변수엔 마지막으로 처리된 정점의 방문순서가 저장.
		}
		//visitSeq : 마지막으로 처리한 정점의 방문 순서 값이 저장되어 있음.
		
		for(int i= 1; i<101;i++) {
			if(visitSeq == visited[i]) {
				ans = (ans>i)?ans:i;	//정점의 번호
			}
		}
		return ans;
		
	}
}


















