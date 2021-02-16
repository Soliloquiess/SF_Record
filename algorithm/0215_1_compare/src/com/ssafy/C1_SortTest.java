package com.ssafy;

import java.util.Arrays;
import java.util.Comparator;

public class C1_SortTest {

	static class StudentComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) { 
			//이너클래스
			
			return o2.no - o1.no;
		}
		
	}
	public static void main(String[] args) {
		Student[] students = {
				new Student(1,10),
				new Student(3,50),
				new Student(2,80),
				new Student(4,10)
		};
		
		System.out.println(Arrays.toString(students));
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));
		
		Arrays.sort(students,new StudentComparator());
		System.out.println(Arrays.toString(students));
		
		Arrays.sort(students,new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.score-o2.score;
			}
		});
		
		System.out.println(Arrays.toString(students));
		Arrays.sort(students, (o1,o2)->o1.score - o2.score);
		System.out.println(Arrays.toString(students));
	}
}


