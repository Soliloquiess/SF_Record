package lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo3 {
	static int N, M, result = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//관리자가 사용 가능한 패스워드 최대값(0<=N<=1000)
		M = Integer.parseInt(br.readLine());//해커가 사용한 패스워드 갯수
		
		int[] attack = new int[M];//해커가 사용한 패스워드 저장 배열
		StringTokenizer st = new StringTokenizer(br.readLine());//해커가 사용한 패스워드들
		
		for (int i = 0; i < M; i++) {
			attack[i] = Integer.parseInt(st.nextToken());//해커가 시도한 패스워드 저장
		}
	
		//사용 가능한 패스워드 후보와 해커가 사용한 패스워드를 비교하면서 안전거리 계산하기(min)
		for (int i = 0; i < N; i++) {//가능한 패스워드 범위
			int safeDistance = Integer.MAX_VALUE;//안전거리
			
			for (int j = 0; j < attack.length; j++) {//안전거리 계산
				int tmp = 0; //결과. 서로 다른 비트 수 기록한 변수
				tmp = countDiffBit(i, attack[j]);				
				safeDistance = Math.min(safeDistance, tmp);				
			}
			
			result = Math.max(safeDistance, result);			
		}
			System.out.println(result);		
	}

	//패스워드 후보와 해커가 사용한 패스워드를 비교하면서 안전거리 계산하기(min)
	private static int countDiffBit(int admin, int hacker) {
		//^(xor):exclusive or
		int tmp = admin ^ hacker;///서로 다른 비트만 1로 나옴
		int cnt = 0;
		//xor한 결과를 이진수 문자열 변환 -> char[]
		char[] s = Integer.toBinaryString(tmp).toCharArray();
		for (int i = 0; i < s.length; i++) {
			if(s[i] == '1')
				cnt++;
		}
		return cnt;
	}

}
