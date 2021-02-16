package com.collection;

import java.util.HashMap;
import java.util.Set;

//HashMap(Map 종류):key-value. key는 중복되지 않게 해야함.
public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("num","123");
		map.put("name","tommy");
		map.put("address","seoul");
		
		map.put("address","london");
		System.out.println(map.get("address"));//키에 해당하는 값이 안 나옴
		System.out.println(map);
		
		Set<String> keys = map.keySet(); //map 안의 키만 뽑아냄.
		for(String key:keys)
		{
			String val = map.get(keys);
			System.out.println(key+":"+val);
		}
	}
}
