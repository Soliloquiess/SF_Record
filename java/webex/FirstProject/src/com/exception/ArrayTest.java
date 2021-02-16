package com.exception;

//ArrayIndexOutOfBoundsException:
public class ArrayTest {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		
		for(int i = 0; i<=nums.length;i++)
		{
			try {
				int a = 3, b=0,c=0;
				c=a/b;	//�и� 0�� ���� . arithmeticException
				System.out.println(nums[i]);
			}
			catch(ArrayIndexOutOfBoundsException e) 
			{
				//���� ó�� �ڵ�
				System.out.println("oops,sorry");
				System.out.println(e.getMessage());
			} //����ó���ڵ�
			catch(ArithmeticException w) {
				System.out.println("�и�� 0�� �ƴϿ��� �մϴ�.");
			}
			finally 	//���� �߻� ���οͻ�� ���� �Ź� ����
			{
				System.out.println("finally");
			}
		}
		
		System.out.println("done!!");
	}
}
