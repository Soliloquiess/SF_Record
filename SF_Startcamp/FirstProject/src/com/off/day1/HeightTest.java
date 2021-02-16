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
		//1.키보드로부터 인원수 입력 배열 생성하기.
		
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("인원수:");
//		
//		int num = sc.nextInt(); //인원수 -> 배열의 크기
//		int [] heights = new int[num];
//		
//		//2. 각각의 사람들 키값을 배열에 저장하기
//		for(int i = 0; i<heights.length;i++)
//		{
//			heights[i] = 100 + ran.nextInt(91);//100~190
//		}
//		System.out.println(Arrays.toString(heights)); //값 확인
//		//3. 배열에 저장된 키 값중에서 제일 큰 값 알아내서 출력.
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
		
		//int num = sc.nextInt(); //인원수 -> 배열의 크기
		int [] heights = new int[num];
		
		//2. 각각의 사람들 키값을 배열에 저장하기
		for(int i = 0; i<heights.length;i++)
		{
			heights[i] = 100 + ran.nextInt(91);//100~190
		}
		System.out.println(Arrays.toString(heights)); //값 확인
		//3. 배열에 저장된 키 값중에서 제일 큰 값 알아내서 출력.
		
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
//			//입력
//            human[i] = Integer.parseInt(br.readLine());
//        }
//        
//        for(int i=0; i<size; i++) {
//            System.out.println( human[i] + " ");
//        }


	}

}
