package extra.s3.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 3. 25.
 * @see 12752	116
 * @time
 * @caution [고려사항] [입력사항] [출력사항]
 */
public class BJ_G4_1261_알고스팟 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int C, R;
	static char[][] map;
	static int [][] deltas = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " ");
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		map = new char[R][];
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
		}

		// 입력 완료
		System.out.println(bfs());
	}

	static int bfs() {
		boolean[][] visited = new boolean[R][C];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, 0));
		
		while(!pq.isEmpty()) {
			// 1. 한녀석 빼기
			Point head = pq.poll();
			// 2. 사용하기
			if(visited[head.r][head.c]) {
				continue;
			}
			visited[head.r][head.c]=true;
			
			if(head.r==R-1 && head.c==C-1) {
				return head.broke;
			}
			// 3. 자식 찾기.
			for(int d=0; d<deltas.length; d++) {
				int nr = head.r + deltas[d][0];
				int nc = head.c + deltas[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc]) {
					if(map[nr][nc]=='1') {
						pq.offer(new Point(nr, nc, head.broke+1));
					}else {
						pq.offer(new Point(nr, nc, head.broke));
					}
				}
			}
		}

		return -1;
	}
	
	static boolean isIn(int r, int c) {
		return 0<=r && r<R && 0<=c && c<C;
	}

	static class Point implements Comparable<Point> {
		int r, c, broke;

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

	private static String src = "3 3\r\n" +
			"011\r\n" +
			"111\r\n" +
			"110";
}
