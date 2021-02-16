package com.exception;

//ArrayIndexOutOfBoundsException:
public class ArrayTest {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		
		for(int i = 0; i<=nums.length;i++)
		{
			try {
				int a = 3, b=0,c=0;
				c=a/b;	//분모에 0이 들어옴 . arithmeticException
				System.out.println(nums[i]);
			}
			catch(ArrayIndexOutOfBoundsException e) 
			{
				//예외 처리 코드
				System.out.println("oops,sorry");
				System.out.println(e.getMessage());
			} //예외처리코드
			catch(ArithmeticException w) {
				System.out.println("분모는 0이 아니여야 합니다.");
			}
			finally 	//예외 발생 여부와상관 없이 매번 실행
			{
				System.out.println("finally");
			}
		}
		
		System.out.println("done!!");
	}
}
