package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class DP_ListTest2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//������ ����
		int [] arr = new int[N];//���ҵ� ����, ������ ��
		int[] LIS = new int[N]; //�� ���Ҹ� �������� ������ ���� �������
		
		for(int i =0; i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		int size= 0;
		for(int i =0; i<N;i++) {
				//3�� �� ÷�� ���°� �״��� 0��° ���� ��,
			//binarySearch(int [] a, int fromIndex(in), int toIndex(ex), int key)
			int temp = Arrays.binarySearch(LIS, 0,size,arr[i]); //���ϰ�:-insertPoint -1
//			System.out.println(arr[i] + ":" + temp);
		}
		
		temp = Math.abs(temp)-1;//������ġ
		System.out.println("after"+temp);
		
		LIS[temp] = arr[i];
		
		if(size==temp) {	//������ġ�� �ε����� ũ�Ⱑ ������ �ᱹ �������� ������ġ��� ���
			size++;
		}
		/*������ ������ */
//		int size = 0;
//		for(int i = 0; i<N; i++) {
//			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);	//���ϰ�: -insertPoint -1
//			
//			temp = Math.abs(temp)-1; //�ߺ����� �����Ƿ� Ž���� �����ϰ� �������� ����
//			LIS[temp] = arr[i]; //�ǵڿ� �߰��ǰų� ���� ��ġ�� ����ų�
//			
//			if(temp ==size) 
//			{
//					++size;
//			}
//		}
//		System.out.println(size);
	}
}