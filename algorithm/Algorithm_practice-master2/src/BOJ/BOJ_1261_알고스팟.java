package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int C,R;	//col,row
	static char [][] map;
	static int [][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};

	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		C= Integer.parseInt(tokens.nextToken());
		R= Integer.parseInt(tokens.nextToken());
		map = new char[R][];
		for(int r = 0; r<R; r++) {
			map[r] = input.readLine().toCharArray();
		}
		//입력완료
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		boolean [][]visited = new boolean[R][C];
		//bfs에는 큐 쓰는데 우선순위 줘서 쓰니까 우선순위 큐 사용
		//pq에선 반드시 비교 할 수 있어야 , 그래서 comparable 인터페이스 구현해줘야한다.
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, 0));
		
		while(!pq.isEmpty()) {
			//1.한 녀석 빼기
			Point head = pq.poll();
			//2.사용하기
			if(visited[head.r][head.c]) {
				continue;
			}
			visited[head.r][head.c] = true;
			if(head.r==R-1 && head.c ==C-1)//혹시 내가 목적지니?
			{	//head가 목적지면 브로커가 가진 목적지 부분 반환
				return head.broke;
			}
			
			//3.자식찾기 (사방탐색)
			for(int d = 0; d<deltas.length; d++) {
				int nr = head.r+deltas[d][0];
				int nc = head.r+deltas[d][1];
		
				if(isIn(nr, nc)&& !visited[nr][nc]) {
					if(map[nr][nc]=='1') {		//이거라면 벽을 깰거
						pq.offer(new Point(nr,nc,head.broke+1)); //하나 깨고 왔으니까 최대 증가
					}else {
						pq.offer(new Point(nr,nc,head.broke));
					}
				}
			}
		}
		
		return -1;
	}
	
	static boolean isIn(int r, int c) {
		
	}
	
	static class Point implements Comparable<Point>{
		
		int r,c,broke;

		public Point(int r, int c, int broke) {
			super();
			this.r = r;
			this.c = c;
			this.broke = broke;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", broke=" + broke + "]";
		}
		
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.broke, o.broke);
		}
	}
	
	
	private static String src = "2\r\n" +
			"5 3\r\n" +
			"D*S\r\n" +
			".X.\r\n" +
			".X.\r\n" +
			".X.\r\n" +
			"...\r\n" +
			"5 3\r\n" +
			"D*S\r\n" +
			"...\r\n" +
			".X.\r\n" +
			".X.\r\n" +
			"...";
}

