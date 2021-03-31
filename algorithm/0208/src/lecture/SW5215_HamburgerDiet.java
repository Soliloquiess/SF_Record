package lecture;

import java.util.Scanner;

public class SW5215_HamburgerDiet {
	static int R[][], maxCal;//R[][]:각재료별 점수와 칼로리 저장할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//tc no
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();//재료 갯수
			maxCal = sc.nextInt();//제한 열량
			
			R = new int[N][2];//[0]맛에 대한 점수, [1]칼로리
			for (int i = 0; i < N; i++) {
				R[i][0] = sc.nextInt();//점수
				R[i][1] = sc.nextInt();//칼로리
			}
			
			//각 재료별 조합을 만들어 그때의 맛점수가 최고인 것 찾기
			int idx = 0;//조합할 재료 번호
			int score = 0;//맛점수. 재료를 선택해 나갈 때마다 올라감.
			
			int max = find(idx, score, maxCal);
			System.out.println("#" + tc + " " + max);			
		}//for
	}//main

	//idx번째 재료를 고려해서(넣을수도 있고 뺄수도 있다) 조합을 만들었을 때 
	//칼로리 체크 후 맛점수 리턴하는 함수 
	//idx:사용할 재료 번호, score: idx번째 재료를 고려했을때의 맛점수, remain:남아있는 사용 가능 칼로리
	private static int find(int idx, int score, int remain) {
		if(remain < 0) {//조합 성립 안됨
			return 0;
		}
		if(remain == 0) {//제한 열량 안에서 조합 완성
			return score;//그 시점의 맛점수 리턴
		}
		if(idx == R.length) {//모든 재료를 조합 만드는데 다 사용
			return score;//그 시점의 맛점수 리턴
		}		
		
		//idx번째 재료를 사용하지 않한 경우
		int v1 = find(idx+1, score, remain);//그다음 재료로 
		
		//idx번째 재료를 사용한 경우-맛점수와 열량을 조정하고 다음 재료로 감
		//R[idx][0]: idx번째 재료의 맛점수. R[idx][1]: idx번째 재료의 칼로리
		int v2 = find(idx+1, score + R[idx][0], remain - R[idx][1] );
		
		return Math.max(v1,  v2);
	}
	
	
	
}
