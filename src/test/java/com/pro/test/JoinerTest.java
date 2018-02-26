package com.pro.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;

public class JoinerTest {
	
	public static void main(String[] args) {
		test();
	}

	public static void test(){
		StringBuilder sb = new StringBuilder();
		List<String> lst = new ArrayList<String>();
		lst.add("Hello");
		lst.add("Kitty");
		lst.add("Tom");
		Joiner joiner = Joiner.on(", ");
		joiner.appendTo(sb, lst);
		System.out.println(sb);
		// Hello, Kitty, Tom

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "haha");
		map.put("key2", "val2");
		map.put("key3", "val3");
		map.put("key4", 1234);
		MapJoiner mapJoiner = Joiner.on(", ").withKeyValueSeparator("=");
		String mapStr = mapJoiner.join(map);
		System.out.println(mapStr);
		//key1=haha, key2=val2, key3=val3
	}
}
