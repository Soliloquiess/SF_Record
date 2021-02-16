package com.off.day1;

import java.util.Arrays;

public class ArrayTest2 {

	public static void main(String[] args) {
		
		int[][] a;
		int [] b[];
		int c[][][];
		
		int [][]data = new int [3][];
		System.out.println(data.length);
		data[0] = new int[5];
		data[1] = new int[3];
		data[2] = new int[1];
		
		int[][] score = {
				{1,2,3},
				{4,5},
				{6}
		};
		System.out.println(Arrays.deepToString(score));
		
	}

}
