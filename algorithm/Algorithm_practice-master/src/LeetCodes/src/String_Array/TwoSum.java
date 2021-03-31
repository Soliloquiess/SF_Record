package String_Array;


import java.util.*;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,8,11,21};
        int target =10;
        TwoSum a = new TwoSum();
        int[]  result = a.solve(nums, target);
        for(int i : result)
        	System.out.println(i);
	}
	
	//
	public int[] solve(int[] nums, int target) {
		//2.���� �׸�
		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		//3.for
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])){	//�ʿ� ���� �ֳ� üũ
				
				int mapValue = map.get(nums[i]); //i=1�϶� 8 , map(8,0)
				result[0]  = mapValue +1; //1
			    result[1]  = i+1 ;        //2
				
			}else {
				map.put(target-nums[i], i); //key 10-2=8, value i=0 
			}
		}
		
		
		return result;
		
	}
}
