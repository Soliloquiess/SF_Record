package SWEA;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬_디펜스 {
	private static int[][] map; 
	private static int[][] copyMap; 
	private static boolean[][] isDead; 
	private static int current; 
	private static int count; 
	private static int result; 
	private static int answer; 
	private static int[] archer; 
	private static int N;
	private static int M;
	private static int D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copyMap = new int[N][M];
		isDead = new boolean[N][M];
		// 맵 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int read = Integer.parseInt(st.nextToken());
				if (read == 1) {
					current++;
				}
				map[i][j] = read;
				copyMap[i][j] = map[i][j];
				isDead[i][j] = false;
			}
		}

		if (current == 0 || M == 0) {
			System.out.println(0);
			return;
		}

		archer = new int[3];

		setArcher(0, 0); // 궁수 배치 시작!

		System.out.println(answer);

		br.close();
	}

	public static void setArcher(int index, int length) {
		if (length == 3) { // 셋다 배치한 경우 종료 => 공격 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copyMap[i][j] = map[i][j];
					isDead[i][j] = false;
				}
			}
			count = current;
			battle();
			return;
		}
		for (int i = index; i < M; i++) {
			archer[length] = i;
			setArcher(i + 1, length + 1);
		}
	}

	// 조합으로 선정된 궁수 3명 동시 공격
	public static void battle() {
		while (count != 0) {
			// 공격 구현
			for (int i = 0; i < archer.length; i++) {
				// 가장 가까운 거리의 적 계산
				dist(archer[i]);
			}
			move();
			// 이동 후에 적이 없으면
			if (count == 0) {
				break;
			}
		}
		if (answer < result) {
			answer = result;
		}
		result = 0; 
	}

	public static void dist(int pos) {
		int lowDist = Integer.MAX_VALUE;
		int x = -1;
		int y = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 1) {
					int temp = Math.abs(i - N) + Math.abs(j - pos);
					if (lowDist > temp) {
						lowDist = temp;
						x = i;
						y = j;
					} else if (lowDist == temp) {
						if (y > j) {
							lowDist = temp;
							x = i;
							y = j;
						}
					}
				}
			}
		}

		// 가장 짧은 거리로 선정된 적이 사정거리 이내면
		if (Math.abs(x - N) + Math.abs(y - pos) <= D) {
			isDead[x][y] = true;
		}
	}

	// 적 이동
	public static void move() {
		for (int i = 0; i < M; i++) {
			if (copyMap[N - 1][i] == 1) {
				count--;
			}
		}
		for (int i = N - 1; i >= 1; i--) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = copyMap[i - 1][j];
			}
		}
		for (int i = 0; i < M; i++) {
			copyMap[0][i] = 0;
		}
	}
} 



