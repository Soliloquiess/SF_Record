package com.off.day1;

import java.util.Arrays;
import java.util.Scanner;

/* 0.�׽�Ʈ���̽� �Է� �ޱ�(�ݺ� �۾�)
 * 1.2���� char�迭(N*N) ����
 * 2.�迭�� �� �Է�(Scanner)�ѱ��ھ� �Է� �޾ƾ� ��
 * 3.�Է� Ȯ��
 * 4.8�� Ž���ϱ� ���� ����迭 ����(dx, dy)
 * 5.�迭���� �� �����ؼ� ~
 * 
 * 6.��� ���(�׽�Ʈ ���̽� ��ŭ)
 * */
public class MakeBuilding {
	static String src = 
			"3 6 G B G G B B G B G G B G B B B B G B B G B B B B G B B B B G G B B B B G 5 G B G G B G B G G B  B B B B G B G B B B G B B B B 3 G G B G B B B B B\r\n";
	
	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(src);
		int T = s.nextInt();//0. �׽�Ʈ���̽� ��. 3
		
		//4.8�� Ž�� �迭(��,��,��,��,�»�, ���, ����, ����)
		int[] dx = {-1,1,0,0,-1,-1,1,1};
		int[] dy = {0,0,-1,1,-1,1,-1,1};
		
		for (int tc = 1; tc <= T; tc++) {
			int N = s.nextInt();//�迭�� ũ��. 6
			
			//1.�迭����
			char[][] map = new char[N][N];//G, B �̷� ���ڰ� ��� ��
			//int[][] floor = new int[N][N];//�� B�� ���� ĭ�� ���� ����
			int max = 0;
			
			//2.�Է�
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = s.next().charAt(0); //"G", "B"
					//"hello".charAt(2);//'h'
				}
			}
			
			//3.�Է�Ȯ��
			//System.out.println(Arrays.deepToString(map));
						
			
			//5.�� ���� ���� ������ ��쿡 �۾�
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//������ ��쿡�� �۾�
					if(map[i][j] == 'B') {
						
						//1.8�濡 ������ �ֳ� üũ
						boolean flag = false;
						for (int k = 0; k < 8; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];

							if (nx >= 0 && ny >= 0 && nx < N && ny < N) {//���� ���̶��
								if (map[nx][ny] == 'G') {
									flag = true;
									break;
								}
							}
						}//8��üũ
												
						//2.������ �ִ� ���: 2��
						if(flag == true) {
							//�ִ� 2��
							max = (max > 2) ? max : 2 ;
							
						}else {//3.������ ���� ���->���μ��ι��� ī��Ʈ
							int cnt = 0;
							
							for (int x = 0; x < N; x++) {// 3-1.���ι��� ����
								if (map[x][j] == 'B')
									cnt++;
							}

							for (int y = 0; y < N; y++) {// 3-2.���ι��⼼��
								if (map[i][y] == 'B')
									cnt++;
							}
							cnt--;// �ߺ��� ���ֱ�
							max = (max < cnt)? cnt: max;							
						}						
					}								
				}				
			}			
 			
			System.out.println("#" + tc + " " + max);
		}
	}
	
	
}





