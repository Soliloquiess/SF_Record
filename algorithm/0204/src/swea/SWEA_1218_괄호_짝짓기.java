package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_°ýÈ£_Â¦Áþ±â {
	
	    public static void main(String args[]) throws Exception
	    {
	        Scanner sc = new Scanner(System.in);
	       
	        for(int tc = 1; tc <= 10; tc++)
	        {
	            int N = sc.nextInt();
	            sc.nextLine();
	            char[] arr = sc.nextLine().toCharArray();
	            Stack<Character> stack = new Stack<Character>();
	             
	            for(int i=0; i<N; i++) {
	                if(arr[i]=='{' || arr[i]=='(' || arr[i]=='[' || arr[i]=='<')
	                    stack.push(arr[i]);
	                else {
	                    if(arr[i]=='}' && stack.peek()=='{')
	                        stack.pop();
	                    else if(arr[i]==']' && stack.peek()=='[')
	                        stack.pop();
	                    else if(arr[i]==')' && stack.peek()=='(')
	                        stack.pop();
	                    else if(arr[i]=='>' && stack.peek()=='<')
	                        stack.pop();
	                    else
	                        stack.push(arr[i]);
	                }
	            }
	            if(stack.size()==0)
	                System.out.println("#"+tc+" 1");
	            else
	                System.out.println("#"+tc+" 0");
	        }
	    }
	}