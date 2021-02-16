package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1233_사칙연산_유효성_검사 {
	static int[] visit;
	static int[][] edge;
	static String[] node;
	static int n;
	static Stack <Integer> st;
	static int flag;
	
	public static void op(String s) {
		if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			if(st.size() < 2) {
				flag = 0;
				return;
			}
			int a = st.pop();
			int b = st.pop();
			
			if(s.equals("+")) {
				st.push(b+a);
			}
			if(s.equals("-")) {
				st.push(b-a);
			}
			if(s.equals("*")) {
				st.push(b*a);
			}
			if(s.equals("/")) {
				if(a == 0) {
					a = 1;
				}
				st.push(b/a);
			}
		}
		else {
			st.push(Integer.parseInt(s));
		}
	}
	
	public static void dfs(int x) {
		if(flag == 0)
			return;
		visit[x] = 1;
		for(int i = 1; i <= n; i++) {
			if(edge[x][i] == 1 && visit[i] == 0) {
				dfs(i);
			}
		}
		op(node[x]);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			node = new String[n+1];
			edge = new int[n+1][n+1];
			visit = new int[n+1];
			st = new Stack<>();
			flag = 1;
			
			for(int i = 1; i <= n; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(tk.nextToken());
				node[i] = tk.nextToken();
				for(int j = 0; j < 2; j++) {
					if(tk.hasMoreTokens()) {
						int to = Integer.parseInt(tk.nextToken());
						edge[from][to] = 1;
					}
				}
			}
			dfs(1);
			if(st.size() < 1)
				flag = 0;

			System.out.println("#" + t + " " + flag);
		}
	}
}

/*

부모노드인지 단말노드인지 확인하는 방법은, hasMoreTokens으로 판별하였다.
2개의 문자를 받고, 그 뒤에 더 문자가 오면 왼쪽, 오른쪽 위치를 알리므로 부모노드인 것으로 생각하고 2개의 문자로 끝나면 단말 노드로 생각하였다.

이후 조건문을 사용하여 부모 노드 일때, 해당하는 문자가 숫자인 경우 유효성이 옳지 않으므로 isRight라는 변수를 통하여 유효성이 옳지 않은 tree라고 판별하였다.
마찬가지로, 단말 노드 일때, 해당하는 문자가 숫자가 아닌경우 유효성이 옳지 않다고 판별하였다.

코드Permalink
import java.io.*;
import java.util.*;

class Solution {
	static int result = 0;
	public static void main(String []args) throws Exception {  
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int tc = 10;
    	
    	for(int idx = 1; idx <= tc; idx++) {
    		int n = stoi(br.readLine());
    		int isRight = 1;
    		char curN;
    		for(int i = 1; i <= n; i++){
    			
    			st = new StringTokenizer(br.readLine());
    			st.nextToken();
    			curN = st.nextToken().charAt(0);
    			if(st.hasMoreTokens()) {	// 단말 노드가 아닐 때, 사칙 연산이 있어야한다.
    				if('0' <= curN && curN <= '9') {	// 숫자인 경우, 유효성이 옳지 않다
    					isRight= 0;
    				}
    			}
    			else {						// 단말 노드 일 때, 숫자가 있어야 한다.
    				if(curN < '0' || '9' < curN ) {		// 숫자가 아닌 경우, 유효성이 옳지 않다
    					isRight= 0;
    				}
    			}
    		}
    		
    		System.out.println("#" + idx + " " + isRight);
    	}
    	
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}

*/