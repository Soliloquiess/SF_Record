package com.off.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HeightTest {

	public static void main(String[] args) throws IOException 
	{
		//1.Ű����κ��� �ο��� �Է� �迭 �����ϱ�.
		
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("�ο���:");
//		
//		int num = sc.nextInt(); //�ο��� -> �迭�� ũ��
//		int [] heights = new int[num];
//		
//		//2. ������ ����� Ű���� �迭�� �����ϱ�
//		for(int i = 0; i<heights.length;i++)
//		{
//			heights[i] = 100 + ran.nextInt(91);//100~190
//		}
//		System.out.println(Arrays.toString(heights)); //�� Ȯ��
//		//3. �迭�� ����� Ű ���߿��� ���� ū �� �˾Ƴ��� ���.
//		
//		int max = heights[0];
//		for (int i = 1; i<heights.length; i++)
//		{
//			if(heights[i]>max)
//			{
//				max = heights[i];
//			}
//		}
//		System.out.println("max: "+max);
//	}
//}





		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int num = Integer.parseInt(st.nextToken());
		
		//int num = sc.nextInt(); //�ο��� -> �迭�� ũ��
		int [] heights = new int[num];
		
		//2. ������ ����� Ű���� �迭�� �����ϱ�
		for(int i = 0; i<heights.length;i++)
		{
			heights[i] = 100 + ran.nextInt(91);//100~190
		}
		System.out.println(Arrays.toString(heights)); //�� Ȯ��
		//3. �迭�� ����� Ű ���߿��� ���� ū �� �˾Ƴ��� ���.
		
		int max = heights[0];
		for (int i = 1; i<heights.length; i++)
		{
			if(heights[i]>max)
			{
				max = heights[i];
			}
		}
		System.out.println("max: "+max);
		
//		int[] human = new int[size];	
//		
//		for(int i=0; i<size; i++) {
//			//�Է�
//            human[i] = Integer.parseInt(br.readLine());
//        }
//        
//        for(int i=0; i<size; i++) {
//            System.out.println( human[i] + " ");
//        }


	}

}
