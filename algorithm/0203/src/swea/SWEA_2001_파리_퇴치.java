package swea;

import java.util.*;

/*
 * 이 문제는 보자마자 완전 탐색으로 푸는게 가장 쉬워 보여서 완전탐색을 이용하였다.

 

map 2차원 배열에 값들을 저장시키고 m의 크기에 따라서 그 범위내에 있는 정사각형의 값들을 다 더해준다. 그리고 max 값을 비교해주면서 진행한다.
 */
public class SWEA_2001_파리_퇴치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int sum = 0;
                    for (int k = 0; k < M; k++) {
                        for (int p = 0; p < M; p++) {
                            sum += map[i + k][j + p];
                        }
                    }
                    if (max < sum)
                        max = sum;
                }
            }
            System.out.println("#" + t + " " + max);
        }
    }
}