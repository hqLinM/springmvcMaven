package com.pro.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class JavaTest {

	public static void main(String[] args) {
		List<String> nameList = new ArrayList<String>();
		nameList.add("1111");
		nameList.add("2222");
		nameList.add("tom");
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		map.put("key", 11);
		mapList.add(map);
		map = new HashMap<String, Object>();
		map.put("key", 22);
		mapList.add(map);
		
		String joinResult = StringUtils.join(nameList, ",");
		String joinResult2 = StringUtils.join(mapList, ",");
		System.out.println(joinResult);	//1111,2222,tom
		System.out.println(joinResult2);	//{key=11},{key=22}
	}

}
