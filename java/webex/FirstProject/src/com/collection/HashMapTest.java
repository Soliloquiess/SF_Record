package com.collection;

import java.util.HashMap;
import java.util.Set;

//HashMap(Map ����):key-value. key�� �ߺ����� �ʰ� �ؾ���.
public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("num","123");
		map.put("name","tommy");
		map.put("address","seoul");
		
		map.put("address","london");
		System.out.println(map.get("address"));//Ű�� �ش��ϴ� ���� �� ����
		System.out.println(map);
		
		Set<String> keys = map.keySet(); //map ���� Ű�� �̾Ƴ�.
		for(String key:keys)
		{
			String val = map.get(keys);
			System.out.println(key+":"+val);
		}
	}
}
