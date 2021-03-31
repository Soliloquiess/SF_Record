package String_Array;

public class _18_TrappingRainWater {

	public static void main(String[] args) {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(nums));
	}
	public static int trap(int[] height) {
		int result =0;
		if(height==null || height.length<=2)
			return result;
		
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		
		//2.left
		int max = height[0];	//max�������� height ���س����鼭 ��
		left[0] = height[0];
		
		for(int i=1; i<height.length; i++) {
			if(height[i] <max) {
				left[i] =max;
			}else {
				left[i] = height[i];
				max = height[i];
			}
		}
		/*
1.int[ ] left: {0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}
2.Int[ ] right: {3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1}
3.Math.min : {0 1, 1, 2, 2, 2 2 3 2 2 ,2, 1}
4.Height : {0, 1, 0, 2, 1, 0, 1, 3, 2 ,1, 2, 1}
5. 0, 0 1 0, 1, 2, 1, 0, 0, 1, 0, 0
		 * 
		 */
		//2.right( �� �ڿ��� ����)
		max = height[height.length-1];
		right[height.length-1] = height[height.length-1];
		for(int i=height.length-2; i>=0; i--) {
			if(height[i]<max) {
				right[i]=max;	
			}else {
				right[i] = height[i]; //10������ ���� max�� 1�ε� 2�� max �ٲ����.
				max = height[i];
			}
		}
		
		for(int i=0; i<height.length; i++) {
			result += Math.min(left[i],right[i])-height[i];
		}
		return result;
		
	}
}