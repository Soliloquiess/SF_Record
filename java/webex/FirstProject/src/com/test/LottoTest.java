package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LottoTest {
	//로또에 사용할 숫자 만들어서 
	//45(1~45)->6
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str);
		
		int[] nums =new int[6];
		
		for (int i = 0; i<nums.length;i++)
		{
			nums[i] = (int)(Math.random()*45)+1;
//			따라서 방금 얻은 난수인 temp를 현재 배열 num에 입력된 모든 원소와 비교한다.
//
//			   만약 지금 nums[3]=temp 의 과정을 거쳤다면, nums[0], nums[1], nums[2]까지만 비교하면 되므로 j < i 일때까지만 비교한다.
//			중복값 제거중복된 원소라면 i 값을 하나 줄여주고 break를 통해 내부 반복문을 빠져나간 뒤 다시 난수 추출을 시작한다. 
//			i 값이 하나 줄어들었으므로 중복된 숫자가 들어갔던 인덱스는 새로운 난수로 덮어씌우기 된다. 
			for (int j = 0; j<i; j++)
			{
				if(nums[i] == nums[j])
				{
					i--;
					break;
				}
			}
		}
		
		//배열 안의 값 출력
//		for (int i = 0; i < nums.length; i++) 
		{
//			System.out.print(nums[i] +" ");
//		}
			
		for (int i :nums)
		{
			System.out.println(i + " ");
		}

		
	}

}
}
	
