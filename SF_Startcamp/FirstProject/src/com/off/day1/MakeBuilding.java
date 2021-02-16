package com.off.day1;

import java.util.Arrays;
import java.util.Scanner;

/* 0.테스트케이스 입력 받기(반복 작업)
 * 1.2차원 char배열(N*N) 생성
 * 2.배열에 값 입력(Scanner)한글자씩 입력 받아야 함
 * 3.입력 확인
 * 4.8방 탐색하기 위한 방향배열 생성(dx, dy)
 * 5.배열안의 값 접근해서 ~
 * 
 * 6.결과 출력(테스트 케이스 만큼)
 * */
public class MakeBuilding {
	static String src = 
			"3 6 G B G G B B G B G G B G B B B B G B B G B B B B G B B B B G G B B B B G 5 G B G G B G B G G B  B B B B G B G B B B G B B B B 3 G G B G B B B B B\r\n";
	
	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(src);
		int T = s.nextInt();//0. 테스트케이스 수. 3
		
		//4.8방 탐색 배열(상,하,좌,우,좌상, 우상, 좌하, 우하)
		int[] dx = {-1,1,0,0,-1,-1,1,1};
		int[] dy = {0,0,-1,1,-1,1,-1,1};
		
		for (int tc = 1; tc <= T; tc++) {
			int N = s.nextInt();//배열의 크기. 6
			
			//1.배열생성
			char[][] map = new char[N][N];//G, B 이런 글자가 들어 감
			//int[][] floor = new int[N][N];//각 B가 들어가는 칸의 빌딩 높이
			int max = 0;
			
			//2.입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = s.next().charAt(0); //"G", "B"
					//"hello".charAt(2);//'h'
				}
			}
			
			//3.입력확인
			//System.out.println(Arrays.deepToString(map));
						
			
			//5.각 값에 대해 빌딩인 경우에 작업
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//빌딩인 경우에만 작업
					if(map[i][j] == 'B') {
						
						//1.8방에 공원이 있나 체크
						boolean flag = false;
						for (int k = 0; k < 8; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];

							if (nx >= 0 && ny >= 0 && nx < N && ny < N) {//범위 안이라면
								if (map[nx][ny] == 'G') {
									flag = true;
									break;
								}
							}
						}//8방체크
												
						//2.공원이 있는 경우: 2층
						if(flag == true) {
							//최대 2층
							max = (max > 2) ? max : 2 ;
							
						}else {//3.공원이 없는 경우->가로세로방향 카운트
							int cnt = 0;
							
							for (int x = 0; x < N; x++) {// 3-1.세로방향 세기
								if (map[x][j] == 'B')
									cnt++;
							}

							for (int y = 0; y < N; y++) {// 3-2.가로방향세기
								if (map[i][y] == 'B')
									cnt++;
							}
							cnt--;// 중복값 빼주기
							max = (max < cnt)? cnt: max;							
						}						
					}								
				}				
			}			
 			
			System.out.println("#" + tc + " " + max);
		}
	}
	
	
}





