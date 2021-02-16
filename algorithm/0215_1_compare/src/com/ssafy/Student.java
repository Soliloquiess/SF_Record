package com.ssafy;

public class Student implements Comparable<Student>{
	int no,score;

	
	public Student(int no, int score) {
		super();
		this.no = no;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.no - o.no;
	}
	
}
