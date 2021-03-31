package Jungol;

import java.util.Scanner;

public class Jungol_1681�ع��ϼ�ȯȸ�� {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int money=Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		map=new int[N][N];
		visited=new boolean[N];
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				map[i][j]=sc.nextInt();
			}
		}
		
		DFS(1,0,0); //cnt, ��ġ, ��
		System.out.println(money);
	}
	private static void DFS(int cnt, int location, int price) {
		
		if(cnt==N){
			if(map[location][0]!=0){ // ������ ���ư��� ����� ���� 0�̸� �� �� ����. 
				if(price+map[location][0] < money) money=price+map[location][0]; //������ ��� + price�Ѱ� money���� ������ �� ���� ��� ��°��̴�. 
			}
			
			return;
		}
		for(int i=1; i<N; i++){ //0�� �κ��� �ٽ� ������ ���� �ö� !! 1���� �����ϱ�. 
			if(visited[i]==false && map[location][i] != 0){
				if(map[location][i]+price < money){//��������� �������� �����ϱ�. 
					visited[location]=true;
					DFS(cnt+1, i, map[location][i]+price); //����� �����Ͽ� �Ѱ� �ֱ� 
					visited[i]=false;
				}
			}
		}
		
	}

}