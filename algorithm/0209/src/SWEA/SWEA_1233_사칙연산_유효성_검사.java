package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1233_��Ģ����_��ȿ��_�˻� {
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

�θ������� �ܸ�������� Ȯ���ϴ� �����, hasMoreTokens���� �Ǻ��Ͽ���.
2���� ���ڸ� �ް�, �� �ڿ� �� ���ڰ� ���� ����, ������ ��ġ�� �˸��Ƿ� �θ����� ������ �����ϰ� 2���� ���ڷ� ������ �ܸ� ���� �����Ͽ���.

���� ���ǹ��� ����Ͽ� �θ� ��� �϶�, �ش��ϴ� ���ڰ� ������ ��� ��ȿ���� ���� �����Ƿ� isRight��� ������ ���Ͽ� ��ȿ���� ���� ���� tree��� �Ǻ��Ͽ���.
����������, �ܸ� ��� �϶�, �ش��ϴ� ���ڰ� ���ڰ� �ƴѰ�� ��ȿ���� ���� �ʴٰ� �Ǻ��Ͽ���.

�ڵ�Permalink
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
    			if(st.hasMoreTokens()) {	// �ܸ� ��尡 �ƴ� ��, ��Ģ ������ �־���Ѵ�.
    				if('0' <= curN && curN <= '9') {	// ������ ���, ��ȿ���� ���� �ʴ�
    					isRight= 0;
    				}
    			}
    			else {						// �ܸ� ��� �� ��, ���ڰ� �־�� �Ѵ�.
    				if(curN < '0' || '9' < curN ) {		// ���ڰ� �ƴ� ���, ��ȿ���� ���� �ʴ�
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