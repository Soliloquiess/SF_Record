package com.algo6;

import java.util.Arrays;

public class PermutationTest {
	//3자리수 순열
	//3P3 = 3! = 6
	
	static int N =3, R =3; //nPr
	static int[] result, numbers; //뽑힌 숫자 담을 배열
	static boolean[] isSelected; //N개중 선택된 숫자 표시(true,false)배열
	
	public static void main(String[] args) {
		result = new int[R];//뽑을 수의 갯수만큼
		numbers = new int[N]; //전체 수의 갯수만큼
		
		for(int i = 0; i<numbers.length;i++) {
			numbers[i]= i+1;
		}
		isSelected = new boolean[N];
		permutation(0);//뽑은 숫자 개수
	}
	
	//현재까지 뽑힌 숫자 갯수를 입력받아 체크하고
	//아직까지 뽑아야 하는 숫자가 남았으면 뽑기
	public static void permutation(int cnt) {
		if(cnt ==R) {	//다 뽑았으면
			System.out.println(Arrays.toString(result));//결과출력
			return;
		}
		for(int i =0; i<N;i++) {// 모든 숫자를 대상으로 작업
			if(!isSelected[i]) {	//뽑히지 않았다면
				isSelected[i] = true;//i번쨰 숫자 사용할거야
				result[i] = numbers[i];
				
				permutation(cnt+1);	//다음 위체에 넣을 값 뽑으러 보냄
				isSelected[i] = false; //i번째 숫자가 숫자를 바꿔서 다시 뽑힐 수 있도록 바꿔줘야 함
				
			}
		}
	}
}
