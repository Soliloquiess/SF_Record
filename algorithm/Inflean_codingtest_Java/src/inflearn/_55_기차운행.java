package inflearn;
/*55. 기차 운행(스택 자료구조 응용)*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

public class _55_기차운행
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
//        System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] s = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            s[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        String str = "";
        int j = 0;
        for(int i = 0;i<n;i++){
            stack.push(s[i]);
            str += "P";
            while(!stack.empty()){
                if(j+1 == stack.peek()){
                    j++;
                    stack.pop();
                    str += "O";
                }else{
                    break;
                }
            }
            
        }

        if(!stack.empty()) {System.out.println("impossible");
        }else{
            System.out.println(str);
        }


    }
}
           
