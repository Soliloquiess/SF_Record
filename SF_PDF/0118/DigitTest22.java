package com.ssafy.ws01.step3;

public class DigitTest22 {

	public static void main(String[] args) {
		int num = 0;
		int change = 5/2; //2 중간
		int skip = -1;//띄울 칸수
		
		for (int i = 0; i < 5; i++) {
			if(i <= change) {//0~2. 위~중간지점까지는 점점 줄어들어야 함
				skip++;
				for(int b = 0; b < skip; ++b) {	// 1.숫자 앞쪽 공백 출력 부분
					System.out.printf("%3s"," ");	// 3칸의 너비로 공백 출력						
				}
				
				for (int j = i; j < 5 - i; j++) {//2.숫자 출력
					System.out.printf("%3d", ++num);
					
				}
				System.out.println();
				
			}else {//3~4
				skip--;				
				for(int b = 0; b < skip; ++b) {	// 1.숫자 앞쪽 공백 출력 부분
					System.out.printf("%3s"," ");	// 3칸의 너비로 공백 출력	
				}
				
				for (int j = skip; j < 5 - skip; j++) {//2.숫자 출력
					System.out.printf("%3d", ++num);					
				}
				System.out.println();
			}			
		}
		

	}

}
