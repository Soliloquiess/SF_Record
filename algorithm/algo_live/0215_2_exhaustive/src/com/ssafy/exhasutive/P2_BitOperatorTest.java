package com.ssafy.exhasutive;
/**
 * @author THKim
 */
public class P2_BitOperatorTest {

	public static void main(String[] args) {

		int k = 0xa5;  // 1010 0101
		// k 비트열의 상태중 오른쪽에서 1만큼 떨어진 비트 확인
		System.out.println(k & 1<<1);
		// k 비트열의 상태중 오른쪽에서 2만큼 떨어진 비트 확인
		System.out.println((k & 1<<2)+"//"
				+Integer.toBinaryString(k & 1<<2));
		
		// k비트열의 오른쪽에서 1만큼 떨어진 자리 1비트로 만들기
		System.out.println((k | 1<<1)+"//"
				+Integer.toBinaryString(k | 1<<1));
		
	}

}
