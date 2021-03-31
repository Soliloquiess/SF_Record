package Test;

import java.util.Arrays;

public class Week2 {
	public static void main(String[] args) {
		
		int max =0;
		int [] array = {1,5,3,8,2};
		
		Arrays.sort(array);
		max = array[array.length-1];
		System.out.println("max : "+ max);
	}
}
