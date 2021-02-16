package SWEA;


import java.io.*;
import java.util.*;
public class SWEA_1861_∆€∆Â∆Æ_º≈«√ {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            System.out.print("#" + tc + " ");
            int N = sc.nextInt();
            String[] deck = new String[N];
            for(int i=0; i<N; i++) {
                deck[i] = sc.next();
            }
            int half = N/2;
            int remain = N%2;
            for(int i=0; i<half; i++) {
                System.out.print( deck[i] + " " + deck[remain+half+i] + " " );
            }
            if( remain > 0 ) System.out.print( deck[half] ); 
            System.out.println();
        }
        sc.close();
    }
}