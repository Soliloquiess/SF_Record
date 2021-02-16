package SWEA;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
//    static int N, M, R, S;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
       	int turn  = Math.min(a, b) / 2;	
        map = new int[a][b];
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int q = 0; q < turn; q++) {
            for (int w = 0; w < c; w++) {

                int bottom = a - q - 1;		
                int right = b - q - 1;

                int temp = map[q][q];
                for (int i = q; i < right; i++) {
                    map[q][i] = map[q][i + 1];
                }
                for (int i = q; i < bottom; i++) {
                    map[i][right] = map[i + 1][right];
                }
                for (int i = right; i > q; i--) {
                    map[bottom][i] = map[bottom][i - 1];
                }
                for (int i = bottom; i > q; i--) {
                    map[i][q] = map[i - 1][q];
                }
                map[q + 1][q] = temp;
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}