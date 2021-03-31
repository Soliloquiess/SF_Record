package lecture;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Swea_1225 {
 
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k=0;k<10;k++) {
             
            int tc = Integer.parseInt(br.readLine());
            sb.append("#"+tc+" ");
             
            Queue<Integer> que = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<8;i++) {
                que.offer(Integer.parseInt(st.nextToken()));
            }
            int cnt=1;
            while(true) {
                int num = que.poll();
                num-=cnt++;
                 
                if(cnt==6) cnt=1;
                 
                if(num<=0) {
                    que.offer(0);
                    break;
                }else {
                    que.offer(num);
                }
//              System.out.println(que.toString());
            }
            while(!que.isEmpty()) {
                sb.append(que.poll()+" ");
            }
            sb.append("\n");
             
        }
        System.out.println(sb);
    }
 
}