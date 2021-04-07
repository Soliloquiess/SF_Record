package extra.s3.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.file.FileVisitResult;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 3. 15.
 * @see
 * @mem 
 * @time
 * @caution [고려사항] [입력사항] [출력사항]
 */
public class BJ_G5_20056_마법사상어와파이어볼 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, M, K;
	static Queue<FireBall> queue;
	// fireball의 merge를 위해 위치 파악
	static FireBall[][] map;
	// 이동 방향 정의
	static int[][] deltas = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static int[] deltaSetA = { 0, 2, 4, 6 }, deltaSetB = { 1, 3, 5, 7 };

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		// fireball을 관리한다.
		queue = new LinkedList<>();
		map = new FireBall[N + 1][N + 1];
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int fr = Integer.parseInt(tokens.nextToken());
			int fc = Integer.parseInt(tokens.nextToken());
			int fm = Integer.parseInt(tokens.nextToken());
			int fs = Integer.parseInt(tokens.nextToken());
			int fd = Integer.parseInt(tokens.nextToken());
			
			queue.offer(new FireBall(fr, fc, fm, fs, fd));
		}
		// 초기 fireball 정보
		// System.out.println(queue);
		// 입력 완료

		while (!queue.isEmpty()) {
			// 명령이 남아있지 않으면 그만~~
			if (K == 0) {
				break;
			}

			// 단계별로 fireball 이동시키기.
			int size = queue.size();
			while (size-- > 0) {
				// 맨 앞에 녀석 가져오기
				FireBall front = queue.poll();

				// 사용하기
				front.move();
				
				// 이동 후 가는 지점이 비어있다면.. 내가 자리잡기.
				if (map[front.r][front.c] == null) {
					map[front.r][front.c] = front;
				}
				// 다른 녀석이 선점하고 있었어.. --> 그럼 합치기.
				else {
					map[front.r][front.c].merge(front);
				}
			} // 이동 완료!!!!

			// merge된 녀석들을 분리해보자
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					if (map[r][c] != null) {
						FireBall fb = map[r][c]; // 이놈이 이동할 계획임
						map[r][c] = null;// 지점 정리
						// 다른 녀석과 합쳐진 녀석 --> 4개로 분리됨.
						if (fb.mergeCnt > 1) {
							int newMess = fb.m/5;
							if(newMess==0) {
								continue;
							}
							int newSpeed = fb.s/fb.mergeCnt;
							
							int [] deltaSet = fb.allSameDir? deltaSetA: deltaSetB;
							for(int d=0; d<deltaSet.length; d++) {
								queue.offer(new FireBall(fb.r, fb.c, newMess, newSpeed, deltaSet[d]));
							}
						} 
						// 합쳐지지 않은 녀석은 그냥 가기
						else {
							queue.offer(fb);
						}
					}
				}
			}// merge 처리 완료
			K--;
		}// 모든 이동 완료
		int mSum = 0;
		while(!queue.isEmpty()) {
			mSum+=queue.poll().m;
		}
		System.out.println(mSum);
	}

	static class FireBall {
		int r, c, m, s, d;
		int mergeCnt = 1;// 몇개가 합쳐진거니?
		boolean allSameDir = true; // 합쳐질 때 모두 짝수 또는 모두 홀수?

		public FireBall(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		// fireball은 해당 방향으로 지정 속도만큼 이동한다. 1과 N은 연결되어있다.
		public void move() {
            /*
            
            for(int i=0; i<s; i++) {
                this.r+=deltas[d][0];
                if(this.r>N) {
                    this.r=1;
                }else if(this.r<1) {
                    this.r=N;
                }
                this.c+=deltas[d][1];
                if(this.c>N) {
                    this.c=1;
                }else if(this.c<1) {
                    this.c=N;
                }
            }*/
			// +N을 하는 이유는 %의 결과가 음수일 때를 대비해서에요.
			this.r = (this.r + (deltas[d][0] * s) % N + N) % N;
			this.c = (this.c + (deltas[d][1] * s) % N + N) % N;
		}

		// fireball은 합쳐질 수 있다.
		public void merge(FireBall other) {
			// 중량: 더해진다.
			this.m += other.m;
			// 속도: 더해진다.
			this.s += other.s;
			// mergeCnt
			mergeCnt++;
			// 방향 - 중간에 한번이라도 달라지면 다른거임
			if (allSameDir && (this.d % 2 != other.d % 2)) {
				allSameDir = false;
			}

		}

		@Override
		public String toString() {
			return "FireBall [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}

	}

	private static String src = "7 5 3\r\n" + 
			"1 3 5 2 4\r\n" + 
			"2 3 5 2 6\r\n" + 
			"5 2 9 1 7\r\n" + 
			"6 2 1 3 5\r\n" + 
			"4 4 2 4 2";
}
