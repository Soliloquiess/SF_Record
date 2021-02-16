package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class SWEA_1225_암호생성기 {
 
public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> res_list = new ArrayList<>();
         
        for(int t=1; t<=10; t++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
             
            for(int i=0; i<8; i++) {
                int number =Integer.parseInt(st.nextToken());
                list.add(number);
                 
            }
             
            int minus = 1;
             
            while( true ) {
                if(minus==6) {
                    minus = 1;
                }
                int a = list.get(0)-minus;
                minus++;
                list.add(a);
                list.remove(0);
                 
                if(list.get(7) <=0) {
                    list.set(7, 0);
                    break;
                }
            }
 
            System.out.print("#"+t+" ");
            for(int k=0; k<8; k++) {
                System.out.print(list.get(k)+" ");
            }
            System.out.println();
        }
         
 
    }
 
}