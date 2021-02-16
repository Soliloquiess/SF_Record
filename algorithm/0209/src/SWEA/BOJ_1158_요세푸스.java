package SWEA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1158_¿ä¼¼Çª½º {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=1; i<=a; i++) {
            queue.offer(i);
        }
        for (int i=0; i<a-1; i++) {
            for (int j=0; j<b-1; j++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }
        sb.append(queue.poll() + ">");
        System.out.println(sb);
    }
}