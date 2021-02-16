package SWEA;


import java.util.*;

public class SWEA_5215_햄버거_다이어트 {
	static int n;
	static int m;
	static int[] a;
	static int[] b;
	static int max;
	
	public static void dfs(int x, int s, int k) {
		if(k > m) {
			return;
		}
		
		if(x == n) {
			max = Math.max(s, max);
		}
		else {
			dfs(x + 1, s + a[x], k + b[x]);
			dfs(x + 1, s, k);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			a = new int[n];
			b = new int[n];
			max = 0;
			
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			
			dfs(0, 0, 0);
			System.out.println("#" + t + " " + max);
		}
	}
}