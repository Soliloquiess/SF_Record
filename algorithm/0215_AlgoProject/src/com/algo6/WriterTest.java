package com.algo6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WriterTest {
	public static void main(String[] args) {
		ArrayList<Writer> list = new ArrayList<Writer>();
		list.add(new Writer(3,"tommy",35,"Hello java"));
		list.add(new Writer(2,"jane",45,"stop java"));
		list.add(new Writer(1,"bill",40,"sing java"));
		list.add(new Writer(4,"kim",22,"bye java"));
		list.add(new Writer(5,"tommy",55,"good java"));
	
		//Arrays.sort()
		Collections.sort(list);	//list:Comparable Ÿ���� ��ü���� ��.
		for(Writer w : list) {
			System.out.println(w);
		}
		System.out.println();
		

		//���� ������ �Ǵ°� �־����
		Collections.sort(list, new WriterNameComparator());	
		for(Writer w : list) {
			System.out.println(w);
		}
		
		//���� ���� ���� Comparator ��ü����
		Collections.sort(list,new Comparator<Writer>() {

			@Override
			public int compare(Writer o1, Writer o2) {
				// TODO Auto-generated method stub
				return o1.age-o2.age;
			} //Comparator�� impl�ϴ� ���� Ŭ����
			
		});
	}
}
