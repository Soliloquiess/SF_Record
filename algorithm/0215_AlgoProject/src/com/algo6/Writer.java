package com.algo6;

/*
 interface: COmparable, Comparator
 객체의 정렬과 관련된 인터페이스
 Comparable: 클래스 내부에 객체의 정렬기준을 만들어둘때 사용됨
 Comparator: 클래스 외부에 객체 정렬기준을 만들어 둘때 사용됨.
 */
public class Writer implements Comparable<Writer> {
	int num;
	String name;
	int age;
	String title;
	
	public Writer(int num, String name, int age, String title) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Writer [num=" + num + ", name=" + name + ", age=" + age + ", title=" + title + "]";
	}

	@Override
	public int compareTo(Writer other) {
		int result = this.num - other.num;//num 기준으로 오름차순정렬
		return result;
	}
}
