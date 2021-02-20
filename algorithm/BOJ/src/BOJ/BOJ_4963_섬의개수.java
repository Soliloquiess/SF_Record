package BOJ;

import java.util.Scanner;

public class BOJ_4963_���ǰ��� {
	static int[][] visit;
	static int[][] map;
	static int N, M;
	static int ans;
	static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			ans = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			if(N == 0 && M == 0) break;
			
			map = new int[N][M];
			visit = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int k = 0; k < M; k++) {
					map[i][k] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int k = 0; k < M; k++) {
					if (map[i][k] == 0)
						continue;
					dfs(i, k);
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	static void dfs(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= M || ny >= N || map[ny][nx] == 0)
				continue;

			map[ny][nx] = 0;
			dfs(ny, nx);
		}
	}
}



//public class BOJ_4963_���ǰ��� {
//
//}
//import java.util.*;
//
//public class Main {
//    static int[][] map;
//    static boolean[][] visit;
//    static int[] move_x = {1,-1,0,0,1,1,-1,-1};
//    static int[] move_y = {0,0,-1,1,1,-1,-1,1}; //�밢���� �ð����.
//    static int w,h;
//    static int cnt = 0;
//
//    static void dfs(int x, int y){
//        visit[x][y] = true;
//
//        for(int i=0; i<8; i++){
//            int mx = x+move_x[i];
//            int my = y+move_y[i];
//
//            if(mx >= 0 && my >= 0 && mx < h && my < w){
//                if(visit[mx][my] == false && map[mx][my] == 1){
//                    dfs(mx,my);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while(true){
//            w = scanner.nextInt();
//            h = scanner.nextInt();
//
//            map = new int[h][w];
//            visit = new boolean[h][w];
//            if(w == 0 && h == 0)
//                break;
//            for(int i=0; i<h; i++){
//                for(int j=0; j<w; j++){
//                    map[i][j] = scanner.nextInt();
//                }
//            }
//            cnt = 0;
//            for(int i=0; i<h; i++){
//                for(int j=0; j<w; j++){
//                    if(map[i][j] == 1 && visit[i][j] == false){
//                        dfs(i,j);
//                        cnt++;
//                    }
//                }
//            }
//            System.out.println(cnt);
//        }
//    }
//}

//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class BOJ_4963_���ǰ��� {
//    // ��ǥ�� �����¿�밢���� ���� ����
//    static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
//    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
//
//    static int w, h;
//    static int[][] map;
//    static int[][] visited; // �湮���� �ʾ�����: 0, �湮������: 1
//    static int cntOfIsland; // ���� ��
//
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            w = scanner.nextInt();
//            h = scanner.nextInt();
//            cntOfIsland = 0;
//
//            if (w == 0 && h == 0) break; // ���� ����: 0 0
//
//            map = new int[h][w];
//            visited = new int[h][w];
//
//            for (int i=0; i<h; i++) {
//                for (int j=0; j<w; j++) {
//                    map[i][j] = scanner.nextInt(); // ��: 1, �ٴ�: 0
//                    visited[i][j] = 0;
//                }
//            }
//
//            // ��ǥ Ž��
//            for (int i=0; i<h; i++) {
//                for (int j=0; j<w; j++) {
//                    // �ش� ��ǥ�� ���̰�, �湮���� ���� ��ǥ�� Ž�� ����
//                    if (map[i][j] == 1 && visited[i][j] == 0) {
//                        bfs(i, j);
//                    }
//                }
//            }
//            System.out.println(cntOfIsland);
//        }
//    }
//
//    // �ʺ� �켱 Ž��
//    static void bfs(int x, int y) {
//        Queue<Pair> queue = new LinkedList<>();
//        queue.add(new Pair(x, y)); // ���� ��ǥ�� ť�� ����
//        visited[x][y] = 1; // �湮
//
//        while (!queue.isEmpty()) {
//            int x1 = queue.peek().getX();
//            int y1 = queue.peek().getY();
//            queue.poll(); // ��ǥ�� �湮�ϰ� ť���� ����
//
//            // �ش� ��ǥ�� ���� �����¿�밢���� Ȯ��
//            for (int i=0; i<8; i++) {
//                int nextX = x1 + dx[i];
//                int nextY = y1 + dy[i];
//
//                // �ش� ��ǥ�� ���� �ȿ� ������
//                if (nextX >= 0 && nextX < h && nextY >=0 && nextY < w) {
//                    // �ش� ��ǥ�� ���̰�, �湮���� ���� ��ǥ�� ���� ������ ǥ��
//                    if (map[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
//                        queue.add(new Pair(nextX, nextY)); // ���� ��ǥ�� ť�� ����
//                        visited[nextX][nextY] = 1; // �湮
//                    }
//                }
//            }
//        }
//        cntOfIsland++; // ���� �� ����
//    }
//
//    // ��ǥ�� ���� Ŭ����
//    public static class Pair {
//        private int x;
//        private int y;
//
//        public Pair(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//        public int getX() { return x; }
//        public int getY() { return y; }
//    }
//}
