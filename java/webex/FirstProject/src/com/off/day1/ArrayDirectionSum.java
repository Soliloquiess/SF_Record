package com.off.day1;

public class ArrayDirectionSum {

	public static void main(String[] args) {
		//�迭 �� ��� �� �������.
		int [][] data=  
		{
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				
		};//����� �迭
		
		//�� Ȯ��
		for (int  i =0; i<data.length;i++)
		{
			for(int j = 0; j<data[i].length;j++)
			{
				System.out.print(data[i][j] +" ");
			}
			System.out.println();
		}
		
		
		System.out.println();	//����
		
		
		
		
		//�����¿� ���� ���� �� ����� �ε��� ��(��,��,�� ,��)
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		//int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}
		
		//��� �������� �����¿� �� ���
		for (int i = 0; i<data.length ;i++)
		{
			for(int j =0;j<data.length;j++) {
				//int value = data[i][j];//i,j�� ���� �����ϰ� �ִ� x,y��
						//4�� �����ؼ� �� ���� ��� 
				int sum = 0; //4�� ������ ��.
				
				//4�� �����ؼ� �� ���� ���.
				
					for(int k = 0; k<4; k++)  //4�� ����
					{	
						//���ο� x,y��ǥ�� ���
						int nx = i+dx[k];//2+(-1)=>1
						int ny = j+dy[k];//2+0=>2
						
						//nx,ny�� �迭 ���� ������ üũ �� �� ���.
						if(nx>=0 && nx< data.length && ny >=0 && ny<data.length)
						{
							sum = sum + data[nx][ny];
//							System.out.print(data[nx][ny]+" ");	//1,2 ���
						}
					//4�� ���� for	
						
				}//if
					System.out.print(sum+" ");
			}//j
			System.out.println();
		}//i
	}
}


