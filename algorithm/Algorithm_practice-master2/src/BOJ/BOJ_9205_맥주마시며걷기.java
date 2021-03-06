package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9205_���ָ��ø�ȱ� {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int N=sc.nextInt();
			int[][] location=new int[2][N+2];
			int[][] graph=new int[N+2][N+2];
			
			for(int i=0;i<N+2;i++) {
				location[0][i]=sc.nextInt();
				location[1][i]=sc.nextInt();
			}
			
			int total=0;
			for(int i=0;i<N+2;i++) {
				for(int j=0;j<N+2;j++) {
					total=0;
					total+=Math.abs(location[0][i]-location[0][j]);
					total+=Math.abs(location[1][i]-location[1][j]);
					if(total<=1000) {
						graph[i][j]=1;
						graph[j][i]=1;
					}
				}
			}
			boolean[] visited=new boolean[N+2];
			visited[0]=true;
			Queue<Integer> q=new LinkedList();
			q.add(0);
			while(!q.isEmpty()) {
				int check=q.poll();
				for(int i=0;i<N+2;i++) {
					if(graph[check][i]==1) {
						if(!visited[i]) {
							visited[i]=true;
							q.add(i);
						}
					}
				}
			}
			
			if(visited[N+1]) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
		}
	}
}
