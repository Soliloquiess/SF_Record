package com.collection;

import java.util.HashSet;

//HashSet(Set ����): ���� X, �ߺ� X

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();

		set.add("bill");
		set.add("jane");
		set.add("june");
		set.add("bill");
		set.add("kim");
		set.add("lee");
		set.add("bill");
		
		System.out.println(set);
	}
}
