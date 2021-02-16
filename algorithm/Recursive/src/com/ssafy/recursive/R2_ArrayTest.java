package com.ssafy.recursive;

public class R2_ArrayTest {
	static int arr[] = {10,20,30};
	
	//�迭�� ���� ������ ���
	private static void printArray1(int i)
	{
		if(i == arr.length)
		{
			System.out.println();
			return;
		}
		
		System.out.println(arr[i]+"\t");
		printArray1(i+1);
	}
	
	static int arr2[][] = {{11,12,13},{20,30,40}};
	
	//�迭�� ������ ���Ҹ� ��� ���
	private static void printRowArray(int i)
	{
		if (i ==arr2.length) return ;
		for (int j = 0; j<arr2[i].length;j++)
		{
			System.out.print(arr2[i][j]+"\t");
		}
		System.out.println();
		
		printRowArray(i+1);
	}
	
	public static void main(String[] args) {
		printArray1(0);
		printRowArray(0);//ù����� ����̶� 0�ָ� �ȴ�.
	}

}
