package swea;

import java.util.Scanner;

public class SWEA_2805_농작물_수확하기  {
  
    public static int N;
 
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
 
        int TC = sc.nextInt();
        int[][] area;
        for (int t = 1; t <= TC; t++) {
            N = sc.nextInt();
            area = new int[N][N];
             
            //입력
            for (int i = 0; i < area.length; i++) {
                String str = sc.next();
                char[] arr_char = str.toCharArray();
                for (int j = 0; j < area.length; j++) {
                    area[i][j] = arr_char[j]-'0';
                }
            }
             
            int sum = 0;
             
             
            for (int i = 0; i < area.length; i++) {
                for (int j = Math.abs(N/2-i); j < N-Math.abs(N/2-i); j++) {
                    sum += area[i][j];
                }
            }
             
             
//          for (int i = 0; i < map.length; i++) {
//              for (int j = 0; j < map.length; j++) {
//                  System.out.print(map[i][j]);
//              }
//              System.out.println();
//          }
             
            System.out.printf("#%d %d\n",t,sum);
             
             
        }
    }
 
}