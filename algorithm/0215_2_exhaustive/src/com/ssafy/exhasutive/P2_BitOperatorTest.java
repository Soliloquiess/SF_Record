package com.ssafy.exhasutive;

public class P2_BitOperatorTest {
	public static void main(String[] args) {
		int k = 0xa5; //1010 0101 
		//16������ 1010�� ���ĺ� a, 0101�� 5
		//k ��Ʈ���� ���� �� �����ʿ��� 1��ŭ ������ ��Ʈ Ȯ��
		System.out.println(k & 1<<1);
		//k��Ʈ�� ���� �� �����ʿ��� 2��ŭ ������ ��Ʈ Ȯ��
		System.out.println((k&1<<2)+"//"+Integer.toBinaryString(k&1<<2));
		//k��Ʈ���� �����ʿ��� 1��ŭ ������ �ڸ� ��Ʈ 1��Ʈ�� �����
		System.out.println((k|1<<1)+"//"+Integer.toBinaryString(k|1<<2));
	}
}
