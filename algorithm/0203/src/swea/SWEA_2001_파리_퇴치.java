package swea;

import java.util.*;

/*
 * �� ������ ���ڸ��� ���� Ž������ Ǫ�°� ���� ���� ������ ����Ž���� �̿��Ͽ���.

 

map 2���� �迭�� ������ �����Ű�� m�� ũ�⿡ ���� �� �������� �ִ� ���簢���� ������ �� �����ش�. �׸��� max ���� �����ָ鼭 �����Ѵ�.
 */
public class SWEA_2001_�ĸ�_��ġ {
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