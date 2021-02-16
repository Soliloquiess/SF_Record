package com.live01;

public class RecursiveTest {
	public static void main(String[] args) {
		//1. recur(): start, end, step �ݺ���ó�� �� �ٿ� ������ִ� �Լ�
		recur(0,5,1);
		recur(1,10,2);
		
		//2. sum(): start, end . start~end ������ ���� ���ϴ� �Լ�
		sum(1,10);
	}
	
	static void recur (int start, int end, int step) {
		//1. ������Ʈ
		if(start>end)
		{
			System.out.println();
		}
		//2. �ݺ���Ʈ-����ϰ� ���ȣ��
		
		else {
			System.out.println(start+" ");
			recur(start+step,end,step);
		}
	}
	
	static int tmp =0;
	static void sum(int start, int end) {
		//1. ������Ʈ
		if(start>end) {
			System.out.println("��: "+tmp);
		}
		//2.�ݺ���Ʈ-����, ���ȣ��
		else {
			tmp+= start;
			sum(start+1,end);
		}
		
	}
}