package com.off.day1;

public class ArrayDirectionSum {

	public static void main(String[] args) {
		//배열 안 모든 값 출력하자.
		int [][] data=  
		{
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				
		};//사용할 배열
		
		//값 확인
		for (int  i =0; i<data.length;i++)
		{
			for(int j = 0; j<data[i].length;j++)
			{
				System.out.print(data[i][j] +" ");
			}
			System.out.println();
		}
		
		
		System.out.println();	//구분
		
		
		
		
		//상하좌우 방향 접근 시 사용할 인덱스 값(상,하,좌 ,우)
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		//int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}
		
		//모든 데이터의 상하좌우 값 출력
		for (int i = 0; i<data.length ;i++)
		{
			for(int j =0;j<data.length;j++) {
				//int value = data[i][j];//i,j는 현재 접근하고 있는 x,y값
						//4방 접근해서 그 값을 출력 
				int sum = 0; //4방 누적한 값.
				
				//4방 접근해서 그 값을 출력.
				
					for(int k = 0; k<4; k++)  //4방 접근
					{	
						//새로운 x,y좌표값 계산
						int nx = i+dx[k];//2+(-1)=>1
						int ny = j+dy[k];//2+0=>2
						
						//nx,ny가 배열 안의 값인지 체크 한 후 출력.
						if(nx>=0 && nx< data.length && ny >=0 && ny<data.length)
						{
							sum = sum + data[nx][ny];
//							System.out.print(data[nx][ny]+" ");	//1,2 출력
						}
					//4방 접근 for	
						
				}//if
					System.out.print(sum+" ");
			}//j
			System.out.println();
		}//i
	}
}


