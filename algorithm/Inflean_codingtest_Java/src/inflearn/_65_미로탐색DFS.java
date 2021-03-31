package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _65_미로탐색DFS {

	static int map[][] = new int [10][10];
	static int[][]ch= new int [10][10];
	static int dx[] = { 1, 0, -1, 0 };	//dx=1,dy=0 은 6시 방향 -1,0이면 12시 0,1은 3시방향 0 -1은 9시 방향
	static int dy[] = { 0, 1, 0, -1 };	//예전 문제와 같이 x는 행 y는 열
	static int cnt = 0;	
	
	static  void DFS(int x, int y) {
		int xx, yy, i;
		if (x == 7 && y == 7) {	//종착지점.
			cnt++;		//종착지점 왔으니까 cnt++
		}

		else {		//여기서 뻗어나감
			for (i = 0; i < 4; i++) {
				xx = x + dx[i];			//현재지점에서 dx더해주면 앞으로 갈좌표
				yy = y + dy[i];			//마찬가지.
				if (xx < 1 || xx>7 || yy < 1 || yy>7)		//격자판 밖으로 벗어남.
					continue;		//컨티뉴는 밑에부분 하지않고 지나가버림.
				if (map[xx][yy] == 0 && ch[xx][yy] == 0) {		//이제 탐색.
					//넘어가려는 지점이 통로인지 확인.
					//그 격자에 방문하지 않았더라.
					ch[xx][yy] = 1;
					DFS(xx, yy);
					ch[xx][yy] = 0;	//체크 했던거 꼭 풀어줘야 한다.
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st; 
			Scanner sc= new Scanner(System.in);
			

				//freopen("input.txt", "rt", stdin);
//				scanf("%d %d", &n, &m);
			int i, j;
			for (i = 1; i <= 7; i++) {
				

				st = new StringTokenizer(br.readLine()," ");
				
				for (j = 1; j <= 7; j++) {
//					scanf("%d", &map[i][j]);
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ch[1][1] = 1;		//1행 1열 부터 출발
			DFS(1, 1);			//1행 1열이 넘어감.
			System.out.printf("%d\n", cnt);		//cnt 찍으면 됨.

	}
}
