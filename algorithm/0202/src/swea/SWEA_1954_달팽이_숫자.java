package swea;

import java.util.Scanner;

public class SWEA_1954_달팽이_숫자 {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int answer = 1;
		
		// 테스트케이스(T)의 수 동안 반복
		for(int k=0; k<T; k++) {
			
			// 각 케이스별 배열, 변수 초기화
			int N = scan.nextInt();
			int [][]arr = new int[N][N];
			int col = 0;	// 행
			int row = -1;	// 열
			int flag = 1;	// 위치 조정(1, -1)
			int number = 1;	// 값 넣기
			int count = N;	// 각 열당 숫자가 N, N-1, N-1, N-2, N-2, ... 로 감소
			System.out.println("#" + answer);
			answer +=1;
			while(true) {
				
				// -> , <- 방향
				for(int i=0; i<N; i++) {
					row += flag;	// 열 증가
					arr[col][row] = number;
					number += 1;	// 숫자 1씩 증가
				}
				
				// ->, <-이 끝난 후 개수가 하나씩 감소
				N -= 1;
				if(N == 0)	break;	// 달팽이 알고리즘의 종료 조건
				
				// ↓ , ↑ 방향
				for(int i=0; i<N; i++) {
					col += flag;
					arr[col][row] = number;
					number +=1;
				}
				flag *= (-1);	// -> , ↓ 이 끝난 후에는 열, 행이 감소해야 함 
			}
			
			for(int i=0; i<count; i++) {
				for(int j=0; j<count; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		
		
		scan.close();
		
	}

}