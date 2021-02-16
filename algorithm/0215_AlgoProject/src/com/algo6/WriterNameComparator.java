package com.algo6;

import java.util.Comparator;

public class WriterNameComparator implements Comparator<Writer> {

	public static void main(String[] args) {
		

	}

	@Override
	public int compare(Writer o1, Writer o2) {
		int result = o1.name.compareTo(o2.name);
		if(result == 0)
			return o1.title.compareTo(o2.title);//2번째 정렬기준
			
		return result;
	}

}
