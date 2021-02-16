package com.algo6;

/*
 interface: COmparable, Comparator
 ��ü�� ���İ� ���õ� �������̽�
 Comparable: Ŭ���� ���ο� ��ü�� ���ı����� �����Ѷ� ����
 Comparator: Ŭ���� �ܺο� ��ü ���ı����� ����� �Ѷ� ����.
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
		int result = this.num - other.num;//num �������� ������������
		return result;
	}
}
