package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {

	/*
	 5 17
어렵지는 않았는데 BFS, DFS가 가끔 헷갈린다.
BFS는 Queue로 구현하고
DFS는 재귀로 구현한다!
그리고 처음에 N과 K가 같을 때를 처리하지 않아서 틀렸었다.
아 그리고 next값을 *2 할 때 멍충하게 +N으로 해서 틀렸다. 😷

수빈이의 위치가 N(0 ≤ N ≤ 100,000), 동생은 K(0 ≤ K ≤ 100,000)에 위치하고 있다. 수빈이는 자신의 위치에서 N+1, N-1, N*2 만큼 이동할 수 있는데, 이때 수빈이가 동생을 찾을 수 있는 가장 빠른 시간을 구해 출력하면 되는 문제이다.

풀이
최단거리 문제와 유사해 BFS로 풀이했다.
이미 방문했던 숫자를 체크하기 위해 check 배열을 100,001개로 초기화하고 최소 시간을 기록하기 위해 이전 위치에서의 시간 + 1을 배열에 넣어줬다.

큐에 해당 위치를 넣어주고 check[현재위치]의 값을 1로 변경한다.
큐가 비지않을 동안 while문을 돌면서 다음에 갈 위치(next)를 변경한다.
next가 범위안에 있고 이전에 방문한 이력이 없으면 큐에 넣어준다.
BFS를 수행하기 전에 N과 K가 같을 때 0으로 출력해줘야함을 처리해야한다.
	 */
	public static int MAX = 100001;
	public static int n, k;
	public static int[] data = new int[MAX];

	// 너비 우선 탐색(BFS)
	public static int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == k) return data[now];
			int next = now - 1;
			if (0 <= next && next < MAX && data[next] == 0) {
				data[next] = data[now] + 1;
				q.add(next);
			}
			next = now + 1;
			if (0 <= next && next < MAX && data[next] == 0) {
				data[next] = data[now] + 1;
				q.add(next);
			}
			next = now * 2;
			if (0 <= next && next < MAX && data[next] == 0) {
				data[next] = data[now] + 1;
				q.add(next);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();
		
		System.out.println(bfs());
	}

}




/*
 import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {
    static int N;
    static int K;
    static int[] check = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(check[temp]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}
 */
