package com.ssafy.algo;

import java.util.Scanner;
public class Solution22{
	static int N;//�迭 ũ��
    static int[][] map; //�迭 ����
    
    static boolean inRange(int nx, int ny) {
        if(nx>=0 && nx<N && ny>=0 && ny<N) { //x , y ���� �� ���� 
            return true;
        }else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt(); //N �Է¹ް�
        map=new int[N][N]; //map �迭 ����
        
        int x=sc.nextInt(); //�������� �Ǵ� x��ǥ
        int y=sc.nextInt(); //�������� �Ǵ� y��ǥ
        
        int dx[] = { -1, 1, 0, 0 };  //x��ǥ
        int dy[] = { 0, 0, 1, -1 };  //y��ǥ
        
        for(int i=0; i<dx.length; i++) {
            int nx= x+dx[i];
            int ny= y+dy[i];
            if(inRange(nx,ny)) { //���� ���� 
                map[nx][ny]=1; // ������ true �� 1�� ���� �ƴϸ� ���Ѵ�. 
            }
        }
        /// ó�� �ڵ� �ۼ�
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
