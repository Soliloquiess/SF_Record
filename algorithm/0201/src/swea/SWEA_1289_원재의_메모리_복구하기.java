package swea;

import java.util.Scanner;
import java.io.FileInputStream;
 
class SWEA_1289_원재의_메모리_복구하기 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next();
            int cnt = 0;
             
            for(int i=0; i<str.length(); i++) {
                if(i==0) {
                    if(str.charAt(i) == '1') cnt++;
                } else {
                    if(str.charAt(i) != str.charAt(i-1)) cnt++;
                }
            }
            System.out.printf("#%d %d\n",test_case,cnt);
        }
         
    }
}