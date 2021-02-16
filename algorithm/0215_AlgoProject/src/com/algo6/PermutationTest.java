package com.algo6;

import java.util.Arrays;

public class PermutationTest {
	//3�ڸ��� ����
	//3P3 = 3! = 6
	
	static int N =3, R =3; //nPr
	static int[] result, numbers; //���� ���� ���� �迭
	static boolean[] isSelected; //N���� ���õ� ���� ǥ��(true,false)�迭
	
	public static void main(String[] args) {
		result = new int[R];//���� ���� ������ŭ
		numbers = new int[N]; //��ü ���� ������ŭ
		
		for(int i = 0; i<numbers.length;i++) {
			numbers[i]= i+1;
		}
		isSelected = new boolean[N];
		permutation(0);//���� ���� ����
	}
	
	//������� ���� ���� ������ �Է¹޾� üũ�ϰ�
	//�������� �̾ƾ� �ϴ� ���ڰ� �������� �̱�
	public static void permutation(int cnt) {
		if(cnt ==R) {	//�� �̾�����
			System.out.println(Arrays.toString(result));//������
			return;
		}
		for(int i =0; i<N;i++) {// ��� ���ڸ� ������� �۾�
			if(!isSelected[i]) {	//������ �ʾҴٸ�
				isSelected[i] = true;//i���� ���� ����Ұž�
				result[i] = numbers[i];
				
				permutation(cnt+1);	//���� ��ü�� ���� �� ������ ����
				isSelected[i] = false; //i��° ���ڰ� ���ڸ� �ٲ㼭 �ٽ� ���� �� �ֵ��� �ٲ���� ��
				
			}
		}
	}
}
