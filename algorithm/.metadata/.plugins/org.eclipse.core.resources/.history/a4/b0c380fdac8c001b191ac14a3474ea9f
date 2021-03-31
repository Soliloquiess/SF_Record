package BOJ;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1600_¸»ÀÌµÇ°íÇÂ¿ø¼þÀÌ
{
	static int K,N,M,result;
	static int map[][];
	static boolean visit[][][];
	static int count[][];
	static boolean isEnd;
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[N][M];
		visit = new boolean[N][M][K+1];
		count = new int[N][M];
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++ )
			{
				map[i][j] = sc.nextInt(); 
			}
		}
		
		result = bfs();
		System.out.println(result);
	}
	
	public static int bfs()
	{
		Queue<Monkey> queMonkey = new LinkedList<Monkey>();
		queMonkey.add(new Monkey(0,0,K));
		visit[0][0][K] = true;
		
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		int ddx[] = {1,2,2,1,-1,-2,-2,-1};
		int ddy[] = {2,1,-1,-2,-2,-1,1,2};
		
		while(!queMonkey.isEmpty())
		{
			Monkey m = queMonkey.poll();
			
			if(m.x==(N-1) && m.y==(M-1))
			{
				return count[m.x][m.y];
			} 
			
			for(int i = 0; i<4; i++)
			{
				int tx = m.x+dx[i];
				int ty = m.y+dy[i];
				int useYn = m.useYn;
				
				if(tx<0 || ty<0 || tx>=N || ty>=M || visit[tx][ty][useYn]==true)
				{
					continue;
				}
				
				if(map[tx][ty] == 1)
				{
					continue;
				}
				
				visit[tx][ty][useYn] = true;
				count[tx][ty] = count[m.x][m.y]+1;
				Monkey newMon = new Monkey(tx,ty,useYn);
				queMonkey.offer(newMon);
				//queMonkey.add(new Monkey(tx,ty,useYn));
			}
			
			if(m.useYn>0)
			{
				for(int i = 0; i<8; i++)
				{
					int tx = m.x+ddx[i];
					int ty = m.y+ddy[i];
					int useYn = m.useYn-1;
				
					
					if(map[tx][ty] == 1)
					{
						continue;
					}
					
				}
			}
		}
		return -1;
	}
}

class Monkey
{
	int x,y,useYn;
	
	Monkey(int x, int y, int useYn)
	{
		this.x = x;
		this.y = y;
		this.useYn = useYn;
	}
}