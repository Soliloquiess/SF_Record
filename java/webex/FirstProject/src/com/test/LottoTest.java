package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LottoTest {
	//�ζǿ� ����� ���� ���� 
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
//			���� ��� ���� ������ temp�� ���� �迭 num�� �Էµ� ��� ���ҿ� ���Ѵ�.
//
//			   ���� ���� nums[3]=temp �� ������ ���ƴٸ�, nums[0], nums[1], nums[2]������ ���ϸ� �ǹǷ� j < i �϶������� ���Ѵ�.
//			�ߺ��� �����ߺ��� ���Ҷ�� i ���� �ϳ� �ٿ��ְ� break�� ���� ���� �ݺ����� �������� �� �ٽ� ���� ������ �����Ѵ�. 
//			i ���� �ϳ� �پ������Ƿ� �ߺ��� ���ڰ� ���� �ε����� ���ο� ������ ������ �ȴ�. 
			for (int j = 0; j<i; j++)
			{
				if(nums[i] == nums[j])
				{
					i--;
					break;
				}
			}
		}
		
		//�迭 ���� �� ���
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
	
